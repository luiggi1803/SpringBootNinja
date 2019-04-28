package com.udemy.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.controller.CourseController;
import com.udemy.entity.Course;
import com.udemy.repository.CourseJpaRepository;
import com.udemy.service.CourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService{
	
	private static final Log LOGGER= LogFactory.getLog(CourseServiceImpl.class);
	
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	@Override
	public List<Course> listAllCourses() {
		LOGGER.info("call: listAllCourses()");
		return courseJpaRepository.findAll();
	}

	@Override
	public Course addCourse(Course course) {
		LOGGER.info("call: addCourse()");
		return courseJpaRepository.save(course);
	}

	@Override
	public int removeCourse(int id) {
		courseJpaRepository.deleteById(id);
		return 0;
	}

	@Override
	public Course updateCourse(Course course) {
		return courseJpaRepository.save(course);
	}

}
