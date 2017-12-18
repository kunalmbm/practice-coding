package ds.ctci.ch4.graph;

import java.util.LinkedList;

public class RouteBetweenNodes {
	
	static boolean search(Graph g, Node start, Node end) {
		
		if(start == end)
			return true;
		
		for(Node n : g.nodes)
			n.state = State.Unvisisted;
		
		LinkedList<Node> q = new LinkedList<Node>();
		q.add(start);
		start.state = State.Visiting;
		
		while(!q.isEmpty()) {
			Node n = q.removeFirst();
			for(Node a : n.adjacent) {
				if(a.state!=State.Unvisisted)
					continue;
				
				if(a == end)
					return true;
				
				a.state = State.Visiting;
				q.addLast(a);
			}
			n.state = State.Visited;
		}
		
		return false;
	}
	

	public static void main(String[] args) {
		
		Node zero = new Node(0);
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		
		Graph g = new Graph();
		g.nodes.add(zero);
		g.nodes.add(one);
		g.nodes.add(two);
		g.nodes.add(three);
		g.nodes.add(four);
		g.nodes.add(five);
		g.nodes.add(six);
		g.nodes.add(seven);
		
		
		zero.addAdjacent(one);
		zero.addAdjacent(four);
		
		one.addAdjacent(two);
		
		two.addAdjacent(three);
		two.addAdjacent(four);
		
		three.addAdjacent(one);
		
		four.addAdjacent(zero);
		
		five.addAdjacent(six);
		five.addAdjacent(seven);
		
		six.addAdjacent(seven);
		
		//three.addAdjacent(five);
		
		System.out.println("0->6 : " + search(g, zero, six));
		System.out.println("7->2 : " + search(g, seven, two));

		System.out.println("0->3 : " + search(g, zero, three));
		System.out.println("0->0 : " + search(g, zero, zero));
		System.out.println("4->3 : " + search(g, four, three));
		System.out.println("1->3 : " + search(g, one, three));
		
	}
}
