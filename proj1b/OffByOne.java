public class OffByOne implements CharacterComparator {

	// 面对恰好相差一个字符的状态其返回为true的形式：
	@Override
	public boolean equalChars(char x, char y) {
		// 对应指定的位置相差为1返回为true;
		return Math.abs(x-y)==1;
	}


}
