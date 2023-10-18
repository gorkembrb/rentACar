package kodlama.spring.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import kodlama.spring.rentACar.business.abstracts.BrandService;
import kodlama.spring.rentACar.business.requests.CreateBrandRequest;
import kodlama.spring.rentACar.business.requests.UpdateBrandRequest;
import kodlama.spring.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.spring.rentACar.business.responses.GetByIdBrandResponse;
import kodlama.spring.rentACar.entities.concretes.Brand;

@RestController // annotation (bilgilendirme ifadesi)
//uygulam calısma esnasında bu class restcontroller dememkkı burası erısım noktası olarak anlıyor
@RequestMapping("/api/brands") // adresleme
//kontrol merkezıyle bır yontemle ıletısım kurmalı
//adresin sonuna api/brands derse bu controlleru kastedıyor demektir
public class BrandsController {
	// Api isimlendirmelerinde cogul kullanılır.http keywordlerınden kaynaklı
	// servisi kullanıcak

	private BrandService brandService;

	@Autowired
	public BrandsController(BrandService brandService) { // bunun yerine @AllArgsConstructor yazılabılır
		this.brandService = brandService;
	}

	@GetMapping() //Data çekmek için -- bunu getAll ısmı ıle cagrıbılsın yanı boyle bır ıstek geldıgınde bu fonk calısacak
	public List<GetAllBrandsResponse> getAll() {
		return brandService.getAll();
	}
	
	@GetMapping("/{id}") //suslu parantez olursa bu variable demek
	public GetByIdBrandResponse getById(@PathVariable int id) { //api/brands/1 gibi path üzerinden değeri oku
		return brandService.getById(id);
	}
	
	@PostMapping() //eklemeler için
	@ResponseStatus(code=HttpStatus.CREATED) //bunun http statulerınden 201 yanı onun bır nesne olusturdugunu anlatır. postla 201(Created) dondursun dıye bu ıslemı yapıoruz
	public void add(@RequestBody() @Valid CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest);
	}
	
	@PutMapping
	public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
		
		this.brandService.update(updateBrandRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.brandService.delete(id);
	}

}
