package com.example.demo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

public class AccountUserDetails implements UserDetails{

	private final MyUser myUser;

    public AccountUserDetails(MyUser myUser) {
        this.myUser = myUser;
    }
    
    public MyUser getUser() { 
        return myUser;
    }

    public String getName() { 
        return this.myUser.getName();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // ユーザに与えられている権限リストを返却するメソッド
        return AuthorityUtils.createAuthorityList("ROLE_" + this.myUser.getRoleName());
    }

    @Override
    public String getPassword() { 
        return this.myUser.getPassword();
    }

    @Override
    public String getUsername() { 
        return this.myUser.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() { // アカウントの有効期限の状態を判定するメソッド
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { // アカウントのロック状態を判定するメソッド
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { // 資格情報の有効期限の状態を判定するメソッド
        return true;
    }

    @Override
    public boolean isEnabled() { // 有効なユーザかを判定するメソッド
        return true;
    }
	
}
