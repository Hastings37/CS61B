import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Random;

public class TestArrayDequeGold {

	// public void t

	@Test
	public void Test1(){

		StringBuilder msg = new StringBuilder();
		StudentArrayDeque<Integer> sDeque = new StudentArrayDeque<>();
		ArrayDequeSolution<Integer> deque = new ArrayDequeSolution<>();
		for (int i = 0; i < 500; i++) {
			double random = StdRandom.uniform();

			if(i%5==0){
				msg.append("isEmpty()\n");
				assertEquals(msg.toString(), deque.isEmpty(), sDeque.isEmpty());
			}

			if (random <= 0.20) {//
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
				msg.append("isEmpty()\n");
				assertEquals(msg.toString(), deque.isEmpty(), sDeque.isEmpty());
				if(deque.isEmpty()){
					continue;
				}
				msg.append("removeFirst()\n");

				Integer first1 = sDeque.removeFirst();
				Integer first2 = deque.removeFirst();
				assertEquals(msg.toString(), first2, first1);
			} else if (random <= 0.80) {
				msg.append("addLast()\n");
				Integer rand = (Integer) StdRandom.uniform(0, 10000);
				sDeque.addLast(rand);
				deque.addLast(rand);
				assertEquals(msg.toString(), deque.get(deque.size() - 1), sDeque.get(sDeque.size() - 1));
			} else {
				msg.append("isEmpty()\n");
				assertEquals(msg.toString(), deque.isEmpty(), sDeque.isEmpty());
				if(deque.isEmpty()){
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



// import static org.junit.Assert.*;
// import org.junit.Test;
//
// public class TestArrayDequeGold {
// 	@Test
// 	public void test() {
// 		StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
// 		ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
//
// 		StringBuilder msg = new StringBuilder();
//
// 		int s = 0;
// 		for (int i = 0; i < 500; i++) {
// 			if (i % 5 == 0) {
// 				msg.append("size()\n");
// 				assertEquals(msg.toString(), ads.size(), sad.size());
// 			}
//
// 			double selector = StdRandom.uniform();
// 			if (selector < 0.25) {
// 				sad.addFirst(i);
// 				ads.addFirst(i);
// 				s++;
// 				msg.append("addFirst(" + i + ")\n");
// 				assertEquals(msg.toString(), ads.get(0), sad.get(0));
// 			} else if (selector < 0.5) {
// 				sad.addLast(i);
// 				ads.addLast(i);
// 				s++;
// 				msg.append("addLast(" + i + ")\n");
// 				assertEquals(msg.toString(), ads.get(s - 1), sad.get(s - 1));
// 			} else if (selector < 0.75) {
// 				if (ads.isEmpty()) {
// 					msg.append("isEmpty()\n");
// 					assertTrue(msg.toString(), sad.isEmpty());
// 					continue;
// 				}
// 				Integer x = ads.removeFirst();
// 				Integer y = sad.removeFirst();
// 				s--;
// 				msg.append("removeFirst()\n");
// 				assertEquals(msg.toString(), x, y);
// 			} else {
// 				if (ads.isEmpty()) {
// 					msg.append("isEmpty()\n");
// 					assertTrue(msg.toString(), sad.isEmpty());
// 					continue;
// 				}
// 				Integer x = ads.removeLast();
// 				Integer y = sad.removeLast();
// 				s--;
// 				msg.append("removeLast()\n");
// 				assertEquals(msg.toString(), x, y);
// 			}
// 		}
// 	}
// }