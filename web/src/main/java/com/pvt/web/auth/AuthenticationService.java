package com.pvt.web.auth;

import com.pvt.entities.Role;
import com.pvt.entities.User;
import com.pvt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("authService")
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = (User)userService.getByLogin(login);
        System.out.println("User : " + user);
        if (user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new MvcUser(user. getName(), user.getLogin(), user.getPassword(),
                isUserActive(user.getRole().getRoleName()), true, true, true, getGrantedAuthorities(user));
    }

    private boolean isUserActive(String status) {
        if (status.equals("DEL") || status.equals("GUE") || status.equals("")) return false;
        return true;
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        Role role = user.getRole(); {
            System.out.println("PersonProfile : " + role.getRoleName());
            authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getRoleName()));
        }
        System.out.print("authorities :" + authorities);
        return authorities;
    }

}
