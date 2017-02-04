package views;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController
{
	@FXML
	private Button createButton;
	@FXML
	private Button viewCoursesButton;

	@FXML
	public void createButtonClick(ActionEvent e)
	{
		try
		{
			Parent parent = FXMLLoader.load(getClass().getResource("create_course_window.fxml"));
			Scene mazeScene = new Scene(parent);
			Stage newStage = (Stage) ((Node)e.getSource()).getScene().getWindow();
			newStage.hide();
			newStage.setScene(mazeScene);
			newStage.show();
		} catch (IOException e1)
		{
			e1.printStackTrace();
		}		
	}
	
	@FXML
	public void viewClick(ActionEvent e)
	{
		try
		{
			Parent parent = FXMLLoader.load(getClass().getResource("view_courses.fxml"));
			Scene mazeScene = new Scene(parent);
			Stage newStage = (Stage) ((Node)e.getSource()).getScene().getWindow();
			newStage.hide();
			newStage.setScene(mazeScene);
			newStage.show();
		} catch (IOException e1)
		{
			e1.printStackTrace();
		}		
	}
	
}
