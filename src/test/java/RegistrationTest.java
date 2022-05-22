import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.loose.fis.sre.services.FileSystemService;
import org.loose.fis.sre.services.UserService;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import static org.testfx.assertions.api.Assertions.assertThat;
@ExtendWith(ApplicationExtension.class)
public class RegistrationTest {
    public static final String USERNAME = "userone";
    public static final String PASSWORD = "passone";

    @BeforeEach
    void setUp() throws Exception{
        FileSystemService.APPLICATION_FOLDER = ".registration-test-example";
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomePath().toFile());
        System.out.println(FileSystemService.APPLICATION_HOME_PATH);
        UserService.initDatabase();
    }

    @Start
    void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        primaryStage.setTitle("Registration");
        primaryStage.setScene(new Scene(root, 900,475));
        primaryStage.show();
    }

    @Test
    void testTheRegistrationPhase(FxRobot fxRobot){
        fxRobot.clickOn("#usernameField");
        fxRobot.write(USERNAME);
        fxRobot.clickOn("#passwordField");
        fxRobot.write(PASSWORD);
//        fxRobot.clickOn("role");
//        fxRobot.type(KeyCode.DOWN);
//        fxRobot.type(KeyCode.ENTER);

        assertThat(fxRobot.lookup("#registrationMessage").queryText()).hasText("Account created successfully!");
        assertThat(UserService.getAllUsers()).size().isEqualTo(1);

        fxRobot.clickOn("#registerButton");
        assertThat(fxRobot.lookup("#registrationMessage").queryText()).hasText(
                String.format("An account with the username %s already exists!", USERNAME)
        );

        fxRobot.clickOn("#usernameField");
        fxRobot.write("1");
        fxRobot.clickOn("#registerButton");

        assertThat(fxRobot.lookup("#registrationMessage").queryText()).hasText("Account created successfully");
        assertThat(UserService.getAllUsers()).size().isEqualTo(2);


    }
}
