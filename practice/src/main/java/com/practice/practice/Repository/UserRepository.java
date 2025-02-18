package com.practice.practice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.practice.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}
