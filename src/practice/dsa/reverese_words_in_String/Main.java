package practice.dsa.reverese_words_in_String;

public class Main {
    public static void main(String[] args) {
        Solution sol=new Solution();
        System.out.println(sol.reverseWords("the sky is blue"));
        System.out.println("|"+sol.reverseWords("  hello world  ")+"|");
        System.out.println("|"+sol.reverseWords("a good   example")+"|");

    }
}
