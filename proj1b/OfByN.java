public class OfByN implements CharacterComparator {
	/*
	 * 采用单个整数的单参数构造函数*/
	public int N;

	OfByN(int N) {
		this.N = N;
		// 返回一个指定的对象为对相差N的字符的字符返回为true的形式;
	}

	@Override
	public boolean equalChars(char x, char y) {
		return Math.abs(x - y) == N;
	}


}
