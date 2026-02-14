class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        // Create a 2D array to store champagne amount in each glass
        // We only need to simulate up to query_row + 1 rows
        double[][] tower = new double[query_row + 2][query_row + 2];
        
        // Pour champagne into the top glass
        tower[0][0] = poured;
        
        // Simulate the flow of champagne
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                // Calculate excess champagne in current glass
                double excess = (tower[i][j] - 1.0) / 2.0;
                
                // If there's excess, flow it to the glasses below
                if (excess > 0) {
                    tower[i + 1][j] += excess;
                    tower[i + 1][j + 1] += excess;
                }
            }
        }
        
        // Return the amount in the queried glass (capped at 1.0)
        return Math.min(1.0, tower[query_row][query_glass]);
    }
}
   