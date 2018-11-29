
import database_management.Login;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;


import product_management.Product;
import product_management.Product_CRUD;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 80010-37-15
 */
public class Test_unit {

    Login login;
    Product product;
    Product_CRUD product_crud;

    public Test_unit() {
        try {
            login = new Login();
            product = new Product();
            product_crud = new Product_CRUD();
        } catch (SQLException ex) {
            Logger.getLogger(Test_unit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  /*  @Test
    public void create_test() {
        product.setShort_description("Description courte");
        product.setLong_description("Description longue");
        product.setPrice_bt(42.50);
        product.setPhoto("Chemin image");
        product.setQuantity(5);
        product.setTaxe(26.0);
        product.setId_supplier(1);
        product.setId_subheading(1);
        try {
            product_crud.create(product);
        } catch (SQLException ex) {
            fail(ex.getMessage());
        }
        assertTrue(true);
    }

    @Test
    public void read_test() {
        try {
            for (Product list_product : product_crud.read()) {
                System.out.println(list_product.getShort_description());
            }
        } catch (SQLException ex) {
            fail(ex.getMessage());
        }
        assertTrue(true);
    }*/
  /*  @Test
    public void update_test() throws SQLException{
        product.setId(10);
        product.setShort_description("Description courte modifier");
        product.setLong_description("Description longue modifier");
        product.setPrice_bt(42.50);
        product.setPhoto("Chemin image modifier");
        product.setQuantity(5);
        product.setTaxe(26.0);
        product.setId_supplier(1);
        product.setId_subheading(1);
        product_crud.update(product);
    }*/
    
   /* @Test
    public void delete_test() throws SQLException{
        product.setId(3);
        product_crud.delete(product);
        
    }*/
}
