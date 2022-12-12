package pl.edu.pjwstk.booksmpr35.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjwstk.booksmpr35.model.Author;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
Optional<Author> findAuthorByFirstNameAndLastName(String firstName, String lastName);

Author findAuthorByFirstName(String firstName);
Author save(Author author);

}
