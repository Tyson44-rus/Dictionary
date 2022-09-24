import java.util.regex.Pattern;

public interface Dictionaries {
    Pattern patLatLetter = Pattern.compile("[a-zA-Z]+");
    Pattern patNumber = Pattern.compile("[0-9]+");

    boolean check(String temp);

    boolean check_2(String temp);
}
