//package org.loose.fis.sre;

import org.junit.jupiter.api.*;
import org.loose.fis.sre.exceptions.IncorrectCredentials;
import org.loose.fis.sre.exceptions.OneOrMoreEmptyFieldsException;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.exceptions.UsernameLengthException;
import org.loose.fis.sre.model.User;
import org.loose.fis.sre.services.FileSystemService;
import org.apache.commons.io.FileUtils;
import org.loose.fis.sre.services.UserService;

import static org.testfx.assertions.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class UserServiceTest {

    //for the user
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String ROLE = "role";

    @BeforeAll
    static void BeforeAll(){
        System.out.println("Before class");
    }

    @AfterAll
    static void AfterAll(){
        System.out.println("After class");
    }

    @BeforeEach
    void setUp() throws Exception{
        FileSystemService.APPLICATION_FOLDER = ".registration-test-example";
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomePath().toFile());
        System.out.println(FileSystemService.APPLICATION_HOME_PATH);
        UserService.initDatabase();
    }

    @AfterEach
    void tearDown(){
        System.out.println("after each");
    }

    @Test
    @DisplayName("Database is initialized with no users in it")
    void testDatabaseInitializedAndNoUsersInIt(){
        assertThat(UserService.getAllUsers()).isNotNull();
        assertThat(UserService.getAllUsers()).isEmpty();
    }

    @Test
    @DisplayName("User is succesfully stored in database")
    void testUserIsAddedToDatabase() throws UsernameAlreadyExistsException, OneOrMoreEmptyFieldsException, UsernameLengthException {
        UserService.addUser(USERNAME, PASSWORD, ROLE, "");
        assertThat(UserService.getAllUsers()).isNotEmpty();
        assertThat(UserService.getAllUsers()).size().isEqualTo(1);
        User user = UserService.getAllUsers().get(0);
        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo(USERNAME);
        assertThat(user.getPassword()).isEqualTo(UserService.encodePassword(USERNAME,PASSWORD));
        assertThat(user.getRole()).isEqualTo(ROLE);
        assertThat(user.getList()).isEqualTo("not selected");
    }

    @Test
    @DisplayName("User can not be added twice ")
    void testThatUserCanNotBeAddedTwice(){
        assertThrows(UsernameAlreadyExistsException.class, () -> {
            UserService.addUser(USERNAME, PASSWORD, ROLE, "");
            UserService.addUser(USERNAME, PASSWORD, ROLE, "");
        });
    }

    @Test
    @DisplayName("Check if provided credentials are ok (for log in)")
    void testCheckCredentials(){
        assertThrows(IncorrectCredentials.class, () -> {
            UserService.addUser(USERNAME,PASSWORD,ROLE,"");
            User user = UserService.getAllUsers().get(0);
            UserService.VerifyUserCredentials(USERNAME, "a password", ROLE);
        });
    }

    @Test
    @DisplayName("Check if all fields are filled in case of sign up")
    void checkVoidFields(){
        assertThrows(OneOrMoreEmptyFieldsException.class, () -> {
            UserService.addUser("user","pass",ROLE,"");
            User user = UserService.getAllUsers().get(0);
            UserService.checkIfFieldsAreFilled("","pass",ROLE);
        });
    }

    @Test
    @DisplayName("Check if username length is between 3 and 20")
    void testCheckUserLen(){
        assertThrows(UsernameLengthException.class, () -> {
//            UserService.addUser("mm",PASSWORD, ROLE, "");
//            User user = UserService.getAllUsers().get(0);
            UserService.checkUserNameLength("1234567891234567891255321");
        });
    }

}
