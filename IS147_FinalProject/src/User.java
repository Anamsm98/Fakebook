import java.util.Scanner;

public class User {
    final private Account account;
    private User[] friends;
    private Submission[] posts;
    Scanner scanner = new Scanner(System.in);

    public User() {
        System.out.println("To create an account please enter your name, age, year of birth, month of birth, day of birth, and finally your email.");
        String name = scanner.nextLine();
        int age = scanner.nextInt();
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        String email = validateEmail();
        this.account = new Account(name,age,year,month,day,email);
        this.friends = new User[100];
        this.posts = new Submission[100];
        System.out.println("Your Fakebook account has been created!");
    }

    private String validateEmail() {
        String email = scanner.next();
        if (email.isEmpty() || !email.contains("@") || !email.contains(".")) {
            System.out.println("Please enter a valid email address.");
            validateEmail();
        }
        return email;
    }

    public Account getAccount() {
        return account;
    }

    public User[] getFriends() {
        return friends;
    }

    public void setFriends(User[] friends) {
        this.friends = friends;
    }

    public void addFriend(User user) {
        if (!findFriend(user)) {
            for (int i = 0; i < this.friends.length; i++) {
                if (this.friends[i] == null) {
                    this.friends[i] = user;
                    break;
                }
            }
            System.out.printf("%s has been added to your friends list!",user.account.name);
            System.out.println();
        } else {
            System.out.printf("%s is on your friends list.",user.account.name);
            System.out.println();
        }
    }

    public void removeFriend(User user) {
        if (findFriend(user)) {
            for (int i = 0; i < this.friends.length; i++) {
                if (this.friends[i] == user) {
                    this.friends[i] = null;
                    break;
                }
            }
            System.out.printf("%s has been removed from your friends list.",user.account.name);
            System.out.println();
        } else {
            System.out.printf("%s is not on your friends list.",user.account.name);
            System.out.println();
        }
    }

    public boolean findFriend(User user) {
        for (User u : this.friends) {
            if (u == user) {
                return true;
            }
        }
        return false;
    }

    public Submission[] getPosts() {
        return posts;
    }

    public void setPosts(Submission[] posts) {
        this.posts = posts;
    }

    public void createPost() {
        Submission post = new Submission();
        System.out.println("What type of post would you like to create? Enter 1 for a text post or 2 for an image.");
        int selection = scanner.nextInt();
        switch (selection) {
            case 0:
                return;
            case 1:
                System.out.println("Please enter your post contents.");
                post = new Text(scanner.next());
                break;
            case 2:
                System.out.println("Please enter the image URL followed by a caption.");
                post = new Image(scanner.next(),scanner.next());
                break;
            default:
                System.out.println("Invalid option: Please try again or enter 0 to cancel post creation.");
                createPost();
        }
        for (int i = 0; i < this.posts.length; i++) {
            if (this.posts[i] == null) {
                this.posts[i] = post;
                break;
            }
        }
        System.out.println("Your post has been successfully created!");
    }

    public void deletePost(int index) {
        if (this.posts[index - 1] != null) {
            this.posts[index - 1] = null;
        }
        System.out.println("This post has been deleted.");
    }

    public static void main(String[] args) {
        System.out.println("Hello and welcome to Fakebook!");
        User anam = new User();
        User zaid = new User();
        User mahmood = new User();
        System.out.println("Let's add a few friends.");
        anam.addFriend(zaid);
        anam.addFriend(mahmood);
        System.out.println("If you don't want a friend anymore you can always remove them.");
        anam.removeFriend(mahmood);
        System.out.println("Next let's try creating your first post.");
        anam.createPost();
        System.out.println("You can also delete your post if you're unhappy with it. Just enter the number of the post.");
        anam.deletePost(1);
        System.out.println("Thanks for joining Fakebook!");
    }
}
