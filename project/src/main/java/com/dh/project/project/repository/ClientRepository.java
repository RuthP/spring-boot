package com.dh.project.project.repository;

import com.dh.project.project.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rpalomino on 6/19/2017.
 */
public interface ClientRepository extends JpaRepository<Client,Long> {
}
