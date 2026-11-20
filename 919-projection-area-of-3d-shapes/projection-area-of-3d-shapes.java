class Solution {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        
        int xy = 0; 
        int yz = 0; 
        int zx = 0; 

        for (int i = 0; i < n; i++) {
            int rowMax = 0;
            int colMax = 0;

            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    xy++;
                }
                rowMax = Math.max(rowMax, grid[i][j]);
                colMax = Math.max(colMax, grid[j][i]);
            }

            yz += rowMax;
            zx += colMax;
        }

        return xy + yz + zx;
    }
}