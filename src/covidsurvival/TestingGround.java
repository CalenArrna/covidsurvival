package covidsurvival;

import java.util.ArrayList;
import java.util.List;

public class TestingGround {
    public static void main(String[] args) {
        String text = "Valami baromi hosszú kellene amit lehet darabolni! De ja, ez így szarra se jó!";
        List<String> list = splitStringON(15,text);
        for (String s : list) {
            System.out.println(s);
        }

    }

    private static List<String> splitStringON(int charLenght, String text) {
        List<String> listOfLines = new ArrayList<>();
        int numberOfFullLines = text.length() / charLenght;
        int lengthOfLastLine = text.length() % charLenght;
        int iterLength = numberOfFullLines + (lengthOfLastLine == 0 ? 0 : 1);
        for (int i = 0; i < iterLength; i++) {
            if (!(lengthOfLastLine == 0)) {
                int from = charLenght * i;
                String s = text.substring(from, from + (i == iterLength - 1 ? lengthOfLastLine : charLenght));
                listOfLines.add(s);
            } else {
                int from = charLenght * i;
                String s = text.substring(from, from + charLenght);
                listOfLines.add(s);
            }
        }
        return listOfLines;
    }
}
