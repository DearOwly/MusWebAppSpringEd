package so.sonya.muswebapp2.security.details;

import lombok.Builder;
import lombok.Singular;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;

@Builder
public final class EmailPasswordUser implements UserDetailsWithId {
    private UUID id;

    private String email;

    private String passwordHash;

    @Singular
    private Set<GrantedAuthority> authorities;

    @Builder.Default
    private boolean accountExpired = false;

    @Builder.Default
    private boolean accountLocked = false;

    @Builder.Default
    private boolean credentialsExpired = false;

    @Builder.Default
    private boolean enabled = true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !accountExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !credentialsExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public UUID getId() {
        return id;
    }
}
