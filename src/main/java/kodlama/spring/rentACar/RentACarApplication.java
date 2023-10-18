package kodlama.spring.rentACar;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kodlama.spring.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.spring.rentACar.core.utilities.exceptions.ProblemDetails;
import kodlama.spring.rentACar.core.utilities.exceptions.ValidationProblemDetails;

@SpringBootApplication
@RestControllerAdvice //butun controllerlar ExceptionHandler a tabi demek
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}
	
	@ExceptionHandler //burada bir hata olursa buradan gececegini bilecek
	@ResponseStatus(code=HttpStatus.BAD_REQUEST) //bu hata yakalnırsa hata statusunu ayarladık
	public ProblemDetails handleBusinessException(BusinessException businessException) { //BusinessException turunde bır hata olursa araya gırecek
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		
		return problemDetails;
	}
	
	
	@ExceptionHandler 
	@ResponseStatus(code=HttpStatus.BAD_REQUEST) 
	public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
		ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
		validationProblemDetails.setMessage("VALİDATİON.EXCEPTİON");
		validationProblemDetails.setValidationErrors(new HashMap<String,String>());
		
		for(FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		return validationProblemDetails;
	}
	
	
	@Bean //Yeni bir ModelMapper üretir ve IoC ye ekler
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
}

//Brand --> Marka
//Car--> Araba verı tabanında bunları tutucaz