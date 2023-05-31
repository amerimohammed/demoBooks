package nl.miwgroningen.cohort11.ameri.demoBooks.repository;

import nl.miwgroningen.cohort11.ameri.demoBooks.model.Copy;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Mohammed Alameri on 31/05/2023.
 * @project Opdracht
 */
public interface CopyRepository extends JpaRepository<Copy, Long> {
}
