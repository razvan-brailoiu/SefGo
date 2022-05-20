package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.IncorrectCredentials;
import org.loose.fis.sre.exceptions.UserNotInDatabaseException;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.model.User;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class UserService {

    private static ObjectRepository<User> userRepository;

    public static void initDatabase() {
        FileSystemService.initDirectory();
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("registration-example.db").toFile())
                .openOrCreate("test", "test");

        userRepository = database.getRepository(User.class);
    }

    public static ObjectRepository<User> getUserRepository() {
        return userRepository;
    }

    public static void addUser(String username, String password, String role) throws UsernameAlreadyExistsException {
        checkUserDoesNotAlreadyExist(username);
        userRepository.insert(new User(username, encodePassword(username, password), role));
    }

    private static void checkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername()))
                throw new UsernameAlreadyExistsException(username);
        }
    }

    private static void checkIfUserInDatabase (String username) throws UserNotInDatabaseException {
        int flag = 0;
        for (User user: userRepository.find()){
            if(Objects.equals(username, user.getUsername()))
                flag = 1;
        }

        if(flag == 0) throw new UserNotInDatabaseException();
    }

    public static void changePassWord (String username, String newpassword) throws UserNotInDatabaseException{
        checkIfUserInDatabase(username);
        for(User user: userRepository.find()){
            if(Objects.equals(username,user.getUsername())){
                deleteUser(user);
                try {
                    addUser(username, encodePassword(username, newpassword),"Developer");
                }
                catch(UsernameAlreadyExistsException e){
                    System.out.println(e.getMessage());
                }
                break;
            }
        }
    }

    public static void deleteByUsername(String username){
        for(User user: userRepository.find()){
            if(Objects.equals(user.getUsername(),username))
                userRepository.remove(user);
        }
    }

    public static List<User> getAllUsers(){
        return userRepository.find().toList();
    }

    public static void deleteUser(User user){
        userRepository.remove(user);
    }

    private static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // This is the way a password should be encoded when checking the credentials
        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", ""); //to be able to save in JSON format
    }


    public static int VerifyUserCredentials (String username, String password, String role) throws IncorrectCredentials {
        String aux_pass = encodePassword(username, password);
        for (User user : userRepository.find()){
            if(Objects.equals(username,user.getUsername()) && Objects.equals(role,user.getRole()) && Objects.equals(aux_pass,user.getPassword())){
                if(role.equals("Admin"))
                    return 1;
                else return 2;
            }
        }
        throw new IncorrectCredentials();
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }


}
