//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    public class Pair implements Comparable<Pair>{
        int distance;
        int[] point ;
        Pair(int distance , int point[]){
            this.distance = distance;  
            this.point = point ;
        }
        public int compareTo(Pair other) {
            return this.distance - other.distance;  
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int n = points.length ;
        for(int i = 0 ; i< n; i++){
            int distance = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            pq.offer(new Pair(distance , points[i])); 
        }
        int[][] res = new int[k][2]; 
        int index = 0 ; 
        while(k > 0 && !pq.isEmpty()){
            res[index++] = pq.poll().point ; 
            k--;
       }
       return res ; 
    }
}

//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] points = new int[n][2];
            for (int i = 0; i < n; i++) {
                points[i][0] = scanner.nextInt();
                points[i][1] = scanner.nextInt();
            }
            Solution solution = new Solution();
            int[][] ans = solution.kClosest(points, k);

            Arrays.sort(ans, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            });
            for (int[] point : ans) {
                System.out.println(point[0] + " " + point[1]);
            }
            System.out.println("~");
        }

        scanner.close();
    }
}
// } Driver Code Ends