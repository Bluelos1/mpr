package pl.edu.pjwstk.booksmpr35.repository;

import pl.edu.pjwstk.booksmpr35.model.Book;

import java.util.HashMap;
import java.util.List;

public class BookRepository {
    //Utowrzyć strukture zpaisu danych
    //Utworzyc operacje CRUD -> 5 metod z odpowiednim typem zwracanym
    //Utworzyć klase testów
    //Utworzyć implementację testów korzystając z podejścia TDD
    //Dodać pole Long id do klasy Book
    //Implelemtancja getBookById(Long id) i deleteBook(Long id) powinna zwracac
    //  wyjątek IllegalArgumentException jak nie znajdzie książki o wskazanym ID
    //Dodac przypadek testowy, który będzie sprawdzał czy metoda zwraca w/w wyjatek

    private HashMap<Long, Book> bookHashMap = new HashMap<>();

    public Book createBook(Book book){
        book.setId(findMaxId());
        bookHashMap.put(book.getId(),book);
                return book;
    }

    public void deleteBook(Long id){
        if(bookHashMap.containsKey(id)){
            bookHashMap.remove(id);
        }
        else throw new IllegalArgumentException();
    }

    Book getBookById(Long id){
        if (bookHashMap.containsKey(id)){
            return bookHashMap.get(id);
        }
        throw new IllegalArgumentException();
    }

    public List<Book> getAllBooks(){return bookHashMap.values().stream().toList();}

    public Book updateBook(Long id, Book updatedBook){
        Book bookToUpdate = getBookById(id);

        if(updatedBook.getPublisher() != null ){
            bookToUpdate.setPublisher(updatedBook.getPublisher());
        }

        if(updatedBook.getTitle() != null){
            bookToUpdate.setTitle(updatedBook.getTitle());
        }

        if(updatedBook.getAuthor() != null){
            bookToUpdate.setAuthor(updatedBook.getAuthor());
        }

        bookHashMap.put(id, bookToUpdate);

        return bookToUpdate;

    }

    private Long findMaxId(){
        if (bookHashMap.size() == 0){
            return 0L;
        }
        return bookHashMap.keySet().stream()
                .mapToLong(a->a)
                .max()
                .getAsLong()+1;
    }
}
