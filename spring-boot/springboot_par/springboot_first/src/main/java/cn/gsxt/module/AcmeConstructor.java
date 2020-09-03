package cn.gsxt.module;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ConfigurationProperties(prefix = "acme")
@ConstructorBinding
@Getter
@Setter
public class AcmeConstructor {

    private boolean enabled;

    private InetAddress remoteAddress;

    private final Security security;


    public AcmeConstructor(boolean enabled, InetAddress remoteAddress, Security security) {
        this.enabled = enabled;
        this.remoteAddress = remoteAddress;
        this.security = security;
    }


    @Getter
    @Setter
    public static class Security {

        private String username;

        private String password;

        private List<String> roles;

        public Security(String username, String password, List<String> roles) {
            this.username = username;
            this.password = password;
            this.roles = roles;
        }
    }
}