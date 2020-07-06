class Node{
    int dest;
    int weight;
    Node next;

}
class AdjList{
    Node head;
    public AdjList(){
        this.head=null;
    }
}
class Graph{
    int V;
    AdjList [] array; 

    public void addEdge(Graph graph,int src,int dest,int weight){


        Node newNode = adjNode(dest,weight); 
        newNode.next=graph.array[src].head;
        graph.array[src].head = newNode; 
      
        newNode = adjNode(src,weight); 
        newNode.next = graph.array[dest].head; 
        graph.array[dest].head = newNode; 
    }

    public static Node  adjNode (int dest, int weight){
        Node node = new Node();
        node.dest =dest;
        node.weight = weight;
        node.next = null;
        return node;
    }
public static void printArr(int[] dist, int n)
{
	if(dist[n-1] == Integer.MAX_VALUE)
		System.out.println("-1");
	else
		System.out.println(dist[n-1]);
}
public  void dijkstra(Graph graph, int src)
{
	int V = graph.V; 
	int[] dist = new int[V];
	
	MinHeap minHeap = createMinHeap(V);

  
	for (int v = 0; v < V; ++v)
	{
		dist[v] = Integer.MAX_VALUE;
		minHeap.array[v] = newMinHeapNode(v, dist[v]);
		minHeap.pos[v] = v;
	}


	minHeap.array[src] = newMinHeapNode(src, dist[src]);
	minHeap.pos[src] = src;
	dist[src] = 0;
	decreaseKey(minHeap, src, dist[src]);

	
	minHeap.size = V;

	
	while (!isEmpty(minHeap))
	{
		
		MinHeapNode minHeapNode = extractMin(minHeap);
		int u = minHeapNode.v; 

		
		Node pCrawl = graph.array[u].head;
		while (pCrawl != null)
		{
			int v = pCrawl.dest;

			
			if (isInMinHeap(minHeap, v) && dist[u] != Integer.MAX_VALUE && pCrawl.weight + dist[u] < dist[v])
			{
				dist[v] = dist[u] + pCrawl.weight;

				
				decreaseKey(minHeap, v, dist[v]);
			}
			pCrawl = pCrawl.next;
		}
	}

	printArr(dist, V);
}
public static MinHeapNode newMinHeapNode (int v, int dist){
    MinHeapNode minHeapNode = new MinHeapNode();
    minHeapNode.v=v;
    minHeapNode.dist = dist;
    return minHeapNode;
}
public static MinHeap createMinHeap(int capacity){
    MinHeap minHeap = new MinHeap();
    minHeap.size =0;
    minHeap.pos = new int [capacity];
    minHeap.capacity = capacity;
    minHeap.array =new MinHeapNode[capacity];
    return minHeap;

}

public static  void  swapMinHeapNode (MinHeapNode a , MinHeapNode b){
        MinHeapNode t= a;
        a=b;
        b=t;
    }

private void minHeapify(MinHeap minHeap, int idx){
    int smallest;
    int left;
    int right;
    smallest =idx;
    left= 2 * idx + 1;
    right = 2 * idx + 2;
    if (left < minHeap.size && minHeap.array[left].dist < minHeap.array[smallest].dist)
    {
      smallest = left;
    }

    if (right < minHeap.size && minHeap.array[right].dist < minHeap.array[smallest].dist)
    {
      smallest = right;
    }

    if (smallest != idx){
        MinHeapNode smallestNode = minHeap.array[smallest];
        MinHeapNode idxNode = minHeap.array[idx];
        minHeap.pos[smallestNode.v] = idx;
        minHeap.pos[idxNode.v] = smallest;
        // swapMinHeapNode(minHeap.array[smallest], minHeap.array[idx]);
        MinHeapNode t= minHeap.array[smallest];
        minHeap.array[smallest]=minHeap.array[idx];
        minHeap.array[idx]=t;

        minHeapify(minHeap, smallest);
    }
}
private boolean isEmpty(MinHeap minHeap)
{
    return minHeap.size == 0;
}
private MinHeapNode extractMin(MinHeap minHeap)
{
    if (isEmpty(minHeap) != false)
    {
        return null;
    }

    MinHeapNode root = minHeap.array[0];

    
    MinHeapNode lastNode = minHeap.array[minHeap.size - 1];
    minHeap.array[0] = lastNode;

    
    minHeap.pos[root.v] = minHeap.size-1;
    minHeap.pos[lastNode.v] = 0;

    
    --minHeap.size;
    minHeapify(minHeap, 0);

    return root;
}
private void decreaseKey(MinHeap minHeap, int v, int dist)
{
     
    int i = minHeap.pos[v];

    minHeap.array[i].dist = dist;

    
    while (i != 0 && minHeap.array[i].dist < minHeap.array[(i - 1) / 2].dist)
    {
        
        minHeap.pos[minHeap.array[i].v] = (i - 1) / 2;
        minHeap.pos[minHeap.array[(i - 1) / 2].v] = i;
        // swapMinHeapNode(minHeap.array[i], minHeap.array[(i - 1) / 2]);

        MinHeapNode t= minHeap.array[i];
        minHeap.array[i]=minHeap.array[(i - 1) / 2];
        minHeap.array[(i - 1) / 2]=t;

        
        i = (i - 1) / 2;
    }
}
private boolean isInMinHeap(MinHeap minHeap, int v)
{
   if (minHeap.pos[v] < minHeap.size)
   {
     return true;
   }
   return false;
}
}
class MinHeapNode{
    int v;
    int dist;
}
class MinHeap{
    int size;
    int capacity;
    int [] pos;
    MinHeapNode [] array;
    
}

class B1 {

    public static void main(String args[])throws IOException
    {
        readers.init(System.in);
		int V = readers.nextInt();
		int M = readers.nextInt();
		
		Graph graph = createGraph(V);
		for(int i=0; i<M; i++){
			int u = readers.nextInt();
			int v=readers.nextInt();
			int w = readers.nextInt();
        	graph.addEdge(graph, u-1, v-1, w);
			
		}
		for (int j=0; j<V;  j++){
			int k=readers.nextInt();
		}
		graph.dijkstra(graph, 0);
		
    }

 
    public static Graph createGraph(int V){
        Graph graph = new Graph();
        graph.V =V;
        graph.array =new AdjList[V];
        for (int i=0; i<V; ++i){
            graph.array[i] = new AdjList();
            graph.array[i].head = null;

        }
        return graph;
    }
    
}