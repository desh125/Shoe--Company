package lk.ijse.gdse.springboot.back_end.repo;

import lk.ijse.gdse.springboot.back_end.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<Inventory,String> {
}
