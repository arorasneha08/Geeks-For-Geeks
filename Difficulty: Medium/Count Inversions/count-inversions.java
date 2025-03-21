//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    static int merge(int arr[] , int low , int mid , int high){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        int count = 0 ; 
        
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]); 
                left ++ ; 
            }
            else {
                temp.add(arr[right]); 
                count += (mid - left +1 ); 
                right ++ ; 
            }
        }
        while(left <= mid){
            temp.add(arr[left]);
            left ++ ; 
        }
        while(right <= high){
            temp.add(arr[right]); 
            right ++ ; 
        }
        for(int i = 0 ;i < temp.size() ; i++){
            arr[low+i] = temp.get(i) ; 
        }
        return count ; 
    }
    static int mergeSort(int arr[] , int low , int high){
        int count = 0 ; 
        if(low >= high) return count; 
        int mid = (low + high)/2 ; 
        
        count += mergeSort(arr , low , mid);
        count += mergeSort(arr , mid+1 , high);
        count += merge(arr , low , mid , high); 
        
        return count ; 
    }
    static int inversionCount(int arr[]) {
        int n = arr.length ; 
        return mergeSort(arr , 0 , n-1); 
    }
}