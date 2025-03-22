public class LinkedListDeque<T> {
	// 创建的是基于链表的形式的双端队列;
	private int size;
	private Node sentry;//哨兵

	// 循环的双端列表的形式
	private class Node {
		public T item;
		public Node next;
		public Node prev;

		Node() {
			item = null;// 这里的直接设置为null的形式
			next = null;
			prev = null;

		}

		Node(T item) {
			this.item = item;
			next = null;
			prev = null;
		}

	}

	public LinkedListDeque() {
		size = 0;
		sentry = new Node();
	}

	public void addFirst(T item) {
		// 指定的数据添加在末尾的形式
		// 这样的双端队列的sentry（哨兵）的前一个位置就是所谓的末尾的元素啊
		// 末尾元素的下一个就是我们的sentry
		Node newNode = new Node(item);
		Node first = sentry.next;
		if (first == null) {
			newNode.next = sentry;
			newNode.prev = sentry;
			sentry.next = newNode;
			sentry.prev = newNode;
			// 指定的下一个和前面的一个都是这个指定的对象；
		} else {
			newNode.next = sentry.next;
			newNode.prev = sentry;
			sentry.next.prev = newNode;
			sentry.next = newNode;
		}
		size++;
	}

	public void addLast(T item) {
		Node newNode = new Node(item);
		Node last = sentry.prev;
		if (last == null) {
			newNode.next = sentry;
			newNode.prev = sentry;
			sentry.next = newNode;
			sentry.prev = newNode;
		} else {
			newNode.next = last.next;
			newNode.prev = last;
			last.next.prev = newNode;
			last.next = newNode;
		}
		size++;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void printDeque() {
		Node p = sentry.next;
		while (p!=sentry) {
			System.out.print(p.item + " ");
			p = p.next;
		}
		System.out.println();
		return;
	}

	public T removeFirst() {
		Node first = sentry.next;
		if (size == 0) return null;//也就是内部不存在数据的时候
		sentry.next = first.next;
		first.next.prev = sentry;
		first.next = null;
		first.prev = null;//这样的指向性质的内容是无法修改其数值信息的
		// 其内部的含义是从一个地方转向到另一个地方的操作；
		size--;
		return first.item;
	}

	public T removeLast() {
		Node last = sentry.prev;
		if (size == 0) return null;
		sentry.prev = last.prev;
		last.prev.next = sentry;
		last.next = null;
		last.prev = null;
		size--;
		return last.item;

	}

	public T get(int index) {
		int i = 0;
		Node p = sentry.next;
		while (p != null && i < index) {
			p = p.next;
			i++;
		}
		if (p == null) return null;
		return p.item;
	}

	public T getRecursive(int index) {
		// 使用递归的形式进行的求解
		// 并不是啊这里的额
		// 所以在使用中需要注意一下
		if (index < 0 || index >= size) return null;
		return getRecursiveHelper(sentry.next, index);
	}

	public T getRecursiveHelper(Node p, int index) {
		if (index == 0) return p.item;
		return getRecursiveHelper(p.next, index - 1);
	}
}
// 这样的泛型的信息在其内部可以接受的只有包装之后的类才行;
