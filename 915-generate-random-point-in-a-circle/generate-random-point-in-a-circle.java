import java.util.Random;

class Solution {
    private double radius;
    private double x_center;
    private double y_center;
    private Random rand;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        this.rand = new Random();
    }
    
    public double[] randPoint() {

        double theta = 2 * Math.PI * rand.nextDouble();
        
        
        double r = radius * Math.sqrt(rand.nextDouble());
        

        double x = x_center + r * Math.cos(theta);
        double y = y_center + r * Math.sin(theta);
        
        return new double[]{x, y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */