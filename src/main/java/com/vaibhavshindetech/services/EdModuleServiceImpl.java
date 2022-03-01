package com.vaibhavshindetech.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vaibhavshindetech.bindings.CitizenData;
import com.vaibhavshindetech.bindings.PlanInfo;
import com.vaibhavshindetech.constants.AppConstant;
import com.vaibhavshindetech.entities.CoTrigger;
import com.vaibhavshindetech.entities.PlanInfoEntity;
import com.vaibhavshindetech.props.AppProps;
import com.vaibhavshindetech.repository.CoTriggerRepository;
import com.vaibhavshindetech.repository.EdModuleRepository;

@Service
public class EdModuleServiceImpl implements EdModuleService {
	@Autowired
	private EdModuleRepository edModuleRepository;

	@Autowired
	private CoTriggerRepository coTriggerRepository;

	@Autowired
	private AppProps appProps;

	RestTemplate restTemplate = new RestTemplate();

	@Override
	public PlanInfo isEligible(CitizenData citizenData) {
		String url = appProps.getMessages().get(AppConstant.ED_RULE_URL);
		ResponseEntity<PlanInfoEntity> response = restTemplate.postForEntity(url, citizenData, PlanInfoEntity.class);
		PlanInfoEntity planInfoEntity = response.getBody();
		planInfoEntity.setCaseId(citizenData.getCaseId());
		PlanInfoEntity planInfoEntity1 = edModuleRepository.save(planInfoEntity);
		PlanInfo planInfo = new PlanInfo();
		BeanUtils.copyProperties(planInfoEntity1, planInfo);
		CoTrigger coTrigger = new CoTrigger();
		coTrigger.setCaseId(planInfo.getCaseId());
		coTrigger.setCoTriggerStatus(AppConstant.PENDING);
		coTriggerRepository.save(coTrigger);
		return planInfo;
	}

}
