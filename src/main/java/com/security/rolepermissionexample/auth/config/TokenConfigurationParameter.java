package com.security.rolepermissionexample.auth.config;

import com.security.rolepermissionexample.auth.model.enums.ConfigurationParameter;
import com.security.rolepermissionexample.auth.utils.KeyConverter;
import lombok.Getter;
import org.springframework.context.annotation.Configuration;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Configuration class named {@link TokenConfigurationParameter} for token parameters used in authentication and authorization.
 */
@Getter
@Configuration
public class TokenConfigurationParameter {
    private final String issuer;
    private final int accessTokenExpireMinute;
    private final int refreshTokenExpireDay;
    private final PublicKey publicKey;
    private final PrivateKey privateKey;

    /**
     * Constructs a new {@link TokenConfigurationParameter} instance with default values from {@link ConfigurationParameter}.
     */
    public TokenConfigurationParameter() {

        this.issuer = ConfigurationParameter.ISSUER.getDefaultValue();

        this.accessTokenExpireMinute = Integer.parseInt(
                ConfigurationParameter.AUTH_ACCESS_TOKEN_EXPIRE_MINUTE.getDefaultValue()
        );

        this.refreshTokenExpireDay = Integer.parseInt(
                ConfigurationParameter.AUTH_REFRESH_TOKEN_EXPIRE_DAY.getDefaultValue()
        );

        this.publicKey = KeyConverter.convertPublicKey(
                ConfigurationParameter.AUTH_PUBLIC_KEY.getDefaultValue()
        );

        this.privateKey = KeyConverter.convertPrivateKey(
                ConfigurationParameter.AUTH_PRIVATE_KEY.getDefaultValue()
        );

    }

}
