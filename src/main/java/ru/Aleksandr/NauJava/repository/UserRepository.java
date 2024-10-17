package ru.Aleksandr.NauJava.repository;

import org.springframework.stereotype.Repository;
import ru.Aleksandr.NauJava.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository implements CRUDRepository<User, Integer> {
    private final Map<Integer, User> userDatabase = new HashMap<>();
    private static int userCounter = 0;

    @Override
    public void create(User user) {
        userCounter++;
        user.setId(userCounter++);
        userDatabase.put(user.getId(), user);
    }

    @Override
    public User read(Integer id) {
        return userDatabase.get(id);
    }

    @Override
    public void update(User user) {
        userDatabase.put(user.getId(), user);
    }

    @Override
    public void delete(Integer id) {
        userDatabase.remove(id);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(userDatabase.values());
    }
}