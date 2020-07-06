import java.util.*;

class Node { 
    int key, height; 
    Node left, right; 
  
    Node(int d) { 
        key = d; 
        height = 1; 
        right=null;
        left=null;
    } 
} 

class AVL { 
    Node root;
    AVL(){
        root=null;
    }
    static int parent(Node node, int key, int par) {  
        if (node == null) 
            return -1; 
  
        if (key < node.key) 
            return parent(node.left, key, node.key);
        
        else if (key > node.key) 
            return parent(node.right, key, node.key);

        else
            return par; 
    }  
    int height(Node N) { 
        if (N == null) 
            return 0; 
  
        return N.height; 
    } 
    


    int max(int a, int b) { 
        if(a>=b)
            return a;
        else
            return b;
      
    } 
    Node rightRotate(Node y ) { 
       
        Node x = y.left; 
        Node T2 = x.right; 
  
        count_right=count_right+1;
        x.right = y; 
        y.left = T2;
    
        y.height = max(height(y.left), height(y.right)) + 1; 
        x.height = max(height(x.left), height(x.right)) + 1; 
  
        return x; 
    } 
  
    int getBalance(Node N) { 
        if (N != null) 
            return height(N.left) - height(N.right); 
        return 0; 
    } 
    Node leftRotate(Node x) { 
        Node y = x.right; 
        Node T2 = y.left; 
  
        y.left = x; 
        count_left=count_left+1;
        x.right = T2; 

        x.height = max(height(x.left), height(x.right)) + 1; 
        y.height = max(height(y.left), height(y.right)) + 1; 
  
        return y; 
    } 
  
  
     public Node insert(Node node, int key) { 
  
        if (node == null) 
            return (new Node(key)); 
        
        if (key > node.key) 
        node.right = insert(node.right, key); 
        else if (key < node.key) 
            node.left = insert(node.left, key); 
        else 
            return node; 
  
        
            node.height = 1 + max(height(node.left), 
            height(node.right)); 

            int balance = getBalance(node); 

            if (balance > 1 && key < node.left.key) 
            return rightRotate(node); 

            if (balance < -1 && key > node.right.key) 
            return leftRotate(node); 

            if (balance > 1 && key > node.left.key) { 
            node.left = leftRotate(node.left); 
            return rightRotate(node); 
            } 

            if (balance < -1 && key < node.right.key) { 
            node.right = rightRotate(node.right); 
            return leftRotate(node); 
            } 

            return node; 
            } 

    static void printInorder(Node root){
        if(root==null)
        return ;
           printInorder(root.left);
           System.out.print(root.key+ " ");
           printInorder(root.right);
    }

    public static int count_left=0;
    public static int count_right=0;
   

    public static void main (String[] args){

        Node root = null;
        avl tree =new avl();
        Scanner in = new Scanner(System.in);
        int quer = in.nextInt();
        in.nextLine();
        for(int i=0; i<quer; i++){
            String que = in.nextLine();
            String [] arr = que.split(" ");
            if (arr[0].equals("ADD"))
            root= tree.insert(root,  Integer.parseInt(arr[1]));
            else if(arr[0].equals("PARENT")){
               int par = parent(root , Integer.parseInt(arr[1]) , 0);
               System.out.println(par);
            }
        
            //tree.parent(root, Integer.parseInt(arr[1]), 0);
            else if (arr[1].equals("L"))
            //    tree.leftRotate(root);
               System.out.println(count_left);
            else if (arr[1].equals("R"))
            System.out.println(count_right);
            
        }
            

           
                

                 




        }
    }


    

