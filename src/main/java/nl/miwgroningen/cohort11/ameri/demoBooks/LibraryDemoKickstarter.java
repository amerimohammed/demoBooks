package nl.miwgroningen.cohort11.ameri.demoBooks;

import lombok.RequiredArgsConstructor;
import nl.miwgroningen.cohort11.ameri.demoBooks.model.LibraryUser;
import nl.miwgroningen.cohort11.ameri.demoBooks.repository.LibraryUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Mohammed Alameri on 02/06/2023.
 * Get the application of the ground
 */
@SpringBootApplication
@RequiredArgsConstructor
public class LibraryDemoKickstarter implements CommandLineRunner {
    private final LibraryUserRepository libraryUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if(libraryUserRepository.findByUsername("admin").isEmpty()){
            LibraryUser admin = new LibraryUser();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("changeThisNow"));
            libraryUserRepository.save(admin);
            System.err.println("Admin created remember to change the password!");
        }else {
            System.err.println("Admin already exists nothing to do here");
        }
    }
}
