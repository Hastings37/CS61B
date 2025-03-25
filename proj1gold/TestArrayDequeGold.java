import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Random;

public class TestArrayDequeGold {

	@Test
	public void Test1(){
		/*
		 * 随机对StudentArrayDeque 和 ArrayDequeSolution 直到双方在输出上存在分歧出现
		 * StdRandom 去生成随机数的操作
		 * 修改您的 TestArrayDequeGold.java ，
		 * 以便 assertEquals 的 message 参数包含导致
		 *  StudentArrayDeque 输出错误答案的操作列表。
		 *   输出指定的操作的列表信息是什么意思的啊
		 *
		 * 需要给出详细的方法调用操作的执行列表状态
		 * 但是其期望和实际上的输出是并不需要直接给出出来的
		 *
		 *
		 * 在执行操作的时候构建出故障序列
		 *
		 *
		 *
		 * 可以进行检查的操作有
		 * 前面添加 前面删除 后面添加 后面删除 大小 isEmpty()
		 * get 指定的位置上面
		 * 但是容易出现不知道是get 出现的问题还是添加或者是删除出现的问题在内部
		 * */
		// 检查isEmpty()的方法也是可以的;
		StringBuilder msg = new StringBuilder();
		StudentArrayDeque<Integer> sDeque = new StudentArrayDeque<>();
		ArrayDequeSolution<Integer> deque = new ArrayDequeSolution<>();
		for (int i = 0; i < 500; i++) {
			double random = StdRandom.uniform();

			if (random <= 0.20) {
				// 检验size方法
				msg.append("size()\n");
				assertEquals(msg.toString(), deque.size(), sDeque.size());
			} else if (random <= 0.40) {
				msg.append("addFirst()\n");
				Integer rand = (Integer) StdRandom.uniform(0, 10000);
				sDeque.addFirst(rand);
				deque.addFirst(rand);
				assertEquals(msg.toString(), deque.get(0), sDeque.get(0));
			} else if (random <= 0.60) {
				// size检查
				int s1 = sDeque.size();
				int s2 = deque.size();
				if (s1 != s2) {
					msg.append(" size()\n");
					assertEquals(msg.toString(), s2, s1);
				}
				if (s1 == 0) {
					continue;
				}
				msg.append("removeFirst()\n");
				Integer first1 = sDeque.removeFirst();
				Integer first2 = deque.removeFirst();
				assertEquals(msg.toString(), first2, first1);
			} else if (random <= 0.80) {
				// addLast
				msg.append("addLast()\n");
				Integer rand = (Integer) StdRandom.uniform(0, 10000);
				sDeque.addLast(rand);
				deque.addLast(rand);
				assertEquals(msg.toString(), deque.get(deque.size() - 1), sDeque.get(sDeque.size() - 1));
			} else {
				// removeLast
				// size检查
				int s1 = sDeque.size();
				int s2 = deque.size();
				if (s1 != s2) {
					msg.append(" size()\n");
					assertEquals(msg.toString(), s2, s1);
				}
				if (s1 == 0) {
					continue;
				}
				msg.append("removeLast()\n");
				Integer last1 = sDeque.removeLast();
				Integer last2 = deque.removeLast();
				assertEquals(msg.toString(), last2, last1);
				// 这里应该不会出现空指针的情况的吧;
				// 也即是和其自己的get()方法是关系紧密的;
			}
		}
	}
}
