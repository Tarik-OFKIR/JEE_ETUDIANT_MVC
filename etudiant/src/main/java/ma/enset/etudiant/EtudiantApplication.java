package ma.enset.etudiant;

import ma.enset.etudiant.entites.Etudiant;
import ma.enset.etudiant.repositories.EtudaintRepossitory;
import ma.enset.etudiant.resourse.Genre;
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
    CommandLineRunner commandLineRunner(EtudaintRepossitory etudaintRepossitory){
        return args -> {

            etudaintRepossitory.save(new Etudiant(null,"Tarik","Ofkir","tarikofkir@gmail.com",new Date(), Genre.MASCULIN,false));
            etudaintRepossitory.save(new Etudiant(null ,"Akram","Kssiba","tarikofkir@gmail.com",new Date(), Genre.MASCULIN,false));
            etudaintRepossitory.save(new Etudiant(null ,"Anaas","Rghioui","tarikofkir@gmail.com",new Date(), Genre.MASCULIN,false));
            etudaintRepossitory.save(new Etudiant(null ,"saade","Moustakim","tarikofkir@gmail.com",new Date(), Genre.MASCULIN,false));

        };
    }

}
