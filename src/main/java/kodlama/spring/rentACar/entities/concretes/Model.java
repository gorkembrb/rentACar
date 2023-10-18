package kodlama.spring.rentACar.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="models")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Model {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne // Model cok kere tekrarlanıyor bir Brand için
	@JoinColumn(name = "brand_id") //Model tablosu icin bir brand_id alanı koyacak ve bu brand_id ile brand arasında ilişki kuracak
	private Brand brand;
	
	@OneToMany(mappedBy = "model")
	private List<Car> cars;
	
}
