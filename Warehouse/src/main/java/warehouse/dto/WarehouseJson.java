package warehouse.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class WarehouseJson
{
	@JsonProperty("id")
	private String ID;
	@JsonProperty("name")
	private String name;

	@JsonProperty("shop_ids")
	private List<String> shopIDs = new ArrayList<>();
}