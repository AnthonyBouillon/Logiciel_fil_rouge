/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product_management;

import database_management.Login;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 80010-37-15
 */
public class Product_CRUD {

    Login login;
    Product product;
    private String sql;

    // Constructeur | Deux classes instanciés
    public Product_CRUD() throws SQLException {
        login = new Login();
        product = new Product();
    }

    public void create(Product product) throws SQLException {
        sql = "INSERT INTO produit"
                + "(description_court_produit, description_long_produit, prix_ht_produit, photo_produit, quantite_produit, tva, id_fournisseur, id_sous_rubrique) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        login.setRequest_p(sql);
        login.getRequest_p().setString(1, product.getShort_description());
        login.getRequest_p().setString(2, product.getLong_description());
        login.getRequest_p().setDouble(3, product.getPrice_bt());
        login.getRequest_p().setString(4, product.getPhoto());
        login.getRequest_p().setInt(5, product.getQuantity());
        login.getRequest_p().setDouble(6, product.getTaxe());
        login.getRequest_p().setInt(7, product.getId_supplier());
        login.getRequest_p().setInt(8, product.getId_subheading());
        login.getRequest_p().execute();
    }

    public List<Product> read() throws SQLException {
        List<Product> list_product = new ArrayList();
        login.setRequest("SELECT * FROM produit");
        while (login.getRequest().next()) {
            // Un produit dans la liste = un objet
            product = new Product();
            product.setId(login.getRequest().getInt("id_produit"));
            product.setShort_description(login.getRequest().getString("description_court_produit"));
            product.setLong_description(login.getRequest().getString("description_long_produit"));
            product.setPrice_bt(login.getRequest().getDouble("prix_ht_produit"));
            product.setPhoto(login.getRequest().getString("photo_produit"));
            product.setQuantity(login.getRequest().getInt("quantite_produit"));
            product.setTaxe(login.getRequest().getDouble("tva"));
            product.setId_supplier(login.getRequest().getInt("id_fournisseur"));
            product.setId_subheading(login.getRequest().getInt("id_sous_rubrique"));
            list_product.add(product);
        }
        return list_product;

    }

    public void update(Product product) throws SQLException {
        
        login.setRequest_p("UPDATE produit SET description_court_produit = ?, description_long_produit = ?, prix_ht_produit = ?, photo_produit = ?, quantite_produit = ?, tva = ?, id_fournisseur = ?, id_sous_rubrique = ? WHERE id_produit = ?");
        login.getRequest_p().setInt(9, product.getId());
        login.getRequest_p().setString(1, product.getShort_description());
        login.getRequest_p().setString(2, product.getLong_description());
        login.getRequest_p().setDouble(3, product.getPrice_bt());
        login.getRequest_p().setString(4, product.getPhoto());
        login.getRequest_p().setInt(5, product.getQuantity());
        login.getRequest_p().setDouble(6, product.getTaxe());
        login.getRequest_p().setInt(7, product.getId_supplier());
        login.getRequest_p().setInt(8, product.getId_subheading());
        login.getRequest_p().execute();
    }

    public void delete(Product product) throws SQLException {
        login.setRequest_p("DELETE FROM commande_produit WHERE id_produit = ?");
        login.getRequest_p().setInt(1, product.getId());
        login.getRequest_p().execute();

        login.setRequest_p("DELETE FROM livraison_produit WHERE id_produit = ?");
        login.getRequest_p().setInt(1, product.getId());
        login.getRequest_p().execute();

        login.setRequest_p("DELETE FROM produit WHERE id_produit = ?");
        login.getRequest_p().setInt(1, product.getId());
        login.getRequest_p().execute();
    }
}
