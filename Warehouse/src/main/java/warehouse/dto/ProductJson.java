package warehouse.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductJson
{
	@JsonProperty("id") private String ID;
	@JsonProperty("name") private String name;
	@JsonProperty("price") private double price;
	@JsonProperty("quantity") private int quantity;

	@JsonProperty("shop_id") private String shopID;
	@JsonProperty("warehouse_id") private String warehouseID;
}