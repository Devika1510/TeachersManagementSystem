package com.example.devika.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.devika.Bean.Teacher;
import com.example.devika.service.impl.serviceImpl;

@Controller
public class TeacherController {
	private serviceImpl service;
	public TeacherController(serviceImpl service) {
		super();
		this.service = service;
	}
	@GetMapping("/teachers")
	public String list(Model model) {
			model.addAttribute("teachers",service.getAll());
			return "teachers";
	}
	@GetMapping("/teachers/new")
	public String insertTeacher(Model model) {
		Teacher teacher=new Teacher();
		model.addAttribute("teacher",teacher);
		return "create_teacher";
	}
	@PostMapping("/teachers")
	public String saveStudent(@ModelAttribute("teacher") Teacher teacher) { ///bind form  object to student entity
		service.create(teacher);
		return "redirect:/teachers";
		}
	@GetMapping("/teachers/edit/{id}")
	public String editStudentForm(@PathVariable Long id,Model model) {
		model.addAttribute("teacher",service.getById(id));
		return "edit_teacher";
	}
	@PostMapping("/teachers/{id}")
	public String  studentUpdate(@PathVariable Long id,@ModelAttribute("teacher") Teacher teacher,Model model ) {
		Teacher existing=service.getById(id);
		existing.setFirstName(teacher.getFirstName());
		existing.setLastName(teacher.getLastName());
		existing.setEmail(teacher.getEmail());
		service.update(existing);
		return"redirect:/teachers"
;		}
	//delete handler method
	@GetMapping("/teachers/{id}")
	public String deleteStudent(@PathVariable Long id) {
		service.delete(id);
		return "redirect:/teachers";
	}
}
