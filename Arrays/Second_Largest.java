class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
         int lar = Integer.MIN_VALUE;
        int secLarg = Integer.MIN_VALUE;
        
        for(int ele : arr){
            if(ele>lar){
                secLarg=lar;
                lar=ele;
            }
            else if(ele<lar && ele>secLarg){
                secLarg = ele;
                
            }
            
        }
        if(secLarg==Integer.MIN_VALUE){
            return -1;
        }
        return secLarg;
    }
}