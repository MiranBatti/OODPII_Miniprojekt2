package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Course;
import models.Student;
import models.Teacher;

public class ModelController
{
	private ObservableList<Student> students = FXCollections.observableArrayList();
	private ObservableList<Teacher> teachers = FXCollections.observableArrayList();
	private ObservableList<Course> courses = FXCollections.observableArrayList();
	
	public ObservableList<Student> getStudents()
	{
		return students;
	}
	
	public ObservableList<Teacher> getTeachers()
	{
		return teachers;
	}
	
	public ObservableList<Course> getCourses()
	{
		return courses;
	}
	
	public void unregisterStudent(Student student)
	{
		students.remove(student);
	}
	
	public void registerStudent(Student student)
	{
		students.add(student);
	}
	
	public void addTeacher(Teacher teacher)
	{
		teachers.add(teacher);
	}
	
	public void createCourse(Course course, Teacher teacher)
	{
		courses.add(course);
		teachers.add(teacher);
	}
	
	public boolean seatsFull(Course course)
	{
		return course.isFull();
	}
	
}
