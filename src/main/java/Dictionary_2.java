import java.util.regex.Matcher;

public class Dictionary_2 implements Dictionaries {
    @Override
    public boolean check(String temp) {
        String[] str = temp.split(":");
        Matcher matLatLetter = patLatLetter.matcher(str[1]);
        Matcher matNumber = patNumber.matcher(str[0]);
        return str[0].length() == 5 && matNumber.matches() && str[1].length() == 4 && matLatLetter.matches();
    }

    @Override
    public boolean check_2(String temp) {
        Matcher matNumber = patNumber.matcher(temp);
        return temp.length() == 5 && matNumber.matches();
    }
}
