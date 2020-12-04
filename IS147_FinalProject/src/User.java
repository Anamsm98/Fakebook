import java.util.Scanner;

public class User {
    final private Account account;
    private User[] friends;
    private Submission[] posts;

    public User() {
        System.out.println("To create an account please enter your name, age, year of birth, month of birth, day of birth, and finally your email.");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int age = scanner.nextInt();
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        String email = scanner.next();
        this.account = new Account(name,age,year,month,day,email);
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

    public Submission[] getPosts() {
        return posts;
    }

    public void setPosts(Submission[] posts) {
        this.posts = posts;
    }
}
