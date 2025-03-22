public class ArrayDeque<Type> {
	private int size;
	private Type[] array;
	private int front;  // 队列的前端指针
	private int rear;   // 队列的后端指针

	public ArrayDeque() {
		this(8);
	}

	public ArrayDeque(int capacity) {
		array = (Type[]) new Object[capacity];  // 创建一个指定容量的数组
		size = 0;
		front = 0;  // 初始化前端指针
		rear = 0;   // 初始化后端指针
	}

	// 调整数组大小
	public void resize() {
		if (size == array.length) {
			// 扩容，创建一个新数组
			Type[] tmp = (Type[]) new Object[array.length * 2];
			// 将元素从 front 开始，依次复制到 tmp 数组中
			for (int i = 0; i < size; i++) {
				tmp[i] = array[(front + i) % array.length];
			}
			array = tmp;
			front = 0; // front 重新指向新数组的开始
			rear = size; // rear 更新为当前元素数
		} else if (array.length >= 16 && ((double) size < array.length * 0.25)) {
			// 缩小数组大小，防止浪费内存
			Type[] tmp = (Type[]) new Object[array.length / 2 + 1];
			// 将元素从 front 开始，依次复制到 tmp 数组中
			for (int i = 0; i < size; i++) {
				tmp[i] = array[(front + i) % array.length];
			}
			array = tmp;
			front = 0; // front 重新指向新数组的开始
			rear = size; // rear 更新为当前元素数
		}
	}

	// 将一个元素添加到队列前端
	public void addFirst(Type item) {
		resize();  // 检查是否需要扩展数组

		// 如果前端指针已经到达数组的开始，需要将其循环回数组末尾
		front = (front - 1 + array.length) % array.length;
		array[front] = item;
		size++;
	}

	// 将一个元素添加到队列后端
	public void addLast(Type item) {
		resize();  // 检查是否需要扩展数组

		array[rear] = item;
		rear = (rear + 1) % array.length;  // 后端指针循环到数组开头
		size++;
	}

	// 删除并返回队列前端的元素
	public Type removeFirst() {
		if (size == 0) return null;

		Type tmp = array[front];
		array[front] = null;  // 释放该位置的元素
		front = (front + 1) % array.length;  // 前端指针循环
		size--;

		return tmp;
	}

	// 删除并返回队列后端的元素
	public Type removeLast() {
		if (size == 0) return null;

		rear = (rear - 1 + array.length) % array.length;  // 往前移动后端指针
		Type tmp = array[rear];
		array[rear] = null;  // 释放该位置的元素
		size--;

		return tmp;
	}

	// 检查队列是否为空
	public boolean isEmpty() {
		return size == 0;
	}

	// 打印队列中的所有元素
	public void printDeque() {
		for (int i = 0; i < size; i++) {
			// 计算每个元素在数组中的实际位置
			System.out.print(array[(front + i) % array.length] + " ");
		}
		System.out.println();
	}

	// 获取队列中指定索引的元素
	public Type get(int index) {
		if (index < 0 || index >= size) return null;
		return array[(front + index) % array.length];  // 根据前端指针和索引计算实际位置
	}

	// 返回队列的大小
	public int size() {
		return size;
	}
}
