package so.sonya.muswebapp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import so.sonya.muswebapp2.model.Message;

import java.util.Optional;
import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, UUID> {
    @Query("select m from Message m where m.author.id = :authorId")
    Optional<Message> findByAuthorId(UUID authorId);
}
