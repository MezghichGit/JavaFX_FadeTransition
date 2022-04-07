package application;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.scene.shape.Rectangle;

import javafx.util.Duration;

public class Main extends Application {
	
	 private FadeTransition ft;
	 private Rectangle rect;
	    
	    
	@Override
	public void start(Stage primaryStage) {
		try {
			rect = new Rectangle(20, 20, 150, 150);
			
			ft = new FadeTransition(Duration.millis(5000), rect);
			
		    ft.setFromValue(1.0);
		    ft.setToValue(0.0);
		    
		    rect.setOnMouseClicked(new RectClickHandler());
		        
			StackPane root = new StackPane();
			root.getChildren().add(rect);
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private class RectClickHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {

        	double opa = rect.getOpacity();

            if ((int) opa == 0) {
                return;
            }

            Animation.Status as = ft.getStatus();

            if (as == Animation.Status.RUNNING) {
                return;
            }

            if (as == Animation.Status.STOPPED) {
                ft.play();
            }
            
        }

        
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
