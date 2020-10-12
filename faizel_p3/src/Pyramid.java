public class Pyramid extends Shape3D {
    private double pyramidHeight;
    private double baseLength;
    private double baseWidth;

    public Pyramid(double length, double width, double height) {
        baseLength = length;
        baseWidth = width;
        pyramidHeight = height;
    }

    @Override
    public double getVolume() {
        double area = ((pyramidHeight * baseLength * baseWidth)/3);
        return area;
    }

    @Override
    public String getName() {
        String name = "pyramid";
        return name;
    }

    @Override
    public double getArea() {
        double part1 = baseLength * baseWidth;
        double part2 = Math.sqrt(((baseLength/2) * (baseLength/2)) + (pyramidHeight * pyramidHeight));
        double part3 = Math.sqrt(((baseWidth/2) * (baseWidth/2)) + (pyramidHeight * pyramidHeight));
        double area = part1 + (baseLength * part3) + (baseWidth * part2);
        return area;
    }
}
