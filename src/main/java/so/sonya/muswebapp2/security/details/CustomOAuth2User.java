package so.sonya.muswebapp2.security.details;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.UUID;

public class CustomOAuth2User extends DefaultOAuth2User implements UserDetailsWithId {
    private final UUID id;

    public CustomOAuth2User(OAuth2User user, String nameAttributeKey, UUID id) {
        super(
            user.getAuthorities(),
            user.getAttributes(),
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
        return getAttribute("email");
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
