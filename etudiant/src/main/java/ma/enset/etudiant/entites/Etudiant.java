package ma.enset.etudiant.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.etudiant.resourse.Genre;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Etudiant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String prenom;
    private String email;
    @Temporal(TemporalType.DATE)
    private Date dateDeNeaissance;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private boolean regle;
}
