import model.Customer;

import java.sql.*;

public class MyJDBC {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/shop", "root", "");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from oc_customer");

            while (resultSet.next()) {
                System.out.println("customer_id: " + resultSet.getInt("customer_id"));
                System.out.println("firstname:" + resultSet.getString("firstname"));
                System.out.println("lastname" + resultSet.getString("lastname"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Customer getCustomerById(int customer_id) {
        Customer customer = new Customer();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/shop", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from oc_customer where customer_id = " + customer_id);

            if (resultSet.next()) {
                customer.setCustomer_id(resultSet.getInt("customer_id"));
                customer.setFirstname(resultSet.getString("firstname"));
                customer.setLastname(resultSet.getString("lastname"));

                System.out.println("customer_id: " + resultSet.getInt("customer_id"));
                System.out.println("firstname: " + resultSet.getString("firstname"));
                System.out.println("lastname: " + resultSet.getString("lastname"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

    public static Customer getCustomerByEmail(String email){
        Customer customer = new Customer();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/shop", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from oc_customer where email = " + email);

            if (resultSet.next()) {
                customer.setCustomer_id(resultSet.getInt("customer_id"));
                customer.setFirstname(resultSet.getString("firstname"));
                customer.setLastname(resultSet.getString("lastname"));
                customer.setEmail(resultSet.getString("email"));


                System.out.println("customer_id: " + resultSet.getInt("customer_id"));
                System.out.println("firstname: " + resultSet.getString("firstname"));
                System.out.println("lastname: " + resultSet.getString("lastname"));
                System.out.println("email: " + resultSet.getString("email"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

    public static void deleteUserById(int customer_id) throws SQLException {
        Customer customer = new Customer();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/shop", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("delete from oc_customer where customer_id = " + customer_id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
