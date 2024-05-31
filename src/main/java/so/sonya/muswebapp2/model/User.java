package so.sonya.muswebapp2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import so.sonya.muswebapp2.converter.RoleSetConverter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "users")
public class User extends AbstractEntity {
    @Email
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
