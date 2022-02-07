package com.sboot.sijak.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


//Spring-Security = 보안 + 인증 open platform
//WebSecurityConfigurerAdapter 제공 confgure 메소드를 override 하여 내장 로그인이 아닌 개발자 생성 로그인 화면 사용 가능

//메모리에 사용자의 저장소가 있는 in-memory: 계정이 적고 변경이 적을떄
//db는 .datasource 사용
@Configuration
@EnableWebSecurity
public class WSecurityConfig extends WebSecurityConfigurerAdapter{
	
	//httpBasic: basic auth 사용 (base64 encoding, https 사용 권장)
	//username, password 입력시 base64 encoding 하여 request 마다 server에 전달
	//server는 실제 사용자 인지 확인 
	protected void configure(HttpSecurity hs1) throws Exception{
		//http 기반 인증 및 사용자 인증 요청만 요청 허용
		hs1.httpBasic().and().authorizeRequests()
		//kaja/login 경로인 특정 경로로만 지정하여 접근 허용
		.antMatchers("/kaja/login").permitAll()
		//로그아웃은 모든 유저 접근 가능
		.and().logout().permitAll()
		//로그인시 form 기반 로그인 가능하며 로그인 페이지와 로그인 성공시에대한 url 정의
		.and().formLogin()
		//로그인 페이지에 요청 url 정의 
		.loginPage("/kaja/login")
		// 실제 로그인은 /loginHaha에서 실시
		// action은 loginHaha로 함
		.loginProcessingUrl("/loginHaja")
		//로그인 성공시 toResul로 이동
		.defaultSuccessUrl("/toResult", true)
		//basic auth 사용을 위해 csrf 해제
		.and().csrf().disable();
	}
	
	//다중 사용자의 경우
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder amb1) throws Exception{
		amb1.inMemoryAuthentication().withUser("babo").password(passwordEncoder().encode("ondal")).roles("ADMIN");
		amb1.inMemoryAuthentication().withUser("pyungkang").password(passwordEncoder().encode("kongjoo")).roles("USER");
		//inMemory 사용 하여 in-memory에 넣어줌 passwordEncoder > 비밀번호 암호화
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
