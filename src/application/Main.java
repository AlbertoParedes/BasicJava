package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class Main extends Application {

	private Pane mypane;

	@Override
	public void start(Stage stage) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/forest.fxml"));
		loader.setController(new SetBlur(stage));
		mypane = (Pane) loader.load();

		stage.setTitle("Dale al balón");
		stage.setScene(new Scene(mypane));
		stage.show();
	}

	class SetBlur {
		Stage stage;
		@FXML
	    private Button reiniciar;

		@FXML
		private ImageView imageView;       

		/*@FXML Cuando se inicia la vista se ejecuta este metodo que es como si fuese el main
		public void initialize() {           
			imageView.setEffect(new GaussianBlur(10));
		}*/
		int x = 5;
	    public SetBlur(Stage stage) {
			this.stage = stage;  
		}

		@FXML
	    void cambiarVista(ActionEvent event) {
			stage.setTitle("Sigue dándole al balón");
	    		imageView.setEffect(new GaussianBlur(x));
	    		x += 5;
	    		
	    		if(x>=80) {
	    			reiniciar.setVisible(true);
	    		}
	    		
	    }
	    
	    @FXML
	    void reiniciando(ActionEvent event) {
	    		stage.setTitle("Dale al balón");
	    		reiniciar.setVisible(false);
	    		imageView.setEffect(new GaussianBlur(0));
	    		x = 5;
	    }

	}

	public static void main(String[] args) {
		launch(args);
	}

}