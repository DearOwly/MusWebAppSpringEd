package so.sonya.muswebapp2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import so.sonya.muswebapp2.dto.request.CreateCommentRequest;
import so.sonya.muswebapp2.dto.request.UpdateCommentRequest;
import so.sonya.muswebapp2.dto.response.CommentResponse;
import so.sonya.muswebapp2.exception.CommentNotFoundException;
import so.sonya.muswebapp2.mapper.CommentMapper;
import so.sonya.muswebapp2.model.Comment;
import so.sonya.muswebapp2.repository.CommentRepository;
import so.sonya.muswebapp2.service.CommentService;

import java.util.UUID;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository repository;
    private final CommentMapper mapper;

    @Override
    public CommentResponse findById(UUID id) {
        return mapper.toResponse(
                repository.findById(id)
                              .orElseThrow(CommentNotFoundException::new));
    }

    @Override
    public CommentResponse findByAuthorId(UUID authorId) {
        return mapper.toResponse(
                repository.findByAuthorId(authorId)
                              .orElseThrow(CommentNotFoundException::new));
    }

    @Override
    public CommentResponse save(CreateCommentRequest createCommentRequest) {
        return mapper.toResponse(
                repository.save(
                        mapper.toEntity(createCommentRequest)));
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public CommentResponse update(UUID uuid, UpdateCommentRequest updateCommentRequest) {
        Comment comment = repository.getReferenceById(uuid);

        mapper.update(comment, updateCommentRequest);

        return mapper.toResponse(repository.save(comment));
    }

    @Override
    public Page<CommentResponse> findAll(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return repository
                .findAll(pageable)
                .map(mapper::toResponse);
    }
}
