package so.sonya.muswebapp2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import so.sonya.muswebapp2.dto.request.CreateMessageRequest;
import so.sonya.muswebapp2.dto.request.UpdateMessageRequest;
import so.sonya.muswebapp2.dto.response.MessageResponse;
import so.sonya.muswebapp2.exception.MessageNotFoundException;
import so.sonya.muswebapp2.mapper.MessageMapper;
import so.sonya.muswebapp2.model.Message;
import so.sonya.muswebapp2.repository.MessageRepository;
import so.sonya.muswebapp2.service.MessageService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository repository;
    private final MessageMapper mapper;

    @Override
    public MessageResponse findById(UUID id) {
        return mapper.toResponse(
                repository.findById(id)
                              .orElseThrow(MessageNotFoundException::new));
    }

    @Override
    public MessageResponse findByAuthorId(UUID authorId) {

        return mapper.toResponse(
                repository.findByAuthorId(authorId)
                              .orElseThrow(MessageNotFoundException::new));
    }

    @Override
    public MessageResponse save(CreateMessageRequest createMessageRequest) {
        return mapper.toResponse(
                repository.save(
                        mapper.toEntity(createMessageRequest)));
    }

    @Override
    public void deleteById(UUID  id) {
        repository.deleteById(id);
    }

    @Override
    public MessageResponse update(UUID uuid, UpdateMessageRequest updateMessageRequest) {
        Message message = repository.getReferenceById(uuid);

        mapper.update(message, updateMessageRequest);

        return mapper.toResponse(repository.save(message));
    }

    @Override
    public Page<MessageResponse> findAll(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return repository
                .findAll(pageable)
                .map(mapper::toResponse);
    }
}
