package com.sevensummits.jwt.demo.global.jpa;

import com.sevensummits.jwt.demo.user.ApplicationUser;
import com.sevensummits.jwt.demo.user.ApplicationUserService;
import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<ApplicationUser> {

    private final ApplicationUserService applicationUserService;

    public AuditorAwareImpl(final ApplicationUserService applicationUserService) {
        this.applicationUserService = applicationUserService;
    }

    @Override
    @NonNull
    public Optional<ApplicationUser> getCurrentAuditor() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return Optional.of(applicationUserService.findByUsername(authentication.getName()));
    }

}
