class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>(); 
        int n = arr.length ; 
        int cnt1 = 0 ;
        int cnt2 = 0 ; 
        int elem1 = 0 ;
        int elem2 = 0 ; 
        for(int i = 0 ; i < n ; i++){
            if(cnt1 == 0 && elem2 != arr[i]){
                elem1 = arr[i];
                cnt1 = 1 ;
            }
            else if(cnt2 == 0 && elem1 != arr[i]){
                elem2 = arr[i] ;
                cnt2 = 1;
            }
            else if(arr[i] == elem1){
                cnt1 ++; 
            }
            else if(arr[i] == elem2){
                cnt2 ++; 
            }
            else{
                cnt1 -- ;
                cnt2 -- ; 
            }
        }
        int min = (n/3);
        cnt1 = 0 ; 
        cnt2 = 0 ; 
        for(int i = 0 ; i < n ; i++){
            if(arr[i] == elem1) cnt1 ++; 
            if(arr[i] == elem2) cnt2 ++; 
        }
        if(cnt1 > min){
            res.add(elem1) ; 
        }
        if(cnt2 > min){
            res.add(elem2); 
        }
        Collections.sort(res); 
        return res; 
    }
}