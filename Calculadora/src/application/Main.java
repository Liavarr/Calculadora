package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//Llamamos al fxml y cargamos el Arnchor pane principal
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Calculadora.fxml"));
	        AnchorPane root = loader.load();
	        
	        //CalculadoraController controller = loader.getController();
			//AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Calculadora.fxml"));
			//Cargamos la escena y el CSS
	        Scene scene = new Scene(root,277,234);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			// Obtenemos el controlador y llamamos a su metodo para asignar listeners
	        CalculadoraController controller = loader.getController();
	        controller.asignarKeyListeners(scene); // Llamada para asignar los listeners de teclado
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
