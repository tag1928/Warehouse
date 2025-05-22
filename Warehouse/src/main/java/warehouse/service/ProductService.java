package warehouse.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import warehouse.dto.ProductJson;
import warehouse.entities.Product;
import warehouse.repositories.ProductRepository;

@AllArgsConstructor
@Service
public class ProductService
{
	private final ProductRepository productRepository;

	private boolean isNotValid(ProductJson json)
	{
		if (json.getID() == null) return true;
		if (json.getName() == null) return true;
		if (json.getID().isBlank()) return true;
		if (json.getName().isBlank()) return true;

		return false;
	}

	private void printProduct(Product product)
	{
		System.out.println("ID: " + product.getID());
		System.out.println("Name: " + product.getName());
		System.out.println("Price: " + product.getPrice());
		System.out.println("Quantity: " + product.getQuantity());
		System.out.println("Shop ID: " + product.getShopID());
		System.out.println("Warehouse ID: " + product.getWarehouseID());
	}

	private Product convert(ProductJson json)
	{
		Product product = new Product();

		product.setID(json.getID());
		product.setName(json.getName());
		product.setPrice(json.getPrice());
		product.setQuantity(json.getQuantity());
		product.setShopID(json.getShopID());
		product.setWarehouseID(json.getWarehouseID());

		return product;
	}

	private ProductJson convert(Product product)
	{
		ProductJson json = new ProductJson();

		json.setID(product.getID());
		json.setName(product.getName());
		json.setPrice(product.getPrice());
		json.setQuantity(product.getQuantity());
		json.setShopID(product.getShopID());
		json.setWarehouseID(product.getWarehouseID());

		return json;
	}

	public ProductJson get(String ID)
	{
		Product product = productRepository.getReferenceById(ID);
		return convert(product);
	}

	public void add(ProductJson json)
	{
		if (isNotValid(json)) return;

		Product product = convert(json);

		productRepository.save(product);

		System.out.println("Added a new product:");
		printProduct(product);
	}

	public void update(ProductJson json)
	{
		if (isNotValid(json)) return;

		Product product = convert(json);

		productRepository.deleteById(product.getID());
		productRepository.save(product);

		System.out.println("Updated a product:");
		printProduct(product);
	}

	public void delete(String ID)
	{
		productRepository.deleteById(ID);

		System.out.println("Deleted a product with ID: " + ID);
	}
}