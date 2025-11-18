package org.example;

import static org.junit.jupiter.api.Assertions.*;

class LibraryImplTest {

    LibraryImpl testLibrary;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        testLibrary = new LibraryImpl();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        testLibrary = null;
    }

    @org.junit.jupiter.api.Test
    void addBookToLibrary() {
        //given
        String title = "TestTitle";
        String author = "TestAuthor";
        //when
        testLibrary.addBookToLibrary(title, author);
        //then
        assertEquals(1, testLibrary.bookMap.size());
    }

    @org.junit.jupiter.api.Test
    void removeBookFromLibrary() {
        //given
        String title = "TestTitle";
        String author = "TestAuthor";
        String bookId = testLibrary.addBookToLibrary(title, author);
        //when
        testLibrary.removeBookFromLibrary(bookId);
        //then
        assertEquals(0, testLibrary.bookMap.size());
        assertTrue(testLibrary.bookMap.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void addBookToClient() {
        //given
        String title = "TestTitle";
        String author = "TestAuthor";
        String bookId = testLibrary.addBookToLibrary(title, author);
        String testFirstName = "TestFirstName";
        String testLastName = "TestLastName";
        String clientId = testLibrary.addClientToLibrary(testFirstName, testLastName);
        //when
        testLibrary.addBookToClient(bookId, clientId);
        //then
        assertEquals(1, testLibrary.booksRentedToClientsMap.size());
    }

    @org.junit.jupiter.api.Test
    void removeBookFromClient() {
        //given
        String title = "TestTitle";
        String author = "TestAuthor";
        String bookId = testLibrary.addBookToLibrary(title, author);
        String testFirstName = "TestFirstName";
        String testLastName = "TestLastName";
        String clientId = testLibrary.addClientToLibrary(testFirstName, testLastName);
        testLibrary.addBookToClient(bookId, clientId);
        //when
        testLibrary.removeBookFromClient(bookId);
        //then
        assertEquals(0, testLibrary.booksRentedToClientsMap.size());
        assertTrue(testLibrary.booksRentedToClientsMap.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void addClientToLibrary() {
        //given - dane wejściowe
        String testFirstName = "TestFirstName";
        String testLastName = "TestLastName";
        //when - wywołujemy metodę testowaną - addClientToLibrary
        testLibrary.addClientToLibrary(testFirstName, testLastName);
        //then - sprawdzamy efekt - assert!
        assertEquals(1, testLibrary.clientMap.size());
    }

    @org.junit.jupiter.api.Test
    void removeClientFromLibrary() {
        //given
        String testFirstName = "TestFirstName";
        String testLastName = "TestLastName";
        String clientId = testLibrary.addClientToLibrary(testFirstName, testLastName);
        //when
        testLibrary.removeClientFromLibrary(clientId);
        //then
        assertTrue(testLibrary.clientMap.isEmpty());
    }
}