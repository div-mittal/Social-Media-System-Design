import java.sql.Date;

public class Post {
    private User user;
    private String postHeading;
    private String postContent;
    Date postTime;

    public Post(User user, String postHeading, String postContent){
        this.user = user;
        this.postHeading = postHeading;
        this.postContent = postContent;
        this.postTime = new Date(System.currentTimeMillis());
    }

    public User getPostUser(){
        return this.user;
    }

    public String getPostHeading() {
        return this.postHeading;
    }

    public String getPostContent() {
        return this.postContent;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void displayPost() {
        System.out.println("[ " + this.user.getUsername() + " ]" + " " + getPostHeading());
        System.out.println("Content: " + getPostContent());
        System.out.println("Posted on: " + this.postTime);
    }

    @Override
    public String toString() {
        return "[ " + this.user.getUsername() + " ]" + " " + getPostHeading() + "\n" +
               "Content: " + getPostContent() + "\n" +
               "Posted on: " + this.postTime;
    }
}
