import java.util.Map;
import java.util.HashMap;

class GraphWN{

  class Node{
    private int key;
    private int distance;
    private String color;
    private Node pre; //Predecessor
    private Map<Node, Integer> adj; //Node adj map(Node, weight)

    public Node(int key){
  	  this.key = key;
  	  this.distance = 0;
  	  this.color = "white";
  	  this.pre = null;
  	  this.adj = new HashMap<Node, Integer>();
    }

    public int getKey(){
    	return this.key;
    }

    public void setDistance(int dis){
    	this.distance = dis;
    }

    public int getDistance(){
    	return this.distance;
    }

    public void setColor(String color){
    	this.color = color;
    }

    public String getColor(){
    	return this.color;
    }

    public void setPre(Node pre){
    	this.pre = pre;
    }

    public Node getPre(){
    	return this.pre;
    }

    public void setAdj(Node node, int weight){
    	this.adj.put(node, weight);
    }

    public Map<Node, Integer> getAdj(){
    	return this.adj;
    }
  }

  private int size;
  private Map<Integer, Node> nodes;

  public GraphWN(){
  	this.size = 0;
  	this.nodes = new HashMap<Integer, Node>();
  }

  public int getSize(){
  	return this.size;
  }

  public Map<Integer, Node> getNodes(){
  	return this.nodes;
  }

  public Node addNode(int key){
  	this.size += 1;
  	Node node = new Node(key);
  	nodes.put(key, node);
  	return node;
  }

  public Node getNode(int key){
  	if(this.nodes.containsKey(key)){
  		return this.nodes.get(key);
  	}else{
  		return null;
  	}
  }

  public void addEdge(int f, int t, int weight, boolean digraph){
  	if(!this.nodes.containsKey(f)){
  		addNode(f);
  	}
  	if (!this.nodes.containsKey(t)) {
  		addNode(t);
  	}
  	this.nodes.get(f).setAdj(this.nodes.get(t), weight);
  	if (!digraph) {
  		this.nodes.get(t).setAdj(this.nodes.get(f), weight);
  	}
  }

  public static void main(String arg[]){
  	//testing for digraph with 5 vertices
  	System.out.println("directed Graph");
  	GraphWN digraph = new GraphWN();
  	for(int i=1; i<=5; i++){
  		digraph.addNode(i);
  	}
  	digraph.addEdge(1, 4, 0, true);
  	digraph.addEdge(1, 2, 0, true);
  	digraph.addEdge(2, 3, 0, true);
  	digraph.addEdge(3, 5, 0, true);

  	for(Integer key : digraph.getNodes().keySet()){
  		for(Node ad_node : digraph.getNode(key).getAdj().keySet()){
  			System.out.println("("+key+", "+ad_node.getKey()+")");
  		}
  	}
  	System.out.print("\n");

  	//testing for undirected graph with 5 vertices
  	System.out.println("Undirected Graph");
  	GraphWN undigraph = new GraphWN();
  	for(int i=1; i<=5; i++){
  		undigraph.addNode(i);
  	}
  	undigraph.addEdge(1, 4, 0, false);
  	undigraph.addEdge(1, 2, 0, false);
  	undigraph.addEdge(2, 3, 0, false);
  	undigraph.addEdge(3, 5, 0, false);

  	for(Integer key : undigraph.getNodes().keySet()){
  		for(Node ad_node : undigraph.getNode(key).getAdj().keySet()){
  			System.out.println("("+key+", "+ad_node.getKey()+")");
  		}
  	}
  }

}

