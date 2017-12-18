package ds.ctci.ch4.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	int id = 0;
	String name = "";
	State state = State.Unvisisted;
	List<Node> adjacent = new ArrayList<Node>();
	
	Node(int id) {
		this.id = id;
	}
	Node(String name) {
		this.name = name;
	}
	
	void addAdjacent(Node node) {
		adjacent.add(node);
	}
}

enum State {Unvisisted, Visiting, Visited};