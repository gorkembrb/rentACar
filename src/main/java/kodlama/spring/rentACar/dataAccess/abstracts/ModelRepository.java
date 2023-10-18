package kodlama.spring.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.spring.rentACar.entities.concretes.Model;

public interface ModelRepository extends JpaRepository<Model, Integer>{ // calistigimiz tip model- primary key(Id) tipi integer
	
}
