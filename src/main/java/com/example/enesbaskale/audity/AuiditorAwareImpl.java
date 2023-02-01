package com.example.enesbaskale.audity;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuiditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Enes");
    }
}
