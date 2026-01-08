class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //Set<Integer> set = new TreeSet<>();
        //ArrayList<Integer> list = new ArrayList<>();

        int[] temp = new int[m+n];

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
        }
        
        //return list;
    }
}