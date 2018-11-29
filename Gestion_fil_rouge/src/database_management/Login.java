/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 80010-37-15
 */
public class Login {

    private final String url = "jdbc:mysql://localhost:3306/fil_rouge_test";
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
        this.connection = DriverManager.getConnection(url, username, password);
    }

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

}
