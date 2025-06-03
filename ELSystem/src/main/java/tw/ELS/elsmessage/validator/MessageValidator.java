package tw.ELS.elsmessage.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import tw.ELS.elsmessage.model.ELSMessage;


public class MessageValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return ELSMessage.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "messageinformation", "productBean.name.error", "留言欄位不能為空");
		
	}

}
