class maxHeap {
    public int capacity;
    public int [] mH;
    public int currentSize;
    public maxHeap(int capacity){
        this.capacity=capacity;
        mH = new int [capacity+1];
       currentSize =0;
    }
    public void createHeap(int [] arrA){
        if(arrA.length>0){
            for(int i=0;i<arrA.length;i++){
                insert(arrA[i]);
            }
        }
    }
    public void display(){
        for(int i=1;i<mH.length;i++){
            System.out.print(" " + mH[i]);
        }
        System.out.println("");
    }
    public void insert(int x) {
        if(currentSize==capacity){
            System.out.println("heap is full");
            return;
        }
        currentSize++;
        int idx = currentSize;
        mH[idx] = x;
        bubbleUp(idx);
    }

    public void bubbleUp(int pos) {
        int parentIdx = pos/2;
        int currentIdx = pos;
        while (parentIdx > 0 && mH[parentIdx] < mH[currentIdx]) {

            swap(currentIdx,parentIdx);
            currentIdx = parentIdx;
            parentIdx = parentIdx/2;
        }
    }

    public int extractMax() {
        int max = mH[1];
        if (currentSize == 0)
            return -1;
        mH[1] = mH[currentSize];
        mH[currentSize] = -1;
        sinkDown(1);
        currentSize--;
        return max;
    }

    public void sinkDown(int k) {
        int smallest = k;
        int leftChildIdx = 2 * k;
        int rightChildIdx = 2 * k+1;
        if (leftChildIdx < heapSize() && mH[smallest] < mH[leftChildIdx]) {
            smallest = leftChildIdx;
        }
        if (rightChildIdx < heapSize() && mH[smallest] < mH[rightChildIdx]) {
            smallest = rightChildIdx;
        }
        if (smallest != k) {

            swap(k, smallest);
            sinkDown(smallest);
        }
    }
    
    public void swap(int a, int b) {
        int temp = mH[a];
        mH[a] = mH[b];
        mH[b] = temp;
    }
    public boolean isEmpty() {
        return currentSize == 0;
    }

    public int heapSize(){
        return currentSize;
    }

    public int getMax(){
        return mH[1];
    }
}
class MaxHeap{
public static void main (String[] args){
    maxHeap maxHeap = new maxHeap(10);
        maxHeap.insert(5); 
        maxHeap.insert(3); 
        maxHeap.insert(17); 
        maxHeap.insert(10); 
        maxHeap.insert(84); 
        maxHeap.insert(19); 
        maxHeap.insert(6); 
        maxHeap.insert(22); 
        maxHeap.insert(9); 
        int a= maxHeap.getMax();
        maxHeap.display();
        System.out.println(a);


}
}