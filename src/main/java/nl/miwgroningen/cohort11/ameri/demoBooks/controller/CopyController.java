package nl.miwgroningen.cohort11.ameri.demoBooks.controller;

import lombok.RequiredArgsConstructor;
import nl.miwgroningen.cohort11.ameri.demoBooks.model.Book;
import nl.miwgroningen.cohort11.ameri.demoBooks.model.Copy;
import nl.miwgroningen.cohort11.ameri.demoBooks.repository.BookRepository;
import nl.miwgroningen.cohort11.ameri.demoBooks.repository.CopyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * @author Mohammed Alameri on 31/05/2023.
 * @project Provides service api for physical copies
 */

@Controller
@RequestMapping("/copy")
@RequiredArgsConstructor
public class CopyController {
    private final BookRepository bookRepository;
    private final CopyRepository copyRepository;

    @GetMapping("/new/{bookId}")
    private String createNewCopy(@PathVariable("bookId") Long bookId){
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if(optionalBook.isPresent()){
            Copy copy = new Copy();
            copy.setBook(optionalBook.get());
            copyRepository.save(copy);
        }
        return "redirect:/book/all";
    }
}

