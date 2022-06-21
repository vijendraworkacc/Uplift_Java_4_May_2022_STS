package com.te.learnspringsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.learnspringsecurity.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, String> {

}
