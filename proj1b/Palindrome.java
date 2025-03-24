import javafx.concurrent.WorkerStateEvent;
import org.junit.rules.TestRule;

import java.util.LinkedList;

public class Palindrome {
	// 给定一个string 其应该返回一个Deque顺序和之前的一样的状态;
	// 内部自己传入指定的需要的比较器的形式是这样的;
	public Deque<Character> wordToDeque(String word) {
		// 也即是内部不存在equals的形式
		// LinkedListDeque<Character> deque =  new LinkedListDeque<>();
		// 这样的类型的映射是可以的;
		Deque<Character> deque = new LinkedListDeque<>();

		for (int i = 0; i < word.length(); i++) {
			Character c = word.charAt(i);
			deque.addLast(c);
		}

		return deque;
	}

	/*
	 * 给定的单词是回文的形式就是true 反之为false
	 * */
	public boolean isPalindrome(String word) {
		int len = word.length();

		for (int i = 0; i < len / 2; i++) {
			if (word.charAt(i)!=word.charAt(len-1-i)) return false;
		}
		return true;
		// 也就是说这里根本就没有使用那里的形式出现;
	}
	// 添加一个重载isPalindrome的新的方法出现

	public boolean isPalindrome(Deque<Character> deque) {
		// 分别从两侧开始进行便利的操作;
		// 可以获取到的数据全都是指定的内部存储的数据并不是 要不然就是要对其内部进行的删除操作才行
		int len = deque.size();
		for (int i = 0; i < len / 2; i++) {
			if (deque.get(i)!=deque.get(len-1-i)) return false;
		}
		return true;
	}

	public boolean isPalindrome(String word,CharacterComparator cc){
		// 比较的方式信息作为参数传递进去
		// 后面传入的是一个指定的字符比较器的形式;
		int len = word.length();
		for (int i = 0; i < len / 2; i++) {
            if (!cc.equalChars(word.charAt(i), word.charAt(len-1-i))) return false;
        }
		return true;
	}


}
