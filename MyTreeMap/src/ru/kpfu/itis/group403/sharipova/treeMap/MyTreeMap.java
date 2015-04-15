package ru.kpfu.itis.group403.sharipova.treeMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class MyTreeMap<K extends Comparable<K>, V> {
	private Node root;
	private int size=0;
	private class Node{
		private K key;
		private V val;
		public Node(K key, V val) {
			super();
			this.key = key;
			this.val = val;
		}
		private Node left;
		private Node right;		

	}
	public int size() {
		return size;
	}
	public void put(K key, V val){
		root=put(root, key, val);
		size++;
	}	
	private Node put(Node x, K key, V val){
		if (x==null)
			return new Node(key, val);
		int cmp=key.compareTo(x.key);
		if (cmp<0) x.left=put(x.left, key, val);
		else if(cmp>0) x.right=put(x.right, key, val);
		else x.val=val;
		return x;

	}
	public V get(K key) {
		return get(root, key);
	}
	private V get (Node x, K key) {
		if (x==null) return null;
		int cmp=key.compareTo(x.key);
		if (cmp<0) return get(x.left, key);
		else if(cmp>0) return get(x.right, key);
		else return x.val;
	}
	private Node min(Node root) {
		Node node=root;
		while(node.left!=null){
			node=node.left;
		}
		return node;
	}
	private Node deleteMin(Node x){
		if(x.left==null) return x.right;
		x.left=deleteMin(x.left);
		return x;
	}
	public void delete(K key) {
		root=delete(root, key);
		size--;
	}
	private Node delete(Node x, K key) {
		if(x==null) return null;
		int cmp=key.compareTo(x.key);
		if (cmp<0) return delete(x.left, key);
		else if(cmp>0) return delete(x.right, key);
		else {
			if(x.right==null) return x.left;
			if(x.left==null) return x.right;
			Node t=x;
			x=min(t.right);
			x.right=deleteMin(t.right);
			x.left=t.left;
		}
		return x;
	}
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<>();
		return set;
	}
	private void fillSet(Set<Map.Entry<K, V>> set, Node node) {

		if(node == null) {
			return;
		}
		
		if(node.left != null) {
			fillSet(set, node.left);
		}

		if(node.right != null) {
			fillSet(set, node.right);
		}
		set.add(new Map.Entry<K, V>() {

			@Override
			public K getKey() {
				return node.key;
			}

			@Override
			public V getValue() {
				return node.val;
			}

			@Override
			public V setValue(V value) {
		
				V lastVal = node.val;
				
				node.val = value;
				
				return lastVal;
			
			}
			
		});
		
	}
	public static void main(String[] args) {
		MyTreeMap<Integer, String> map= new MyTreeMap<Integer, String>();
		map.put(5, "five");
		map.put(1, "one");
		map.put(4, "four");
		map.put(7, "seven");
		String s=map.get(11);
		

	}

}
