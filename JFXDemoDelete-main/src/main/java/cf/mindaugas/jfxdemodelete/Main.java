package cf.mindaugas.jfxdemodelete;

import cf.mindaugas.jfxdemodelete.data.HibernateUtil;
import cf.mindaugas.jfxdemodelete.logic.HelloController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        var fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        var helloController = new HelloController();
        fxmlLoader.setController(helloController);

        var scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        var session = HibernateUtil.getSessionFactory();
        helloController.setSession(session);
    }

    @Override
    public void stop() throws Exception {
        HibernateUtil.shutdown();
        super.stop();
    }

    public static void main(String[] args) {
        launch();
    }
}