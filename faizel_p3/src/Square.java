public class Square extends Shape2D{
    private double sideLength;

    public Square(double side) {
        sideLength = side;
    }

    @Override
    public double getArea() {
        double area = sideLength * sideLength;
        return area;
    }

    @Override
    public String getName() {
        String name = "square";
        return name;
    }
}
