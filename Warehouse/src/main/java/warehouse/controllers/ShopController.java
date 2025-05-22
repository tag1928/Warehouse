package warehouse.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import warehouse.dto.ShopJson;
import warehouse.service.ShopService;

@AllArgsConstructor
@RestController
@RequestMapping("/shop")
public class ShopController
{
	private final ShopService shopService;

	@GetMapping("/{ID}")
	public ResponseEntity<ShopJson> get(@PathVariable String ID)
	{
		return ResponseEntity.ok(shopService.get(ID));
	}

	@PostMapping
	public void post(@RequestBody ShopJson json)
	{
		shopService.add(json);
	}

	@PutMapping
	public void put(@RequestBody ShopJson json)
	{
		shopService.update(json);
	}

	@DeleteMapping("/{ID}")
	public void delete(@PathVariable String ID)
	{
		shopService.delete(ID);
	}
}