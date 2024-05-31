package so.sonya.muswebapp2.security.details;

import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;
import so.sonya.muswebapp2.exception.AuthProviderMismatchException;
import so.sonya.muswebapp2.model.AuthProvider;
import so.sonya.muswebapp2.model.User;
import so.sonya.muswebapp2.repository.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomOidcUserService extends OidcUserService {
    private final UserRepository repository;

    @Override
    public OidcUser loadUser(OidcUserRequest request) throws OAuth2AuthenticationException {
        OidcUser user = super.loadUser(request);
        return processUser(request, user);
    }

    private OidcUser processUser(OidcUserRequest request, OidcUser oidcUser) {
        String nameAttributeKey = request.getClientRegistration()
                                           .getProviderDetails()
                                           .getUserInfoEndpoint()
                                           .getUserNameAttributeName();

        String email = oidcUser.getEmail();

        Optional<User> userOptional = repository.findByEmail(email);
        User user;

        if (userOptional.isPresent()) {
            user = userOptional.get();

            AuthProvider userAuthProvider = user.getAuthProvider();
            AuthProvider authProvider = getAuthProvider(request);

            if (!userAuthProvider.equals(authProvider)) {
                throw new AuthProviderMismatchException(userAuthProvider, authProvider);
            }

            user = updateUser(user, oidcUser);
        } else {
            user = createUser(request, oidcUser);
        }

        return new CustomOidcUser(oidcUser, nameAttributeKey, user.getId());
    }

    private User updateUser(User user, OidcUser oidcUser) {
        user.setGivenName(oidcUser.getGivenName());
        user.setFamilyName(oidcUser.getFamilyName());

        return repository.save(user);
    }

    private User createUser(OidcUserRequest request, OidcUser oidcUser) {
        User user = User.builder()
                        .authProvider(getAuthProvider(request))
                        .authProviderId(oidcUser.getSubject())
                        .email(oidcUser.getEmail())
                        .emailVerified(oidcUser.getEmailVerified())
                        .givenName(oidcUser.getGivenName())
                        .familyName(oidcUser.getFamilyName())
                        .build();

        return repository.save(user);
    }

    private AuthProvider getAuthProvider(OidcUserRequest request) {
        return AuthProvider.valueOf(request.getClientRegistration().getRegistrationId().toUpperCase());
    }
}
