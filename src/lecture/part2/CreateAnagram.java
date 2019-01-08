package lecture.part2;


/**
 * The class Anagrams inputs a word and generates its anagrams
 */

public class CreateAnagram {
    int c = 0;

    public static void main(String[] args)  {
        CreateAnagram ob = new CreateAnagram();
        ob.input();
    }

    void input()  {
        String input = "cat";
        display("", input);
    }

    void display(String prefix, String word) {
        if (word.length() <= 1) {
            c++;
           // System.out.println("word = "+current);
        } else {
            for (int i = 0; i < word.length(); i++) {
                System.out.println("i = "+i);
                System.out.println("word.length() = "+word.length());
                String current = word.substring(i, i + 1);
                String before = word.substring(0, i);
                String after = word.substring(i + 1);
                System.out.println("current = "+current);
                System.out.println("before = "+before);
                System.out.println("after = "+ after);

                System.out.println("calling function display  with prefix + current = " + prefix + current + " & before + after = " + before + after);
                display(prefix + current, before + after);
                System.out.println("done function display  with prefix + current = " + prefix + current + " & before + after = " + before + after);

            }
        }
    }
}
