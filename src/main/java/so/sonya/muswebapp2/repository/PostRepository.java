package so.sonya.muswebapp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import so.sonya.muswebapp2.model.Post;

import java.util.Optional;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
    @Query("select p from Post p where p.author.id = :authorId")
    Optional<Post> findByAuthorId(UUID authorId);
}
