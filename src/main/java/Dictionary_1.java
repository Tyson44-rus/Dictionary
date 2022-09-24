import java.util.regex.Matcher;

public class Dictionary_1 implements Dictionaries {
    @Override
    public boolean check(String temp) {
        String[] str = temp.split(":");
        Matcher matLatLetter = patLatLetter.matcher(str[0]);
        Matcher matNumber = patNumber.matcher(str[1]);
        return str[0].length() == 4 && matLatLetter.matches() && str[1].length() == 5 && matNumber.matches();
    }

    @Override
    public boolean check_2(String temp) {
        Matcher matLatLetter = patLatLetter.matcher(temp);
        return temp.length() == 4 && matLatLetter.matches();
    }
}
