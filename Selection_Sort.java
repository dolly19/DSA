public class SelectionSort {

    static void sort(int A[], int low , int high){
        if(low>high)
            return ;
        else{
            int max =low;
            for(int i=low+1; i<=high; i++){
                if(A[i]>A[max])
                    max=i;
            }
            int temp = A[high];
            A[high] = A[max];
            A[max]= temp;
            sort(A, low, high-1);
        }
    }

    public static void main(String[] args){
        int A[]={ 4, 5 ,8 ,1 , 0};
        int n= A.length;
        sort(A,0,n-1);
        for(int i: A)
            System.out.println(i);
    }



}