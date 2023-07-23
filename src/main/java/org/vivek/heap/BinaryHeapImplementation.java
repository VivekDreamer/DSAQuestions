package org.vivek.heap;

public class BinaryHeapImplementation {
    static class MinHeap{
        int[] arr;
        int size;
        int capacity;
        public MinHeap(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            this.arr = new int[capacity];
        }
        int left(int i) { return (2*i + 1); }

        int right(int i) { return (2*i + 2); }

        int parent(int i) { return (i-1)/2; }

        public void insert(int x){
            if(size == capacity) return;
            size++;
            arr[size-1] = x;
            for(int i = size-1 ; i != 0 && arr[parent(i)] > arr[i];){
                int temp = arr[i];
                arr[i] = arr[parent(i)];
                arr[parent(i)] = temp;
                i = parent(i);
            }
        }

        //given the binary heap with one possible violation, fix the heap
        public void minHeapify(int i){
            int leftChildIdx = left(i);
            int rightChildIdx = right(i);
            int smallestIdx = i;
            if(leftChildIdx < size && arr[leftChildIdx] < arr[smallestIdx]) smallestIdx = leftChildIdx;
            if(rightChildIdx < size && arr[rightChildIdx] < arr[smallestIdx]) smallestIdx = rightChildIdx;
            if(smallestIdx != i){
                //swap smallest idx value with the ith index value 
                int temp = arr[i];
                arr[i] = arr[smallestIdx];
                arr[smallestIdx] = temp;
                minHeapify(smallestIdx);
            }
        }

        //we have to remove the minimum element from the priorty queue
        public int extractMin(){
            if(size <= 0) return Integer.MAX_VALUE;
            if(size == 1){
                size--;
                return arr[0];
            }
            int temp = arr[0];
            arr[0] = arr[size-1];
            arr[size-1] = temp;
            size--;
            minHeapify(0);
            return arr[size];
        }

        //we have binary heap, we have to update the particuular index with the new value and then, you have to correct the heap after updating the value
        public void decreaseKey(int i, int x){
            arr[i] = x;
            while(i != 0 && arr[parent(i)] > arr[i]){
                int temp = arr[i];
                arr[i] = arr[parent(i)];
                arr[parent(i)] = temp;
                i = parent(i);
            }
        }

        //we have to delete the value at particular index in binary heap and after deleting, heap must follows the property of minheap.
        public void deleteKey(int i){
            decreaseKey(i, Integer.MIN_VALUE);
            extractMin();
        }

        //given a random array, rearrange it's element to form a min heap
        //it's time complexity is O(n )
        public void buildHeap(){
            for(int i = (size-2)/2; i >= 0; i--){
                minHeapify(i);
            }
        }

    }
        public static void main(String[] args) {
            MinHeap heap = new MinHeap(11);
            heap.insert(3);
            heap.insert(2);
            heap.insert(15);
            heap.insert(20);
            System.out.println(heap.extractMin());
            heap.decreaseKey(2, 1);
            System.out.println(heap.extractMin());
        }
    
}
