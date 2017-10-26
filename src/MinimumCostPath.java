import java.util.*;
public class MinimumCostPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] costMatrix = {{1,2,3,4},{4,8,2,4},{1,5,3,32}};
		int [][] totalCost = new int[3][3];
		totalCost[0][0] = costMatrix[0][0];
		for(int i = 1;i <= 2;i++){
			totalCost[i][0] = totalCost[i-1][0] + costMatrix[i][0];
		}
		for(int j = 1;j <= 2;j++){
			totalCost[0][j] = totalCost[0][j-1] + costMatrix[0][j];
		}
		for(int i = 1;i<=2;i++){
			for(int j = 1;j<=2;j++){
				totalCost[i][j] = min(totalCost[i-1][j-1],totalCost[i][j-1],totalCost[i-1][j]) + costMatrix[i][j];
			}
		}
		System.out.println("Result is: " + totalCost[1][2]);
	}
	public static int min(int a,int b,int c){
		if(a < b){
			return c < a ? c : a;
		}else
			return b < c ? b : c;
	}

}
