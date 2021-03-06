package edu.rice.myqueue;

import java.util.Stack;

public class MyQueue<E> {
	private Stack<E> in;
	private Stack<E> out;
	private int count;
	
	public MyQueue(){
		in = new Stack<E>();
		out = new Stack<E>();
		count = 0;
	}
	
	public E add(E item){
		in.push(item);
		count++;
		return item;
	}
	
	public E peek(){
		if(out.empty()){
			for(int i = 0; i < count; i++){
				out.push(in.pop());
			}
			in.clear();
			if(out.empty())
				return null;
		}
		return out.peek();
	}
	
	public E pop(){
		E item = peek();
		if(item != null){
			out.pop();
			count--;
		}
		return item;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append(in.toString());
		sb.append(out.toString());
		return sb.toString();
	}
	
	public static void main(String s[]){
		MyQueue<Integer> queue = new MyQueue<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		
		System.out.println(queue);
		queue.pop();
		System.out.println(queue);
		queue.pop();
		System.out.println(queue);
		queue.add(5);
		System.out.println(queue);
		queue.add(6);
		System.out.println(queue);
		queue.pop();
		System.out.println(queue);
		queue.pop();
		System.out.println(queue);
		queue.pop();
		System.out.println(queue);
		queue.pop();
		System.out.println(queue);
	}
}
