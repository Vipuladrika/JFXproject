package cf.mindaugas.jfxdemodelete.logic;

import cf.mindaugas.jfxdemodelete.data.Message;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;

public class HelloController {
    private SessionFactory session;
    @FXML private Label textLabel;
    @FXML private TextField textInput;
    @FXML private Button displayButton;
    @FXML private Button replaceButton;

    // public HelloController(SessionFactory session) {
    //     this.session = session;
    // }

    public void setSession(SessionFactory session) {
        this.session = session;
    }

    // Ref: https://stackoverflow.com/a/34785707/1964707
    public void initialize(){
        this.displayButton.setOnAction(e -> textLabel.setText(textInput.getText()));
        this.replaceButton.setOnAction(e -> {
            var ses = session.openSession();
            var tx = ses.beginTransaction();

            var message = ses.get(Message.class, 1L);
            if (message == null) message = new Message();
            message.setText(textInput.getText());
            ses.save(message);

            tx.commit();
            ses.close();
        });
    }
}