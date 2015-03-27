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
    public int size() {
		return amount;
	}
    public boolean  isEmpty() {
		if (amount==0) 
			return true;
		else 
			return false;
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
	public T peek() {
		return (T)elements[start];
	}

}
