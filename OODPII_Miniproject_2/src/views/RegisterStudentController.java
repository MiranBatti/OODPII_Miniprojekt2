package views;

import controllers.ModelController;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Student;

public class RegisterStudentController
{
	@FXML
	private TextField firstNameText;
	@FXML
	private TextField lastNameText;
	@FXML
	private Button okButton;
	
	private Stage dialogStage;
	
	private Student student;
	
    public void setDialogStage(Stage dialogStage) 
    {
        this.dialogStage = dialogStage;
    }
	
	@FXML
	public void handleOk()
	{
		Student student = new Student(firstNameText.getText(), lastNameText.getText());
		App.getModelController().registerStudent(student);
		dialogStage.close();
		setStudent(student);
	}
	
	@FXML
	public void initialize()
	{
		okButton.disableProperty()
				.bind(Bindings.createBooleanBinding(
						() -> firstNameText.getText().trim().isEmpty(),
						firstNameText.textProperty())
						.or(Bindings.createBooleanBinding(
								() -> lastNameText.getText().trim().isEmpty(),
								lastNameText.textProperty())));
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
		dialogStage.close();
	}
}
