import java.io.BufferedReader;

public class PostService {
    private UserService userService;
    private BufferedReader reader;

    public PostService(UserService userService, BufferedReader reader) {
        this.userService = userService;
        this.reader = reader;
    }

    public void createPost() throws Exception {
        System.out.println("Creating a new post...");

        System.out.print("Enter username : ");
        String username = reader.readLine();

        User user = userService.getUserFromUsername(username);

        System.out.print("Enter Post Heading : ");
        String postHeading = reader.readLine();

        System.out.print("Enter Post Content : ");
        String postContent = reader.readLine();

        Post newPost = new Post(user, postHeading, postContent);
        user.addPost(newPost);
        System.out.println("Post created successfully.");
    }
}
