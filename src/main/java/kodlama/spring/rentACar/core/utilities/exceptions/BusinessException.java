package kodlama.spring.rentACar.core.utilities.exceptions;

public class BusinessException extends RuntimeException{
	public BusinessException(String message) {
		super(message); // mesaji RuntimeException a gonderdik
	}
}
