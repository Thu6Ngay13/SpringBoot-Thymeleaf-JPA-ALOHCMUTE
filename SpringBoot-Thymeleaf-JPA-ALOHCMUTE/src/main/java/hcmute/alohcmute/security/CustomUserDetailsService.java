package hcmute.alohcmute.security;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hcmute.alohcmute.entities.LoaiTaiKhoan;
import hcmute.alohcmute.entities.TaiKhoan;
import hcmute.alohcmute.repositories.TaiKhoanRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
    TaiKhoanRepository taiKhoanRepository;

    @Override
    public UserDetails loadUserByUsername(String taiKhoanOrEmail) throws UsernameNotFoundException {
        Optional<TaiKhoan> user = taiKhoanRepository.findByTaiKhoanOrEmail(taiKhoanOrEmail, taiKhoanOrEmail);
        if (user.isPresent()) {
            return new org.springframework.security.core.userdetails.User(
            		user.get().getTaiKhoan(),
                    user.get().getMatKhau(),
                    mapRolesToAuthorities(user.get().getLoaiTaiKhoans()));
        } else {
            throw new UsernameNotFoundException("Invalid username or password.");
        } 
    }
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<LoaiTaiKhoan> loaiTaiKhoans) {
        Collection<? extends GrantedAuthority> mapLoaiTaiKhoans = loaiTaiKhoans.stream()
                .map(loaiTaiKhoan -> new SimpleGrantedAuthority(loaiTaiKhoan.getTenLoai()))
                .collect(Collectors.toList());
        return mapLoaiTaiKhoans;
    }
}