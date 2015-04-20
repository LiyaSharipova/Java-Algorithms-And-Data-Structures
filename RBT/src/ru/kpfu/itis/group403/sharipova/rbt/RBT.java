package ru.kpfu.itis.group403.sharipova.rbt;


public class RBT<K extends Comparable<K>, V> {
	public static final boolean RED=true;
	public static final boolean BLACK=false;
	private Node root;
	
	private class Node{
		private K key;
		private V val;
		private boolean color;
		public Node(K key, V val, boolean color) {
			super();
			this.key = key;
			this.val = val;
			this.color=color;
		}
		private Node left;
		private Node right;		

	}
	private boolean isRed(Node h) {
		return h.color==RED;
	}
	private Node rotateLeft(Node h) {
		Node x=h.right;
		h.left=x.right;
		x.right=h;
		x.color=h.color;
		h.color=RED;
		return x;
	}
	private Node rotateRight(Node h) {
		Node x=h.left;
		h.right=x.left;
		x.left=h;
		x.color=h.color;
		h.color=RED;
		return x;
	}
	private void flipColors(Node h) {
		h.color=RED;
		h.left.color=BLACK;
		h.right.color=BLACK;
	}
	public void put(K key, V val) {
		root=put(root, key, val);
		//???
		root.color=BLACK;
	}
	private Node put(Node h, K key, V val) {
		if(h==null)
			return new Node(key, val, RED);
		int cmp=key.compareTo(h.key);
		if (cmp<0)
			h.left=put(h.left, key, val);
		else if (cmp>0) h.right=put(h.right, key, val);
		else h.val=val;
		
		if (isRed(h.right)&&!isRed(h.left)) h=rotateLeft(h);
		if (isRed(h.left)&& isRed(h.left.left)) h=rotateRight(h);
		if (isRed(h.left)&& isRed(h.right)) flipColors(h);
		return h;
		
	}
}
