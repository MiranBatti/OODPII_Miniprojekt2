package models;

import javafx.beans.property.StringProperty;

public abstract class Person
{
	protected String firstName;
	protected String lastName;
	protected String dateOfBirth;
	
	protected StringProperty firstNameProperty;
	protected StringProperty lastNameProperty;
	protected StringProperty dateOfBirthProperty;
	
	public void setName(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName  = lastName;
		
		firstNameProperty.set(firstName);
		lastNameProperty.set(lastName);
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
		firstNameProperty.set(firstName);
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
		lastNameProperty.set(lastName);
	}
	
	public String getName()
	{
		return firstName + " " + lastName;
	}
	
	public StringProperty getNameProperty()
	{
		StringProperty fullName = (StringProperty) firstNameProperty.concat(" " + lastName);
		return fullName;
	}
	
	public StringProperty getFirstName()
	{
		return firstNameProperty;
	}
	
	public StringProperty getLastName() 
	{
		return lastNameProperty;
	}
	
	public void setDateOfBirth(String dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getDateOfBirth()
	{
		return dateOfBirth;
	}
	
}
