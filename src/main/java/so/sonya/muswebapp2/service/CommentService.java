package so.sonya.muswebapp2.service;

import so.sonya.muswebapp2.dto.request.CreateCommentRequest;
import so.sonya.muswebapp2.dto.request.UpdateCommentRequest;
import so.sonya.muswebapp2.dto.response.CommentResponse;
import so.sonya.muswebapp2.service.base.GenericPagingService;
import so.sonya.muswebapp2.service.base.GenericService;
import so.sonya.muswebapp2.service.base.GenericUpdatingService;

import java.util.UUID;

public interface CommentService extends
        GenericService<UUID, CreateCommentRequest, CommentResponse>,
        GenericUpdatingService<UUID, UpdateCommentRequest, CommentResponse>,
        GenericPagingService<CommentResponse> {
    CommentResponse findByAuthorId(UUID authorId);
}
