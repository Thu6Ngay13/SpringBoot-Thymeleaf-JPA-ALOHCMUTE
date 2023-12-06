package hcmute.alohcmute.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SpringSecurity {
    
	@Autowired
	private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
    	        .csrf(csrf -> csrf.disable())
    	        .authorizeHttpRequests((authorize) -> authorize
    	        				.requestMatchers("/register/**").permitAll()
    	        				.requestMatchers("/user/**").hasAnyRole("ADMIN", "USER")
    	        				.requestMatchers("/admin/**").hasAnyRole("ADMIN")
    	        				.anyRequest().authenticated()
    	        )
    	        .formLogin(
    	                form -> form
    	                        .loginPage("/login").loginProcessingUrl("/login")
    	                        .usernameParameter("username").passwordParameter("password")
    	                        .defaultSuccessUrl("/user", true)
    	                        .permitAll()
    	        )
    	        .logout(
    	                logout -> logout
    	                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
    	                        .permitAll()
    	        )
    	        .exceptionHandling(
    	        		except -> except
    	        				.accessDeniedPage("/403")
    	        )
    	        .build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
    
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
    	return (web) -> web.ignoring().requestMatchers("/css/**", "/images/**", "/js/**");
    }
}