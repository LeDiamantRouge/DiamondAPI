package fr.lediamantrouge.diamondapi.database;

public interface IDataBaseType<CT> {

    void startConnection(DataBaseCredential credential);

    void endConnection();

    CT getConnection();
}
