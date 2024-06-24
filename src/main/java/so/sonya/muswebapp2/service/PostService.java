package so.sonya.muswebapp2.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import so.sonya.muswebapp2.dto.request.*;
import so.sonya.muswebapp2.dto.response.CommentResponse;
import so.sonya.muswebapp2.dto.response.PostResponse;

import java.util.UUID;

public interface PostService {
    Page<PostResponse> findAll(Pageable pageable);

    PostResponse findById(UUID id);

    Page<PostResponse> findAllByAuthorId(UUID authorId, Pageable pageable);

    PostResponse create(CreatePostRequest request, UUID authorId);

    PostResponse update(UpdatePostRequest request, UUID authorId);

    void deleteById(UUID id, UUID authorId);

    void like(LikeRequest request, UUID userId);

    Page<CommentResponse> findAllCommentsByPostId(UUID id, Pageable pageable);

    CommentResponse postComment(UUID id, PostCommentRequest request, UUID userId);

    CommentResponse editComment(UUID id, EditCommentRequest request, UUID userId);

    void deleteCommentById(UUID id, UUID commentId, UUID userId);
}
