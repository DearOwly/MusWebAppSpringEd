package so.sonya.muswebapp2.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;
import so.sonya.muswebapp2.api.ThreadApi;
import so.sonya.muswebapp2.dto.request.CreateThreadRequest;
import so.sonya.muswebapp2.dto.request.UpdateThreadRequest;
import so.sonya.muswebapp2.dto.response.ThreadResponse;
import so.sonya.muswebapp2.service.ThreadService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ThreadController implements ThreadApi {
    private final ThreadService service;

    @Override
    public ThreadResponse getById(UUID id) {
        return service.findById(id);
    }

    @Override
    public Page<ThreadResponse> getAll(Integer pageNumber, Integer pageSize) {
        return service.findAll(pageNumber, pageSize);
    }

    @Override
    public ThreadResponse updateInfo(UpdateThreadRequest updateThreadRequest) {
        return service.update(updateThreadRequest.id(), updateThreadRequest);
    }

    @Override
    public ThreadResponse getByAuthorId(UUID authorId) {
        return service.findByAuthorId(authorId);
    }

    @Override
    public void delete(UUID id) {
        service.deleteById(id);
    }

    @Override
    public ThreadResponse create(CreateThreadRequest createThreadRequest) {
        return service.save(createThreadRequest);
    }
}
