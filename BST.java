class Node {
    int data;
    Node left, right;
    Node (int key){
        data = key;
        left =right=null;

    }}
class BST{
    Node root;
     BST(){
         root=null;
     }
    public Node insert(Node root , int value){
        if(root == null)
          root = new Node(value);
        else{
            if(value<root.data)
             root.left = insert(root.left , value);
             else
             root.right =insert(root.right , value );

        }
        return root;
    }
     public int min(Node root){
         if(root.left == null)
           return root.data;
        else
          return min(root.left);
     }
     public int max(Node root){
         if(root.right == null)
          return root.data;
        else
         return max(root.right);

     }
     public boolean search(Node root , int value){
         Node current = root;
         while(current!= null){
            if(current.data == value)
            return true;
            else if(current.data> value)
            return search(current.left , value);
            else
            return search(current.right , value);
         }
         return false;
     }
     public Node search_ref (Node root , int value){
         Node current = root;
         while (current!=null){
             if(current.data == value)
             return current;
             else if(current.data>value)
             return search_ref(current.left, value);
             else
             return search_ref(current.right, value);

         }
         return null;
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
     public Node delete(Node root , int value){
        if(root==null)
            return null;
        if (root.data>value)
        root.left=delete(root.left, value);
        else if(root.data<value)
        root.right=delete(root.right, value);
        else{
            // two chils
            if(root.left!=null && root.right!=null){
                Node temp= root;
                int  minright = min(temp.right);
                root.data= minright;
                delete(root.right, minright);

            }
            //one child
            else if(root.left!=null)
                root=root.left;
            else if(root.right!=null)
                root=root.right;
            else
            // no child
                root=null;

        }
        return root;
     }


     public static void main(String [] args){
        Node root = null;
        BST tree =new BST();
        root =tree.insert(root , 50);
        // root=tree.insert(root, 30);
        //root=tree.insert(root, 20);
        root=tree.insert(root, 40);
        root=tree.insert(root, 70);
        root=tree.insert(root, 60);
        root=tree.insert(root, 80);
        // System.out.println("Inorder");
        // tree.printInorder(root);
        // int min =tree.min(root);
        // System.out.println("\nmin :"+ min);
        // int max =tree.max(root);
        // System.out.println("max :"+ max);
        // boolean check = tree.search(root, 26);
        // System.out.print( check);
        root =tree.delete(root,50 );
        System.out.println("Inorder");
        tree.printInorder(root);
     }



}
