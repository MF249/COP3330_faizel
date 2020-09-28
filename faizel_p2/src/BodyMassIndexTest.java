import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {

    @Test
    public void testCalcBmi(){
        BodyMassIndex b = new BodyMassIndex(71, 150);

        NumberFormat formatter = new DecimalFormat("#0.0");
        double bmi = b.calcBmi(71, 150);
        String convertedBmi = formatter.format(bmi);
        assertEquals(convertedBmi,"20.9");
    }

    @Test
    public void testAssignCategory(){
        BodyMassIndex b = new BodyMassIndex(71, 150);

        double bmi = b.bmi;
        String category = b.assignCategory(bmi);
        assertEquals(category, "Normal Weight");
    }

    @Test
    public void testUnderweightCategory(){
        BodyMassIndex b = new BodyMassIndex(75, 115);

        double bmi = b.bmi;
        String category = b.assignCategory(bmi);
        assertEquals(category, "Underweight");
    }

    @Test
    public void testNormalWeightCategory(){
        BodyMassIndex b = new BodyMassIndex(68, 150);

        double bmi = b.bmi;
        String category = b.assignCategory(bmi);
        assertEquals(category, "Normal Weight");
    }

    @Test
    public void testOverweightCategory(){
        BodyMassIndex b = new BodyMassIndex(65, 170);

        double bmi = b.bmi;
        String category = b.assignCategory(bmi);
        assertEquals(category, "Overweight");
    }

    @Test
    public void testObesityCategory(){
        BodyMassIndex b = new BodyMassIndex(50, 200);

        double bmi = b.bmi;
        String category = b.assignCategory(bmi);
        assertEquals(category, "Obesity");
    }
}
