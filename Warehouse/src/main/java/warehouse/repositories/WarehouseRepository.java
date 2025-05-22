package warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import warehouse.entities.Warehouse;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, String>
{
}