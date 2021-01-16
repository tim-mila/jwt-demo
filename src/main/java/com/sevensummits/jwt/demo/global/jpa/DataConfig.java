package com.sevensummits.jwt.demo.global.jpa;

import com.sevensummits.jwt.demo.user.ApplicationUser;
import com.sevensummits.jwt.demo.user.ApplicationUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
class DataConfig {

    @Bean
    AuditorAware<ApplicationUser> auditorProvider(final ApplicationUserService applicationUserService) {
        return new AuditorAwareImpl(applicationUserService);
    }
}
