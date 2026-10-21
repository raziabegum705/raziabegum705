class Solution {
    public void sortColors(int[] nums) { //dutch national flag algorithm 
        int l=0;
        int r=nums.length-1;
        int mid=0;
        while(mid<=r){
            if(nums[mid]==0){  //swap mid and l
                int temp=nums[l];
                nums[l]=nums[mid];
                nums[mid]=temp;
                mid++;
                l++;
            }
            else if(nums[mid]==2){ //swap mid and r
                int temp=nums[r];
                nums[r]=nums[mid];
                nums[mid]=temp;
                r--;
            }
            else{ // if mid==1 then just mid++
                mid++;

            }
        }
        return ;
    }
}