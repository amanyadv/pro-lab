import java.util.LinkedList;

class GraphWL {
    int V;
    LinkedList<Integer> adjs []; 

    public GraphWL(int v){
        this.V = v;
        adjs = new LinkedList[v];
        for (int i=0; i<v; i++) {
            try{
                adjs[i] = new LinkedList<>();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public void addAdj(int v, int w){
       try{
            adjs[v].add(w);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public int getVertices(){
        return V;
    }

    public LinkedList<Integer> getAdj(int v){
        try{
            return adjs[v];
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public GraphWL createGraph(int v, int edges[][]){
        GraphWL graph = new GraphWL(v);
        for (int i=0; i<edges.length; i++) {
            //System.out.println("edge - ("+edges[i][0]+", "+edges[i][1]+")");
            try{
                graph.addAdj(edges[i][0], edges[i][1]);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

        return graph;
    }
}