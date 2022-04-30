class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int len1 = nums1.length, len2 = nums2.length;
        int[] res = new int[len1+len2];
        
        int a1=0,a2=0;
        for(int i=0;i<res.length;i++){
            if((a2>=len2) || (a1<len1 && a2<len2 && nums1[a1]<nums2[a2])){
                res[i] = nums1[a1++];
            } else if((a1>=len1) || (a1<len1 && a2<len2 && nums1[a1]>=nums2[a2])){
                res[i] = nums2[a2++];
            }
        }
        
        if((len1+len2)%2==0){
            return (res[((len1+len2)/2)]+res[((len1+len2)/2)-1])/2.0;
        } else {
            return res[(len1+len2)/2];
        }
        
    }
}