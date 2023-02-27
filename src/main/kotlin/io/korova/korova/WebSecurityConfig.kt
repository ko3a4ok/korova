package io.korova.korova

import javax.sql.DataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.JdbcUserDetailsManager
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class WebSecurityConfig {

  @Order(1)
  @Bean
  fun apiFilterChain(http: HttpSecurity): SecurityFilterChain {
    http.authorizeRequests()
      .requestMatchers("/css/**").permitAll()
      .requestMatchers("/korova/**").hasAuthority("ROLE_ADMIN")
      .requestMatchers("/user/**").hasAuthority("ROLE_USER")
      .and()
      .formLogin().loginPage("/log-in")

    return http.build()
  }

  @Bean
  fun userDetailsService(dataSource: DataSource): UserDetailsService {
    return JdbcUserDetailsManager(dataSource)
  }

}
