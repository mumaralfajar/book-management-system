package com.example.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    @Test
public void testEqualsAndHashCode() {
    Book book1 = new Book();
    book1.setId(1L);
    book1.setTitle("Test Title");
    book1.setAuthor("Test Author");
    book1.setIsbn("123456789");

    Book book2 = new Book();
    book2.setId(1L);
    book2.setTitle("Test Title");
    book2.setAuthor("Test Author");
    book2.setIsbn("123456789");

    assertEquals(book1, book2);
    assertEquals(book1.hashCode(), book2.hashCode());
}

    @Test
    public void testToString() {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Test Title");
        book.setAuthor("Test Author");
        book.setIsbn("123456789");

        String expected = "Book(id=1, title=Test Title, author=Test Author, isbn=123456789)";
        assertEquals(expected, book.toString());
    }
}
