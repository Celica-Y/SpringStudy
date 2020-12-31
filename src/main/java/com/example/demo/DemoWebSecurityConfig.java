package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
class DemoWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // AUTHORIZE
        	//authorizeRequests()で対象のリクエストを受け取る
            .authorizeRequests()
            //helloページ（パスが「/hello」）は認証外（常にアクセス許可）と指定
            /* */.mvcMatchers("/hello").permitAll()
            //すべてのリクエスト（ただし上で認証外に指定した「/hello」は除く）を要認証
            /* */.anyRequest()
            /*    */.authenticated()
            .and()
            // LOGIN
            .formLogin()
            //ログイン成功後のデフォルトページを指定
            /* */.defaultSuccessUrl("/success")
        // end
        ;
    }
}