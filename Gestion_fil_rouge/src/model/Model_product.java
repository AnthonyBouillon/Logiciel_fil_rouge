package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import product_management.Product;
import product_management.Product_CRUD;

public class Model_product extends AbstractTableModel {

    // En-tête des colonnes
    private final String[] Titles = {"Titre", "Description", "Prix", "Photo", "Quantité", "Taxe"};
    public List<Product> product_list;
    Product_CRUD product_crud;

    /**
     * Constructeur Instance de deux classes Assigne la liste qui sera utilisé
     * pour le jTable
     *
     * @throws SQLException
     */
    public Model_product() throws SQLException {
        product_crud = new Product_CRUD();
        product_list = new ArrayList();
        product_list = this.product_crud.read();
    }

    @Override
    public int getColumnCount() {
        return Titles.length;
    }

    @Override
    public String getColumnName(int column) {
        return Titles[column];
    }

    @Override
    public int getRowCount() {
        return product_list.size();
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return product_list.get(row).getShort_description();
            case 1:
                return product_list.get(row).getLong_description();
            case 2:
                return product_list.get(row).getPrice_bt();
            case 3:
                return product_list.get(row).getPhoto();
            case 4:
                return product_list.get(row).getQuantity();
            case 5:
                return product_list.get(row).getTaxe();
            default:
                return null;
        }
    }

    /**
     * Ajoute un produit dans la liste et dans la bdd
     *
     * @param product
     * @throws SQLException
     */
    public void create_product(Product product) throws SQLException {
        fireTableRowsInserted(product_list.size() - 1, product_list.size());
        product_crud.create(product);
    }

    /**
     * Renvoie la liste des produits
     *
     * @return la liste des produits
     */


    /**
     * Supprime un client dans la liste et dans la bdd
     *
     * @param i
     * @param product
     * @throws SQLException
     */
    public void delete_product(int i, Product product) throws SQLException {
        fireTableRowsDeleted(i, i);
        product_crud.delete(product);

    }

    /**
     * Actualise la liste, et potentiellement, modifie un produit dans la bdd
     *
     * @param update
     * @param product
     * @throws SQLException
     */
    public void update_product(boolean update, Product product) throws SQLException {
        product_list = product_crud.read();
        if (update == true) {
            product_crud.update(product);
        }
    }
}
