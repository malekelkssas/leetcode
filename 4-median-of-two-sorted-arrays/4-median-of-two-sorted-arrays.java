import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int [] arr = new int [nums1.length+nums2.length];
    	mergeArrays(nums1, nums2,nums1.length ,nums2.length , arr);
    	if(arr.length%2!=0)
    		return arr[arr.length/2];
    	else
    		return (arr[arr.length/2]+arr[(arr.length/2)-1])/(double)2;
    }
 
	  public static void mergeArrays(int[] arr1, int[] arr2, int n1,
              int n2, int[] arr3)
{
int i = 0, j = 0, k = 0;


while (i<n1 && j <n2)
{

if (arr1[i] < arr2[j])
arr3[k++] = arr1[i++];
else
arr3[k++] = arr2[j++];
}


while (i < n1)
arr3[k++] = arr1[i++];


while (j < n2)
arr3[k++] = arr2[j++];
}
//    public static void main (String [] args)
//    {
//    	Solution m = new Solution();
//    	System.out.println(m.findMedianSortedArrays(new int []{},new int [] {4}));
//    }
}