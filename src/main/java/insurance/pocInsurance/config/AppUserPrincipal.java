/*package pocInsurance.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pocInsurance.config.AppUserInfo;

import java.util.Collection;

public class AppUserPrincipal implements UserDetails {
    private final AppUserInfo userInfo;
    private final Collection<? extends GrantedAuthority> authorities;

    public AppUserPrincipal(AppUserInfo userInfo, Collection<? extends GrantedAuthority> authorities) {
        this.userInfo = userInfo;
        this.authorities = authorities;
    }

    public AppUserInfo getAppUser() {
        return userInfo;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null; // password lato backend non necessaria
    }

    @Override
    public String getUsername() {
        return userInfo.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }
}
*/