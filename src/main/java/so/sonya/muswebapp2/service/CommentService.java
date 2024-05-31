package so.sonya.muswebapp2.service;

import so.sonya.muswebapp2.dto.request.CreateCommentRequest;
import so.sonya.muswebapp2.dto.response.CommentResponse;
import so.sonya.muswebapp2.service.base.GenericService;

import java.util.UUID;

public interface CommentService extends GenericService<UUID, CreateCommentRequest, CommentResponse> {
    CommentResponse findByAuthorId(UUID authorId);
}
