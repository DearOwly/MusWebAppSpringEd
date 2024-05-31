package so.sonya.muswebapp2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import so.sonya.muswebapp2.dto.request.CreateMessageRequest;
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
}
