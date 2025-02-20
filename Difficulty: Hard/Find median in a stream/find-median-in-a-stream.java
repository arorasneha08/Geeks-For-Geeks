//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            ArrayList<Double> ans = ob.getMedian(nums);
            for (double i : ans) {
                System.out.printf("%.1f ", i);
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        ArrayList<Double> res = new ArrayList<>(); 
        PriorityQueue<Double> minHeap = new PriorityQueue<>();
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(double num : arr){
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll()); 
            if(minHeap.size() > maxHeap.size()){
                maxHeap.offer(minHeap.poll()); 
            }
            if(maxHeap.size() > minHeap.size())  res.add(maxHeap.peek());
            else res.add((minHeap.peek() + maxHeap.peek()) / 2.0) ; 
        }
        return res; 
    }
}