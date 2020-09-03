package com.example.demo;

import com.example.demo.book.Book;
import com.example.demo.book.BookRepository;
import com.example.demo.book.BookService;
import com.example.demo.book.BookStatus;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    @Mock
    BookRepository bookRepository;

    @Test
    public void save(){
        Book book = new Book();

        when(bookRepository.save(book)).thenReturn(book);

        BookService bookService = new BookService(bookRepository);
        Book result = bookService.save(book);

        assertThat(book.getCreated()).isNotNull();
        assertThat(book.getBookStatus()).isEqualTo(BookStatus.DRAFT);
        assertThat(result).isNotNull();

    }
}
