package ru.kpfu.itis.group11403.sharipova.linkedlist;

public class MyLinkedList<T> {
	private int size=0;

	private class Item {
		private T obj;
		
		private Item next;

		public Item getNext() {
			return next;
		}

		public void setNext(Item next) {
			this.next = next;
		}

		public T getObj() {
			return obj;
		}

		public void setObj(T obj) {
			this.obj = obj;
		}		
	}


	private Item first;

	private Item end;
	
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Item getFirst() {
		return first;
	}
	public Item getEnd() {
		return end;
	}
	public void setFirst(Item first) {
		this.first = first;
	}
	public void setEnd(Item end) {
		this.end = end;
	}


	public void add(T data) {

		Item addedItem = new Item();
		addedItem.setObj(data);

		if (first==null){
			first= new Item();
			first.setObj(data);
			end= first;
		}
		else if (first==end) {
			first.setNext(addedItem);
			end=addedItem;			
		}
		else{
			end.setNext(addedItem);
			end=addedItem;
		}
		size++;

	}
	public Item getItem( int index){
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Невозможно получить элемент по индексу " + index);
		}
        int i=0;
        Item item= new Item();
        item=first;
        while(i<index){
        	item=item.getNext();
        	i++;
        }
        return item;
	}

	public void paste (T data, int index){
		Item addedItem = new Item();
		addedItem.setObj(data);
		Item item= getItem(index);
		addedItem.setNext(item);
		getItem(index-1).setNext(addedItem);
		size++;
	}
	private void delete(int index) {
		if(first == null) {			
			throw new IndexOutOfBoundsException("Невозможно удалить элемент из пустого списка");
		}
		if( index==0){
			setFirst(getItem(index+1));
		}
		else if (getItem(index)==end){
			getItem(index-1).setNext(null);
			setEnd(getItem(index-1));
		}
		else{
			getItem(index-1).setNext(getItem(index+1));
		}
		size--;
	}
	
	public static void main(String[] args) {
		MyLinkedList<Student> myLinkedList = new MyLinkedList<Student>();
		myLinkedList.add(new Student(10, 1940, "John"));
		myLinkedList.add(new Student(11, 1941, "bill"));
		myLinkedList.add(new Student(12, 1940, "Kir"));
		for (int i=0; i<myLinkedList.getSize(); i++){
			System.out.println(myLinkedList.getItem(i).getObj().getName());
		}
		Student st= (Student)myLinkedList.getItem(2).getObj();
		myLinkedList.paste(new Student(12, 1940, "Bob"), 1);
		System.out.println("Paste Bob on the 2nd spot");
		for (int i=0; i<myLinkedList.getSize(); i++){
			System.out.println(myLinkedList.getItem(i).getObj().getName());
		}
		myLinkedList.delete(2);
		System.out.println("Delete the 3rd");
		for (int i=0; i<myLinkedList.getSize(); i++){
			System.out.println(myLinkedList.getItem(i).getObj().getName());
		}
	}

}
