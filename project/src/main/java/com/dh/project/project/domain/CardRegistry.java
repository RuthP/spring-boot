package com.dh.project.project.domain;

import javax.persistence.*;

/**
 * Created by DELL on 20/06/2017.
 */
@Entity
public class CardRegistry {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Car car;
    @ManyToOne
    private RegistryCarSold registryCarSold;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public RegistryCarSold getRegistryCarSold() {
        return registryCarSold;
    }

    public void setRegistryCarSold(RegistryCarSold registryCarSold) {
        this.registryCarSold = registryCarSold;
    }
}
