package so.sonya.muswebapp2.security.details;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import so.sonya.muswebapp2.exception.AuthProviderMismatchException;
import so.sonya.muswebapp2.exception.EmailNotFoundException;
import so.sonya.muswebapp2.model.AuthProvider;
import so.sonya.muswebapp2.repository.UserRepository;

import static so.sonya.muswebapp2.mapper.RoleToGrantedAuthorityMapper.toGrantedAuthorities;

@Service
@AllArgsConstructor
public class EmailPasswordUserService implements UserDetailsService {
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findByEmail(email)
                   .filter(user -> {
                       if (!user.getAuthProvider().equals(AuthProvider.LOCAL)) {
                           throw new AuthProviderMismatchException(user.getAuthProvider(), AuthProvider.LOCAL);
                       }
                       return true;
                   })
                   .map(user -> EmailPasswordUser.builder()
                                    .email(user.getEmail())
                                    .passwordHash(user.getPasswordHash())
                                    .authorities(toGrantedAuthorities(user.getRoles()))
                                    .build())
                   .orElseThrow(() -> new EmailNotFoundException(email));
    }
}
