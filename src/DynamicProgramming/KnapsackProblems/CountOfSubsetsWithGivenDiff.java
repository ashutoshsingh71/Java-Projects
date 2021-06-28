package DynamicProgramming.KnapsackProblems;

//We have an array Ar[] and a number D. We need to find the count of subsets which have the difference equal to given number
//Idea: lets have 2 subsets S1 & S2
//so,1 -> number(s1) - number(s2) = D
//& ,2 ->  number(s1) + number(s2) = number(Ar)
//  By solving eqn 1 & 2, we will have 2(number(s1)) = D + number(Ar)
// number(s1) = (D + number(Ar))/2
//So the above problem reduced to find number of subsets with given sum

public class CountOfSubsetsWithGivenDiff {
    public static int findCountOfSubset(int [] arr, int diff){
        int arraySum = 0;
        for(int i : arr){
            arraySum += i;
        }
        int numberOffirstSubsetElements = (diff + arraySum)/2;
        int count = CountOfSubsetWithGivenSum.findCountOfSubsets(arr,arr.length,numberOffirstSubsetElements);
        return count;
    }

    public static void main(String [] args){
        int [] arr = {3,4,1,5};
        System.out.println(findCountOfSubset(arr,1));
    }
}
