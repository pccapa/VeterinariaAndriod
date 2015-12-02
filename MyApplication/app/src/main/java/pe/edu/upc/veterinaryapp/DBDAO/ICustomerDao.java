package pe.edu.upc.veterinaryapp.DBDAO;

import java.util.List;

import pe.edu.upc.veterinaryapp.entities.Customer;


public interface ICustomerDao {
    Customer fetchCustomerById(int idCustomer);
     List<Customer> fetchAllCustomers();
    // add Customer
     boolean addCustomer(Customer customer);
    // add Customers in bulk
     boolean addCustomers(List<Customer> customer);
    boolean deleteAllCustomers();
}
