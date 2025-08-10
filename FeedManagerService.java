import java.io.BufferedReader;
import java.util.*;

public class FeedManagerService {
    private BufferedReader reader;
    private UserService userService;

    public FeedManagerService(UserService userService, BufferedReader reader) {
        this.reader = reader;
        this.userService = userService;
    }

    public void getFeed() throws Exception {
        System.out.print("Enter The username for which you want to display the Feed : ");
        String username = reader.readLine();

        username = username.trim();
        
        User user = userService.getUserFromUsername(username);

        if(user == null){
            return;
        }

        List<User> friends = user.getFriends();

        List<Post> feed = new ArrayList<>();
        for(User friend : friends){
            feed.addAll(friend.getPosts());
        }

        Collections.sort(feed, new Comparator<Post>() {
            @Override
            public int compare(Post p1, Post p2) {
                return p2.getPostTime().compareTo(p1.getPostTime());
            }
        });

        printFeed(feed);
    }

    private void printFeed(List<Post> posts) {
        if (posts == null || posts.isEmpty()) {
            System.out.println("No posts available.");
            return;
        }

        for (Post post : posts) {
            System.out.println(post);
        }
    }
}