package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	   @Autowired
	    AccountUserDetailsService userDetailsService;

	   @Bean
	   public PasswordEncoder passwordEncoder() {
	        //BCryptアルゴリズムを使用してパスワードのハッシュ化を行う
	        return new BCryptPasswordEncoder(); // BCryptアルゴリズムを使用
	    }

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        // AuthenticationManagerBuilderに、実装したUserDetailsServiceを設定する
	        auth.userDetailsService(userDetailsService)     // 作成したUserDetailsServiceを設定
	                .passwordEncoder(passwordEncoder());    // パスワードのハッシュ化方法を指定(BCryptアルゴリズム)
	    }
	    
	    @Override
	     public void configure(WebSecurity web) throws Exception {
	         web
	                 .ignoring()
	                 .antMatchers("/resources/**", "/static/**", "/css/**","/images/**");
	     }
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        // 認可の設定
	        http.exceptionHandling()
	                .accessDeniedPage("/accessDeniedPage")  // アクセス拒否された時に遷移するパス
	            .and()
	            .authorizeRequests()
	                .antMatchers("/loginForm","/Form","/","/mouse").permitAll()  // /loginFormは、全ユーザからのアクセスを許可
	                .anyRequest().authenticated();          //  上記以外は、認証を求める

	        // ログイン設定
	        http.formLogin()                                // フォーム認証の有効化
	                .loginPage("/loginForm")                // ログインフォームを表示するパス
	                .loginProcessingUrl("/authenticate")    // フォーム認証処理のパス
	                .usernameParameter("userName")          // ユーザ名のリクエストパラメータ名
	                .passwordParameter("password")          // パスワードのリクエストパラメータ名
	                .defaultSuccessUrl("/home")             // 認証成功時に遷移するデフォルトのパス
	                .failureUrl("/loginForm?error=true");   // 認証失敗時に遷移するパス

	        // ログアウト設定
	        http.logout()
	                .logoutSuccessUrl("/loginForm")         // ログアウト成功時に遷移するパス
	                .permitAll();  // 全ユーザに対してアクセスを許可

	        http.csrf().disable();  //disableの呼び出し無効化。認証が必要なAPIなどがあるときには安易に使ってはいけない。
	    }
	    
}
