package warehouse.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "shop")
@Getter
@Setter
public class Shop
{
	@Id
	@Column(name = "id") private String ID;
	@Column(name = "name") private String name;
}