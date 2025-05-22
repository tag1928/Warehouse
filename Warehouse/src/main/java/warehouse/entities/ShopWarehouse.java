package warehouse.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "shop_warehouse")
@Getter
@Setter
public class ShopWarehouse
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long ID;

	@Column(name = "shop_id") private String shopID;
	@Column(name = "warehouse_id") private String warehouseID;
}