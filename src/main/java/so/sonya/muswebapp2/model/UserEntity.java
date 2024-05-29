package so.sonya.muswebapp2.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "user_table")
public class UserEntity extends AbstractEntity {
    @Column(length = 20)
    String nickname;
    String email;
    String password;
    //ToDo: add logic here
    @OneToMany
    Set<UserEntity> followers;
    @OneToMany
    Set<UserEntity> following;
    //ToDo: add avatar field????
    @Enumerated(value = EnumType.STRING)
    Role role;

    public enum Role{
        ADMIN,
        USER
    }
}
