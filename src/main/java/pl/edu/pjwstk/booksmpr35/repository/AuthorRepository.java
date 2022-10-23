package pl.edu.pjwstk.booksmpr35.repository;

import pl.edu.pjwstk.booksmpr35.model.Author;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AuthorRepository {

    HashMap<Long, Author> authorHashMap = new HashMap<>();

    public Author createAuthor(Author author){
        author.setId(findMaxId());
        authorHashMap.put(author.getId(),author);
        return author;
    }

    private Long findMaxId() {
        if(authorHashMap.size() == 0) {
            return 0L;
        }
        return authorHashMap.keySet().stream()
                .mapToLong(a-> a)
                .max()
                .getAsLong();
    }

    public List<Author> getAllAuthors(){

        return new ArrayList<>(authorHashMap.values());
    }

    public Author getAuthorById(Long id){
        if(authorHashMap.containsKey(id)){
            return authorHashMap.get(id);
        }
        throw new IllegalArgumentException();
    }

    public Author updateAuthor(Long id, Author author){
        //todo
        return null;
    }


    public void deleteAuthorById(Long id){
        if(authorHashMap.containsKey(id)){
            authorHashMap.remove(id);
        }
        throw new IllegalArgumentException();
    }
}
