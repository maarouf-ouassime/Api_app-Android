package com.enset.modeleDAO;

import java.util.List;
import java.util.Map;

import com.enset.interfaces.TaskInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.enset.modele.Task;

@Repository
public class TaskDAO implements TaskInterface {

	@Autowired
	JdbcTemplate template;

	@Override
	public List<Map<String, Object>> liste() {
		List<Map<String, Object>> list = template.queryForList("select * from task");
		return list;
	}

	@Override
	public List<Map<String, Object>> listeId(int id) {
		return null;
	}

	@Override
	public int add(Task p) {
		String sql = "insert into task(nom,description)values(?,?)";
		return template.update(sql, p.getNom(), p.getDescription());
	}

	@Override
	public int edit(Task p) {
		String sql="update task set nom=?, description=? where id=?";
		return template.update(sql,p.getNom(),p.getDescription(),p.getId());
	}

	@Override
	public int delete(int id) {
		String sql="delete from task where id=?";
		return template.update(sql,id);
	}

}
