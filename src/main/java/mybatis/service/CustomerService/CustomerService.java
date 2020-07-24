package mybatis.service.CustomerService;

import mybatis.repository.model.Article;
import mybatis.repository.model.ArticleFilter;
import mybatis.repository.model.Customer;
import mybatis.utility.Paging;

import java.util.List;

public interface CustomerService {
    boolean addCustomer(String name,String password,String mobile,String address);
    Customer checklogin(String mobile,String password);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(int id);
    List<Customer> getCustomer();
}
