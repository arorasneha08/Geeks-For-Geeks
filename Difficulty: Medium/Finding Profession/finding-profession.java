class Solution {
    public String profession(int level, int pos) {
        // code here
        int x = pos - 1;

        int cnt = 0;
        while (x > 0) {
            cnt += (x & 1);
            x >>= 1;
        }

        return (cnt % 2 == 0) ? "Engineer" : "Doctor";
    }
}