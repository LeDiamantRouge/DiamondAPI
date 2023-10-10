package fr.lediamantrouge.diamondapi.database;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DataBaseCredential {

    private String host;
    private int port;
    private String user;
    private String password;
    private String database;
}
