package bomberone.views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ExitAlertBox implements DialogBox{
    
    /* Fields. */
    private boolean answer;
    private Stage window;
    private Scene scene;
    private Label message;
    private Button confirmExit;
    private Button cancelExit;
    private VBox windowLayout;
    
    /* Methods. */
    
    /**
     * {@inheritDoc}
     */
    public boolean display(final String title, final String message, 
            final String confirmExitButtonText, final String cancelButtonText) {

        this.window = new Stage();
        this.message = new Label(message);
        this.confirmExit = new Button(confirmExitButtonText);
        this.cancelExit = new Button(cancelButtonText);
        this.windowLayout = new VBox(10);
        
        //Setting the dialog result to false.
        this.answer = false;
        
        //Setting the title and making this window modal.
        this.window.setTitle(title);
        this.window.initModality(Modality.APPLICATION_MODAL);
        this.window.setMinWidth(250);
        
        //Setting the actions event handlers into the buttons.
        this.confirmExit.setOnAction(e -> onClickConfirmExitButton());
        this.confirmExit.setOnAction(e -> { window.close(); });
        
        //Setting the visual objects in the layout.
        this.windowLayout.getChildren().addAll(this.message, this.confirmExit, this.cancelExit);
        this.windowLayout.setAlignment(Pos.CENTER);
        
        //Creating the scene.
        this.scene = new Scene(windowLayout);
        
        //Setting the scene into the stage.
        this.window.setScene(this.scene);
        this.window.showAndWait();
        
        return answer;
    }

    private void onClickConfirmExitButton() {
        this.answer = true;
        window.close();
    }
}