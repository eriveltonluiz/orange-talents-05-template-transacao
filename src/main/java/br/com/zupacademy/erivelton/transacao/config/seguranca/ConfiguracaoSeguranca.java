package br.com.zupacademy.erivelton.transacao.config.seguranca;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

@Configuration
public class ConfiguracaoSeguranca extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests(authorizeRequests -> authorizeRequests.antMatchers(HttpMethod.GET, "/api/transacoes/**")
				.hasAnyAuthority("SCOPE_transacoes:read")
				.anyRequest().authenticated()
				)
		.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
	}

}
