import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static private UserService userService;
    static private FeedManagerService feedManagerService;
    static private PostService postService;
    static private FriendService friendService;
    static BufferedReader reader;

    public Main() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        userService = new UserService(reader);
        feedManagerService = new FeedManagerService(userService, reader);
        postService = new PostService(userService, reader);
        friendService = new FriendService(userService, reader);
    }

    public UserService getUserService() {
        return userService;
    }

    public FeedManagerService getFeedManagerService() {
        return feedManagerService;
    }

    public static void main(String[] args) {
        Main mainApp = new Main();
        mainApp.run();
    }

    public void run() {
        // Sample interaction
        try {
            int input = -1;
            while (input != 0) {
                System.out.println("Enter option (1: Register, 2: Login, 3: Logout, 4: Add Friend, 5: Get Feed, 6: Create Post, 7: Display All Users, 0: Exit):");
                String inputLine = reader.readLine();
                try {
                    input = Integer.parseInt(inputLine);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    continue;
                }

                switch (input) {
                    case 1:
                        userService.registerUserService();
                        break;

                    case 2:
                        userService.loginUserService();
                        break;

                    case 3: 
                        userService.logoutUserService();
                        break;

                    case 4:
                        friendService.addFriend();
                        break;

                    case 5:
                        feedManagerService.getFeed();
                        break;

                    case 6: 
                        postService.createPost();
                        break;

                    case 7:
                        userService.displayAllUsers();
                        break;  

                    case 0:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid option. Try again.");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
