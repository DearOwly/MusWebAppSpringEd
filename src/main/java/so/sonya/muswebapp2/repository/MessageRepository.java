package so.sonya.muswebapp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import so.sonya.muswebapp2.model.MessageEntity;

import java.util.Optional;
import java.util.UUID;

public interface MessageRepository extends JpaRepository<MessageEntity, UUID> {
    Optional<MessageEntity> findByAuthor_Uuid(UUID authorId);
}
