public class BodyMassIndex {
    // class elements
    private double userHeight;
    private double userWeight;
    public double bmi;
    public String category;

    // public method to calculate bmi using formula
    public double calcBmi(double height, double weight) {
        double bmi = ((703 * weight)/(height * height));
        return bmi;
    }

    // public method that returns Category string using else if
    public String assignCategory(double bmi) {
        String temp;

        if (bmi < 18.5){
            temp = "Underweight";
        }
        else if(bmi < 25) {
            temp = "Normal Weight";
        }
        else if(bmi < 30) {
            temp = "Overweight";
        }
        else{
            temp = "Obesity";
        }
        return temp;
    }

    public BodyMassIndex(double height, double weight) {
        userHeight = height;
        userWeight = weight;
        bmi = calcBmi(height, weight);
        category = assignCategory(bmi);
    }

}
