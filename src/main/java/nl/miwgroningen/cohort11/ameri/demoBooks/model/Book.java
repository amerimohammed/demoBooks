package nl.miwgroningen.cohort11.ameri.demoBooks.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Mohammed Alameri on 30/05/2023.
 * @project Book entity representation
 */
@Entity
@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
public class Book {
    @Id @GeneratedValue
    private Long bookId;
    private String title;
    private String author;
}
