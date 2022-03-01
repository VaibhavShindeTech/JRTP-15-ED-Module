package com.vaibhavshindetech.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaibhavshindetech.entities.PlanInfoEntity;

public interface EdModuleRepository extends JpaRepository<PlanInfoEntity, Serializable>{

}
