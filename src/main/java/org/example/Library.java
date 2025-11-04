package org.example;

public interface Library {
    void addBookToLibrary(Book book);
    void removeBookFromLibrary(Book book);
    void addBookToClient(String clientId, String bookId);
    void removeBookFromClient(String clientId, String bookId);
    void addClientToLibrary(Client client);
    void removeClientFromLibrary(String clientId);
}
