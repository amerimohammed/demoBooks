package nl.miwgroningen.cohort11.ameri.demoBooks.controller;

import lombok.RequiredArgsConstructor;
import nl.miwgroningen.cohort11.ameri.demoBooks.model.Author;
import nl.miwgroningen.cohort11.ameri.demoBooks.model.Book;
import nl.miwgroningen.cohort11.ameri.demoBooks.model.Copy;
import nl.miwgroningen.cohort11.ameri.demoBooks.repository.AuthorRepository;
import nl.miwgroningen.cohort11.ameri.demoBooks.repository.BookRepository;
import nl.miwgroningen.cohort11.ameri.demoBooks.repository.CopyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Mohammed Alameri on 02/06/2023.
 * @project Opdracht
 */
@Controller
@RequiredArgsConstructor
public class SeedController {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final CopyRepository copyRepository;

    @GetMapping("/seed")
    private String seedDatabase(){
        Author patrick = new Author();
        patrick.setFirstName("Patrick");
        patrick.setLastName("Rothfuss");
        authorRepository.save(patrick);

        Set<Author> authors = new HashSet<>();
        authors.add(patrick);

        Book nameOfTheWind = new Book();
        nameOfTheWind.setAuthors(authors);
        nameOfTheWind.setTitle("The Name of the Wind");
        bookRepository.save(nameOfTheWind);

        for (int i = 0; i < 3; i++) {
            Copy copy = new Copy();
            copy.setBook(nameOfTheWind);
            if(i % 2 !=0){
                copy.setAvailable(false);
            }
            copyRepository.save(copy);
        }
        return "redirect:/";
    }
}
