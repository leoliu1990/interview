package edu.rice.setofstacks;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class SetOfStacks<E> {
	private int singlesize;
	private ArrayList<E[]> list;
	private int total;
	
	private int loc;
	private int offset;
	private int loc_pop;
	private int offset_pop;
	
	
	public SetOfStacks(int singlesize){
		this.singlesize = singlesize;
		initialize();
	}
	
	@SuppressWarnings("unchecked")
	private void initialize(){
		this.list = new ArrayList<E[]>();
		list.add((E[]) new Object[singlesize]);		
		this.total = 0;
		this.loc = 0;
		this.offset = 0;
		this.loc_pop = 0;
		this.offset_pop = 0;
	}
	
	@SuppressWarnings("unchecked")
	public E push(E item){
		E array[] = list.get(loc);
		array[offset] = item;
		list.set(loc, array);
		loc_pop = loc;
		offset_pop = offset;
		if(offset == singlesize-1){
			list.add((E[]) new Object[singlesize]);
			loc++;
			offset = 0;
		}else{
			offset++;
		}
		total++;
		return item;
	}
	
	public E peek(){
		if(total == 0)
			throw new EmptyStackException();
		E array[] = list.get(loc_pop);
		return array[offset_pop];
	}
	
	public E pop(){
		E item = peek();
		loc = loc_pop;
		offset = offset_pop;
		if(offset_pop == 0){
			list.remove(loc_pop);
			loc_pop--;
			offset_pop = singlesize-1;
		}else{
			offset_pop--;
		}
		total--;
		return item;
	}
	
	public String toString(){
		if(total == 0)
			return "";
		
		StringBuffer sb = new StringBuffer();
		E array[] = list.get(loc_pop);
		for(int i = offset_pop; i >= 0;i--){
			sb.append(array[i]);
			sb.append(" ");
		}
		for(int i = loc_pop-1; i >= 0; i--){
			array = list.get(i);
			for(int j = singlesize-1 ; j >= 0; j--){
				sb.append(array[j]);
				sb.append(" ");
			}
		}
		return sb.toString();
	}
	
	public static void main(String s[]){
		SetOfStacks<Integer> stack = new SetOfStacks<Integer>(4);
		System.out.println(stack);
		stack.push(1);
		System.out.println(stack);
		stack.push(2);
		System.out.println(stack);
		stack.push(3);
		System.out.println(stack);
		stack.push(4);
		System.out.println(stack);
		stack.push(5);
		System.out.println(stack);
		stack.push(6);
		System.out.println(stack);
		int p = stack.pop();
		System.out.println(stack+": "+p);
		p = stack.pop();
		System.out.println(stack+": "+p);
		p = stack.pop();
		System.out.println(stack+": "+p);
		p = stack.pop();
		System.out.println(stack+": "+p);
	}
}
