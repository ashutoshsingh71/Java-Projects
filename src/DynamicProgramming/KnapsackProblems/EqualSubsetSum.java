package DynamicProgramming.KnapsackProblems;

public class EqualSubsetSum {
    public static boolean findSubsetEqualSum(int[] arr,int size,int sum){
        int total = 0;
        for(int i = 0;i<size;i++){
            total += arr[i];
        }
        if(total % 2 != 0){
            return false;
        }
        return SubsetSumProblem.findSubsetSumThroughRecursion(arr,size,sum/2);
    }
    public static void main(String [] args){
        int [] ar = {1,2,3,4,5,9};
        int total = 12;
        System.out.println(findSubsetEqualSum(ar,6,total));
    }
}
