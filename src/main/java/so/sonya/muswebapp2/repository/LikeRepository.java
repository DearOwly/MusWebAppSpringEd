package so.sonya.muswebapp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import so.sonya.muswebapp2.model.LikeEntity;

import java.util.UUID;

public interface LikeRepository extends JpaRepository<LikeEntity, UUID> {
}
