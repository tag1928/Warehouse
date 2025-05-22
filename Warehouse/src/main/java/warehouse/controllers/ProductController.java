package warehouse.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import warehouse.dto.ProductJson;
import warehouse.service.ProductService;

@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController
{
	private final ProductService productService;

	@GetMapping("/{ID}")
	public ResponseEntity<ProductJson> get(@PathVariable String ID)
	{
		return ResponseEntity.ok(productService.get(ID));
	}

	@PostMapping
	public void post(@RequestBody ProductJson json)
	{
		productService.add(json);
	}

	@PutMapping
	public void put(@RequestBody ProductJson json)
	{
		productService.update(json);
	}

	@DeleteMapping("/{ID}")
	public void delete(@PathVariable String ID)
	{
		productService.delete(ID);
	}
}