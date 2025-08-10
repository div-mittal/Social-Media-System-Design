import java.util.*;

public class User {
    private String username;
    private String password;
    List<User> friends;
    List<Post> posts;

    private User (String username, String password){
        this.username = username;
        this.password = password;
        this.friends = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }

    public List<User> getFriends() {
        return friends;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void addPost(Post post) {
        if (post != null) {
            posts.add(post);
        } else {
            System.out.println("Cannot add a null post.");
        }
    }

    public static User createUser(String username, String password){
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            System.out.println("Username and password cannot be empty.");
            return null;
        }

        username = username.trim();

        User newUser = new User(username, password);
        System.out.println("User created: " + username);
        return newUser;
    } 

    public User loginUser(String password){
        if(password == null || password.isEmpty()){
            System.out.println("Enter the Password");
            return null;
        }

        if(!this.getPassword().equals(password)){
            System.out.println("The password Do Not Match");
            return null;
        }

        return this;
    } 

    public void addFriend(User friend){
        if(friend == null){
            System.out.println("User not Found");
        }
        friends.add(friend);
    }

    @Override
    public String toString() {
        return "[ " + this.username + " ]";
    }
}
