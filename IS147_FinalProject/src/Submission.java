import java.time.LocalTime;

public class Submission {
    protected LocalTime time;
    protected boolean draftStatus;

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

    public Text(String text, boolean status) {
        this.text = text;
        this.time = LocalTime.now();
        this.draftStatus = status;
    }

    public String getText() {
        return text;
    }
}

class Image extends Submission {
    final private String url;
    final private String caption;

    public Image(String url, String caption, boolean status) {
        this.url = url;
        this.caption = caption;
        this.time = LocalTime.now();
        this.draftStatus = status;
    }

    public String getUrl() {
        return url;
    }

    public String getCaption() {
        return caption;
    }
}