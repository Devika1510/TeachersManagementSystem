package com.example.devika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.devika.Bean.Teacher;
import com.example.devika.repository.TeachersRepository;

@SpringBootApplication
public class TeacherManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TeacherManagementSystemApplication.class, args);
	}
	@Autowired
	private TeachersRepository repo;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Teacher t=new Teacher((long)1,"Devika","Ramasamy","rdevika472@gmail.com");
		repo.save(t);
	}

}
