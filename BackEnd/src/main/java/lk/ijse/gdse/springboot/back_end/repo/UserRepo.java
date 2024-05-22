package lk.ijse.gdse.springboot.back_end.repo;

import lk.ijse.gdse.springboot.back_end.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
}
