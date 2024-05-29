package so.sonya.muswebapp2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import so.sonya.muswebapp2.dto.PostDto;
import so.sonya.muswebapp2.exception.notFound.PostNotFoundException;
import so.sonya.muswebapp2.mapper.PostMapper;
import so.sonya.muswebapp2.repository.PostRepository;
import so.sonya.muswebapp2.service.PostService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;
    @Override
    public PostDto findByAuthorId(UUID authorId) {
        return postMapper.toDto(
                postRepository.findByAuthor_Uuid(authorId)
                        .orElseThrow(() ->new PostNotFoundException()));
    }

    @Override
    public PostDto findById(UUID id) {
        return postMapper.toDto(
                postRepository.findById(id)
                    .orElseThrow(() -> new PostNotFoundException()));
    }

    @Override
    public UUID save(PostDto postDto) {
        return postRepository.save(
                postMapper.toEntity(postDto)).getUuid();
    }

    @Override
    public void deleteById(UUID id) {
        postRepository.deleteById(id);
    }

    @Override
    public PostDto update(UUID id, PostDto postDto) {
        return null;
    }
}
