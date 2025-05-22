package warehouse.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import warehouse.dto.WarehouseJson;
import warehouse.service.WarehouseService;

@AllArgsConstructor
@RestController
@RequestMapping("/warehouse")
public class WarehouseController
{
	private final WarehouseService warehouseService;

	@GetMapping("/{ID}")
	public ResponseEntity<WarehouseJson> get(@PathVariable String ID)
	{
		return ResponseEntity.ok(warehouseService.get(ID));
	}

	@PostMapping
	public void post(@RequestBody WarehouseJson json)
	{
		warehouseService.add(json);
	}

	@PutMapping
	public void put(@RequestBody WarehouseJson json)
	{
		warehouseService.update(json);
	}

	@DeleteMapping("/{ID}")
	public void delete(@PathVariable String ID)
	{
		warehouseService.delete(ID);
	}
}