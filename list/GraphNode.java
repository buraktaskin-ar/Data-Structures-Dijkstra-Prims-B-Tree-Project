package graph_ds.adj.list;

import java.util.ArrayList;

public class GraphNode {

	String name;
	int index;
	boolean isVisited = false;
	GraphNode parentNode;
	public ArrayList<GraphNode> neighbors  = new ArrayList<GraphNode>();


	public GraphNode(String name, int index){
		this.name = name;
		this.index = index;




	}








}
