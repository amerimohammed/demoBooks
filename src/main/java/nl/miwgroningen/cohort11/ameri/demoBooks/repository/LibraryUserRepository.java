package nl.miwgroningen.cohort11.ameri.demoBooks.repository;

import nl.miwgroningen.cohort11.ameri.demoBooks.model.LibraryUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Mohammed Alameri on 02/06/2023.
 * @project Opdracht
 */
public interface LibraryUserRepository extends JpaRepository<LibraryUser, Long> {
    Optional<LibraryUser> findByUsername(String username);
}
