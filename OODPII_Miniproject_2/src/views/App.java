package views;

import controllers.ModelController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application 
{
	
	private static ModelController modelController;
	
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Mini-Ladok");
			primaryStage.show();
			modelController = new ModelController();
		} catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static ModelController getModelController()
	{
		return modelController;
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
