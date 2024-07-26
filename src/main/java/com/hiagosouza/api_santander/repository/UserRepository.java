package com.hiagosouza.api_santander.repository;

import com.hiagosouza.api_santander.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
