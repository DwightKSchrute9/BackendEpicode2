
package dao;

import java.util.List;
import java.util.Optional;

import model.User;

public interface UserDao {

    void save(User user);

    Optional<User> findById(Long id);

    List<User> findAll();

    void update(User user);

    void delete(User user);

    void close();
}
