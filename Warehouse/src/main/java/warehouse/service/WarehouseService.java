package warehouse.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import warehouse.dto.WarehouseJson;
import warehouse.entities.Warehouse;
import warehouse.repositories.ShopWarehouseRepository;
import warehouse.repositories.WarehouseRepository;

@AllArgsConstructor
@Service
public class WarehouseService
{
	private final WarehouseRepository warehouseRepository;
	private final ShopWarehouseRepository shopWarehouseRepository;

	private boolean isNotValid(WarehouseJson json)
	{
		if (json.getID() == null) return true;
		if (json.getName() == null) return true;
		if (json.getID().isBlank()) return true;
		if (json.getName().isBlank()) return true;

		return false;
	}

	private void printWarehouse(Warehouse warehouse)
	{
		System.out.println("ID: " + warehouse.getID());
		System.out.println("Name: " + warehouse.getName());
	}

	private Warehouse convert(WarehouseJson json)
	{
		Warehouse warehouse = new Warehouse();
		warehouse.setID(json.getID());
		warehouse.setName(json.getName());

		return warehouse;
	}

	public WarehouseJson get(String ID)
	{
		WarehouseJson output = new WarehouseJson();
		Warehouse warehouse = warehouseRepository.getReferenceById(ID);

		output.setID(ID);
		output.setName(warehouse.getName());
		output.setShopIDs(shopWarehouseRepository.findShopIdsByWarehouseId(ID));

		return output;
	}

	public void add(WarehouseJson json)
	{
		if (isNotValid(json)) return;

		Warehouse warehouse = convert(json);

		warehouseRepository.save(warehouse);

		System.out.println("Added a warehouse:");
		printWarehouse(warehouse);
	}

	public void update(WarehouseJson json)
	{
		if (isNotValid(json)) return;

		Warehouse warehouse = convert(json);

		warehouseRepository.deleteById(warehouse.getID());
		warehouseRepository.save(warehouse);

		System.out.println("Updated a warehouse:");
		printWarehouse(warehouse);
	}

	public void delete(String ID)
	{
		warehouseRepository.deleteById(ID);
		System.out.println("Deleted a warehouse with ID: " + ID);
	}
}