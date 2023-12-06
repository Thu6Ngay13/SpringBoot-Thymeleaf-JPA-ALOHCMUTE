package hcmute.alohcmute.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hcmute.alohcmute.entities.TaiKhoan;
import hcmute.alohcmute.repositories.TaiKhoanRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
    private TaiKhoanRepository taiKhoanRepository;

	@Override
    public UserDetails loadUserByUsername(String taiKhoanOrEmail) throws UsernameNotFoundException {
        Optional<TaiKhoan> user = taiKhoanRepository.findByTaiKhoanOrEmail(taiKhoanOrEmail, taiKhoanOrEmail);
        if (user.isPresent()) {
            return new UserDetailsImpl(user.get());
        } else {
            throw new UsernameNotFoundException("Invalid username or password.");
        } 
    }
}
