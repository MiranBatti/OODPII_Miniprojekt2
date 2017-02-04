package models;

import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Course
{
	private String courseName;
	private String courseID;
	private StringProperty courseNameProp;
	private StringProperty courseIDProp;
	private String courseDate;
	private ObservableList<Student> registeredStudents = FXCollections.observableArrayList();
	private ObservableList<Teacher> courseTeachers = FXCollections.observableArrayList();
	
	public Course(String courseName, String courseID, Teacher teacher)
	{
		this.courseName = courseName;
		this.courseID = courseID;
		addTeacher(teacher);
		
		courseNameProp = new SimpleStringProperty();
		courseIDProp = new SimpleStringProperty();
		
		courseNameProp.set(courseName);
		courseIDProp.set(courseID);
	}
	
	public String getCourseName()
	{
		return courseName;
	}
	
	public String getCourseID()
	{
		return courseID;
	}
	public StringProperty getCourseNameProp()
	{
		return courseNameProp;
	}
	
	public StringProperty getCourseIDProp()
	{
		return courseIDProp;
	}
	
	public void registerStudent(Student student)
	{
		registeredStudents.add(student);
	}
	
	public void addTeacher(Teacher teacher)
	{
		courseTeachers.add(teacher);
	}
	
	public ObservableList<Student> getRegisteredStudents()
	{
		return registeredStudents;
	}
	
	public ObservableList<Teacher> getCourseTeachers()
	{
		return courseTeachers;
	}
}
