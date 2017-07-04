package com.dh.demo.demo.demo.repository;

import com.dh.demo.demo.demo.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by DELL on 29/06/2017.
 */
public interface StatusRepository extends JpaRepository<Status,Long> {
}
