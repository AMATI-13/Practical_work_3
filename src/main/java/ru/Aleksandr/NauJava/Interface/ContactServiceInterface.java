package ru.Aleksandr.NauJava.Interface;

import ru.Aleksandr.NauJava.User;

import java.util.List;

public interface ContactServiceInterface {
    void addContact(User contact);
    User getContact(Integer id);
    void updateContact(User contact);
    void removeContact(Integer id);
    List<User> getAllContacts();
}
