package ru.Aleksandr.NauJava.Interface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.Aleksandr.NauJava.User;
import ru.Aleksandr.NauJava.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements ContactServiceInterface {
    private UserRepository userRepository;
    private final ru.Aleksandr.NauJava.repository.UserRepository UserRepository;

    @Autowired
    public UserService(UserRepository contactRepository) {
        this.UserRepository = contactRepository;
    }

    @Override
    public void addContact(User contact) {
        UserRepository.create(contact);
    }

    @Override
    public User getContact(Integer id) {
        return UserRepository.read(id);
    }

    @Override
    public void updateContact(User contact) {
        UserRepository.update(contact);
    }

    @Override
    public void removeContact(Integer id) {
        UserRepository.delete(id);
    }

    @Override
    public List<User> getAllContacts() {
        return UserRepository.findAll();
    }

    public void addUser(User user) {
    }
}
