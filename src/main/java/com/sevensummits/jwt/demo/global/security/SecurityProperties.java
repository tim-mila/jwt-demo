package com.sevensummits.jwt.demo.global.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "application.security")
public class SecurityProperties {

    private String tokenSecretKey;
    private long tokenExpirationTimeout;

    public String getTokenSecretKey() {
        return tokenSecretKey;
    }

    public void setTokenSecretKey(final String tokenSecretKey) {
        this.tokenSecretKey = tokenSecretKey;
    }

    public long getTokenExpirationTimeout() {
        return tokenExpirationTimeout;
    }

    public void setTokenExpirationTimeout(final long tokenExpirationTimeout) {
        this.tokenExpirationTimeout = tokenExpirationTimeout;
    }
}
