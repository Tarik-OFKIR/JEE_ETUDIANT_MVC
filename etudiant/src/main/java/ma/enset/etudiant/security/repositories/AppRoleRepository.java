package ma.enset.etudiant.security.repositories;


import ma.enset.etudiant.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    AppRole findAppRoleByRoleName(String rolename);
}
