public class Triangle extends Shape2D {
    private double base;
    private double height;

    public Triangle(double b, double h) {
        base = b;
        height = h;
    }

    @Override
    public double getArea() {
        double area = (base * height)/2;
        return area;
    }

    @Override
    public String getName() {
        String name = "triangle";
        return name;
    }
}
