package n310_minimum_height_tree;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    	Node[] nodes = new Node[n];
    	for(int i = 0; i < n; i++) nodes[i] = new Node(i);
    	for(int i = 0; i < edges.length; i++){
    		nodes[edges[i][0]].adjList.add(nodes[edges[i][1]]);
    		nodes[edges[i][1]].adjList.add(nodes[edges[i][0]]);
    	}
    	int randomRoot = new Random().nextInt(n);
    	buildTree(nodes[randomRoot]);
    	return adjustTree(nodes[randomRoot]);
    }
    
    //Build a tree under the given root by using its adjacent list.
    public void buildTree(Node root){
    	for (int i = 0; i < root.adjList.size(); i++){
    		Node adj = root.adjList.get(i);
    		if(root.parent == adj) continue;
    		adj.parent = root;
    		buildTree(adj);
    		root.addChild(adj);
    	}
    }
    
    //Adjust the root of the tree until the tree is "close to balance", satisfying the requirement of a MHT.
    //There are only three cases:
    //1. if the longest path is equal to the second longest path, then this is a unique MHT of the given graph
    //2. if the longest path is 1 longer than the second longest path, then there are two MHTs, the current one, 
    //   and the one rooted with its child of the longest path
    //3. if the longest path is at least 2 longer than the second longest path, then this is not a MHT, 
    //   and we need to change the root to the child of the longest path, and recursively call the function with the new root.
    public List<Integer> adjustTree(Node root){
    	Node maxChild = root.removeMaxChild();
    	if(maxChild == null || maxChild.longestpath + 1 - root.longestpath == 0) { //case 1
    		List<Integer> result = new LinkedList<Integer>();
    		result.add(root.val);
    		return result;
    	}
    	if(maxChild.longestpath + 1 - root.longestpath >= 2){ //case 3
    		root.parent = maxChild;
    		maxChild.addChild(root);
    		return adjustTree(maxChild);
    	}
    	else{ //case 2
    		List<Integer> result = new LinkedList<Integer>();
    		result.add(root.val);
    		result.add(maxChild.val);
    		return result;
    	}
    }
    
    int max(int a, int b){
    	return a > b ? a : b;
    }
    
    class Node{
    	int val;
    	int longestpath;
    	Node parent;
    	List<Node> adjList = new LinkedList<Node>();
    	//Order the children by the length of the corresponding paths
    	PriorityQueue<Node> queue = new PriorityQueue<Node>(11, new NodeComparator());
    	Node(int x) {val = x;}
    	public void addChild(Node child){
    		queue.add(child);
    		if(longestpath < child.longestpath + 1)
    			longestpath = child.longestpath + 1;
    	}
    	public Node removeMaxChild(){
    		Node maxChild = queue.poll();
    		longestpath = (!queue.isEmpty()) ? (queue.peek().longestpath + 1) : 0;
    		return maxChild;
    	}
    }
    
    class NodeComparator implements Comparator<Node>{

		@Override
		public int compare(Node o1, Node o2) {
			if(o1.longestpath < o2.longestpath)
				return 1;
			if(o1.longestpath > o2.longestpath)
				return -1;
			return 0;
		}
    }
}
