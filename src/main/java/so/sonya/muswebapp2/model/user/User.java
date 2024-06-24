package so.sonya.muswebapp2.model.user;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import so.sonya.muswebapp2.converter.persistence.RoleSetConverter;
import so.sonya.muswebapp2.model.base.AbstractEntity;

import java.util.Set;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class User extends AbstractEntity {
    @Column(unique = true, nullable = false)
    String email;

    @Column(nullable = false)
    @Builder.Default
    Boolean emailVerified = false;

    String givenName;

    String familyName;

    String nickName;

    String passwordHash;

    @ManyToMany
    Set<User> followers;

    @ManyToMany(mappedBy = "followers")
    Set<User> following;

    @Convert(converter = RoleSetConverter.class)
    Set<Role> roles;

    @Enumerated(EnumType.STRING)
    AuthProvider authProvider;

    String authProviderId;
}
