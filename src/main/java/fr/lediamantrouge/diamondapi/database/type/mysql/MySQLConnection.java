package fr.lediamantrouge.diamondapi.database.type.mysql;

import fr.lediamantrouge.diamondapi.database.DataBaseCredential;
import fr.lediamantrouge.diamondapi.database.IDataBaseType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLConnection implements IDataBaseType<Connection> {

    Connection conn;

    @Override
    public void startConnection(DataBaseCredential credential) {
        String url = "jdbc:mysql://" + credential.getHost() + ":" + credential.getPort() + "/" + credential.getDatabase();
        Properties props = new Properties();
        props.setProperty("user", credential.getUser());
        props.setProperty("password", credential.getPassword());
        props.setProperty("characterEncoding", "UTF-8");
        props.setProperty("autoReconnect", "true");

        try {
            conn = DriverManager.getConnection(url, props);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void endConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Connection getConnection() {
        return conn;
    }
}
