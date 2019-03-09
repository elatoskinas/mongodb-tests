public abstract class Abstraction {
    private int number1;
    private int number2;
    private String string1;

    public Abstraction(int number1, int number2, String string1) {
        this.number1 = number1;
        this.number2 = number2;
        this.string1 = string1;
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }
}
