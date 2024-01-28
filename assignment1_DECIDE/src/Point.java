package src;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){ 
        return x;
    }

    public double getY(){
        return y;
    }

    public void setX(double x){ 
        this.x = x;
    }

    public void getY(double y){
        this.y = y;
    }

    public double length(){
        return Math.sqrt(x*x + y*y);
    }

    public double magnitude(){
        return length();
    }

    public double lengthSquared(){
        return x*x + y*y;
    }

    public double magnitudeSquared(){
        return lengthSquared();
    }

    public Point add(Point b){
        return new Point(x + b.x, y + b.y);
    }

    public Point subtract(Point b){
        return new Point(x - b.x, y - b.y);
    }

    public Point scalarMultiplication(double b){
        return new Point(x*b, y*b);
    }

    public double dotProduct(Point b){
        return x * b.x + y * b.y;
    }

    public double crossProduct(Point b){
        return x * b.y + y * b.x;
    }

    public double angle(Point b){
        return Math.atan2(crossProduct(b), dotProduct(b));
    }
}
