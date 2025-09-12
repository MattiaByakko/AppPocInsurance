package pocInsurance.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.*;
import java.util.stream.Collectors;

public class KeycloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {
    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        Object realmAccess = jwt.getClaims().get("realm_access");
        if (!(realmAccess instanceof Map)) {
            return Collections.emptyList();
        }

        Object rolesObj = ((Map<?, ?>) realmAccess).get("roles");
        if (!(rolesObj instanceof Collection<?> roles)) {
            return Collections.emptyList();
        }

        return roles.stream()
                .filter(Objects::nonNull)
                .map(Object::toString)
                .map(role -> "ROLE_" + role.toUpperCase()) // es. role=accountant → ROLE_ACCOUNTANT
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }
}
