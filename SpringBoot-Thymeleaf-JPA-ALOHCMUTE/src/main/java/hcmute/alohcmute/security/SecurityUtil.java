package hcmute.alohcmute.security;

import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
	
	public static MyUserInformation getPrincipal() {
		MyUserInformation myUserInformation = (MyUserInformation) 
				(SecurityContextHolder
						.getContext()
						.getAuthentication()
						.getPrincipal());
		return myUserInformation;
	}

}
