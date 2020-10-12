public class Sphere extends Shape3D {
    private double radius;

    public Sphere(double r) {
        radius = r;
    }

    @Override
    public double getVolume() {
        double volume = (4.0/3.0) * Math.PI * (radius * radius * radius);
        return volume;
    }

    @Override
    public String getName() {
        String name = "sphere";
        return name;
    }

    @Override
    public double getArea() {
        double area = (4 * Math.PI) * (radius * radius);
        return area;
    }
}
