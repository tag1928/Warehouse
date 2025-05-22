package warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;
import warehouse.entities.ShopWarehouse;

import java.util.List;

@Repository
public interface ShopWarehouseRepository extends JpaRepository<ShopWarehouse, Long>
{
	@NativeQuery("SELECT shop_id FROM shop_warehouse WHERE warehouse_id = ?1")
	List<String> findShopIdsByWarehouseId(String ID);

	@NativeQuery("SELECT warehouse_id FROM shop_warehouse WHERE shop_id = ?1")
	List<String> findWarehouseIdsByShopId(String ID);

	@NativeQuery("SELECT id FROM product WHERE shop_id = ?1")
	List<String> findProductIdsByShopId(String ID);
}