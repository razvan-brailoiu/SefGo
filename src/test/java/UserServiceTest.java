//package org.loose.fis.sre;

import org.junit.jupiter.api.*;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
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

//    @Test
//    @DisplayName("User is succesfully stored in database")
//    void testUserIsAddedToDatabase() throws UsernameAlreadyExistsException

}
