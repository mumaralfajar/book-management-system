package com.example.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.service.BookService;
import com.example.model.Book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

public class BookControllerTest {

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllBooks() {
        Book book1 = new Book();
        Book book2 = new Book();
        when(bookService.getAllBooks()).thenReturn(Arrays.asList(book1, book2));

        ResponseEntity<List<Book>> result = bookController.getAllBooks();

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(2, result.getBody().size());
        verify(bookService, times(1)).getAllBooks();
    }

    @Test
    public void testGetBookById() {
        Book book = new Book();
        when(bookService.getBookById(1L)).thenReturn(book);

        ResponseEntity<Book> result = bookController.getBookById(1L);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        verify(bookService, times(1)).getBookById(1L);
    }

    @Test
    public void testCreateBook() {
        Book book = new Book();
        when(bookService.saveBook(book)).thenReturn(book);

        ResponseEntity<Book> result = bookController.createBook(book);

        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertNotNull(result.getBody());
        verify(bookService, times(1)).saveBook(book);
    }

    @Test
    public void testUpdateBook() {
        Book book = new Book();
        when(bookService.saveBook(book)).thenReturn(book);

        ResponseEntity<Book> result = bookController.updateBook(1L, book);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        verify(bookService, times(1)).saveBook(book);
    }

    @Test
    public void testDeleteBook() {
        doNothing().when(bookService).deleteBook(1L);

        ResponseEntity<?> result = bookController.deleteBook(1L);

        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
        verify(bookService, times(1)).deleteBook(1L);
    }
}