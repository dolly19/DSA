
public class binaryS {
    static int search(int A[], int x , int n){
        return BinarySearch(A , x , 0, n-1);
    }
    static int BinarySearch(int A[], int x , int low, int high){
        if(low>high)
        return -1;
        else{
            int mid =(low+high)/2;
            if (A[mid]==x)
            return mid;
            else if (A[mid]> x)
                return BinarySearch(A, x, low, mid-1);
            else 
                return BinarySearch(A, x, mid+1, high);
        }
    }

public static void main (String [] args){
    int [] A={2,6,8,12,16,19};
    int n= A.length;
    int a =search(A, 12, n);
    System.out.print(a);
    


}

}