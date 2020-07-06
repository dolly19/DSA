class Node {
	int data;
	Node next;
	Node(int x){
		data =x;
	}
}
class queue{
	Node front;
	Node rear;
	queue(){
		front = null;
		rear = null;
	}
	public boolean isEmpty()
    {
        return(front==null);
    }
	public void enqueue(int x)
    {
        Node node=new Node(x);
        node.next=null;
        if(isEmpty())
            front=node;
        else
            rear.next=node;
        rear=node;
	}
	public int dequeue()
    {
        int t=front.data;
        if(front.next==null)
            rear=null;
        front=front.next;
        return t;
	}
	public int peek()
    {
        return(front.data);
	}

}

