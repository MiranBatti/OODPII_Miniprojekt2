package models;

import java.util.ArrayList;

public class Student extends Person
{
	private ArrayList<Course> registeredCourses;
	
	public Student(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		registeredCourses = new ArrayList<Course>();		
	}
	
	public void addRegistration(Course course)
	{
		registeredCourses.add(course);
	}
	
	public ArrayList<Course> getRegistrations()
	{
		return registeredCourses;
	}
	
	public void removeRegistration(Course course)
	{
		registeredCourses.remove(course);
	}
	
	@Override
	public String toString()
	{
		return firstName + " " + lastName;
	}
}
