package so.sonya.muswebapp2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.sonya.muswebapp2.dto.request.*;
import so.sonya.muswebapp2.dto.response.CommentResponse;
import so.sonya.muswebapp2.dto.response.PostResponse;
import so.sonya.muswebapp2.exception.forbidden.ForbiddenResourceModificationException;
import so.sonya.muswebapp2.exception.notfound.CommentNotFoundException;
import so.sonya.muswebapp2.exception.notfound.PostNotFoundException;
import so.sonya.muswebapp2.exception.notfound.UserNotFoundException;
import so.sonya.muswebapp2.mapper.CommentMapper;
import so.sonya.muswebapp2.mapper.PostMapper;
import so.sonya.muswebapp2.model.Comment;
import so.sonya.muswebapp2.model.Like;
import so.sonya.muswebapp2.model.Post;
import so.sonya.muswebapp2.model.user.User;
import so.sonya.muswebapp2.repository.CommentRepository;
import so.sonya.muswebapp2.repository.LikeRepository;
import so.sonya.muswebapp2.repository.PostRepository;
import so.sonya.muswebapp2.repository.UserRepository;
import so.sonya.muswebapp2.service.PostService;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository repository;
    private final PostMapper mapper;

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    private final UserRepository userRepository;

    private final LikeRepository likeRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<PostResponse> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                         .map(mapper::toResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public PostResponse findById(UUID id) {
        return mapper.toResponse(
            repository.findById(id)
                      .orElseThrow(PostNotFoundException::new)
        );
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PostResponse> findAllByAuthorId(UUID authorId, Pageable pageable) {
        return repository.findAllByAuthorId(authorId, pageable)
                         .map(mapper::toResponse);
    }

    @Override
    public PostResponse create(CreatePostRequest request, UUID authorId) {
        Post post = repository.save(mapper.fromRequest(request));

        post.setAuthor(
            userRepository.findById(authorId)
                          .orElseThrow(UserNotFoundException::new)
        );

        return mapper.toResponse(repository.save(post));
    }

    @Override
    public PostResponse update(UpdatePostRequest request, UUID authorId) {
        Post post = repository.findById(request.id())
                              .orElseThrow(PostNotFoundException::new);

        if (!post.getAuthor()
                 .getId()
                 .equals(authorId)) {
            throw new ForbiddenResourceModificationException(Post.class);
        }

        return mapper.toResponse(repository.save(mapper.update(post, request)));
    }

    @Override
    public void deleteById(UUID id, UUID authorId) {
        Post post = repository.findById(id)
                              .orElseThrow(PostNotFoundException::new);

        if (!post.getAuthor()
                 .getId()
                 .equals(authorId)) {
            throw new ForbiddenResourceModificationException(Post.class);
        }

        repository.deleteById(id);
    }

    @Override
    public void like(LikeRequest request, UUID userId) {
        Post post = repository.findById(request.resourceId())
                              .orElseThrow(PostNotFoundException::new);

        Optional<Like> likeOptional = likeRepository.findById(request.id());

        if (likeOptional.isPresent() && !request.like()) {
            Like like = likeOptional.get();

            if (!like.getUser()
                     .getId()
                     .equals(userId)) {
                throw new ForbiddenResourceModificationException(Post.class);
            }

            post.removeLike(like);
        } else if (likeOptional.isEmpty() && request.like()) {
            User user = userRepository.findById(userId)
                                      .orElseThrow(UserNotFoundException::new);

            Like like = new Like(user);

            post.addLike(like);
        }

        repository.save(post);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CommentResponse> findAllCommentsByPostId(UUID id, Pageable pageable) {
        return commentRepository.findAllByPostId(id, pageable)
                                .map(commentMapper::toResponse);
    }

    @Override
    public CommentResponse postComment(UUID id, PostCommentRequest request, UUID userId) {
        Post post = repository.findById(id)
                              .orElseThrow(PostNotFoundException::new);

        Comment comment = commentRepository.save(
            commentMapper.fromRequest(request)
                         .withAuthor(
                             userRepository.findById(userId)
                                           .orElseThrow(UserNotFoundException::new)
                         )
        );

        repository.save(post.withComment(comment));

        return commentMapper.toResponse(comment);
    }

    @Override
    public CommentResponse editComment(UUID id, EditCommentRequest request, UUID userId) {
        Comment comment = commentRepository.findById(request.id())
                                           .orElseThrow(CommentNotFoundException::new);

        if (!comment.getAuthor()
                    .getId()
                    .equals(userId)) {
            throw new ForbiddenResourceModificationException(Comment.class);
        }

        Post post = repository.findById(id)
                              .orElseThrow(PostNotFoundException::new);

        post.removeComment(comment);
        comment = commentRepository.save(commentMapper.update(comment, request));
        post.addComment(comment);

        return commentMapper.toResponse(comment);
    }

    @Override
    public void deleteCommentById(UUID id, UUID commentId, UUID userId) {
        Comment comment = commentRepository.findById(commentId)
                                           .orElseThrow(CommentNotFoundException::new);

        if (!comment.getAuthor()
                    .getId()
                    .equals(userId)) {
            throw new ForbiddenResourceModificationException(Comment.class);
        }

        Post post = repository.findById(id)
                              .orElseThrow(PostNotFoundException::new);

        post.removeComment(comment);
        commentRepository.delete(comment);
    }
}
