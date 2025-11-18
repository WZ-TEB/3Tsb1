package org.example;

import java.util.HashMap;
import java.util.UUID;

public class LibraryImpl implements Library {

    HashMap<String, Book> bookMap =  new HashMap<>();
    HashMap<String, Client> clientMap =  new HashMap<>();
    HashMap<String, String> booksRentedToClientsMap = new HashMap<>();

    @Override
    public String addBookToLibrary(String title, String author) {
        Book book = new Book(title, author);
        String bookId = UUID.randomUUID().toString();
        book.setBookId(bookId);
        bookMap.put(bookId, book);
        return bookId;
    }

    @Override
    public void removeBookFromLibrary(String bookId) {
        bookMap.remove(bookId);
    }

    @Override
    public void addBookToClient(String bookId, String clientId) {
        booksRentedToClientsMap.put(bookId, clientId);
    }

    @Override
    public void removeBookFromClient(String bookId) {
        booksRentedToClientsMap.remove(bookId);
    }

    @Override
    public String addClientToLibrary(String firstName, String lastName) {
        Client client = new Client(firstName, lastName);
        String clientId = UUID.randomUUID().toString();
        client.setClientId(clientId);
        clientMap.put(clientId, client);
        return clientId;
    }

    @Override
    public void removeClientFromLibrary(String clientId) {
        clientMap.remove(clientId);
    }
}
