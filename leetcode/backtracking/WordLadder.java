import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class WordLadder {
    public static void main(String[] args) {
        String[] arr = { "si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm",
                "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho",
                "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb",
                "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os",
                "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io",
                "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye" };
        List<String> ans = new ArrayList<>();
        // String[]arr={"hot","dot","dog","lot","log","cog"};

        HashMap<String, Boolean> dictionary = new HashMap<>();
        for (String string : arr) {

            dictionary.put(string, false);
        }
        String word = "qa";
        ans.add(word);
        dictionary.put(word, true);
        System.out.println(wordLadder(ans, dictionary, word, "sq"));

    }

    public static int diffCal(String source, String destination) {
        int diff = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != destination.charAt(i))
                diff++;
        }
        return diff;
    }

    public static int wordLadder(List<String> ans, HashMap<String, Boolean> dictionary, String word, String endWord) {
        if (word.equals(endWord)) {
            System.out.println(ans);
            return ans.size();
        }
        int minAns = Integer.MAX_VALUE;
        String minLengthWord = null;
        int minDiff = Integer.MAX_VALUE;
        LinkedList<String> queue=new LinkedList<>();
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < 26; j++) {
                char cc = (char) ('a' + j);
                String tempString = word.substring(0, i) + cc + word.substring(i + 1);
                if (dictionary.containsKey(tempString) && !dictionary.get(tempString)) {
                    int diff = diffCal(tempString, endWord);
                    if (diff < minDiff) {
                        minLengthWord = tempString;
                        minDiff = diff;
                        queue=new LinkedList<>();
                        queue.addLast(tempString);
                    }
                    if (diff == minDiff) {
                        queue.addLast(tempString);
                    }

                }
            }
        }
        while(!queue.isEmpty()){
            String recWord=queue.removeFirst();
            ans.add(recWord);
            dictionary.put(recWord, true);
            minAns = Math.min(minAns, wordLadder(ans, dictionary, recWord, endWord));
            ans.remove(ans.size() - 1);
            dictionary.put(recWord, false);

        }

        return minAns;

    }
}