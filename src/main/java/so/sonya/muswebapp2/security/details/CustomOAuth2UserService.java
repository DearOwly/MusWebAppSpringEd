package so.sonya.muswebapp2.security.details;

import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import so.sonya.muswebapp2.exception.AuthProviderMismatchException;
import so.sonya.muswebapp2.model.AuthProvider;
import so.sonya.muswebapp2.model.User;
import so.sonya.muswebapp2.repository.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    private final UserRepository repository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest request) throws OAuth2AuthenticationException {
        OAuth2User user = super.loadUser(request);
        return processUser(request, user);
    }

    private OAuth2User processUser(OAuth2UserRequest request, OAuth2User oAuth2User) {
        String nameAttributeKey = request.getClientRegistration()
                                      .getProviderDetails()
                                      .getUserInfoEndpoint()
                                      .getUserNameAttributeName();

        String email = oAuth2User.getAttribute("email");

        Optional<User> userOptional = repository.findByEmail(email);
        User user;

        if (userOptional.isPresent()) {
            user = userOptional.get();

            AuthProvider userAuthProvider = user.getAuthProvider();
            AuthProvider authProvider = getAuthProvider(request);

            if (!userAuthProvider.equals(authProvider)) {
                throw new AuthProviderMismatchException(userAuthProvider, authProvider);
            }

            user = updateUser(user, oAuth2User);
        } else {
            user = createUser(request, oAuth2User);
        }

        return new CustomOAuth2User(oAuth2User, nameAttributeKey, user.getId());
    }

    private User updateUser(User user, OAuth2User oAuth2User) {
        user.setGivenName(oAuth2User.getAttribute("given_name"));
        user.setFamilyName(oAuth2User.getAttribute("family_name"));
        return repository.save(user);
    }

    private User createUser(OAuth2UserRequest request, OAuth2User oAuth2User) {
        User user = User.builder()
                        .authProvider(AuthProvider.valueOf(request.getClientRegistration().getRegistrationId().toUpperCase()))
                        .authProviderId(oAuth2User.getAttribute("sub"))
                        .email(oAuth2User.getAttribute("email"))
                        .emailVerified(oAuth2User.getAttribute("email_verified"))
                        .givenName(oAuth2User.getAttribute("given_name"))
                        .familyName(oAuth2User.getAttribute("family_name"))
                        .build();

        return repository.save(user);
    }

    private AuthProvider getAuthProvider(OAuth2UserRequest request) {
        return AuthProvider.valueOf(request.getClientRegistration().getRegistrationId().toUpperCase());
    }
}
