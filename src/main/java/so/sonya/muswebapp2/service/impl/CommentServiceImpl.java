package so.sonya.muswebapp2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import so.sonya.muswebapp2.dto.CommentDto;
import so.sonya.muswebapp2.exception.notFound.CommentNotFoundException;
import so.sonya.muswebapp2.mapper.CommentMapper;
import so.sonya.muswebapp2.repository.CommentRepository;
import so.sonya.muswebapp2.service.CommentService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Override
    public CommentDto findByAuthorId(UUID authorId) {
        return commentMapper.toDto(
                commentRepository.findByAuthor_Uuid(authorId)
                        .orElseThrow(() -> new CommentNotFoundException()));
    }

    @Override
    public CommentDto findById(UUID id) {
        return commentMapper.toDto(
                commentRepository.findById(id)
                        .orElseThrow(() -> new CommentNotFoundException()));
    }

    @Override
    public UUID save(CommentDto commentDto) {
        return commentRepository
                .save(commentMapper.toEntity(commentDto)).getUuid();
    }

    @Override
    public void deleteById(UUID id) {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentDto update(UUID uuid, CommentDto commentDto) {
        return null;
    }
}
