package so.sonya.muswebapp2.security.details;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import java.util.UUID;

public class CustomOidcUser extends DefaultOidcUser implements UserDetailsWithId {
    private final UUID id;

    public CustomOidcUser(OidcUser user, String nameAttributeKey, UUID id) {
        super(
            user.getAuthorities(),
            user.getIdToken(),
            user.getUserInfo(),
            nameAttributeKey
        );
        this.id = id;
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public UUID getId() {
        return id;
    }
}
