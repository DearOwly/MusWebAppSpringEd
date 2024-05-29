package so.sonya.muswebapp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import so.sonya.muswebapp2.model.ThreadEntity;

import java.util.Optional;
import java.util.UUID;

public interface ThreadRepository extends JpaRepository<ThreadEntity, UUID> {
    Optional<ThreadEntity> findByAuthor_Uuid(UUID authorId);
    Optional<ThreadEntity> findByTitle(String title);
}
