
public class linearS {
    static int search(int A[],int n, int x){
		return linearSearch(A,0,n-1,x);
	}
	static int linearSearch(int A[], int low , int high, int value){
		if(low>high)
			return -1;
		else{
			if(A[high]==value)
				return high;
			else
				return linearSearch(A,0,high-1,value);
		}

	}

	 public static void main(String[] args) {
         int A []={2,3,4,5,6,7,9};
         int n=A.length;
         int result=search(A,n,7);
         System.out.println(result);
		 
	}

}