package ru.kpfu.itis.group403.sharipova.graph;

import java.util.Collection;
import java.util.Iterator;

public interface Graph<V> {
	class Edge<V>{
		private V begin;
		private V end;
		public V getBegin() {
			return begin;
		};
		public V getEnd() {
			return end;
		}
		public Edge(V begin, V end) {
			super();
			this.begin = begin;
			this.end = end;
		}
		public boolean equals( Edge<V> v){
			if (v.begin==begin&& v.end==end)
			return true;
			return false;
		}
	}
	boolean add(V vertex);
	boolean add(V begin, V end);
	boolean add(Edge<V> edge);
	boolean isExist(V b, V e);
	boolean isExist(Edge<V> e);
	boolean isExist(V v);
	Collection<V> getAdjList(V vertex);
	boolean delete(V vertex);
	boolean delete(V begin, V end);
	boolean delete(Edge<V> edge);
	Iterator<V> getVertex();

}
