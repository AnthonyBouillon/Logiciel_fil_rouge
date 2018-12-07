package order_management;

import database_management.Login;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Order_CRUD {

    Login login;
    Order order;
    // Constructeur | Deux classes instanciés

    public Order_CRUD() throws SQLException {
        login = new Login();
        order = new Order();
    }

    /**
     * Ajoute dans la liste les produits de la base de données
     *
     * @param year
     * @return @throws SQLException
     */
    public List<Order> read(int year) throws SQLException {
        List<Order> list_order = new ArrayList();
        login.setRequest_p("SELECT commande_produit.id_produit AS \"Référence\", produit.description_court_produit AS \"Nom du produit\", SUM(commande_produit.quantite) AS \"Quantité commandée\", fournisseur.nom_fournisseur AS \"Fournisseur\" FROM commande_produit\n"
                + "JOIN produit ON commande_produit.id_produit = produit.id_produit\n"
                + "JOIN fournisseur ON produit.id_fournisseur = fournisseur.id_fournisseur\n"
                + "JOIN commande ON commande.id_commande = commande_produit.id_commande\n"
                + "WHERE year(commande.date_commande) = ? GROUP BY commande_produit.id_produit");
        login.getRequest_p().setInt(1, year);
        login.getRequest_p().execute();
        ResultSet result = login.getRequest_p().executeQuery();
        while (result.next()) {
            order = new Order();
            order.setId_product(result.getInt("Référence"));
            order.setName_product(result.getString("Nom du produit"));
            order.setQuantity_product(result.getInt("Quantité commandée"));
            order.setName_supplier(result.getString("Fournisseur"));
            list_order.add(order);
        }
        return list_order;

    }

}
