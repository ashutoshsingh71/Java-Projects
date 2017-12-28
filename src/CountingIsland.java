
public class CountingIsland {
	static int row = 5;
	static int col = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M[][]=  new int[][] {{1, 1, 0, 0, 0},
            {1, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 1, 0},
            {1, 0, 0, 0, 1}
           };
           System.out.println("Number of islands is: "+ countIslands(M));
	}
	public static int countIslands(int [][] matrix){
		int count = 0;
		boolean visited[][] = new boolean[row][col];
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(matrix[i][j] == 1 && !visited[i][j]){
					dfs(matrix,i,j,visited);
					++count;
				}
			}
		}
		return count;
	}
	public static void dfs(int [][] matrix,int r,int c,boolean [][] visited){
		int [] rowNum = {-1,-1,-1,0,0,1,1,1};
		int [] colNum = {-1,0,1,-1,1,-1,0,1};
		visited[r][c] = true;
		for(int i=0;i<8;i++){
			if(isSafe(matrix,r + rowNum[i],c + colNum[i],visited)){
				dfs(matrix,r + rowNum[i],c + colNum[i],visited);
			}
		}
	}
	public static boolean isSafe(int [][] matrix,int r,int c,boolean [][] visited){
		return ((r >= 0) && (r < row) &&
				(c >= 0) && (c < col) &&
				(matrix[r][c] == 1) && 
				!visited[r][c]);
	} 
}
