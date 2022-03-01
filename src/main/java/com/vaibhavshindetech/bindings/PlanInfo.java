package com.vaibhavshindetech.bindings;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PlanInfo {
	private Integer elibiligityID;
	private Integer caseId;
	private Integer benefitAmt;
	private String denialReason;
	private String endDate;
	private String name;
	private String planName;
	private String planStatus;
	private String ssn;
	private String startDate;
	private LocalDate createdDate;
}
