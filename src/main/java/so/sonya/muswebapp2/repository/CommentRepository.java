package so.sonya.muswebapp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import so.sonya.muswebapp2.model.Comment;

import java.util.Optional;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
    @Query("select c from Comment c where c.author.id = :authorId")
    Optional<Comment> findByAuthorId(UUID authorId);
}
