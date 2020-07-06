import java.util.*;
class Node{
     int data;
    Node right , left;
    public Node(int key){
        data = key;
        right=left=null;

    }
}
class index{
     int index;
}
class binaryTree{
    public  Node root;
    static int index=0;
    
    public binaryTree(){
        root=null;
    }
    public void printPreorder(Node root){
        if(root != null){
        
            System.out.print(root.data + " ");
            printPreorder(root.left);
            printPreorder(root.right);
         }
         
     }
    public void printInorder(Node root){
        if(root!=null){
           printInorder(root.left);
           System.out.print(root.data+ " ");
           printInorder(root.right);
        }
    }
    public void printPostorder(Node root){
        if(root!=null)
        {
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(root.data + " ");
        }
        
    }
   
    public int count(Node root){
        if(root == null)
            return 0;
        else
            return 1+ count(root.left)+ count(root.right);
    }
    public int height(Node root){
        if(root==null)
            return 0;
        else{
            return 1+Math.max( height(root.left) ,height(root.right));
        }
    }
    public Node Copy (Node root){
        Node copy = new Node(root.data);
        copy.left= Copy(root.left);
        copy.right=Copy(root.right);
        return copy;
    }
    public int search(int arr[], int strt, int end, int value){
        int i;
        for( i=strt; i<=end; i++){
            if (arr[i]==value)
                break;
        }
        return i;

    }
    public Node build(int in[],int post[],int n){
        index pIndex = new index();
        pIndex.index=n-1;
        return buildtree1(in, post, 0, n-1, pIndex);

    }
    public Node buildtree(int in[],int pre[],int strt, int end){
       
        if(strt>end)
            return null;
        Node tnode =new Node(pre[index++]);
        if(strt==end)
            return tnode;
        int inindex= search(in, strt, end, tnode.data);
        tnode.left=buildtree(in, pre, strt, inindex-1);
        tnode.right=buildtree(in, pre, inindex+1, end);
        return tnode;

    }
    public Node buildtree1(int in[],int post[],int strt,int end ,index pIndex){
        if(strt>end)
            return null;
        Node tnode=new Node(post[pIndex.index--]);
        if(strt==end)
            return tnode;
        int inindex=search(in,strt,end,tnode.data );
        tnode.right=buildtree1(in, post, inindex+1, end , pIndex);
        tnode.left=buildtree1(in, post, strt, inindex-1 , pIndex);
        return tnode;

    }
    




    public static void main(String [] args){
        Node root;
        binaryTree tree1 = new binaryTree();
        // root=tree1.root= new Node(1);
        // tree1.root.left =new Node(2);
        // tree1.root.right= new Node(3);
        // tree1.root.left.left =new Node(4);
        // tree1.root.left.right=new Node(5);
        // System.out.println("preorder");
        // tree1.printPreorder();
        // System.out.println("\ninorder");
        // tree1.printInorder();
        // System.out.println("\nPostorder");
        // tree1.printPostorder();
        
        //int a = tree1.height(root);
        //System.out.print(a);
        int[] in ={4, 2, 5 ,1 ,3,};
        int[] post={4, 5,2 ,3 ,1};
        int len=in.length;
        root = tree1.build(in ,post ,len);
        System.out.println("Preorder");
        tree1.printPreorder(root);

        






    }
}