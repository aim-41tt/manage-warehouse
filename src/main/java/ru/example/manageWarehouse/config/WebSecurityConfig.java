package ru.example.manageWarehouse.config;

import java.util.Collections;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import ru.example.manageWarehouse.model.User;
import ru.example.manageWarehouse.repositorys.UserRepositorys;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {
	
	@Autowired
	private UserRepositorys userRepositorys;
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/","/registration").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.permitAll()
				.defaultSuccessUrl("/")
			).csrf(AbstractHttpConfigurer::disable)
			.logout((logout) -> logout.permitAll());

		return http.build();
	}
	
	
	 @Bean
	  public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  }
	 
	 
	  @Bean
	    public UserDetailsService userDetailsService() {
	        return new UserDetailsService() {

	            @Override
	            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	                User user = userRepositorys.findByUsername(username);
	                
	                System.out.printf("%s , %s , %s ;;",username, user.getUsername(), user.getPassword());
	                if (user == null) {
	                    throw new UsernameNotFoundException("User not found!");
	                }
	                return new org.springframework.security.core.userdetails.User(
	                        user.getUsername(),
	                        user.getPassword(),
	                        Collections.singleton(new SimpleGrantedAuthority("USER"))
	                );
	            }
	        };
	    }
	  
	  
	  
	}


/*
.usersByUsernameQuery("select username, password from usr where username=?")
.authoritiesByUsernameQuery("select u.username, ur.roles from users u inner join user role ur on u.id = ur.user id where u.username=?");
*/


