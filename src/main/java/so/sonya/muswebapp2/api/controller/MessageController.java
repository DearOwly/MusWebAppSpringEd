package so.sonya.muswebapp2.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;
import so.sonya.muswebapp2.api.MessageApi;
import so.sonya.muswebapp2.dto.request.CreateMessageRequest;
import so.sonya.muswebapp2.dto.request.UpdateMessageRequest;
import so.sonya.muswebapp2.dto.response.MessageResponse;
import so.sonya.muswebapp2.service.MessageService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class MessageController implements MessageApi {
    private final MessageService service;

    @Override
    public MessageResponse getById(UUID id) {
        return service.findById(id);
    }

    @Override
    public Page<MessageResponse> getAll(Integer pageNumber, Integer pageSize) {
        return service.findAll(pageNumber, pageSize);
    }

    @Override
    public MessageResponse updateInfo(UpdateMessageRequest updateMessageRequest) {
        return service.update(updateMessageRequest.id(), updateMessageRequest);
    }

    @Override
    public MessageResponse getByAuthorId(UUID authorId) {
        return service.findByAuthorId(authorId);
    }

    @Override
    public void delete(UUID id) {
        service.deleteById(id);
    }

    @Override
    public MessageResponse create(CreateMessageRequest createMessageRequest) {
        return service.save(createMessageRequest);
    }
}
