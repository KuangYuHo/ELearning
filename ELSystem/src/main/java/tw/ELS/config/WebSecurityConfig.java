package tw.ELS.config;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import tw.ELS.login.model.MyLogOutHandler;
import tw.ELS.member.model.Member;
import tw.ELS.member.model.MemberService;
import tw.ELS.model.AuthUserDetailsService;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthUserDetailsService userDetailsService;
	
	@Autowired
    private MyLogOutHandler myLogOutHandler;
	
	@Autowired
	private MemberService mService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(userDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		  .authorizeRequests()
		  .antMatchers(HttpMethod.GET, "/member/**").authenticated()
		  .antMatchers(HttpMethod.GET, "/manage/**").authenticated()
		  .antMatchers(HttpMethod.GET, "/shoppingcart/**").authenticated()
		  .antMatchers(HttpMethod.GET, "/orders/**").authenticated()
		  .antMatchers(HttpMethod.GET, "/mylesson/**").authenticated()
		  .antMatchers(HttpMethod.GET).permitAll()
		  .antMatchers(HttpMethod.POST, "/member/**").authenticated()
		  .antMatchers(HttpMethod.POST, "/manage/**").authenticated()
		  .antMatchers(HttpMethod.POST, "/shoppingcart/**").authenticated()
		  .antMatchers(HttpMethod.POST, "/orders/**").authenticated()
		  .antMatchers(HttpMethod.POST, "/mylesson/**").authenticated()
		  .antMatchers(HttpMethod.POST).permitAll()
		  .anyRequest().authenticated()
		  .and()
		  .rememberMe()
		  .tokenValiditySeconds(86400)
		  .key("rememberMe-key")
		  .and()
		  .csrf().disable()
		  .formLogin().loginPage("/login/page")
		  .successHandler(new AuthenticationSuccessHandler() {
		         
		        @Override
		        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
		                Authentication authentication) throws IOException, ServletException {
		            // run custom logics upon successful login
		             
		            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		            String userAccount = userDetails.getUsername();
		            
		            Member loginOK = mService.findByAccount(userAccount);
		            
		            Date dNow = new Date( );
		    	    SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
		    	    String formatDate  = ft.format(dNow);
		    	    java.sql.Date date1 = java.sql.Date.valueOf(formatDate); 
		    	    loginOK.setLastLogIn(date1);
		    	    mService.updateMember(loginOK);
		            
		            request.getSession().setAttribute("LoginOK", loginOK);
		            request.getSession().setAttribute("loginID", loginOK.getMemberID());
		            request.getSession().setAttribute("loginAuth", loginOK.getAuthority());

		            System.out.println("The user " + userAccount + " has logged in.");
		             
		            response.sendRedirect("/index");
		        }
		    })
		  .and().logout()
		  .logoutSuccessHandler(new LogoutSuccessHandler() {
              @Override
              public void onLogoutSuccess(HttpServletRequest request,
                          HttpServletResponse response, Authentication authentication)
                      throws IOException, ServletException {
            	  
            	  request.getSession().invalidate();

                  response.sendRedirect("/index");
              }
          });
		  
	}
}
