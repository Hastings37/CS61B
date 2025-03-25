import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void Test1() {
        StringBuilder msg = new StringBuilder();
        StudentArrayDeque<Integer> sDeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> deque = new ArrayDequeSolution<>();
        int count = 0;  // 用于跟踪队列的实际大小

        for (int i = 0; i < 500; i++) {
            double random = StdRandom.uniform();
            if (i % 5 == 0) {
                // 每5次操作检查队列的大小
                msg.append("size()\n");
                assertEquals(msg.toString(), deque.size(), sDeque.size());
            }

            if (random < 0.25) {
                // 25% 概率添加到队列的前端
                performAddFirst(i, msg, deque, sDeque);
                count++;
            } else if (random < 0.5) {
                // 25% 概率添加到队列的后端
                performAddLast(i, msg, deque, sDeque);
                count++;
            } else if (random < 0.75) {
                // 25% 概率移除队列的前端
                performRemoveFirst(msg, deque, sDeque);
                count--;
            } else {
                // 25% 概率移除队列的后端
                performRemoveLast(msg, deque, sDeque);
                count--;
            }
        }
    }

    // 处理添加到队列前端的操作
    private void performAddFirst(int value, StringBuilder msg, ArrayDequeSolution<Integer> deque, StudentArrayDeque<Integer> sDeque) {
        msg.append("addFirst(" + value + ")\n");
        deque.addFirst(value);
        sDeque.addFirst(value);
        assertEquals(msg.toString(), deque.get(0), sDeque.get(0));
    }

    // 处理添加到队列后端的操作
    private void performAddLast(int value, StringBuilder msg, ArrayDequeSolution<Integer> deque, StudentArrayDeque<Integer> sDeque) {
        msg.append("addLast(" + value + ")\n");
        deque.addLast(value);
        sDeque.addLast(value);
        assertEquals(msg.toString(), deque.get(deque.size() - 1), sDeque.get(sDeque.size() - 1));
    }

    // 处理从队列前端移除元素的操作
    private void performRemoveFirst(StringBuilder msg, ArrayDequeSolution<Integer> deque, StudentArrayDeque<Integer> sDeque) {
        if (deque.isEmpty()) {
            msg.append("isEmpty()\n");
            assertTrue(msg.toString(), sDeque.isEmpty());
            return;  // 跳过空队列的移除操作
        }

        msg.append("removeFirst()\n");
        Integer a = deque.removeFirst();
        Integer b = sDeque.removeFirst();
        assertEquals(msg.toString(), a, b);
    }

    // 处理从队列后端移除元素的操作
    private void performRemoveLast(StringBuilder msg, ArrayDequeSolution<Integer> deque, StudentArrayDeque<Integer> sDeque) {
        if (deque.isEmpty()) {
            msg.append("isEmpty()\n");
            assertTrue(msg.toString(), sDeque.isEmpty());
            return;  // 跳过空队列的移除操作
        }

        msg.append("removeLast()\n");
        Integer a = deque.removeLast();
        Integer b = sDeque.removeLast();
        assertEquals(msg.toString(), a, b);
    }
}
