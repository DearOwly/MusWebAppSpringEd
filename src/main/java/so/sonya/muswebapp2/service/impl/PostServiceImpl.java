package so.sonya.muswebapp2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import so.sonya.muswebapp2.dto.request.CreatePostRequest;
import so.sonya.muswebapp2.dto.response.PostResponse;
import so.sonya.muswebapp2.exception.PostNotFoundException;
import so.sonya.muswebapp2.mapper.PostMapper;
import so.sonya.muswebapp2.model.Post;
import so.sonya.muswebapp2.repository.PostRepository;
import so.sonya.muswebapp2.service.PostService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository repository;
    private final PostMapper mapper;

    @Override
    public PostResponse findById(UUID id) {
        return mapper.toResponse(
                repository.findById(id)
                        .orElseThrow(PostNotFoundException::new));
    }

    @Override
    public PostResponse findByAuthorId(UUID authorId) {
        return mapper.toResponse(
                repository.findByAuthorId(authorId)
                        .orElseThrow(PostNotFoundException::new));
    }

    @Override
    public PostResponse save(CreatePostRequest createPostRequest) {
        return mapper.toResponse(
                repository.save(
                        mapper.toEntity(createPostRequest)));
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
