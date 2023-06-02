package nl.miwgroningen.cohort11.ameri.demoBooks.service;

import lombok.RequiredArgsConstructor;
import nl.miwgroningen.cohort11.ameri.demoBooks.repository.LibraryUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Mohammed Alameri on 02/06/2023.
 * @project Opdracht
 */
@Service
@RequiredArgsConstructor
public class LibraryUserDetailsService implements UserDetailsService {
    private final LibraryUserRepository libraryUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return libraryUserRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Deze gebruiker bestaat niet."));
    }
}
