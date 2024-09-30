package net.youssfi.observabilityspringgrafana.repository;

import net.youssfi.observabilityspringgrafana.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author mohamedyoussfi
 **/
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
