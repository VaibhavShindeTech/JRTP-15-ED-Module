package com.vaibhavshindetech.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaibhavshindetech.entities.CoTrigger;

public interface CoTriggerRepository extends JpaRepository<CoTrigger, Serializable> {

}
