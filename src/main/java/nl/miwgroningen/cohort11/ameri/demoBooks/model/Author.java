package nl.miwgroningen.cohort11.ameri.demoBooks.model;

import com.sun.istack.Nullable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Mohammed Alameri on 01/06/2023.
 * @project Someone who writes or is writing a book
 */
@Entity
@Setter
@Getter
public class Author {
    @Id
    @GeneratedValue
    private Long authorId;
    @Column(nullable = false)
    private String firstName;
    private String infixName = "";
    @Column(nullable = false)
    private String lastName;

    public String getDisplayName() {
        String displayName = firstName;
        if (infixName != "") {
            displayName += " " + infixName;
        }
        displayName += " " + lastName;
        return displayName;
    }

    @Override
    public String toString() {
        return getDisplayName();
    }
}
