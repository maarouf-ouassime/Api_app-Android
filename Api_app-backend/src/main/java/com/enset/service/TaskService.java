package com.enset.service;

import java.util.List;
import java.util.Map;

import com.enset.interfaces.TaskInterface;
import com.enset.modeleDAO.TaskDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enset.modele.Task;

@Service
public class TaskService implements TaskInterface {

	@Autowired
	TaskDAO dao;
	
	@Override
	public List<Map<String, Object>> liste() {
		return dao.liste();
	}

	@Override
	public List<Map<String, Object>> listeId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(Task p) {
		return dao.add(p);
	}

	@Override
	public int edit(Task p) {
		// TODO Auto-generated method stub
		return dao.edit(p);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}



}
