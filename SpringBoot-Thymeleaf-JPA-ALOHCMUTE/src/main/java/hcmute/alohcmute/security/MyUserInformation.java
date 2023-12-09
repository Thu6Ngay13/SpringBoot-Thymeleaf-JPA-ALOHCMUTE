package hcmute.alohcmute.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyUserInformation extends User {
	private static final long serialVersionUID = -6094267035450492087L;
	
	private String hoTen; 
	private String nickName;
	private String email;
	private String gioiTinh;
	private String sDT;
	private String avatarURl;
	
	public MyUserInformation(
			String username, 
			String password, 
			boolean enabled, 
			boolean accountNonExpired,
			boolean credentialsNonExpired, 
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		
	}
}
