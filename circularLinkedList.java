class Node{
    int data;
    Node next;
    Node(int d){
        this.data =d;
        next=null;
    }
}
class circular{
    Node head;

    public Node insert(int data){
        Node node =new Node(data);
        if(head == null){
            head =node;
            node.next=head;}
        else{
            Node n=head;
            while(n.next!= head){
                n =n.next;
            }
            n.next =node;
            node.next = head;

        }
        return head;
    }
    public Node insertAtfront(int data){
        Node node =new Node(data);
        if(head == null){
            head =node;
            node.next=head;}
        else{
            Node n=head;
            while(n.next!= head){
                n =n.next;
            }
            n.next =node;
            node.next =head;
        }
        head = node;
        return head;
    }
    public Node insertAtIndex (int data , int index){
        Node node =new Node(data);
        if(index == 0){
            return insertAtfront(data);

        }
        else{
            Node n=head;
            for(int i=0; i<index-1; i++){
                n=n.next;
            }
            node.next = n.next;
            n.next =node;
            return head;
        }
    
        
    }
    public Node delete(int key){
        Node curr =head;
        Node prev  = null;
        while(curr.data != key){
            if(curr.next == head)
                break;
            prev = curr;
            curr = curr.next;

        }
        //single node
        if(curr.next==head){
            head=null;
            }
        //first node
        else if (curr == head){
            Node n= head;
            while(n.next != head){
                n=n.next;
            }
            head =head.next;
            n.next = head;
        }
        //last node
        else if(curr.next ==  head){
            prev.next = head;
        }
        else{
            prev.next = curr.next;
        }
        return head;

    }
    public void print (){
        Node n=head;
        while(n.next != head){
            System.out.print(" "+ n.data);
            n=n.next;
        }
        System.out.print(" "+n.data);
    }
    public static void main (String [] args){
        circular in =new circular();
        Node head = in.insert(1);
        head =in.insertAtfront(2);
        head = in.insert(3);
        head =in.insert(4);
        head=in.insertAtIndex(5, 3);
        head = in.delete(1);
        in.print();
    }
    


}