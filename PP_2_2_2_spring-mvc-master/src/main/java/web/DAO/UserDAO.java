package web.DAO;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    // Вывести список
    public List<User> findAll() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    // Получить по ID
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    // Добавить в БД
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    // Изменить данные в БД
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    // Удалить
    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}