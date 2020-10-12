public class Cube extends Shape3D {
    private double sideLength;

    public Cube(double side) {
        sideLength = side;
    }

    @Override
    public String getName() {
        String name = "cube";
        return name;
    }

    @Override
    public double getArea() {
        double surfaceArea = 6 * (sideLength * sideLength);
        return surfaceArea;
    }

    @Override
    public double getVolume() {
        double volume = sideLength * sideLength * sideLength;
        return volume;
    }
}
