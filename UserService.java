import java.io.*;
import java.util.*;

public class UserService {
    private BufferedReader reader;
    private Map<String, User> users;
    private static User currUser;

    public void setCurrUser(User user) {
        currUser = user;
    }

    public User getCurrUser() {
        if (currUser == null) {
            System.out.println("No user is currently logged in.");
            return null;
        }
        return currUser;
    }

    public UserService(BufferedReader reader) {
        this.reader = reader;
        users = new HashMap<>();
        currUser = null;
    }

    public boolean registerUserService() throws Exception {
        System.out.println("----User Registration----");
        System.out.print("Enter username : ");
        String username = reader.readLine();

        System.out.print("Enter password : ");
        String password = reader.readLine();

        username = username.trim();

        if(users.containsKey(username)){
            System.out.println("User With this username Already Exists !");
            return false;
        }

        User newUser = User.createUser(username, password);

        users.put(username, newUser);

        setCurrUser(newUser);
        return true;
    }

    public boolean loginUserService() throws Exception{
        System.out.println("----User Login----");
        if(checkUserLoggedIn()){
            System.out.println("User " + currUser.getUsername() + " is already logged in.");
            return false;
        }

        System.out.print("Enter username : ");
        String username = reader.readLine();

        System.out.print("Enter password : ");
        String password = reader.readLine();

        username = username.trim();

        if(!users.containsKey(username)){
            System.out.println("Please Enter A Valid User name !");
            return false;
        }

        User user = users.get(username);

        if(user.loginUser(password) == null){
            return false;
        }

        setCurrUser(user);
        return true;        
    }

    public void logoutUserService() {
        if (currUser == null) {
            System.out.println("No user is currently logged in.");
            return;
        }
        System.out.println("User " + currUser.getUsername() + " logged out successfully.");
        setCurrUser(null);
    }

    public User getUserFromUsername(String username){
        username = username.trim();
        if(!users.containsKey(username)){
            System.out.println("User does not Exist");
            return null;
        }
        return users.get(username);
    }

    public void diplayUserFriends() {
        if(!checkUserLoggedIn()){
            return;
        }

        User user = getCurrUser();
        System.out.println("Friends of " + user.getUsername() + ":");
        for(User friend : user.getFriends()){
            System.out.println(friend);
        }
    }

    private boolean checkUserLoggedIn(){
        User user = getCurrUser();

        if(user == null){
            System.out.println("----Please Login First----");
            return false;
        }
        return true;
    }

    public void displayAllUsers() {
        System.out.println("----All Registered Users----");
        for (User user : users.values()) {
            System.out.println(user);
        }
    }
}
