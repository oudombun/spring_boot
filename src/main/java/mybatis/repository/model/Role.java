package mybatis.repository.model;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return role ;
    }

    int id;
    String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Role(int id, String role) {
        this.id = id;
        this.role = role;
    }
}
