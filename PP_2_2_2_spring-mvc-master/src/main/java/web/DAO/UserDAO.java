package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDAO {
    // Вывести список
    List<User> findAll();

    // Получить по ID
    User getUserById(int id);

    // Добавить в БД
    void saveUser(User user);

    // Изменить данные в БД
    void updateUser(User user);

    // Удалить
    void deleteUser(int id);
}
