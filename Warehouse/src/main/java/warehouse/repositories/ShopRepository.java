package warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import warehouse.entities.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, String>
{
}