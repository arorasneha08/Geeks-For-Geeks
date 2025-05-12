//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // Number of rooms
            int m = sc.nextInt(); // Number of meetings
            int[][] meetings = new int[m][2];
            for (int i = 0; i < m; i++) {
                meetings[i][0] = sc.nextInt(); // Start time
                meetings[i][1] = sc.nextInt(); // End time
            }
            Solution ob = new Solution();
            System.out.println(ob.mostBooked(n, meetings));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends

// User function Template for Java
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        int[] countMeetings = new int[n];
        long[] availTime = new long[n];

        for (int[] meet : meetings) {
            int start = meet[0];
            int end = meet[1];
            boolean found = false;

            long minTime = Long.MAX_VALUE;
            int minTimeRoom = -1;

            for (int i = 0; i < n; i++) {
                if (availTime[i] <= start) {
                    found = true;
                    countMeetings[i]++;
                    availTime[i] = end;
                    break;
                }
                if (minTime > availTime[i]) {
                    minTime = availTime[i];
                    minTimeRoom = i;
                }
            }

            if (!found) {
                availTime[minTimeRoom] += (end - start);
                countMeetings[minTimeRoom]++;
            }
        }

        int maxMeetings = 0;
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            if (countMeetings[i] > maxMeetings) {
                maxMeetings = countMeetings[i];
                maxCount = i;
            }
        }
        return maxCount;
    }
}


//{ Driver Code Starts.
// } Driver Code Ends