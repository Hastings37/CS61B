public interface Deque<Item> {
	public void addFirst(Item item);

	public void addLast(Item item);

	public boolean isEmpty();

	public int size();

	public void printDeque();

	public Item removeLast();

	public Item removeFirst();

	public Item get(int index);
}
