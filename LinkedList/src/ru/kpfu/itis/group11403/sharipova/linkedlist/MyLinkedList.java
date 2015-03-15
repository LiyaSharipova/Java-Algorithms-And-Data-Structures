package ru.kpfu.itis.group11403.sharipova.linkedlist;



public class MyLinkedList<T> {

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


	private void setFirst(Item first) {
		this.first = first;
	}
	private void setEnd(Item end) {
		this.end = end;
	}

	public T get(int index) {
		return getItem(index).getObj();
	}

	public int size() {

		int size = 0;

		if(first == null) {
			return 0;
		}

		for(Item iter = first; iter != null; iter = iter.getNext(), size++);

		return size;

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
		

	}
	private Item getItem( int index){
		if(index < 0 || index >= size()) {
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
		
	}

	public static void main(String[] args) {
		MyLinkedList<Student> myLinkedList = new MyLinkedList<Student>();
		myLinkedList.add(new Student(10, 1940, "John"));
		myLinkedList.add(new Student(11, 1941, "bill"));
		myLinkedList.add(new Student(12, 1940, "Kir"));
		for (int i=0; i<myLinkedList.size(); i++){
			System.out.println(myLinkedList.get(i).getName());
		}
		Student st= myLinkedList.get(2);
		myLinkedList.paste(new Student(12, 1940, "Bob"), 1);
		System.out.println("Paste Bob on the 2nd spot");
		for (int i=0; i<myLinkedList.size(); i++){
			System.out.println(myLinkedList.get(i).getName());
		}
		myLinkedList.delete(2);
		System.out.println("Delete the 3rd");
		for (int i=0; i<myLinkedList.size(); i++){
			System.out.println(myLinkedList.get(i).getName());
		}
	}

}
