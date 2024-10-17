package ru.Aleksandr.NauJava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.Aleksandr.NauJava.User;

@Component
public class CommandProcessor {
    private final UserService userService;

    @Autowired
    public CommandProcessor(UserService userService) {
        this.userService = userService;
    }

    public void processCommand(String input) {
        String[] cmd = input.split(" ");
        switch (cmd[0].toLowerCase()) {
            case "create" -> {
                if (cmd.length < 4) {
                    System.out.println("Использование: create <id> <name> <phone> <email>");
                    return;
                }
                Long id = Long.valueOf(cmd[1]);
                String name = cmd[2];
                String phone = cmd[3];
                String email = cmd[4];
                userService.addUser(new User(id, name, phone, email)); // Предполагается, что User имеет конструктор с этими параметрами
                System.out.println("Пользователь успешно добавлен...");
            }
            case "get" -> {
                if (cmd.length < 2) {
                    System.out.println("Использование: get <id>");
                    return;
                }
                Long id = Long.valueOf(cmd[1]);
                User user = userService.getUser(id);
                if (user != null) {
                    System.out.println("Пользователь: " + user);
                } else {
                    System.out.println("Пользователь с таким ID не найден.");
                }
            }
            case "update" -> {
                if (cmd.length < 5) {
                    System.out.println("Использование: update <id> <name> <phone> <email>");
                    return;
                }
                Long id = Long.valueOf(cmd[1]);
                String name = cmd[2];
                String phone = cmd[3];
                String email = cmd[4];
                userService.updateUser(new User(id, name, phone, email)); // Предполагается, что User имеет конструктор с этими параметрами
                System.out.println("Пользователь успешно обновлен...");
            }
            case "delete" -> {
                if (cmd.length < 2) {
                    System.out.println("Использование: delete <id>");
                    return;
                }
                Long id = Long.valueOf(cmd[1]);
                userService.removeUser(id);
                System.out.println("Пользователь успешно удален...");
            }
            case "list" -> {
                System.out.println("Список всех пользователей:");
                userService.getAllUsers().forEach(System.out::println);
            }
            default -> System.out.println("Введена неизвестная команда...");
        }
    }
}