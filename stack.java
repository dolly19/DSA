class Node{
    int data;
    Node next;
Node(int d){
    this.data =d;
    next=null;
}

}
class stack {
Node head;

public Node push(int data){
    Node node= new Node(data);
    node.next= head;
    head= node;
    return head;
}

public Node pop(){
    head =head.next;
    return head;
}

public boolean isEmpty(){
    return head == null;
}

public int peek(){
    return head.data;
}
public static void main (String[] args){
    stack in = new stack();
    Node head = in.push(2);
    head = in.push(3);
    head =in.push(4);
    head =in.pop();
    System.out.println(in.peek());
    

}


}