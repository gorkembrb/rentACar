package kodlama.spring.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.spring.rentACar.entities.concretes.Brand;

// veri tabanı temel operasyonlarının cogu hazır
public interface BrandRepository extends JpaRepository<Brand, Integer> { // brandın idsinin turu ineteger
	boolean existsByName(String name); //exists gördügü anda true false donduren bir sorgu olusturur (name e gore)--spring jpa keywords
}
