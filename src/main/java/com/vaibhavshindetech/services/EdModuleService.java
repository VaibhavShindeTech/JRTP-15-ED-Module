package com.vaibhavshindetech.services;

import com.vaibhavshindetech.bindings.CitizenData;
import com.vaibhavshindetech.bindings.PlanInfo;
public interface EdModuleService {
	public PlanInfo isEligible(CitizenData citizenData);
}
