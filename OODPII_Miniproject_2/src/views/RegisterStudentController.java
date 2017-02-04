package views;

import controllers.ModelController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Student;

public class RegisterStudentController
{
	@FXML
	private TextField firstNameText;
	@FXML
	private TextField lastNameText;
	
	private Stage dialogStage;
	
	private Student student;
	
	ModelController m;
	
    public void setDialogStage(Stage dialogStage) 
    {
        this.dialogStage = dialogStage;
    }
	
	@FXML
	public void handleOk()
	{
		Student student = new Student(firstNameText.getText(), lastNameText.getText());
		m.registerStudent(student);
		dialogStage.close();
		setStudent(student);
	}
	
	private void setStudent(Student student)
	{
		this.student = student;
	}
	
	public Student getNewStudent()
	{
		return student;
	}
	
	@FXML
	public void handleCancel()
	{
		
	}
	
	public void setCourseList(ModelController m)
	{
		this.m = m;
	}
}
