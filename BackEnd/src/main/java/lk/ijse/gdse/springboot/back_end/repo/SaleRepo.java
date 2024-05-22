package lk.ijse.gdse.springboot.back_end.repo;

import lk.ijse.gdse.springboot.back_end.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SaleRepo extends JpaRepository<Sale,String> {
    @Query(value = "SELECT orderNo FROM Sale ORDER BY orderNo DESC LIMIT 1", nativeQuery = true)
    String getLastId();
}
