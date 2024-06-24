package so.sonya.muswebapp2.api;

import io.swagger.annotations.Api;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import so.sonya.muswebapp2.dto.request.*;
import so.sonya.muswebapp2.dto.response.CommentResponse;
import so.sonya.muswebapp2.dto.response.PostResponse;
import so.sonya.muswebapp2.security.details.UserDetailsWithId;

import java.util.UUID;

import static so.sonya.muswebapp2.api.util.Contants.POST_API_URL;

@Api(tags = "Post | Пост", value = "Post")
@RequestMapping(POST_API_URL)
public interface PostApi {
    @GetMapping(value = "/list", params = {"!author_id"})
    Page<PostResponse> getAll(
        Pageable pageable
    );

    @GetMapping(value = "/list", params = {"author_id"})
    Page<PostResponse> getAllByAuthorId(
        @RequestParam("author_id")
        UUID authorId,

        Pageable pageable
    );

    @GetMapping("/get")
    PostResponse getById(
        @RequestParam
        UUID id
    );

    @PutMapping
    PostResponse create(
        @RequestBody
        @Valid
        CreatePostRequest createPostRequest,

        @AuthenticationPrincipal
        UserDetailsWithId user
    );

    @PatchMapping
    PostResponse update(
        @RequestBody
        @Valid
        UpdatePostRequest updatePostRequest,

        @AuthenticationPrincipal
        UserDetailsWithId user
    );

    @DeleteMapping
    void delete(
        @RequestParam
        UUID id,

        @AuthenticationPrincipal
        UserDetailsWithId user
    );

    @PostMapping
    void like(
        @RequestBody
        @Valid
        LikeRequest request,

        @AuthenticationPrincipal
        UserDetailsWithId user
    );

    @GetMapping("/{post_id}")
    Page<CommentResponse> getComments(
        @PathVariable("post_id")
        UUID postId,

        Pageable pageable
    );

    @PutMapping("/{post_id}")
    CommentResponse postComment(
        @PathVariable("post_id")
        UUID postId,

        @RequestBody
        @Valid
        PostCommentRequest postCommentRequest,

        @AuthenticationPrincipal
        UserDetailsWithId user
    );

    @PatchMapping("/{post_id}")
    CommentResponse editComment(
        @PathVariable("post_id")
        UUID postId,

        @RequestBody
        @Valid
        EditCommentRequest editCommentRequest,

        @AuthenticationPrincipal
        UserDetailsWithId user
    );

    @DeleteMapping("/{post_id}")
    void deleteCommentById(
        @PathVariable("post_id")
        UUID postId,

        @RequestParam
        UUID id,

        @AuthenticationPrincipal
        UserDetailsWithId user
    );
}
