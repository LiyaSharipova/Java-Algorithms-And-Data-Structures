package ru.kpfu.itis.group403.sharipova.graph;

import java.awt.List;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import ru.kpfu.itis.group403.sharipova.graph.Graph.Edge;

public class MyGraph<V> implements Graph<V> {
	HashMap<Edge<V>, Boolean> map;
	LinkedList<V> vertexes;

	@Override
	public boolean add(V vertex) {
		if(vertexes==null){
			vertexes=new LinkedList<V>();
			map= new HashMap<Edge<V>, Boolean>();
		}
		if (!isExist(vertex)){
			vertexes.add(vertex);
			Edge<V> edge;
			Edge<V> edge2;

			for (V v : vertexes) {
				edge=new Edge<V>(vertex, v);
				map.put(edge, false);
				if(!v.equals(vertex)){
					edge2=new Edge<V>(v, vertex);
					map.put(edge2, false);
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean add(V begin, V end) {
		if(vertexes==null){
			vertexes=new LinkedList<V>();
			map= new HashMap<Edge<V>, Boolean>();
		}
		if(isExist(begin, end)){
			return false;
		}
		if(!isExist(begin)&&!isExist(end)){
			add(begin);
			add(end);			
		}
		if(!isExist(end))
			add(end);
		if(!isExist(begin))
			add(begin);
		Edge<V> edge = new Edge<V>(begin, end);
		edge=existedEdge(edge);
		map.put(edge, true);
		return true;
	}

	@Override
	public boolean add(Edge<V> edge) {
		return add(edge.getBegin(), edge.getEnd());		
	}
	@Override
	public boolean isExist(V v) {
		if(vertexes==null){
			return false;
		}
		return vertexes.contains(v);
	}
	@Override
	public boolean isExist(V begin, V end) {
		if(vertexes==null){
			return false;
		}
		Edge<V> edge = new Edge<V>(begin, end);
		edge=existedEdge(edge);
		if(  map.containsKey(edge)&&
				map.get(edge)){
			return true;
		}
		return false;
	}
    private Edge<V> existedEdge(Edge<V> edge){
    	Set<Entry<Edge<V>, Boolean>> entrySet= map.entrySet();
		for (Entry<Edge<V>, Boolean> entry : entrySet ) {
			if (entry.getKey().equals(edge)){
				return entry.getKey();
			}
		}
		return edge;
    }
	@Override
	public boolean isExist(Edge<V> edge) {
		if(vertexes==null){
			return false;
		}
		return  isExist(edge.getBegin(), edge.getEnd());	
	}

	@Override
	public Collection<V> getAdjList(V vertex) {
		if(vertexes==null){
			return null;
		}
		if(!isExist(vertex)) return null;
		LinkedList<V> adjList= new LinkedList<V>();
		Set<Entry<Edge<V>, Boolean>> entrySet= map.entrySet();
		for (Iterator iterator = entrySet.iterator(); iterator.hasNext();) {
			Entry<Edge<V>, Boolean> entry = (Entry<Edge<V>, Boolean>) iterator.next();
			if (entry.getKey().getBegin().equals(vertex)&&(entry.getValue()))
				adjList.add(entry.getKey().getEnd());
			if (entry.getKey().getEnd().equals(vertex)&&(entry.getValue()))	
				adjList.add(entry.getKey().getBegin());
		}

		return adjList;
	}

	@Override
	public boolean delete(V vertex) {
		if(vertexes==null){
			return false;
		}
		if(!isExist(vertex)) return false;
		Set<Entry<Edge<V>, Boolean>> entrySet= map.entrySet();
		for (Iterator iterator = entrySet.iterator(); iterator.hasNext();) {
			Entry<Edge<V>, Boolean> entry = (Entry<Edge<V>, Boolean>) iterator.next();
			if (entry.getKey().getBegin().equals(vertex)||entry.getKey().getEnd().equals(vertex))
				iterator.remove();
		}
		vertexes.remove(vertex);
		return true;
	}

	@Override
	public boolean delete(V begin, V end) {
		if(vertexes==null){
			return false;
		}
		if(!isExist(begin, end)) return false;
        delete(begin);
        delete(end);
        return true;
	}

	@Override
	public boolean delete(Edge<V> edge) {
		return delete(edge.getBegin(), edge.getEnd());
	}

	@Override
	public Iterator<V> getVertex() {
		return vertexes.iterator();
	}
	public String toString() {
		Set<Entry<Edge<V>, Boolean>> entrySet= map.entrySet();
		for (Entry<Edge<V>, Boolean> entry : entrySet ) {
			System.out.println(entry.getKey().getBegin()+ " "+entry.getKey().getEnd()+ " "+  entry.getValue());
		}
		return null;

	}

	public static void main(String[] args) {
		MyGraph<Integer> gr= new MyGraph<Integer>();
		gr.add(1);
		gr.add(1, 2);
		gr.add(3,4);
		gr.add(1,3);
		gr.toString();
		System.out.println("AdjList");
		for (Integer v : gr.getAdjList(1)) {
			System.out.println(v);
		}
		System.out.println("delete 1,2");
		gr.delete(1,2);
		gr.toString();
	}

}
