package com.vaibhavshindetech.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhavshindetech.bindings.CitizenData;
import com.vaibhavshindetech.bindings.PlanInfo;
import com.vaibhavshindetech.services.EdModuleService;

@RestController
@RequestMapping(value = "/ed")
public class EdModuleRestController {
	@Autowired
	private EdModuleService edModuleService;

	@PostMapping(value = "/rule",produces = "application/json",consumes = "application/json")
	public ResponseEntity<PlanInfo> isCitizenEligibleForPlan(@RequestBody CitizenData citizenData) {
		PlanInfo planInfo = edModuleService.isEligible(citizenData);
		return new ResponseEntity<PlanInfo>(planInfo, HttpStatus.OK);

	}
}
