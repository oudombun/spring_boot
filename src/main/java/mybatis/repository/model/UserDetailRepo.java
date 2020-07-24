package mybatis.repository.model;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailRepo {
    @Select("Select * from tbl_users where username=#{username}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "role",column = "id",many = @Many(select = "findRolesByUserId")),
    })
    User loadUserByUsername(String username);

    @Select("select r.* from tbl_role r inner join tbl_user_roles u on r.id=u.role_id where u.user_id=#{id}")
    List<Role> findRolesByUserId(int id);
}

