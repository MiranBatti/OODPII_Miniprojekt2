package views;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Course;
import models.Teacher;

public class CreateCourseController
{
	private Teacher teacher;
	private Course course;
	@FXML
	private Label testLabel;
	@FXML
	private TextField firstName, lastName, signature, courseNameText, courseIDText;
	@FXML
	private Button okButton;
	@FXML
	private CheckBox isExaminator;
	
	public CreateCourseController()
	{

	}
	
	@FXML
	public void initialize()
	{
		okButton.disableProperty()
				.bind(Bindings.createBooleanBinding(
						() -> firstName.getText().trim().isEmpty(),
						firstName.textProperty())
						.or(Bindings.createBooleanBinding(
								() -> lastName.getText().trim().isEmpty(),
								lastName.textProperty())
								.or(Bindings
										.createBooleanBinding(() -> courseIDText
												.getText().trim().isEmpty(),
												courseIDText.textProperty())
										.or(Bindings.createBooleanBinding(
												() -> courseNameText.getText()
														.trim().isEmpty(),
												courseNameText.textProperty())
												.or(Bindings
														.createBooleanBinding(
																() -> signature
																		.getText()
																		.trim()
																		.isEmpty(),
																signature
																		.textProperty()))))));
	}
	
	@FXML
	public void handleOk(ActionEvent e)
	{
		String firstNameText = firstName.getText();
		String lastNameText = lastName.getText();
		String signatureText = signature.getText();
		String courseNameGet = courseNameText.getText();
		String courseIDGet = courseIDText.getText();
		
		teacher = new Teacher(firstNameText, lastNameText, signatureText);
		teacher.setIsExaminator(isExaminator.isSelected());
		course = new Course(courseNameGet, courseIDGet, teacher);
		App.getModelController().createCourse(course, teacher);
		
		try 
		{
			Parent parent = FXMLLoader.load(getClass().getResource("menu.fxml"));
			Scene scene = new Scene(parent);
			Stage newStage = (Stage) ((Node)e.getSource()).getScene().getWindow();
			newStage.hide();
			newStage.setScene(scene);
			newStage.show();
		} catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	@FXML
	public void cancelButton(ActionEvent e)
	{
		try 
		{
			Parent parent = FXMLLoader.load(getClass().getResource("menu.fxml"));
			Scene scene = new Scene(parent);
			Stage newStage = (Stage) ((Node)e.getSource()).getScene().getWindow();
			newStage.hide();
			newStage.setScene(scene);
			newStage.show();
		} catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
}
