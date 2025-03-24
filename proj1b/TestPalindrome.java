import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();//从前面到后面的逐渐获取的操作;

        }
        assertEquals("persiflage", actual);
    }
	//Uncomment this class once you've created your Palindrome class.

    // @Test
    // public void testIsPalindrome() {
    //     assertTrue(palindrome.isPalindrome("deed"));
    //     assertFalse(palindrome.isPalindrome("nooN"));
    // }

    // @Test
    // public void testReloadisPalindrome(){
    //     Deque<Character>deque =palindrome.wordToDeque("Hastings");
    //     Deque<Character>deque1 =palindrome.wordToDeque("HastsaH");
    //     assertFalse(palindrome.isPalindrome(deque));
    //     assertTrue(palindrome.isPalindrome(deque1));
    //
    // }

}
