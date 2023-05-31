package nl.miwgroningen.cohort11.ameri.demoBooks.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import nl.miwgroningen.cohort11.ameri.demoBooks.model.Book;
import nl.miwgroningen.cohort11.ameri.demoBooks.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Mohammed Alameri on 30/05/2023.
 * @project Opdracht
 */
@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;

    @GetMapping("/book/new")
    private String showBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "bookForm";
    }

    @PostMapping("/book/new")
    private String saveOrUpdateBook(@ModelAttribute("book") Book bookToBeSaved, BindingResult result) {
        if (!result.hasErrors()) {
            bookRepository.save(bookToBeSaved);
        }
        return "redirect:/";
    }

    @GetMapping({"/", "/book/all"})
    private String showBookOverview(Model model) {
        model.addAttribute("allBooks", bookRepository.findAll());
        return "bookOverview";
    }
}
