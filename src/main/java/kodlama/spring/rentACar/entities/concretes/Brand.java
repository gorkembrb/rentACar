package kodlama.spring.rentACar.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//tabloya karsılık gelecek bır class olusturuldu veya eslestırıldı denebılır
@Table(name="brands")// bunu verı tabanında brands tablosuna ata, bu bır tablodur ve ısmıde brands dır
@Data // getter ve setter ları bızım yerımıze olusturur ve prarametrısız constructor olusturur
@AllArgsConstructor //parametrelı constructor olusturur
//@Getter sadece getterlar olusur @Setter sadece setterlar, @Data bu ıkısının toplamı
@NoArgsConstructor // parametresız constructor olusturur
@Entity //veri tabanı nesnesi oldugunu belirtir
public class Brand {
	
	@Id //veri tabanında primary key alanısın
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id yı otomatık artır demek
	@Column(name="id") // veri tabanındaki id adlı kolona karsılık geleceksın
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy = "brand") // bir brand in birden fazla model i vardır -- Model içerisindeki brand ile ilişkilendirildi
	private List<Model> models;
	
	
	
}
