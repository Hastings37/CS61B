// TODO: Make sure to make this class a part of the synthesizer package
//package <package name>;
package synthesizer;

import synthesizer.BoundedQueue;

import java.sql.Array;

/*
* 使用ArrayRingBuffer 来复制进行拨弦的声音，Karplus-Strong 算法 BoundedQueue 来实现是这样的;
*
*
*
* 随机的噪声替换掉 BoundedQueue内的每个项目
* 移除前一个双精度数字，然后将其和BQ内的洗一个相乘求取对应的平均值
* 播放其中出队的内容，然后继续进行下去循环*/
//Make sure this class is public
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final means
     * the values cannot be changed at runtime. We'll discuss this and other topics
     * in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        // TODO: Create a buffer with capacity = SR / frequency. You'll need to
        //       cast the result of this divsion operation into an int. For better
        //       accuracy, use the Math.round() function before casting.
        //       Your buffer should be initially filled with zeros.
        int cap =(int)(Math.round(SR/frequency));
        // 开始的时候需要全都是0
        buffer=new ArrayRingBuffer<>(cap);
        for(int i=0;i<cap;i++){
            buffer.enqueue(0.0);
        }

    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        // TODO: Dequeue everything in the buffer, and replace it with random numbers
        //       between -0.5 and 0.5. You can get such a number by using:
        //       double r = Math.random() - 0.5;
        //
        //       Make sure that your random numbers are different from each other.
        // 对内部的东西进行删除和重新填充的操作;
        int size=buffer.capacity();
        for(int i=0;i<size;i++){
            // 删除前面的添加在后面的操作;
            double old=buffer.dequeue();
            double r = Math.random() - 0.5;
            buffer.enqueue(r);

        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm. 
     */
    public void tic() {
        // TODO: Dequeue the front sample and enqueue a new sample that is
        //       the average of the two multiplied by the DECAY factor.
        //       Do not call StdAudio.play().
        double first=buffer.dequeue();
        double second=buffer.peek();
        double avg= (first+second)/2*DECAY;
        buffer.enqueue(avg);
        return ;

    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        // TODO: Return the correct thing.
        double ans=buffer.peek();

        return ans;
        // return 0;
    }
}
