class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Brute force
        // for(int i = 0; i<nums.length; i++){
        //     for(int j = i+1; j<nums.length; j++){
        //         if((nums[i] + nums[j]) == target){
        //             return new int[] {i, j};
        //         }
        //     }
        // }
        // return null;
        
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            Integer requiredNum = (Integer) (target - nums[i]);
            if(indexMap.containsKey(requiredNum)){
                int[] arr =  {indexMap.get(requiredNum), i};
                return arr;
            }
            indexMap.put(nums[i], i);
        }
        return null;
    }
    
}
