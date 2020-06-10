public class Quicksort {
private int[] A;
private int n;
public void sort (int[] values) {
this.A = values;
n = values.length;
quicksort (0, n - 1);
}
private void quicksort (int low, int high) {

int i = low+1, j = high;
int pivot = A[low];
while (i <= j) {

while (A[i] < pivot && i <= j)

i++;
while (A[j] > pivot)
j--;

// exchange if needed
// As we are done we can increase i and j

if (i < j) {

exchange (i, j);
i++;
j--;

}

}
exchange (low, j);
// Recursion
if (low < j - 1)

quicksort (low, j – 1);

if (j+1 < high)

quicksort (j+1, high);

}

private void exchange (int i, int j) {

int temp = A[i];
A[i] = A[j];
A[j] = temp;
}

}

