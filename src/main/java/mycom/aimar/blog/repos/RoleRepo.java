package mycom.aimar.blog.repos;

import mycom.aimar.blog.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {
    Role findByRoleName(String roleName);
}
