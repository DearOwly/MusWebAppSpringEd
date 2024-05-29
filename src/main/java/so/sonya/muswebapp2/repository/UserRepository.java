package so.sonya.muswebapp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import so.sonya.muswebapp2.model.UserEntity;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByNickname(String nickname);
}
