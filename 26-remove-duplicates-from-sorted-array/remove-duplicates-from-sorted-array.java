class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
      int i=0;
      for(int j=1;j<n;j++){
        //only < works not <= cuz nothing will change with <=
      if(nums[i]<nums[j]){
        int temp=nums[i+1];
        nums[i+1]=nums[j];
        nums[j]=temp;
      i++;
      }
      }
      
      
    return i+1;
}
}