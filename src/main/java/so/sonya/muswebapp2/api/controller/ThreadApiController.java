package so.sonya.muswebapp2.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import so.sonya.muswebapp2.api.ThreadApi;
import so.sonya.muswebapp2.dto.request.*;
import so.sonya.muswebapp2.dto.response.MessageResponse;
import so.sonya.muswebapp2.dto.response.ThreadResponse;
import so.sonya.muswebapp2.security.details.UserDetailsWithId;
import so.sonya.muswebapp2.service.ThreadService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ThreadApiController implements ThreadApi {
    private final ThreadService service;

    @Override
    public Page<ThreadResponse> getAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @Override
    public ThreadResponse getById(UUID id) {
        return service.findById(id);
    }

    @Override
    public Page<ThreadResponse> getAllByAuthorId(UUID authorId, Pageable pageable) {
        return service.findAllByAuthorId(authorId, pageable);
    }

    @Override
    public ThreadResponse create(CreateThreadRequest createThreadRequest, UserDetailsWithId user) {
        return service.create(createThreadRequest, user.getId());
    }

    @Override
    public ThreadResponse update(UpdateThreadRequest updateThreadRequest, UserDetailsWithId user) {
        return service.update(updateThreadRequest, user.getId());
    }

    @Override
    public void delete(UUID id, UserDetailsWithId user) {
        service.deleteById(id, user.getId());
    }

    @Override
    public Page<MessageResponse> getMessages(UUID threadId, Pageable pageable) {
        return service.findAllMessagesByThreadId(threadId, pageable);
    }

    @Override
    public MessageResponse postMessage(UUID threadId, PostMessageRequest postMessageRequest, UserDetailsWithId user) {
        return service.postMessage(threadId, postMessageRequest, user.getId());
    }

    @Override
    public MessageResponse editMessage(UUID threadId, EditMessageRequest editMessageRequest, UserDetailsWithId user) {
        return service.editMessage(threadId, editMessageRequest, user.getId());
    }

    @Override
    public void deleteMessageById(UUID threadId, UUID id, UserDetailsWithId user) {
        service.deleteMessageById(threadId, id, user.getId());
    }
}
