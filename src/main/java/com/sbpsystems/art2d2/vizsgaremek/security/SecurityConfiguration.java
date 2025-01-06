package com.sbpsystems.art2d2.vizsgaremek.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable());
		http.cors(cors -> cors.disable());
		http.authorizeRequests()
			.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
			.requestMatchers("/art2d2/api/**").permitAll()
			//.antMatchers("/public/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.httpBasic(Customizer.withDefaults());
		return http.build();
	}


/*
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
			.authorizeRequests().anyRequest().authenticated()
			.and().httpBasic();
	}*/


	/*
		http.csrf().
			disable()
			.authorizeRequests()
			.antMatchers(HttpMethod.OPTIONS, "/**")
			.permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();*/
/*
		http.httpBasic(Customizer.withDefaults());
		http
			.csrf(AbstractHttpConfigurer::disable)
			.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
		return http.build();
*/
	/*
		http
			.authorizeRequests().antMatchers("/api/**").hasAnyRole("OFFER_CREATER", "AGR_LEADER", "ADMIN", "SALESPERSON", "APPROVER").anyRequest().authenticated();
	*/
		/*
		http.csrf(AbstractHttpConfigurer::disable)
			.cors(AbstractHttpConfigurer::disable)
			.authorizeHttpRequests((authorize) ->
				//authorize.anyRequest().authenticated()
				authorize
					.requestMatchers("/art2d2/api/auth/**").permitAll()
					//.requestMatchers(HttpMethod.GET, "/art2d2/api/**").permitAll()
					//.requestMatchers("/art2d2/api/auth/**").permitAll()
					.anyRequest().authenticated()

			);
		return http.build();
*/
	/*
		http
			.csrf(AbstractHttpConfigurer::disable)
			.authorizeRequests()
			.antMatchers("/login/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.httpBasic(Customizer.withDefaults())
			.formLogin(Customizer.withDefaults());

		return http.build();*/



	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}