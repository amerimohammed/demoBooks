package nl.miwgroningen.cohort11.ameri.demoBooks.repository;

import nl.miwgroningen.cohort11.ameri.demoBooks.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Mohammed Alameri on 30/05/2023.
 * @project Opdracht
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitle(String title);
}
