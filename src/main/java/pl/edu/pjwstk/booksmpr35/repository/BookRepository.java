package pl.edu.pjwstk.booksmpr35.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjwstk.booksmpr35.model.Book;
import pl.edu.pjwstk.booksmpr35.model.enums.BookType;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

List<Book> findBooksByBookType(BookType bookType);
}
