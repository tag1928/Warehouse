package warehouse.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import warehouse.dto.ShopJson;
import warehouse.entities.Shop;
import warehouse.entities.ShopWarehouse;
import warehouse.repositories.ShopRepository;
import warehouse.repositories.ShopWarehouseRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ShopService
{
	private final ShopRepository shopRepository;
	private final ShopWarehouseRepository shopWarehouseRepository;

	private boolean isNotValid(ShopJson json)
	{
		if (json.getID() == null) return true;
		if (json.getName() == null) return true;
		if (json.getID().isBlank()) return true;
		if (json.getName().isBlank()) return true;

		return false;
	}

	private void printShop(Shop shop)
	{
		System.out.println("ID: " + shop.getID());
		System.out.println("Name: " + shop.getName());
	}

	private Shop convert(ShopJson json)
	{
		Shop shop = new Shop();
		shop.setID(json.getID());
		shop.setName(json.getName());

		return shop;
	}

	public ShopJson convert(Shop shop)
	{
		ShopJson json = new ShopJson();
		json.setID(shop.getID());
		json.setName(shop.getName());

		return json;
	}

	public ShopJson get(String ID)
	{
		Shop shop = shopRepository.getReferenceById(ID);

		ShopJson output = convert(shop);
		output.setWarehouseIDs(shopWarehouseRepository.findWarehouseIdsByShopId(ID));
		output.setProductIDs(shopWarehouseRepository.findProductIdsByShopId(ID));

		return output;
	}

	public void add(ShopJson json)
	{
		if (isNotValid(json)) return;

		Shop shop = convert(json);

		shopRepository.save(shop);

		List<ShopWarehouse> shopWarehouses = new ArrayList<>();

		for (String x : json.getWarehouseIDs())
		{
			ShopWarehouse shopWarehouse = new ShopWarehouse();
			shopWarehouse.setShopID(shop.getID());
			shopWarehouse.setWarehouseID(x);

			shopWarehouses.add(shopWarehouse);
		}

		shopWarehouseRepository.saveAll(shopWarehouses);

		System.out.println("Added a new shop:");
		printShop(shop);
	}

	public void update(ShopJson json)
	{
		if (isNotValid(json)) return;

		Shop shop = convert(json);

		shopRepository.deleteById(shop.getID());
		shopRepository.save(shop);

		List<ShopWarehouse> shopWarehouses = new ArrayList<>();

		for (String x : json.getWarehouseIDs())
		{
			ShopWarehouse shopWarehouse = new ShopWarehouse();
			shopWarehouse.setShopID(shop.getID());
			shopWarehouse.setWarehouseID(x);

			shopWarehouses.add(shopWarehouse);
		}

		shopWarehouseRepository.saveAll(shopWarehouses);

		System.out.println("Updated a shop:");
		printShop(shop);
	}

	public void delete(String ID)
	{
		shopRepository.deleteById(ID);

		System.out.println("Deleted a shop with ID: " + ID);
	}
}