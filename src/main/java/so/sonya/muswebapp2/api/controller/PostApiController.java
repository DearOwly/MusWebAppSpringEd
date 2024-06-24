package so.sonya.muswebapp2.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import so.sonya.muswebapp2.api.PostApi;
import so.sonya.muswebapp2.dto.request.*;
import so.sonya.muswebapp2.dto.response.CommentResponse;
import so.sonya.muswebapp2.dto.response.PostResponse;
import so.sonya.muswebapp2.security.details.UserDetailsWithId;
import so.sonya.muswebapp2.service.PostService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PostApiController implements PostApi {
    private final PostService service;

    @Override
    public Page<PostResponse> getAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @Override
    public PostResponse getById(UUID id) {
        return service.findById(id);
    }

    @Override
    public Page<PostResponse> getAllByAuthorId(UUID authorId, Pageable pageable) {
        return service.findAllByAuthorId(authorId, pageable);
    }

    @Override
    public PostResponse create(CreatePostRequest createPostRequest, UserDetailsWithId user) {
        return service.create(createPostRequest, user.getId());
    }

    @Override
    public PostResponse update(UpdatePostRequest updatePostRequest, UserDetailsWithId user) {
        return service.update(updatePostRequest, user.getId());
    }

    @Override
    public void delete(UUID id, UserDetailsWithId user) {
        service.deleteById(id, user.getId());
    }

    @Override
    public void like(LikeRequest request, UserDetailsWithId user) {
        service.like(request, user.getId());
    }

    @Override
    public Page<CommentResponse> getComments(UUID postId, Pageable pageable) {
        return service.findAllCommentsByPostId(postId, pageable);
    }

    @Override
    public CommentResponse postComment(UUID postId, PostCommentRequest postCommentRequest, UserDetailsWithId user) {
        return service.postComment(postId, postCommentRequest, user.getId());
    }

    @Override
    public CommentResponse editComment(UUID postId, EditCommentRequest editCommentRequest, UserDetailsWithId user) {
        return service.editComment(postId, editCommentRequest, user.getId());
    }

    @Override
    public void deleteCommentById(UUID postId, UUID id, UserDetailsWithId user) {
        service.deleteCommentById(postId, id, user.getId());
    }
}
