package so.sonya.muswebapp2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import so.sonya.muswebapp2.dto.request.CreateCommentRequest;
import so.sonya.muswebapp2.dto.response.CommentResponse;
import so.sonya.muswebapp2.exception.CommentNotFoundException;
import so.sonya.muswebapp2.mapper.CommentMapper;
import so.sonya.muswebapp2.model.Comment;
import so.sonya.muswebapp2.repository.CommentRepository;
import so.sonya.muswebapp2.service.CommentService;

import java.util.UUID;

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
}
