package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.*;
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

    public static void addUser(String username, String password, String role, String list) throws UsernameAlreadyExistsException, UsernameLengthException, OneOrMoreEmptyFieldsException {
        checkIfFieldsAreFilled(username, password, role);
        checkUserNameLength(username);
        checkUserDoesNotAlreadyExist(username);
        userRepository.insert(new User(username, encodePassword(username, password), role, list));
    }

    private static void checkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername()))
                throw new UsernameAlreadyExistsException(username);
        }
    }

    public static User getUserbyUsername(String username)  {
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername()))
                return user;
        }
        return null;
    }

    public static String getListByUsername (String username) throws UserNotInDatabaseException {
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername()))
                return user.getList();
        }
        return null;
    }

    public static String getListByDate (int date) throws UserNotInDatabaseException {
        String users = "";

        for (User user : userRepository.find()) {

            if (!Objects.equals(user.getList(), "not selected") && !Objects.equals(user.getList(), "all days") && !Objects.equals(user.getList(), "empty")) {
                String[] stringArray = user.getList().split(",");
                for (int i = 0; i < stringArray.length; i++) {
                    if (Objects.equals(Integer.valueOf(stringArray[i]), date)) {
                        users += user.getUsername() + ",";
                        break;
                    }
                }
            }
        }
        return users;
    }

    private static void checkIfUserInDatabase (String username) throws UserNotInDatabaseException {
        int flag = 0;
        for (User user: userRepository.find()){
            if(Objects.equals(username, user.getUsername()))
                flag = 1;
        }

        if(flag == 0) throw new UserNotInDatabaseException();
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

    public static void checkIfFieldsAreFilled(String filledUser, String filledPass, String filledRole) throws OneOrMoreEmptyFieldsException {
        if(filledUser.isEmpty() || filledPass.isEmpty() || filledRole.isEmpty()){
            System.out.println("One of them is emptty");
            throw new OneOrMoreEmptyFieldsException();
        }
    }

    public static void checkUserNameLength(String username) throws UsernameLengthException {
        if(username.length()<3 || username.length()>20)
            throw new UsernameLengthException();
    }

    public static String encodePassword(String salt, String password) {
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
