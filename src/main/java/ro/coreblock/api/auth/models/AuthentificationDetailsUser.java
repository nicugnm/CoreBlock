package ro.coreblock.api.auth.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthentificationDetailsUser {

    private UUID uuid;

    private String username;

    private String password;

    private String mail;
}
