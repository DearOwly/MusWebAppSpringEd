package so.sonya.muswebapp2.security.details;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserDetailsWithId extends UserDetails {
    UUID getId();
}
