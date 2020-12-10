package ee.khk.ikt.demo.repository;

import ee.khk.ikt.demo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByLogin(String login);
}
