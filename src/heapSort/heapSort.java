package heapSort;

import java.util.*;
import java.io.*;

//힙정렬은 적은 메모리를 사용해서 정렬해야 할 때 사용함

public class heapSort {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int Num = Integer.parseInt(bf.readLine());
		
		int[] arr = new int[Num];
		
		for(int i = 0; i < Num; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		HeapSort(arr);
		
		for(int i : arr) {
		    bw.write(i + " ");
		}
		bw.flush();
		bw.close();
	}
	
	public static void HeapSort(int[] arr) {
		
		int n = arr.length;
		
		for(int i = n/2 - 1; i >= 0; i--) {
			heap(arr, n, i);
		}
		
		for(int i = n - 1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			heap(arr, i, 0);
		}
	}
	
	public static void heap(int[] arr, int n, int i) {
		int largest = i;
		int left = i * 2 + 1;
		int right = i * 2 + 2;
		
		if(left < n && arr[left] > arr[largest]) {
			largest = left;
		}
		
		if(right < n && arr[right] > arr[largest]) {
			largest = right;
		}
		
		if(largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			
			heap(arr, n, largest);
		}
	}

}
