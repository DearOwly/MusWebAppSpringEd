package so.sonya.muswebapp2.service;

import so.sonya.muswebapp2.dto.CommentDto;

import java.util.UUID;

public interface CommentService extends StandartService<CommentDto, UUID>{
    CommentDto findByAuthorId(UUID authorId);
}
