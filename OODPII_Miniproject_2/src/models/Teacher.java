package models;

import java.util.ArrayList;

public class Teacher extends Person
{
	private boolean isExaminator = false;
	private ArrayList<Course> coursesTeaching;
	private String signature;
	
	public Teacher(String firstName, String lastName, String signature)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.signature = signature;
	}
	
	public String getSignature()
	{
		return signature;
	}
	
	public ArrayList<Course> getCoursesTeaching()
	{
		return coursesTeaching;
	}
	
	public void setIsExaminator(boolean isExaminator)
	{
		this.isExaminator = isExaminator;
	}
	
	@Override
	public String toString()
	{
		String examinator;
		if(isExaminator)
			examinator = "\tExaminator";
		else
			examinator = "";
		
		return firstName + " " + lastName + examinator;
	}
}
