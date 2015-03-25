import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class DynamicList<E> implements List<E> {
	private Object[] array= new Object[5];
	private int size=0;
	public DynamicList() {}
	public DynamicList(E[] array) {
		size = array.length;
		this.array = Arrays.copyOf(array, array.length);
	}

	private void extendArray(int val){
		if (isEmpty()){
			array = new Object[val];
		}else {
			Object [] temp = new Object[array.length+val];
			System.arraycopy(array,0,temp,0,size);
			array = temp;
		}

	}

	private boolean checkRange(int index){
		if (index < 0 || index >= size){
			throw new IndexOutOfBoundsException("incorrect index /" + index );
		}
		return true;
	}
	private boolean rangeForAddtionCheck(int index){
		if (index < 0 || index >= size){
			throw new IndexOutOfBoundsException("incorrect index /" + "index : "+index+", capacity : " + array.length);
		}
		return !(isEmpty() || array.length < size + 1);
	}

	@Override
	public void add(int index, E element) {
		if(rangeForAddtionCheck(index)){
			extendArray(5);
		}
		Object[] temp= new Object[array.length];
		System.arraycopy(array, 0, temp, 0, index);
		temp[index]=element;
		System.arraycopy(array, index, temp, index+1, array.length-index-1);
		array=temp;
		if (index > size){
			size += index - size;
		}
		size++;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if(size==0){
			return true;
		}
		else return false;
	}

	@Override
	public boolean contains(Object o) {
		for (int i=0; i<size; i++){
			if(array[i].equals(o)){
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {

		return new Iterator<E>() {
			private int iterator = 0;
			@Override
			public boolean hasNext() {
				return iterator < size;
			}

			@Override
			public E next() {
				if (iterator == size){
					throw new NoSuchElementException("no such element with index " + iterator);
				}
				return (E)array[iterator+1];

			}
		};
	}

	@Override
	public Object[] toArray() {
		return Arrays.copyOf(array, size);
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean add(E e) {
		if (isEmpty() || array.length < size+1){
			extendArray(5);
		}
		array[size]=e;
		size++;
		return true;
	}


	@Override
	public boolean containsAll(Collection<?> c) {
		checkCollection(c);
		if (c.isEmpty()){
			return true;
		}
		Object [] collectionObj = c.toArray();
		for (int i = 0; i < collectionObj.length; i++) {
			if (!contains(collectionObj[i])){
				return false;
			}
		}
		return true;
	}
	private void checkCollection(Collection<?> c){
		if (c == null){
			throw new NullPointerException("collection is null");
		}
	}
	@Override
	public boolean addAll(Collection<? extends E> c) {
		if(c.isEmpty()){
			return false;
		}
		checkCollection(c);
		Object[] colObj=c.toArray();
		collectionRangeCheck(colObj.length);
		System.arraycopy(colObj, 0, array, size , colObj.length);
		return true;
	}
	private void collectionRangeCheck(int colSize){
		if (size+colSize>array.length){
			extendArray(size+colSize-array.length);
		}
	}
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		if(c.isEmpty()){
			return false;
		}
		checkRange(index);
		checkCollection(c);
		Object[] colObj=c.toArray();
		int colSize=colObj.length;
		int movedItemAmount=size-index;
		collectionRangeCheck(colObj.length);
		System.arraycopy(array, index, array,index+colSize, movedItemAmount);
		System.arraycopy(colObj, 0, array, index, colSize);

		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		if(c.isEmpty()){
			return false;
		}
		boolean k=false;
		Object[] colObj=c.toArray();
		for (int i = 0; i < colObj.length; i++) {
			if(remove(colObj[i])) 
				k=true;
		}
		return k;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		Object[] colObj=c.toArray();
		if (Arrays.equals(array, colObj)){
			return false;
		}
		boolean k=false;

		for (int i = 0; i < size; i++) {
			if (!c.contains(array[i])){
				remove(i);
				i--;
				k=true;
			}
		}
		return k;

	}

	@Override
	public void clear() {
		for (int i=0; i<=size; i++){
			array[i]=null;
		}
	}

	@Override
	public E get(int index) {		
		return (E)array[index];
	}

	@Override
	public E set(int index, E element) {
		E e= (E)array[index];
		array[index]=element;
		return e;
	}



	@Override
	public E remove(int index) {
		E e= (E)array[index];
		if (index!=size-1){
			for(int i=index; i<size; i++){
				array[i]=array[i+1];
			}
		}
		array[size-1]=null;
		size--;
		return e;
	}

	@Override
	public boolean remove(Object o) {
		if (o == null){
			for (int i = 0; i < size; i++) {
				if (array[i] == null){
					remove(i);
					return true;
				}
			}
		}else {
			for (int i = 0; i < size; i++) {
				if (o.equals(array[i])){
					remove(i);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public int indexOf(Object o) {
		if (o == null){
			for (int i = 0; i < size; i++) {
				if (array[i] == null){	                 
					return i;
				}
			}
		}else {
			for (int i = 0; i < size; i++) {
				if (o.equals(array[i])){	                    
					return i;
				}
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		if (o == null){
			for (int i = size-1; i >= 0; i--) {
				if (array[i] == null){	                 
					return i;
				}
			}
		}else {
			for (int i = size-1; i >= 0; i--) {
				if (o.equals(array[i])){	                    
					return i;
				}
			}
		}
		return -1;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {

		return new ListIterator<E>() {
			private int cursor = index;
			private int last = index-1;
			@Override
			public boolean hasNext() {
				return cursor < size;
			}

			@Override
			public E next() {
				if (cursor == size){
					throw new NoSuchElementException("no such element with index " + cursor );
				}
				int x = cursor;
				cursor ++;
				last++;
				return (E)array[x];
			}

			@Override
			public boolean hasPrevious() {
				return cursor != 0;
			}

			@Override
			public E previous() {
				if (cursor < 0 || cursor >= size){
					throw new NoSuchElementException("no such element with index " + (cursor-1));
				}
				last = cursor;

				Object elem = array[cursor--];

				return (E) elem;
			}

			@Override
			public int nextIndex() {
				return cursor;
			}

			@Override
			public int previousIndex() {
				return cursor-1;
			}

			@Override
			public void remove() {
                if (last < 0){
                    throw new NoSuchElementException("no such element with index " + last);
                }
                try{
                    DynamicList.this.remove(last);
                    cursor = last;
                    last = index-1;
                }catch (IndexOutOfBoundsException e){
                    throw new IndexOutOfBoundsException("no such element with index " + e);
                }
            }

            @Override
            public void set(E o) {
                if(last < 0){
                    throw new IndexOutOfBoundsException("no such element with index " + last);
                }
                try{
                    DynamicList.this.set(last, o);
                }catch (IndexOutOfBoundsException e){
                    throw new IndexOutOfBoundsException("out of range " + e);
                }

            }

            @Override
            public void add(E o) {
                if (last < 0){
                    throw new NoSuchElementException("no such element with index " + last);
                }
                try {
                    int i = cursor;
                    DynamicList.this.add(i, o);
                    cursor = i + 1;
                    last = index-1;
                } catch (IndexOutOfBoundsException e) {
                    throw new IndexOutOfBoundsException("out of range " + (cursor-1));
                }
            }
		};
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		if (fromIndex > toIndex && checkRange(fromIndex) && checkRange(toIndex)){
			throw new IndexOutOfBoundsException("incorrect index " + "formIndex :"
					+ fromIndex + ", toIndex : "+ toIndex);
		}
		List<E> list;
		Object [] obj = Arrays.copyOfRange(array,fromIndex,toIndex);
		if (fromIndex == toIndex){
			list = Collections.EMPTY_LIST;
		}else 
			list = Arrays.asList((E)obj);
		return list;
	}   

	public static void main(String[] args) {
		DynamicList<Integer> newDynamcList= new DynamicList<Integer>();
		newDynamcList.add(0);
		newDynamcList.add(1);
		newDynamcList.add(2);
		//		newDynamcList.remove(1);
		//		newDynamcList.remove(1);
		//		newDynamcList.add(1);
		DynamicList<Integer> newDynamcList2= new DynamicList<Integer>(new Integer[] {0,6});

		newDynamcList.retainAll( newDynamcList2);

	}
}
