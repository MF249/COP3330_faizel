public class Circle extends Shape2D {
    private double radius;

    public Circle(double r) {
        radius = r;
    }

    @Override
    public double getArea() {
        double area = radius * radius;
        area = Math.PI * area;
        return area;
    }

    @Override
    public String getName() {
        String name = "circle";
        return name;
    }
}
