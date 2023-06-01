package nl.miwgroningen.cohort11.ameri.demoBooks.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import nl.miwgroningen.cohort11.ameri.demoBooks.model.Book;
import nl.miwgroningen.cohort11.ameri.demoBooks.repository.AuthorRepository;
import nl.miwgroningen.cohort11.ameri.demoBooks.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

/**
 * @author Mohammed Alameri on 30/05/2023.
 * @project Opdracht
 */
@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @GetMapping("/book/new")
    private String showNewBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("allAuthors", authorRepository.findAll());
        return "bookForm";
    }

    @GetMapping("/book/edit/{bookId}")
    private String showEditBookForm (@PathVariable("bookId") Long bookId, Model model){
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if(optionalBook.isPresent()){
            model.addAttribute("book", optionalBook.get());
            model.addAttribute("allAuthors", authorRepository.findAll());
            return "bookForm";
        }
        return "redirect:/book/all";
    }
    @PostMapping("/book/new")
    private String saveOrUpdateBook(@ModelAttribute("book") Book bookToBeSaved, BindingResult result) {
        if (!result.hasErrors()) {
            bookRepository.save(bookToBeSaved);
        }
        return "redirect:/";
    }

    @GetMapping("/book/delete/{bookId}")
    private String deleteBook(@PathVariable("bookId") Long bookId){
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if(optionalBook.isPresent()){
            bookRepository.delete(optionalBook.get());
        }
        return "redirect:/book/all";
    }

    @GetMapping({"/", "/book/all"})
    private String showBookOverview(Model model) {
        model.addAttribute("allBooks", bookRepository.findAll());
        return "bookOverview";
    }

    @GetMapping("/book/details/{title}")
    private String showBookDetails(@PathVariable("title") String title, Model model){
        Optional<Book> optionalBook  = bookRepository.findByTitle(title);
        if(optionalBook.isPresent()){
            model.addAttribute("bookToShowDetailsFor",  optionalBook.get());
            return "bookDetails";
        }
        return "redirect:/book/all";
    }
}
