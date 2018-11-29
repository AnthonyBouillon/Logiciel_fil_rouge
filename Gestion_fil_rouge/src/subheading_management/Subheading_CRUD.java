/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subheading_management;

import database_management.Login;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 80010-37-15
 */
public class Subheading_CRUD {

    Login login;
    Subheading subheading;

    public Subheading_CRUD() throws SQLException {
        login = new Login();
        subheading = new Subheading();
    }

    public List<Subheading> read() throws SQLException {

        List<Subheading> list_subheading = new ArrayList();

        login.setRequest("SELECT * FROM sous_rubrique");

        while (login.getRequest().next()) {
            subheading = new Subheading();
            subheading.setId(login.getRequest().getInt("id_sous_rubrique"));
            subheading.setName(login.getRequest().getString("nom_sous_rubrique"));
            subheading.setId_heading(login.getRequest().getInt("id_rubrique"));
            list_subheading.add(subheading);
        }

        return list_subheading;
    }
}
