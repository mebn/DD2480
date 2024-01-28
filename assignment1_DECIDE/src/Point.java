package src;

/**
 * Class to represent a point using cartesian coordinates.
 * Holds two doubles, one for the x-axis, and one for the y-axis.
 * Implements some fairly typical functionality you would like to have with a 2D vector / point class
 */
public class Point {
    private double x;
    private double y;

    /**
     * Constructor for the Point class.
     * @param x the value for the x coordinate
     * @param y the value for the y coordinate
     */
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * Getter for the x coordinate
     * @return the x cooridnate of the point
     */
    public double getX(){ 
        return x;
    }

    /**
     * Getter for the y coordinate
     * @return the y cooridnate of the point
     */
    public double getY(){
        return y;
    }

    /**
     * Setter for the x coordinate
     * @param x the value that the x coordinate should be set to.
     */
    public void setX(double x){ 
        this.x = x;
    }

    /**
     * Setter for the x coordinate
     * @param y the value that the y coordinate should be set to.
     */
    public void getY(double y){
        this.y = y;
    }

    /**
     * Gets the length of the vector. 
     * Equivalent to magnitude.
     * @return The distance between the origin and the point
     */
    public double length(){
        return Math.sqrt(x*x + y*y);
    }

    /**
     * Gets the magnitude of the vector.
     * Equivalent to length
     * @return the magnitude of the vector
     */
    public double magnitude(){
        return length();
    }

    /**
     * Gets the length of the vector squared.
     * Equivalent to magnitudeSquared
     * @return the length of the vector squared
     */
    public double lengthSquared(){
        return x*x + y*y;
    }

    /**
     * Gets the magnitude of the vector squared.
     * Equivalent to lengthSquared
     * @return the magnitude of the vector squared
     */
    public double magnitudeSquared(){
        return lengthSquared();
    }

    /**
     * Performs vector addition between this point and one other point
     * @param b The point to be added to this point.
     * @return The resulting point from adding b to this point.
     */
    public Point add(Point b){
        return new Point(x + b.x, y + b.y);
    }

    /**
     * Performs vector subtraction between this point and one other point
     * @param b The point to be subtracted from this point.
     * @return The resulting point from subtracting b from this point.
     */
    public Point subtract(Point b){
        return new Point(x - b.x, y - b.y);
    }

    /**
     * Performs scalar multiplication between this point and a scalar.
     * @param b the scalar to be multiplied with.
     * @return A new point, that is equal to this point scaled by b.
     */
    public Point scalarMultiplication(double b){
        return new Point(x*b, y*b);
    }

    /**
     * Calculates the dot product of this point and one other point
     * @param b The point to be calculating the dot product from.
     * @return The resulting dot product.
     */
    public double dotProduct(Point b){
        return x * b.x + y * b.y;
    }

    /**
     * Calculates the cross product of this point and one other point.
     * The cross product for two 2D vectors X and Y is defined as x1 * y2 + x2 * y1
     * @param b The point to be calculating the cross product from.
     * @return The resulting cross product.
     */
    public double crossProduct(Point b){
        return x * b.y + y * b.x;
    }

    /**
     * Calculates the distance between this point and one other point.
     * @param b The point to calculate the distance from.
     * @return The distance betwwen this point and point b
     */
    public double distance(Point b){
        return subtract(b).magnitude();
    }

    /**
     * Calculates the squared distance between this point and one other point.
     * @param b The point to calculate the distance from.
     * @return The squared distance betwwen this point and point b
     */
    public double distanceSquared(Point b){
        return subtract(b).magnitudeSquared();
    }

    /**
     * Calculates the angle between two vectors.
     * The angle will be positive if it is the clockwise angle between this point and b,
     * and negative if it is the counter-clockwise angle between this point and b.
     * @param b The other vector to calculate the angle between.
     * @return the angle between this point and b.
     */
    public double angle(Point b){
        return Math.atan2(crossProduct(b), dotProduct(b));
    }
}
