package com.enset.interfaces;

import java.util.List;
import java.util.Map;

import com.enset.modele.Task;

public interface TaskInterface{
	public List<Map<String, Object>> liste();
	public List<Map<String, Object>> listeId(int id);
	public int add(Task p);
	public int edit(Task p);
	public int delete(int id);

}
