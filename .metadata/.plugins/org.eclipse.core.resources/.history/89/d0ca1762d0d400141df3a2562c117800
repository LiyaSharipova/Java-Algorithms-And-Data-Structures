package ru.kpfu.itis.group11403.sharipova.queue;

public class Queue<T> {
	private Object [] elements;
	private int start = -1;
	private int end = -1;
    private int amount=0;
    public Queue(int size) {
		if (size<0){
			throw new IllegalArgumentException("negative size");
		}
		elements= new Object[size];
	}
   
    public boolean offer(T t){
    	if (amount+1>elements.length){
    		return false;
    	}
    	if (start==-1){
    		elements[++start]=t;
    		end=0;
    		amount++;
    		return true;
    	}
    	else{
    		end=(end+1)%elements.length;
    		elements[end]=t;
    		amount++;
    		return true;
    	}
    }
	public T poll(){
		if (amount==0) return null;
		Object first=elements[start];
		start++;
		amount--;
		return (T)first;
	}
	public static void main(String[] args) {
		Queue<Integer> q= new Queue<Integer>(3);
		q.offer(0);
		q.offer(1);
		q.offer(2);
		q.poll();
		q.offer(3);
		q.offer(4);
	}
}
