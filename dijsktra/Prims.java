package proje4.dijsktra;


import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {
	

	ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
	
	public Prims(ArrayList<WeightedNode> nodeList) {
		this.nodeList = nodeList;
	}


	// Prim's algorithm from source node
	void prims(WeightedNode node) {
	  for (int counter = 0; counter < nodeList.size(); counter++) {
	      nodeList.get(counter).distance = Integer.MAX_VALUE;
	  }
	  node.distance=0;
		PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
		queue.addAll(nodeList);
		while (!queue.isEmpty()) {
			WeightedNode presentNode = queue.remove();
			for (WeightedNode neighbor : presentNode.neighbors) {
				if (queue.contains(neighbor)) {
				
					if (neighbor.distance > presentNode.weightMap.get(neighbor)) {
						neighbor.distance = presentNode.weightMap.get(neighbor);
						neighbor.parent = presentNode;
						queue.remove(neighbor);
						queue.add(neighbor);
					}
				}
			}
		}
		int cost = 0;

		for (WeightedNode nodeToCheck : nodeList) {
			System.out.println("Node " + nodeToCheck + ", key: " + nodeToCheck.distance + ", Parent: " + nodeToCheck.parent);
			cost = cost + nodeToCheck.distance;
		}

		System.out.println("\nTotal cost of MST: " + cost);
	}
	
	public void addWeightedUndirectedEdge(int i, int j, int d) {
		WeightedNode first = nodeList.get(i);
		WeightedNode second = nodeList.get(j);
		first.neighbors.add(second);
		second.neighbors.add(first);
		first.weightMap.put(second,d);
		second.weightMap.put(first, d);
	}

}
