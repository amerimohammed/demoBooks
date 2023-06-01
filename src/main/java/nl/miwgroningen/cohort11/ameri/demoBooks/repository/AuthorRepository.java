package nl.miwgroningen.cohort11.ameri.demoBooks.repository;

import nl.miwgroningen.cohort11.ameri.demoBooks.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
