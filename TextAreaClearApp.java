import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextAreaClearApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create TextArea
        TextArea textArea = new TextArea();
        textArea.setPromptText("Enter your text here...");

        // Create Clear Button
        Button clearButton = new Button("Clear");
        
        // Set Button Action
        clearButton.setOnAction(e -> textArea.clear());

        // Layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(textArea, clearButton);

        // Scene and Stage
        Scene scene = new Scene(layout, 400, 250);
        primaryStage.setTitle("TextArea Clear Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}