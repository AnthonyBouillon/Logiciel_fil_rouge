package database_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    private final String url;
    private final String rdbms = "mysql";
    private final String hote = "localhost";
    private final String port = "3306";
    private final String database = "fil_rouge_test";
    private final String username = "root";
    private final String password = "leqxd777";

    private final Connection connection;
    private PreparedStatement request;
    private ResultSet result;

    /**
     * Connexion à la base de données
     *
     * @throws SQLException
     */
    public Login() throws SQLException {
        this.url = "jdbc:" + rdbms + "://" + hote + ":" + port + "/" + database;
        this.connection = DriverManager.getConnection(url, username, password);
    }

    /**
     * Création d'un objet requête préparer {@code prepareStatement()}.
     * ------------------------------------------------------------------------
     * Prépare à exécuter la requête.
     *
     * @param sql
     * @throws SQLException
     */
    public void setRequest_p(String sql) throws SQLException {
        request = connection.prepareStatement(sql);
    }

    public PreparedStatement getRequest_p() throws SQLException {
        return request;
    }

    /**
     * Création d'un objet requête {@code createStatement()}.
     * ------------------------------------------------------------------------
     * Renvoie le résultat de la requête {@code executeQuery(sql)}.
     *
     * @param sql
     * @throws SQLException
     */
    public void setRequest(String sql) throws SQLException {
        result = connection.createStatement().executeQuery(sql);
    }

    public ResultSet getRequest() throws SQLException {
        return result;
    }

    public Connection con() {
        return connection;
    }
}
