package hust.soict.globalict.screen.view;
import javax.naming.LimitExceededException;

import hust.soict.globalict.screen.controller.DemoController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class testDemo extends Application {

    public void start(Stage primaryStage) throws Exception{
        final String STORE_FXML_FILE_PATH = "Demo.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        DemoController demoController = new DemoController(/*mainTopic, subTopic, object*/);
        fxmlLoader.setController(demoController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Demo Tourism");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String []args) throws LimitExceededException {

        launch(args);
    }

}
