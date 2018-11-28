/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import product_management.Product;
import product_management.Product_CRUD;

/**
 *
 * @author 80010-37-15
 */
public class Model_product extends AbstractTableModel {

    private final String[] Titles = {"Titre", "Description", "Prix", "Photo", "Quantité", "Taxe"};
    Product_CRUD product_crud;
    List<Product> product_list;

    public Model_product() throws SQLException {
        product_crud = new Product_CRUD();
        product_list = new ArrayList();
        product_list = product_crud.read();
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

    public void add_client(Product product) throws SQLException {
        fireTableRowsInserted(product_list.size() - 1, product_list.size());
        product_crud.create(product);
    }

    public void delete_client(int i, Product product) throws SQLException {
        fireTableRowsDeleted(i, i);
        product_crud.delete(product);
    }

    public void actualise() throws SQLException {
        product_list = product_crud.read();
    }
}
