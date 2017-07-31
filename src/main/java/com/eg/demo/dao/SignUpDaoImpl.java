package com.eg.demo.dao;

import java.util.ArrayList;
import java.util.List;

import com.eg.demo.model.SignUpVo;
import org.springframework.stereotype.Repository;

@Repository
public class SignUpDaoImpl implements SignUpDao {

	//returning list of dummy data, instead data can be retrieved from database or else where
	public List<SignUpVo> getAllStudents()
	{
		List<SignUpVo> students = new ArrayList<SignUpVo>();
		
		SignUpVo vo1 = new SignUpVo();
		vo1.setId(1);
		vo1.setFirstName("sukumar");
		vo1.setLastName("abc");
		students.add(vo1);
		
		SignUpVo vo2 = new SignUpVo();
		vo2.setId(2);
		vo2.setFirstName("kiran");
		vo2.setLastName("kumar");
		students.add(vo2);
		
		return students;
	}
}