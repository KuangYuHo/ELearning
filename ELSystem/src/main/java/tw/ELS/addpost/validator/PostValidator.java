package tw.ELS.addpost.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import tw.ELS.addpost.model.AddPost;





public class PostValidator implements Validator {


	@Override
	public boolean supports(Class<?> clazz) {
		
		return AddPost.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,  "postType", "productBean.name.error", "分類欄位不能為空");

	}


}
