package pl.edu.pjwstk.booksmpr35.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.edu.pjwstk.booksmpr35.model.Author;
import pl.edu.pjwstk.booksmpr35.repository.AuthorRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthorServiceTest {

    AuthorService authorService;
    @Mock
    AuthorRepository authorRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void Should_CreateAuthorWithCorrectInput() {
        //given
        Author a = new Author();
        //when
        when(authorRepository.save(any())).thenReturn(new Author(99L,"Mateusz","Placha"));
        authorService.createAuthor(a);
        //then
        assertNotNull(a.getFirstName());
        assertNotNull(a.getLastName());

    }

    @Test
    void Should_ThrowIllegalArgumentExceptionWhenNotFound() {
        //given

        //when
        when(authorRepository.findAuthorByFirstNameAndLastName(anyString(),anyString()))
                .thenReturn(Optional.of(new Author()));
        //then
        assertThrows(IllegalArgumentException.class, ()->{
            authorService.findAuthorByNameAndLastName(anyString(),anyString());
        });
    }

    @Test
    void getAuthorById() {
    }

    @Test
    void deleteAuthorById() {
    }

    @Test
    void findAuthorByNameAndLastName() {
    }
}