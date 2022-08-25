package io.miso.apitest.config

import mu.KotlinLogging
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

private val logger = KotlinLogging.logger {}

@Configuration
@EnableWebSecurity
class SecurityConfiguration {

    @Bean
    @Throws(Exception::class)
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf().disable().authorizeRequests()
            .antMatchers("/**").permitAll()
            .anyRequest().authenticated();
        return http.build()
    }

    @Bean
    fun userDetailsService(): UserDetailsService {
        val encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()
        val secret = encoder.encode("password")
        val user: UserDetails = User.withUsername("user")
            .password("{noop}password")
            .roles("USER")
            .build()

        logger.info { "Secret: $secret" }

        return InMemoryUserDetailsManager(user)
    }
}
