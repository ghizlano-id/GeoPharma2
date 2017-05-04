package com.ensa.gestionPharmacie.service;

import java.util.List;

import com.ensa.gestionPharmacie.entity.Test;
import com.ensa.gestionPharmacie.entity.TestFils;

public interface TestService {

	List<Test> getAllTest();
	void add(TestFils ts);
}
