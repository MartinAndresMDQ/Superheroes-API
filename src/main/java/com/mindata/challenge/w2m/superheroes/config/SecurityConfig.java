package com.mindata.challenge.w2m.superheroes.config;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig {

//	@Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http
//		.authorizeHttpRequests((authorize) -> authorize
//			.requestMatchers("/swagger-ui", "/h2-console").permitAll()
//			.requestMatchers("/api/superheroes/todos","/api/superheroes/traer/","/api/superheroes/buscar").permitAll()
//			.requestMatchers("/api/superheroes/crear","/api/superheroes/actualizar","/api/superheroes/borrar").hasAnyRole("ADMIN")
//			.anyRequest().authenticated()
//		)
//		.formLogin(login -> login
//				.defaultSuccessUrl("/")
//				.permitAll())
//		.logout(logout -> logout
//				.logoutSuccessUrl("/"));
//        return http.build();
//    }
//	
//	@Bean
//	PasswordEncoder passwordEncoder() {
//		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}
//	
//	@Bean
//	UserDetailsManager inMemoryUserDetailsManager() {
////		var user1 = User.withUsername("user").password("{noop}password").roles("USER").build();
//		var user2 = User.withUsername("admin").password("{noop}password").roles("USER", "ADMIN").build();
//		return new InMemoryUserDetailsManager(user2);
//	}
}