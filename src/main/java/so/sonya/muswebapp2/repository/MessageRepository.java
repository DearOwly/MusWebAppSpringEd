package so.sonya.muswebapp2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import so.sonya.muswebapp2.model.Message;

import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, UUID> {
    @Query("select m from Message m where m.author.id = :authorId")
    Page<Message> findAllByAuthorId(UUID authorId, Pageable pageable);

    @Query("select t.messages from Thread t where t.id = :threadId")
    Page<Message> findAllByThreadId(UUID threadId, Pageable pageable);

}
