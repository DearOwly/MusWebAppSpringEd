package so.sonya.muswebapp2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import so.sonya.muswebapp2.model.Thread;

import java.util.UUID;

public interface ThreadRepository extends JpaRepository<Thread, UUID> {
    @Query("select t from Thread t where t.author.id = :authorId")
    Page<Thread> findAllByAuthorId(UUID authorId, Pageable pageable);
}
