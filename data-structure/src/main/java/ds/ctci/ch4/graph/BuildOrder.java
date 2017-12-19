package ds.ctci.ch4.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ds.util.ArrayUtility;

public class BuildOrder {
	
	static void updateOrderDFS(Node node, List<String> order) {
		
		node.state = State.Visiting;
		for(Node a : node.adjacent) {
			if(a.state == State.Visiting)
				throw new RuntimeException("Cycle detected");
			if(a.state == State.Visited)
				continue;
			updateOrderDFS(a,order);
		}
		node.state = State.Visited;
		order.add(node.name);
		
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
			
			b.addAdjacent(a);
		}
		return g;
		
	}
	
	static List<String> buildOrder(List<String> names, List<String> dep) {
		
		Graph g = buildGraph(names, dep);
		System.out.println("Graph Size : " + g.nodes.size());
		List<String> order = new ArrayList<String>();
		for(Node node : g.nodes) {
			if(node.state == State.Visited)
				continue;
			updateOrderDFS(node, order);
		}
		
		return order;
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
		
		dep.add("d"); dep.add("c");
		dep.add("a"); dep.add("d");
		dep.add("b"); dep.add("d");
		dep.add("f"); dep.add("a");
		dep.add("f"); dep.add("b");
		
		dep.add("g"); dep.add("e");
		dep.add("h"); dep.add("g");
		
		
		List<String> order = buildOrder(names, dep);
		System.out.print("Order : ");
		for(String name : order)
			System.out.printf("%s, ",name);
		
		System.out.println();
		
	}

}
