import java.io.BufferedReader;

public class FriendService {
    private UserService userService;
    private BufferedReader reader;

    public FriendService(UserService userService, BufferedReader reader) {
        this.userService = userService;
        this.reader = reader;
    }

    public void addFriend() throws Exception {
        System.out.println("----Add Friend----");

        System.out.print("Enter your username: ");
        String username = reader.readLine();
        
        User user = userService.getUserFromUsername(username);
        if(user == null) {
            System.out.println("User does not exist.");
            return;
        }

        System.out.print("Enter friend's username: ");
        String friendUsername = reader.readLine();

        User friend = userService.getUserFromUsername(friendUsername);
        if (friend == null) {
            System.out.println("User does not exist.");
            return;
        }

        user.addFriend(friend);
        System.out.println("Friend added successfully.");
    }
}
