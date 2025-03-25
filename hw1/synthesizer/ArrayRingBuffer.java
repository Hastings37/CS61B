// TODO: Make sure to make this class a part of the synthesizer package
package synthesizer;
import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            // 其实在其内部的currentIndex 是已经被定义好了的状态的;
            private int currentIndex=first;
            @Override
            public boolean hasNext() {
                return currentIndex!= last;
            }

            @Override
            public T next() {
                if(!hasNext()) {
	               throw new RuntimeException("No more elements");
                   // 也就是没有更多的数据了的情况;
                }
                return rb[(currentIndex+1)%capacity];
            }
        };
        //  但是这个你让我怎么进行重写啊;
    }

    /* 这是一个上面的内容要求的简单的数组形式的实现操作;*/
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        this.rb=(T[])new Object[capacity];
        this.first=0;
        this.last=0;// 基本的状态为[ ) 的形式的;
        this.fillCount=0;
        this.capacity=capacity;
        /*内部的实现是从前面获取然后从后面进行添加的操作的;
        * 这里使用的思想就是在1A内使用的环形数组的形式去实现的;
        * 最近的插入项之后的下一个索引的位置信息是在这里的;
        * */
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        // 在后面增加数据的操作;
        // 更新最后一个数字的操作是这样的;
        if(isFull()){
            throw new RuntimeException("Ring Buffer Overflow");
        }
        // 也就是出现了首尾重合的状态了;
        int index=last%capacity;
        // 真的是好想法啊 通过fillCount 去判断其是不是被填满的状态的;
        last=((last+1)%capacity);
        fillCount++;
        rb[index]=x;
        return ;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        // 删除对应的起始位置的数据;
        if(isEmpty()) {
            throw new RuntimeException("Ring Buffer Underflow");
        }
        T ans=rb[first%capacity];// 但是也是可以出现一种情况就是将其进行取模的操作就行了
        // 计算的还是其在这里面的相对的位置信息
        // first last 之间的数量关系是怎样的；
        first=(first+1)%capacity;// 新的开始位置
        fillCount--;
        return ans;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        if(isEmpty())
        return null;
        return rb[first%capacity];
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
    // 第五部分 支持指定的迭代的代码的操作是这样的;
}
