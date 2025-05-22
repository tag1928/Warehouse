package warehouse.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "warehouse")
@Getter
@Setter
public class Warehouse
{
	@Id
	@Column(name = "id") private String ID;
	@Column(name = "name") private String name;
}