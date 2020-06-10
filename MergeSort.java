package dolly;
public class sorting{

 static void sort(int A[],int n){
   mergesort( A, 0, n-1);
 }
 static void mergesort(int A[],int low , int high){
   if(low>high)
   return ;
   if(high>low){
     int mid= (high+low)/2;
     mergesort(A,low, mid);
     mergesort(A,mid+1, high);
     merging(A,low, mid , high);
   }
 }


 static void merging(int A[], int low, int mid, int high){
      int [] aux=new int[A.length];
     for (int i=low; i<=high; i++){
       aux[i]= A[i];
     }
     int i =low;
     int j= mid+1;
     int k= low;
     while(i<= mid && j<=high){
       if(aux[i]<=aux[j]){
        A[k]= aux[i];
        i++;
      }
        else{
        A[k]= aux[j];
        j++;}
        k++;
     }
     while(i<=mid){
      A[k]=aux[i];
      k++;
      i++;}
    while(j<=high){
      A[k]=aux[j];
      k++;
      j++;
    }



   }
   static void show(int A[]){
   for(int i:A){
     System.out.print(i+" ");
   }
 }




public static void main (String args[]){

  int A[]= {16, 9, 12, 48, 30, 11, 65, 22};

  int n = A.length;
  sort(A,n);
  show(A);

}
}
