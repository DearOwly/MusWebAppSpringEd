package so.sonya.muswebapp2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import so.sonya.muswebapp2.model.Comment;

import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
    @Query("select c from Comment c where c.author.id = :authorId")
    Page<Comment> findAllByAuthorId(UUID authorId, Pageable pageable);

    @Query("select p.comments from Post p where p.id = :postId")
    Page<Comment> findAllByPostId(UUID postId, Pageable pageable);
}
