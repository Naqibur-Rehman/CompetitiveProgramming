class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        
        while(low <= high){
            int n = numbers[high] + numbers[low];
            if( n == target) {
                return new int[] {low+1, high+1};
            } else if( n < target) {
                low++;
            } else {
                high--;
            }
        }
        
        return null;
    }
}
