package org.example;

public interface Library {
    String addBookToLibrary(String title, String author);
    void removeBookFromLibrary(String bookId);
    void addBookToClient(String bookId, String clientId);
    void removeBookFromClient(String bookId);
    String addClientToLibrary(String firstName, String lastName);
    void removeClientFromLibrary(String clientId);
}
