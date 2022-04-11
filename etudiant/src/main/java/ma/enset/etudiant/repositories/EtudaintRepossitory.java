package ma.enset.etudiant.repositories;

import ma.enset.etudiant.entites.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudaintRepossitory extends JpaRepository<Etudiant,Long> {

    Etudiant findEtudiantByNome(String nome);
    Etudiant deleteEtudiantByid(Long id);
    Page<Etudiant> findByNomeContains(String keyword, Pageable pageable);
}
