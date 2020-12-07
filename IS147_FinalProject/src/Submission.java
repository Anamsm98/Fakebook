import java.time.LocalTime;

public class Submission {
    protected LocalTime time;

    static void description() {
        System.out.println("This is a submission");
    }

    static void description(Text text) {
        System.out.println(text.getText());
    }

    static void description(Image image) {
        System.out.println(image.getCaption());
    }
}

class Text extends Submission {
    final private String text;

    public Text(String text) {
        this.text = text;
        this.time = LocalTime.now();
    }

    public String getText() {
        return text;
    }
}

class Image extends Submission {
    final private String url;
    final private String caption;

    public Image(String url, String caption) {
        this.url = url;
        this.caption = caption;
        this.time = LocalTime.now();
    }

    public String getUrl() {
        return url;
    }

    public String getCaption() {
        return caption;
    }
}