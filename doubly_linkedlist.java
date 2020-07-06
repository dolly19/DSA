class Node{
    int data;
    Node next;
    Node prev;
    Node (int d){
        this.data = d;
        next = prev =null;

    }
}
class d{
    Node head;
    public Node insertAtfront (int data){
        Node node = new Node(data);
        if (head == null)
            head = node;
        else{
            node.next = head;
            head.prev = node;
            head = node;
            }
        return head;
        }
    public Node insertAfterNode (Node pointer , int data){
        Node node = new Node(data); 
        node.next = pointer.next;
        node.prev =pointer;
        pointer.next = node;
        if(node.next!=null)
            node.next.prev = node;
        return head;
    } 
    public Node insertBeforeNode (Node pointer, int data){
        Node node = new Node (data);
        if (pointer == head)
            return insertAtfront(data);
	    else{
            node.next = pointer;
            node.prev = pointer.prev;
            pointer.prev =node;
            if(node.prev!=null)
                node.prev.next = node;
            return head;
	    }
    }
    public Node insert(int data){
        Node node = new Node(data);
        if (head== null)
            head = node;
        else{
            Node n= head;
            while(n.next!=null){
                n=n.next;
                
            }
            n.next = node;
            node.prev= n;

        }
        return head;
    }
    public Node deleteNode (Node del){
        if(head == del)
            head=head.next;
        if(del.prev != null)
            del.prev.next = del.next;
        if(del.next!= null)
            del.next.prev = del.prev;
	    del= null;
        return head;
    }
    public Node delete (int index){
        Node n= head;
        for(int i=0; i<index; i++){
            n=n.next;
        }
        return deleteNode(n);

    }
    public void reverse (){
        Node n=  head;
        Node prev = null;
        Node next =null;
        while(n!= null){
            prev = n.prev;
            next = n.next;
            n.prev = n.next;
            n.next = prev;
            n=next;
        }
        if(prev!=null)
            head = prev.prev;

    
    }
    public void print(){
        Node n= head;
        while(n!=null){
            System.out.print("  "+n.data);
            n=n.next;
        }
    }
    public static void main(String []args){
        d in = new d();
        Node head=in.insert(4);
        head=in.insertAtfront(3);
        head=in.insertAfterNode(head,7);
        head =in.insertBeforeNode(head, 1);
        head = in.delete(0);
        in.print();
        in.reverse();
        System.out.println();
        in.print();


    }
    }

