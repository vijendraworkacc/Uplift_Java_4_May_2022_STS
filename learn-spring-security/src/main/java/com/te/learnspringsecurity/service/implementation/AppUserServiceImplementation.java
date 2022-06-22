package com.te.learnspringsecurity.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.te.learnspringsecurity.entity.AppUser;
import com.te.learnspringsecurity.repository.AppUserRepository;
import com.te.learnspringsecurity.service.AppUserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppUserServiceImplementation implements AppUserService, UserDetailsService {

	private final AppUserRepository appUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 1. Find AppUser from database using username.
		// 2. If AppUser is present, convert AppUser object into spring security User
		// object (Needs GrantedAuthorities object) and return User object.
		// 3. Or else throw new UsernameNotFoundException(...).
		Optional<AppUser> optional = appUserRepository.findByUsername(username);
		if (optional.isPresent()) {
			AppUser appUser = optional.get();
			List<SimpleGrantedAuthority> authorities = appUser.getRoles().stream()
					.map(r -> new SimpleGrantedAuthority(r.getRoleName())).collect(Collectors.toList());
			return new User(appUser.getUsername(), appUser.getPassword(), authorities);
		}
		throw new UsernameNotFoundException("User with the given username " + username + " does not exist!");
	}

}
