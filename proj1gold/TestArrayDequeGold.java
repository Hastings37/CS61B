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
		int count=0;
		for (int i = 0; i < 500; i++) {
			double random = StdRandom.uniform();

			if(i%5==0){
				//i断言判断其实不是Empty()的状态;
				msg.append("size()\n");
				assertEquals(msg.toString(), deque.size(), sDeque.size());
			}//
			if(random <=0.2){
				msg.append("isEmpty()\n");
				if(count==0){
					assertTrue(msg.toString(),sDeque.isEmpty());
				}
			}else if(random>0.2&&random<=0.4){
				msg.append("addFirst("+i+")\n");
				deque.addFirst(i);
				sDeque.addFirst(i);
				Integer a=deque.get(0);
				Integer b=sDeque.get(0);
				assertEquals(msg.toString(), a, b);
				count++;
			}else if(random>0.4&&random<=0.6){
				msg.append("addLast("+i+")\n");
				deque.addLast(i);
				sDeque.addLast(i);
				count++;
				Integer a=deque.get(count-1);
				Integer b=sDeque.get(count-1);
				assertEquals(msg.toString(), a, b);
			}else if(random>0.6&&random<=0.8){
				if(deque.isEmpty()){
					msg.append("isEmpty()");
					assertTrue(msg.toString(),sDeque.isEmpty());
					continue;
				}
				msg.append("removeFirst()\n");
				Integer a=deque.removeFirst();
				Integer b=sDeque.removeFirst();
				assertEquals(msg.toString(), a, b);
				count--;
			}else if(random>0.8){
				if(deque.isEmpty()){
					msg.append("isEmpty()");
					assertTrue(msg.toString(),sDeque.isEmpty());
					continue;
				}
				msg.append("removeLast()\n");
				Integer a=deque.removeLast();
				Integer b=sDeque.removeLast();
				assertEquals(msg.toString(), a, b);
				count--;
			}


		}
	}
}



// import static org.junit.Assert.*;
// import org.junit.Test;

// public class TestArrayDequeGold {
// 	@Test
// 	public void test() {
// 		StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
// 		ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();

// 		StringBuilder msg = new StringBuilder();

// 		int s = 0;
// 		for (int i = 0; i < 500; i++) {
// 			if (i % 5 == 0) {
// 				msg.append("size()\n");
// 				assertEquals(msg.toString(), ads.size(), sad.size());
// 			}

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
