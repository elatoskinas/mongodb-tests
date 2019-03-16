package abstractModel;

import java.util.ArrayList;
import java.util.List;

public class AbstractionImpl2 extends Abstraction {
    private float float1;
    private float float2;
    private List<Integer> intList1;

    public AbstractionImpl2(int number1, int number2, String string1, float float1, float float2) {
        super(number1, number2, string1);
        this.float1 = float1;
        this.float2 = float2;
        this.intList1 = new ArrayList<Integer>();
    }

    public float getFloat1() {
        return float1;
    }

    public void setFloat1(float float1) {
        this.float1 = float1;
    }

    public float getFloat2() {
        return float2;
    }

    public void setFloat2(float float2) {
        this.float2 = float2;
    }

    public List<Integer> getIntList1() {
        return intList1;
    }

    public void setIntList1(List<Integer> intList1) {
        this.intList1 = intList1;
    }
}
