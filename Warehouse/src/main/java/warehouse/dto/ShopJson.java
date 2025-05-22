package warehouse.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ShopJson
{
	@JsonProperty("id") private String ID;
	@JsonProperty("name") private String name;

	@JsonProperty("product_ids") private List<String> productIDs = new ArrayList<>();
	@JsonProperty("warehouse_ids") private List<String> warehouseIDs = new ArrayList<>();
}