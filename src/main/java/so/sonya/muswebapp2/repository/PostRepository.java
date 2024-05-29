package so.sonya.muswebapp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import so.sonya.muswebapp2.model.PostEntity;

import java.util.Optional;
import java.util.UUID;

public interface PostRepository extends JpaRepository<PostEntity, UUID> {
    Optional<PostEntity> findByAuthor_Uuid(UUID authorId);
}
