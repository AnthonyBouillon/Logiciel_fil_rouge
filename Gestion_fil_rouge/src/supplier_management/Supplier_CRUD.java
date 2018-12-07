package supplier_management;

import database_management.Login;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Supplier_CRUD {

    Supplier supplier;
    Login login;

    public Supplier_CRUD() throws SQLException {
        login = new Login();
    }

    /**
     * Ajoute dans la liste les données des fournisseurs
     *
     * @return la liste des fournisseurs
     * @throws SQLException
     */
    public List<Supplier> read() throws SQLException {
        
        ArrayList<Supplier> list_supplier = new ArrayList();
        login.setRequest("SELECT * FROM fournisseur");
        while (login.getRequest().next()) {
            supplier = new Supplier();
            supplier.setId(login.getRequest().getInt("id_fournisseur"));
            supplier.setName(login.getRequest().getString("nom_fournisseur"));
            supplier.setFirstname(login.getRequest().getString("prenom_fournisseur"));
            supplier.setPhone(login.getRequest().getString("telephone_fournisseur"));
            supplier.setEmail(login.getRequest().getString("email_fournisseur"));
            supplier.setAddress(login.getRequest().getString("adresse_fournisseur"));
            list_supplier.add(supplier);
        }
        return list_supplier;
        
    }
}
