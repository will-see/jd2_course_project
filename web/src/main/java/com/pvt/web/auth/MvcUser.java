package com.pvt.web.auth;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.security.Principal;
import java.util.Collection;

@Setter
@Getter
@EqualsAndHashCode
public class MvcUser extends User implements Principal {

    private String name;
    private String displayName;

    public MvcUser(String name, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.name = name;
        populateDisplayName();
    }

    public MvcUser(String name, String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.name = name;
        populateDisplayName();
    }

    public MvcUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public MvcUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    @Override
    public String getName() {
        return getUsername();
    }

    private void populateDisplayName() {
        name = (name + " ").trim();
        displayName = !StringUtils.isBlank(name) ? name : getUsername();
    }
}
