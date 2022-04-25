package com.enset.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enset.modele.Task;
import com.enset.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskControler {
	
	@Autowired
	private TaskService service;
	
	@GetMapping("/liste")
	public List<Map<String, Object>> listar(Model model) {
		return service.liste();
	}
		
	@PostMapping("/add")
	public String save(@RequestBody Task p, Model model) {
		int id=service.add(p);
		if(id==0) {
			return "Impossible d'ajouter!";
		}
		return "Enregistré avec succès!";
	}
	
	@PostMapping("/update/{id}")
	public String save(@RequestBody Task p, @PathVariable int id, Model model) {
		p.setId(id);
		int r=service.edit(p);
		if(r==0) {
			return "No se pudo Actualizar!";
		}
		return "n'a pas pu mettre à jour!";
	}
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable int id,Model model) {
		int r=service.delete(id);
		if(r==0) {
			return "Enregistrement non supprimé!";
		}
		return "Enregistrement supprimé!";
	}
	
}
