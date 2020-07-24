package mybatis.repository.CustomerRepository;

import mybatis.repository.model.Article;
import mybatis.repository.model.ArticleFilter;
import mybatis.repository.model.Customer;
import mybatis.repository.provider.ArticleProvider;
import mybatis.utility.Paging;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository {
    @Insert("insert into tbl_customer (name,password,mobile,address) values(#{name},#{password},#{mobile},#{address})")
    boolean addCustomer(String name,String password,String mobile,String address);

    @Select("select * from tbl_customer where mobile=#{mobile} and password=#{password}")
    @Results({
            @Result(property = "name",column = "name"),
            @Result(property = "mobile",column = "mobile"),
            @Result(property = "address",column = "address")
    })
    Customer checklogin(String mobile,String password);

    @Update("update tbl_customer set name = #{name},mobile = #{mobile},address = #{address} where id = #{id}")
    boolean updateCustomer(Customer customer);

    @Delete("delete from tbl_customer where id = #{id}")
    boolean deleteCustomer(int id);

    @Select("select * from tbl_customer order by a.id asc")
    @Results({
            @Result(property = "name",column = "name"),
            @Result(property = "mobile",column = "mobile"),
            @Result(property = "address",column = "address")
    })
    List<Customer> getCustomer();

}
