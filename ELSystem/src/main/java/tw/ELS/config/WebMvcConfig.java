package tw.ELS.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login/page").setViewName("login");
		registry.addViewController("/logout").setViewName("logoutResult");
		registry.addViewController("/logout/page").setViewName("logout");
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/testm").setViewName("member/updateme1");



	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		
		
		registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/resources/css/");
		registry.addResourceHandler("/assets/**").addResourceLocations("/WEB-INF/resources/assets/");
		registry.addResourceHandler("/vendors/**").addResourceLocations("/WEB-INF/resources/vendors/");
		registry.addResourceHandler("/vendor/**").addResourceLocations("/WEB-INF/resources/vendor/");
		registry.addResourceHandler("/fonts/**").addResourceLocations("/WEB-INF/resources/fonts/");
		registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/resources/images/");
		registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/resources/js/");


		registry.addResourceHandler("/memberImg/**").addResourceLocations("file:/C:/memberImg/");
	}
}
