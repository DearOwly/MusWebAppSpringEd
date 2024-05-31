package so.sonya.muswebapp2.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;
import so.sonya.muswebapp2.api.PostApi;
import so.sonya.muswebapp2.dto.request.CreatePostRequest;
import so.sonya.muswebapp2.dto.request.UpdatePostRequest;
import so.sonya.muswebapp2.dto.response.PostResponse;
import so.sonya.muswebapp2.service.PostService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PostController implements PostApi {
    private final PostService service;

    @Override
    public PostResponse getById(UUID id) {
        return service.findById(id);
    }

    @Override
    public Page<PostResponse> getAll(Integer pageNumber, Integer pageSize) {
        return service.findAll(pageNumber, pageSize);
    }

    @Override
    public PostResponse updateInfo(UpdatePostRequest updatePostRequest) {
        return service.update(updatePostRequest.id(), updatePostRequest);
    }

    @Override
    public PostResponse getByAuthorId(UUID authorId) {
        return service.findByAuthorId(authorId);
    }

    @Override
    public void delete(UUID id) {
        service.deleteById(id);
    }

    @Override
    public PostResponse create(CreatePostRequest createPostRequest) {
        return service.save(createPostRequest);
    }
}
