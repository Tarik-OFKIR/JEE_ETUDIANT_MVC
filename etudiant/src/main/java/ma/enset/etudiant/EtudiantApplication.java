package ma.enset.etudiant;

import ma.enset.etudiant.entites.Etudiant;
import ma.enset.etudiant.entites.Genre;
import ma.enset.etudiant.security.service.ServiceSecurity;
import ma.enset.etudiant.service.ServiceEtudiant;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class EtudiantApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtudiantApplication.class, args);

    }

    @Bean
    CommandLineRunner commandLineRunner(ServiceEtudiant service, ServiceSecurity serviceSeurity){
        return args -> {
            for (int i = 0; i < 20; i++) {
                service.saveEtudiant(new Etudiant(null, "OFKIR", "Tarik", "tarikofkir@gmail.com", new Date(), Genre.MASCULIN, true));
                service.saveEtudiant(new Etudiant(null, "Kssiba", "Akram", "akraksiba@gmail.com", new Date(), Genre.MASCULIN, true));
                service.saveEtudiant(new Etudiant(null, "BHAJY", "Mohamad", "bhajymohamad@gmail.com", new Date(), Genre.MASCULIN, true));
                service.saveEtudiant(new Etudiant(null, "LOUTFI", "Ikhlas", "ikhlasloutfi@gmail.com", new Date(), Genre.FEMININ, true));
            }

            serviceSeurity.saveNewUser("tarik", "123", "123");
            serviceSeurity.saveNewUser("akram", "123", "123");
            serviceSeurity.saveNewUser("ikhlas", "123", "123");
            serviceSeurity.saveNewUser("mohamad", "123", "123");

            serviceSeurity.saveNewRole("USER", "");
            serviceSeurity.saveNewRole("ADMIN", "");

            serviceSeurity.addRoleToUser("tarik", "USER");
            serviceSeurity.addRoleToUser("tarik", "ADMIN");
            serviceSeurity.addRoleToUser("akram", "ADMIN");
            serviceSeurity.addRoleToUser("ikhlas", "USER");
            serviceSeurity.addRoleToUser("mohamad", "USER");
        };
    }

}
