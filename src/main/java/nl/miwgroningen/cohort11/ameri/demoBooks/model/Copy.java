package nl.miwgroningen.cohort11.ameri.demoBooks.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Mohammed Alameri on 31/05/2023.
 * @project physical manifestation of a book
 */
@Entity
@Setter @Getter
public class Copy {

    @Id @GeneratedValue
    private Long copyId;
    private Boolean available = true;

    @ManyToOne
    private Book book;

}
