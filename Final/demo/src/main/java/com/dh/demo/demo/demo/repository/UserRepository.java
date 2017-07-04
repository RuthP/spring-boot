package com.dh.demo.demo.demo.repository;

import com.dh.demo.demo.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by DELL on 17/06/2017.
 */
public interface UserRepository extends JpaRepository<User,Long> {

}
