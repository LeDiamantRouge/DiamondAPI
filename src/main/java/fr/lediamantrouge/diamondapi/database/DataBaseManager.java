package fr.lediamantrouge.diamondapi.database;

import fr.lediamantrouge.diamondapi.database.type.mysql.MySQLConnection;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Objects;

public class DataBaseManager {

    public HashMap<String, MySQLConnection> connections = new HashMap<>();


    public void createConnectionAndConnect(String name, DataBaseCredential credential) {
        Objects.requireNonNull(connections.put(name, new MySQLConnection())).startConnection(credential);
    }

    public void removeConnection(String name) {
        connections.get(name).endConnection();
    }

    public Connection getConnection(String name) {
        return connections.get(name).getConnection();
    }
}
