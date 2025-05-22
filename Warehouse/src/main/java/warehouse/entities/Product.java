package warehouse.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "product")
@Getter
@Setter
public class Product
{
	@Id
	@Column(name = "id") private String ID;
	@Column(name = "name") private String name;
	@Column(name = "price") private double price;
	@Column(name = "quantity") private int quantity;

	@Column(name = "shop_id") private String shopID;
	@Column(name = "warehouse_id") private String warehouseID;
}