package com.dh.project.project.repository;

import com.dh.project.project.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rpalomino on 6/19/2017.
 */
public interface CardRepository extends JpaRepository<Card,Long> {
}
