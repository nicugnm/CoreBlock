package ro.coreblock.api.auth.models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AuthentificationDetailsUser {

    private UUID uuid;

    private String username;

    private String password;

    private String mail;
}
