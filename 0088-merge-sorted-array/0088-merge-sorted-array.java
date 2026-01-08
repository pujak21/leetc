class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m-1;
        int j = m+n-1;
        int k = n-1;

        while(i>=0 && k>=0){
            if(nums1[i] > nums2[k]){
                nums1[j] = nums1[i];
                i--;
            }
            else{
                nums1[j] = nums2[k];
                k--;
            }
            j--;
        }

        // if nums2 still has elements but 1st array elements have been traversed

        while(k>=0){
            nums1[j] = nums2[k];
            k--;
            j--;
        }







        //another brute froce

        /*int k = 0;
        for(int i = m; i<= m+n-1; i++){
            nums1[i] = nums2[k];
            k++;
        }
        Arrays.sort(nums1);*/

        //brute force method

        /*int[] temp = new int[m+n];

        int k = 0;
        for(int i = 0; i<m; i++){
            temp[k] = nums1[i];
            k++;
        }
        for(int i = 0; i<n; i++){
            temp[k] = nums2[i];
            k++;
        }
        Arrays.sort(temp);
        for(int i = 0; i< m+n; i++){
            nums1[i] = temp[i];
        }*/
        
        
    }
}