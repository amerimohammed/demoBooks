package nl.miwgroningen.cohort11.ameri.demoBooks.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * @author Mohammed Alameri on 30/05/2023.
 * @project Book entity representation
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Book {
    @Id
    @GeneratedValue
    private Long bookId;

    @Column(unique = true)
    private String title;

    @ManyToMany
    private Set<Author> authors;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Copy> copies;

    public int getNumberOfAvailableCopies() {
        int count = 0;

        for (Copy copy : copies) {
            if (copy.getAvailable()) {
                count++;
            }
        }

        return count;
    }

    public String getAllAuthorsDisplayNames() {
        StringBuilder authorsString = new StringBuilder();

        for (Author author : authors) {
            authorsString.append(author.getDisplayName()).append(" ");
        }

        return authorsString.toString();
    }
}
