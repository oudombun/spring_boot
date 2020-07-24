package mybatis.service;

import mybatis.repository.ArticleRepository.ArticleRepository;
import mybatis.repository.CustomerRepository.CustomerRepository;
import mybatis.repository.model.Article;
import mybatis.repository.model.ArticleFilter;
import mybatis.repository.model.Customer;
import mybatis.service.ArticleService.ArticleService;
import mybatis.service.CustomerService.CustomerService;
import mybatis.utility.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public boolean addCustomer(String name,String password,String mobile,String address) {
        return customerRepository.addCustomer(name,password,mobile,address);
    }

    @Override
    public Customer checklogin(String mobile, String password) {
        return customerRepository.checklogin(mobile,password);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return customerRepository.updateCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(int id) {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public List<Customer> getCustomer() {
        return customerRepository.getCustomer();
    }
}
