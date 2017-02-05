package models;

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
	private int availableSeats;
	private int seatsTaken;
	private ObservableList<Student> registeredStudents = FXCollections.observableArrayList();
	private ObservableList<Teacher> courseTeachers = FXCollections.observableArrayList();
	
	public Course(String courseName, String courseID, Teacher teacher)
	{
		this.courseName = courseName;
		this.courseID = courseID;
		availableSeats = 3;
		addTeacher(teacher);
		
		courseNameProp = new SimpleStringProperty();
		courseIDProp = new SimpleStringProperty();
		
		courseNameProp.set(courseName);
		courseIDProp.set(courseID);
	}
	
	public Course(String courseName, String courseID, Teacher teacher, int availableSeats)
	{
		this.courseName = courseName;
		this.courseID = courseID;
		this.availableSeats = availableSeats;
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
	
	public void registerStudent()
	{
		if(seatsTaken != availableSeats)
		{
			seatsTaken++;
		}
	}
	
	public void unregisterStudent()
	{
		seatsTaken--;
	}
	
	public boolean isFull()
	{
		if(seatsTaken == availableSeats)
			return true;
		else
			return false;
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
