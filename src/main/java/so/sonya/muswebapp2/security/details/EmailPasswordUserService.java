package so.sonya.muswebapp2.security.details;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import so.sonya.muswebapp2.model.user.AuthProvider;
import so.sonya.muswebapp2.repository.UserRepository;
import so.sonya.muswebapp2.security.exception.AuthProviderMismatchException;
import so.sonya.muswebapp2.security.exception.EmailNotFoundException;

import static so.sonya.muswebapp2.mapper.RoleToGrantedAuthorityMapper.toGrantedAuthorities;

@Service
@RequiredArgsConstructor
public class EmailPasswordUserService implements UserDetailsService {
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findByEmail(email)
                         .filter(user -> {
                             if (!user.getAuthProvider()
                                      .equals(AuthProvider.LOCAL)) {
                                 throw new AuthProviderMismatchException(user.getAuthProvider(), AuthProvider.LOCAL);
                             }
                             return true;
                         })
                         .map(user -> EmailPasswordUser.builder()
                                                       .id(user.getId())
                                                       .email(user.getEmail())
                                                       .passwordHash(user.getPasswordHash())
                                                       .authorities(toGrantedAuthorities(user.getRoles()))
                                                       .build())
                         .orElseThrow(() -> new EmailNotFoundException(email));
    }
}
