package so.sonya.muswebapp2.security.details;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserDetailsWithId extends UserDetails {
    UUID getId();

    @Override
    default boolean isAccountNonExpired() {
        return true;
    }

    @Override
    default boolean isAccountNonLocked() {
        return true;
    }

    @Override
    default boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    default boolean isEnabled() {
        return true;
    }
}
