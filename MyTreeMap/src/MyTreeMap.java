
public class MyTreeMap<K extends Comparable<K>, V> {
	private Node root;
	private class Node{
		private V value;
		private K key;
		private Node left;
		private Node right;		
	
	}
	public void put(K key, V value){
		if (key==null){
			System.out.println("key can't be null");
		}
	    Node curRoot=root;
	    if (curRoot==null){
	    	root.value=value;
	    	root.key=key;
	    	return;
	    }
	    while(curRoot!=null){
	    	if (curRoot.key.equals(key)){
	    		curRoot.value=value;
	    	}
	    	else if(curRoot.key.compareTo(key)<0){
	    		curRoot=curRoot.left;
	    	}
	    	else{
	    		curRoot=curRoot.right;
	    	}
	    }
	    curRoot.key=key;
	    curRoot.value=value;
	    
	}	
	public static void main(String[] args) {
		MyTreeMap<Integer, String> map= new MyTreeMap<Integer, String>();
		
	}
}