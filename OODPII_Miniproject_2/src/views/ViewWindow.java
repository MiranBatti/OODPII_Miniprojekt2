package views;

import java.io.IOException;

import controllers.ModelController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import models.Course;
import models.Student;
import models.Teacher;

public class ViewWindow
{
	@FXML
	private TableView<Course> courseTable;
	@FXML
	private TableColumn<Course, String> courseIDTable;
	@FXML
	private TableColumn<Course, String> courseNameTable;
	
	@FXML
	private ListView<Teacher> teacherList;
	@FXML
	private ListView<Student> studentList;
	
	public ViewWindow()
	{

	}
	
    @FXML
    private void initialize() 
    {
    	
    	courseTable.setItems(App.getModelController().getCourses());
		courseIDTable.setCellValueFactory(cellData -> cellData.getValue().getCourseIDProp());
		courseNameTable.setCellValueFactory(cellData -> cellData.getValue().getCourseNameProp());
		
	    courseTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> showCourseDetails(newValue));
    }
	
    private void update()
    {
    	
    	courseTable.setItems(App.getModelController().getCourses());
		courseIDTable.setCellValueFactory(cellData -> cellData.getValue().getCourseIDProp());
		courseNameTable.setCellValueFactory(cellData -> cellData.getValue().getCourseNameProp());
		
	    courseTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> showCourseDetails(newValue));
    }
    
    private void showCourseDetails(Course course)
    {
		teacherList.setItems(course.getCourseTeachers());
		studentList.setItems(course.getRegisteredStudents());
    }
    
    @FXML
    private void handleUnregister() {
        int selectedIndex = studentList.getSelectionModel().getSelectedIndex();

        if (selectedIndex >= 0) {
            Student selectedStudent = studentList.getSelectionModel().getSelectedItem();
            App.getModelController().unregisterStudent(selectedStudent);
            studentList.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Student Selected");
            alert.setContentText("Please select a student in the list.");

            alert.showAndWait();
        }
    }
    
    @FXML
    private void handleBack(ActionEvent e)
    {
		try
		{
			Parent parent = FXMLLoader.load(getClass().getResource("menu.fxml"));
			Scene scene = new Scene(parent);
			Stage newStage = (Stage) ((Node)e.getSource()).getScene().getWindow();
			newStage.hide();
			newStage.setScene(scene);
			newStage.show();
		} catch (IOException e1)
		{
			e1.printStackTrace();
		}	
    }
    
    @FXML
    private void handleRegister(ActionEvent e)
    {
        int selectedIndex = courseTable.getSelectionModel().getSelectedIndex();

        if (selectedIndex >= 0) {
            Course selectedCourse = courseTable.getSelectionModel().getSelectedItem();
    		try
    		{
    	        // Load the fxml file and create a new stage for the popup dialog.
    			FXMLLoader loader = new FXMLLoader();	 
    			loader.setLocation(getClass().getResource("student_registration.fxml"));
    	        AnchorPane page = (AnchorPane) loader.load();
    	        
    	        // Create the dialog Stage.
    	        Stage dialogStage = new Stage();
    	        dialogStage.setTitle("Register Student");
    	        dialogStage.initModality(Modality.WINDOW_MODAL);
    	        Scene scene = new Scene(page);
    	        dialogStage.setScene(scene);
    	        
    	        RegisterStudentController controller = loader.getController();
    	        controller.setDialogStage(dialogStage);
    	        controller.setCourseList(App.getModelController());
    	        
    	        // Show the dialog and wait until the user closes it
    	        dialogStage.showAndWait();
    	        
    	        studentList.getItems().add(controller.getNewStudent());
    		} catch (IOException e1)
    		{
    			e1.printStackTrace();
    		}	
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Course Selected");
            alert.setContentText("Please select a course in the list.");

            alert.showAndWait();
        }
    	
    }
    
}
