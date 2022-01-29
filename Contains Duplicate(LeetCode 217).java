import java.util.Arrays;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int i=0, j=1;
        while(j < nums.length){
            if(nums[i] == nums[j]) return true;
            i++;
            j++;
        }
        return false;
        
    //     HashMap <Integer, Integer> map = new HashMap<>();
    //     for(int i = 0; i < nums.length; i++){
    //         // int n = nums[i];
    //         if(map.containsKey(nums[i]))  {
    //             return true;
    //         }
    //         map.put(nums[i], i);
    //     }
    // return false;
    }
}
