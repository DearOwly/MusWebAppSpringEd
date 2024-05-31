package so.sonya.muswebapp2.mapper;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import so.sonya.muswebapp2.model.Role;

import java.util.Set;
import java.util.stream.Collectors;

public class RoleToGrantedAuthorityMapper {
    private static final String PREFIX = "ROLE_";

    public static GrantedAuthority toGrantedAuthority(Role role) {
        if (role == null) {
            return null;
        }

        return new SimpleGrantedAuthority(PREFIX + role);
    }

    public static Set<GrantedAuthority> toGrantedAuthorities(Set<Role> roles) {
        return roles.stream()
                   .map(RoleToGrantedAuthorityMapper::toGrantedAuthority)
                   .collect(Collectors.toSet());
    }
}
