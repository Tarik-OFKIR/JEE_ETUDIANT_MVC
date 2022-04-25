package ma.enset.etudiant.security.repositories;


import ma.enset.etudiant.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String> {
    AppUser findAppUserByUserName(String username);
}
