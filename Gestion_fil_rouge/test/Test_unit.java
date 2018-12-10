
import database_management.Login;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

import product_management.Product;
import product_management.Product_CRUD;

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

    @Test
    public void create_test() {
        product.setShort_description("Description courte");
        product.setLong_description("Description longue");
        product.setPrice_bt(42.50);
        product.setPhoto("Chemin image");
        product.setQuantity(5);
        product.setTaxe(26.0);
        product.setId_supplier(1);
        product.setId_subheading(1);
        boolean data_create = false;
        try {
            product_crud.create(product);
            data_create = true;
        } catch (SQLException ex) {
            fail(ex.getMessage());
        }
        assertTrue(data_create);
    }

    @Test
    public void read_test() {
        boolean data_list = false;
        try {
            for (Product list_product : product_crud.read()) {
                System.out.println(list_product.getShort_description() + " " + list_product.getLong_description() + " " + list_product.getId() + " " + list_product.getName_subheading());
                data_list = true;
            }
        } catch (SQLException ex) {
            fail(ex.getMessage());
        }
        assertTrue(data_list);
    }

    @Test
    public void update_test() throws SQLException {
        boolean data_update = false;
        product.setId(10);
        product.setShort_description("Description courte modifier");
        product.setLong_description("Description longue modifier");
        product.setPrice_bt(42.50);
        product.setPhoto("Chemin image modifier");
        product.setQuantity(5);
        product.setTaxe(26.0);
        product.setId_supplier(1);
        product.setId_subheading(1);
        try {
            product_crud.update(product);
            data_update = true;
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertTrue(data_update);
    }

    @Test
    public void delete_test() throws SQLException {
        boolean data_delete = false;
        product.setId(3);
        try {
            product_crud.delete(product);
            data_delete = true;
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertTrue(data_delete);
    }
}
