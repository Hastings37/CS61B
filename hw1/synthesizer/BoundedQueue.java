// package synthesizer;
//
// public interface BoundedQueue<T> {
// 	/*
// 	* 内部的内容的权限信息默认是public abstract 状态的;
// 	* */
//
// 	int capacity();
//
// 	int fillCount();//现在内部的数量信息
//
// 	void enqueue(T x);// 从后面进行添加元素的操作;
//
// 	T dequeue();// 删除并且给出前面的元素；
//
// 	T peek(); //只是获取到但是不进行删除操作;
//
// 	default boolean isEmpty(){
// 		return fillCount() == 0;
// 	}
//
// 	default boolean isFull(){
// 		return fillCount()>=capacity();
// 	}
// }
// /* 抽象类是无法进行实例化的但是其可以使用extends 关键字将其子类化
// * 和接口不一样抽象类可以为公共方法之外的功能提供实现和继承的操作
// * */



package synthesizer;
import java.util.Iterator;

public interface BoundedQueue<T> extends Iterable<T>{
	/*
	 * 内部的内容的权限信息默认是public abstract 状态的;
	 * */

	int capacity();

	int fillCount();//现在内部的数量信息

	void enqueue(T x);// 从后面进行添加元素的操作;

	T dequeue();// 删除并且给出前面的元素；

	T peek(); //只是获取到但是不进行删除操作;

	default boolean isEmpty(){
		return fillCount() == 0;
	}

	default boolean isFull(){
		return fillCount()>=capacity();
	}
}
/* 抽象类是无法进行实例化的但是其可以使用extends 关键字将其子类化
 * 和接口不一样抽象类可以为公共方法之外的功能提供实现和继承的操作
 * */
