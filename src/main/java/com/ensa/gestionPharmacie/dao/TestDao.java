package com.ensa.gestionPharmacie.dao;

import java.util.List;

import com.ensa.gestionPharmacie.entity.Test;
import com.ensa.gestionPharmacie.entity.TestFils;

public interface TestDao {

	List<Test> getAllTest();
	void add(TestFils ts);
}
