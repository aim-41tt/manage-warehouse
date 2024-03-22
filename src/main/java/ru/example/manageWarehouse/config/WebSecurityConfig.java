package ru.example.manageWarehouse.config;

import java.util.Collection;
import java.util.stream.Collectors;

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
				.permitAll().defaultSuccessUrl("/", true)

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
	               
	                if (user == null) {
	                    throw new UsernameNotFoundException("User not found!");
	                }
	                
	                Collection<SimpleGrantedAuthority> authorities = user.getRoles().stream()
	                        .map(role -> new SimpleGrantedAuthority(user.getRoles().toString()))
	                        .collect(Collectors.toList());


	                
	                return new org.springframework.security.core.userdetails.User(
	                		user.getUsername(),
	                        user.getPassword(),
	                        authorities
	                        );
	            }
	        };
	    }
	  
	  
	  
	}



