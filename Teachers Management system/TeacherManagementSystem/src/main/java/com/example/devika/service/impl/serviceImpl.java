package com.example.devika.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.devika.Bean.Teacher;
import com.example.devika.repository.TeachersRepository;
import com.example.devika.service.ServiceInterface;
@Service
public class serviceImpl implements ServiceInterface{
	private TeachersRepository repo;
	@Override
	public List<Teacher> getAll() {
		return repo.findAll();
	}
	@Override
	public Teacher getById(Long id) {
		return repo.findById(id).get();
	}
	public serviceImpl(TeachersRepository repo) {
		super();
		this.repo = repo;
	}
	@Override
	public Teacher create(Teacher t) {
		return repo.save(t);
	}
	@Override
	public Teacher update(Teacher existing) {
		// TODO Auto-generated method stub
		return repo.save(existing);
		
	}
	
	
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
	
	

}
