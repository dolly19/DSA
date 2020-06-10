class Node{
    int data;
    Node next;
    Node (int d){
        data=d;
        next=null;
    }
}
public class Sl{
    Node head;
    public Node  insert(int data){
        Node node= new Node(data);
        if(head == null)
            head=node;
        else{
            Node n=head;
            while(n.next!=null){
                n=n.next;
            }
        n.next= node;
        }
        return head;
     }
    public Node insertAtStart(int data){
        Node node= new Node(data);
        node.next= head;
        head= node;
        return head;
    }
    public Node insertAtEnd(int data){
            Node node= new Node(data);
            Node n = head;
            while(n.next!=null){
                n=n.next;
    
            }
            n.next=node;
            return head;
        }
    public Node atIndex(int index, int data){
            Node node= new Node(data);
            if(index==0){
                insertAtStart(data);
            }
            else{
                Node n = head;
                for(int i=0; i<index-1; i++){
                    n=n.next;
                }
                node.next=n.next;
                n.next=node;
                
    
            }
            return head;
        }
    
    public Node delete(int index){
            if(index==0){
                head=head.next;
            }
            else{
            Node n= head;
            for(int i=0; i<index-1; i++){
                n=n.next;
            }
            Node n1= n.next;
            n.next=n1.next;
        }
        return head;
    }
    public Node reverse(){
            Node prev=null;
            Node current= head;
            Node next =null;
            while(current!=null){
                next=current.next;
                current.next=prev;
                prev=current;
                current= next;
             }
            head=prev;
            return head;
    }
    public void show(){
                Node n= head;
                while(n.next!= null){
                System.out.print(n.data+" ");
                n=n.next;
                }
                System.out.println(n.data);
            }
    
    
    public static void main(String[] args){
        Sl ob= new Sl();
        ob.insert(2);
        ob.insert(3);
        ob.insertAtStart(9);
        ob.insertAtEnd(1);
        ob.atIndex(2,5);
        ob.reverse();
        ob.show();
                
        
    }
    
}