public class Practice {
    public static void main(String[] args) {
        int nums[]={32,1,25,11,2};
        int k=59;
        minimumSubarrayLength(nums,k);
    }
    public static int minimumSubarrayLength(int[] nums, int k) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            long num=0;
            for(int j=i;j<nums.length;j++)
            {
                num^=nums[j];
                System.out.println(num);
                if(num>=k)
                    min=Math.min(min,j-i+1);
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}

