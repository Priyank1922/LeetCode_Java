class Solution {
    public String[] createGrid(int m, int n) {
        List<String>grid = new ArrayList<>();
        for(int i = 0 ; i < m ; i++){
            StringBuilder row = new StringBuilder();
            for(int j = 0 ; j < n ; j++){
                if(i==0 || j == n-1)row.append('.');
                else row.append('#');
            }
            grid.add(row.toString());
        }
        return grid.toArray(new String[0]);
    }
}