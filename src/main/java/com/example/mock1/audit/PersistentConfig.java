package com.example.mock1.audit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class PersistentConfig {
    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> Optional.of(((User)     SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
    }
}