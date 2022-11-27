package com.example.devika.service;

import java.util.List;

import com.example.devika.Bean.Teacher;

public interface ServiceInterface {
	List<Teacher> getAll();
	Teacher getById(Long id);
	Teacher create(Teacher t);
	Teacher update(Teacher t);
	void delete(Long id);
}
