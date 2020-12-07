import java.util.Calendar;
import java.util.Date;

public class Account {
    private static int incrementer = 0;
    protected int id;
    protected String name;
    protected int age;
    protected Date dob;
    protected String email;

    protected Account(String name, int age, int year, int month, int day, String email) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month,day);
        incrementer = Math.addExact(incrementer,1);
        this.id = incrementer;
        this.name = name;
        this.age = age;
        this.dob = calendar.getTime();
        this.email = email;
    }
}