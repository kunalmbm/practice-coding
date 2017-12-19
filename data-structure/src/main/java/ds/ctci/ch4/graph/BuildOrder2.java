package ds.ctci.ch4.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildOrder2 {
	
	static int update(Node[] A, int offset, Graph g) {
		
		for(Node node : g.nodes) {
			if(node.state!=State.Unvisisted)
				continue;
			if(node.inEdgeCount > 0)
				continue;
			A[offset++] = node;
			node.state = State.Visiting;
		}
		
		return offset;
	}
	
	static Graph buildGraph(List<String> names, List<String> dep) {
		Graph g = new Graph();
		Map<String,Node> map = new HashMap<String,Node>();
		for(String name : names) {
			Node node = new Node(name);
			g.nodes.add(node);
			map.put(name, node);
		}
		
		while(!dep.isEmpty()) {
			Node a = map.get(dep.remove(0));
			Node b = map.get(dep.remove(0));
			
			a.addAdjacent(b);
			b.inEdgeCount++;
		}
		return g;
		
	}
	
	static Node[] buildOrder(List<String> names, List<String> dep) {
		
		Graph g = buildGraph(names, dep);
		//System.out.println("Graph Size : " + g.nodes.size());
		Node[] A = new Node[g.nodes.size()];
		
		int offset = 0;
		offset = update(A, offset, g);
		
		int index = 0;
		while(index < A.length) {
			
			Node node = A[index];
			if(node == null)
				throw new RuntimeException("cycle detected");
			
			for(Node a : node.adjacent)
				a.inEdgeCount--;
			
			offset = update(A, offset, g);
			index++;
			node.state = State.Visited;
		}
		
		return A;
	}
	
	public static void main(String[] args) {
		
		List<String> names = new ArrayList<String>();
		List<String> dep = new ArrayList<String>();
		
		names.add("a");
		names.add("b");
		names.add("c");
		names.add("d");
		names.add("e");
		names.add("f");
		names.add("g");
		names.add("h");

		dep.add("a"); dep.add("f");
		dep.add("a"); dep.add("d");
		dep.add("f"); dep.add("b");
		dep.add("d"); dep.add("b");
		dep.add("f"); dep.add("c");
		
		dep.add("e"); dep.add("g");
		dep.add("g"); dep.add("h");
		//dep.add("h"); dep.add("e");

		Node[] A = buildOrder(names, dep);
		System.out.print("Order : ");
		for(Node node : A)
			System.out.printf("%s, ",node.name);
		
		System.out.println();
		
	}

}
