package so.sonya.muswebapp2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.sonya.muswebapp2.dto.request.*;
import so.sonya.muswebapp2.dto.response.MessageResponse;
import so.sonya.muswebapp2.dto.response.ThreadResponse;
import so.sonya.muswebapp2.exception.forbidden.ForbiddenResourceModificationException;
import so.sonya.muswebapp2.exception.notfound.MessageNotFoundException;
import so.sonya.muswebapp2.exception.notfound.ThreadNotFoundException;
import so.sonya.muswebapp2.exception.notfound.UserNotFoundException;
import so.sonya.muswebapp2.mapper.MessageMapper;
import so.sonya.muswebapp2.mapper.ThreadMapper;
import so.sonya.muswebapp2.model.Message;
import so.sonya.muswebapp2.model.Thread;
import so.sonya.muswebapp2.repository.MessageRepository;
import so.sonya.muswebapp2.repository.ThreadRepository;
import so.sonya.muswebapp2.repository.UserRepository;
import so.sonya.muswebapp2.service.ThreadService;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ThreadServiceImpl implements ThreadService {
    private final ThreadRepository repository;
    private final ThreadMapper mapper;

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<ThreadResponse> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                         .map(mapper::toResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public ThreadResponse findById(UUID id) {
        return mapper.toResponse(
            repository.findById(id)
                      .orElseThrow(ThreadNotFoundException::new)
        );
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ThreadResponse> findAllByAuthorId(UUID authorId, Pageable pageable) {
        return repository.findAllByAuthorId(authorId, pageable)
                         .map(mapper::toResponse);
    }

    @Override
    public ThreadResponse create(CreateThreadRequest request, UUID authorId) {
        Thread thread = repository.save(mapper.fromRequest(request));

        thread.setAuthor(
            userRepository.findById(authorId)
                          .orElseThrow(UserNotFoundException::new)
        );

        return mapper.toResponse(repository.save(thread));
    }

    @Override
    public ThreadResponse update(UpdateThreadRequest request, UUID authorId) {
        Thread thread = repository.findById(request.id())
                                  .orElseThrow(ThreadNotFoundException::new);

        if (!thread.getAuthor()
                   .getId()
                   .equals(authorId)) {
            throw new ForbiddenResourceModificationException(Thread.class);
        }

        return mapper.toResponse(repository.save(mapper.update(thread, request)));
    }

    @Override
    public void deleteById(UUID id, UUID authorId) {
        Thread thread = repository.findById(id)
                                  .orElseThrow(ThreadNotFoundException::new);

        if (!thread.getAuthor()
                   .getId()
                   .equals(authorId)) {
            throw new ForbiddenResourceModificationException(Thread.class);
        }

        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<MessageResponse> findAllMessagesByThreadId(UUID id, Pageable pageable) {
        return messageRepository.findAllByThreadId(id, pageable)
                                .map(messageMapper::toResponse);
    }

    @Override
    public MessageResponse postMessage(UUID id, PostMessageRequest request, UUID userId) {
        Thread thread = repository.findById(id)
                                  .orElseThrow(ThreadNotFoundException::new);

        Message message = messageRepository.save(
            messageMapper.fromRequest(request)
                         .withAuthor(
                             userRepository.findById(userId)
                                           .orElseThrow(UserNotFoundException::new)
                         )
        );

        repository.save(thread.withMessage(message));

        return messageMapper.toResponse(message);
    }

    @Override
    public MessageResponse editMessage(UUID id, EditMessageRequest request, UUID userId) {
        Message message = messageRepository.findById(request.id())
                                           .orElseThrow(MessageNotFoundException::new);

        if (!message.getAuthor()
                    .getId()
                    .equals(userId)) {
            throw new ForbiddenResourceModificationException(Message.class);
        }

        Thread thread = repository.findById(id)
                                  .orElseThrow(ThreadNotFoundException::new);

        thread.removeMessage(message);
        message = messageRepository.save(messageMapper.update(message, request));
        thread.addMessage(message);

        return messageMapper.toResponse(message);
    }

    @Override
    public void deleteMessageById(UUID id, UUID messageId, UUID userId) {
        Message message = messageRepository.findById(messageId)
                                           .orElseThrow(MessageNotFoundException::new);

        if (!message.getAuthor()
                    .getId()
                    .equals(userId)) {
            throw new ForbiddenResourceModificationException(Message.class);
        }

        Thread thread = repository.findById(id)
                                  .orElseThrow(ThreadNotFoundException::new);

        thread.removeMessage(message);
        messageRepository.delete(message);
    }
}
