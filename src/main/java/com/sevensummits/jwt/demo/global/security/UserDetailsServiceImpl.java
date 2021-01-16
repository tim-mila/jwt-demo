package com.sevensummits.jwt.demo.global.security;

import com.sevensummits.jwt.demo.user.ApplicationUser;
import com.sevensummits.jwt.demo.user.ApplicationUserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final ApplicationUserService applicationUserService;

    public UserDetailsServiceImpl(final ApplicationUserService applicationUserService) {
        this.applicationUserService = applicationUserService;
    }

    @Override
    public UserDetails loadUserByUsername(final String s) throws UsernameNotFoundException {
        ApplicationUser applicationUser = applicationUserService.findByUsername(s);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(s);
        }
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), Collections.emptyList());
    }
}
