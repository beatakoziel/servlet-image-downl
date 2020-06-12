package servlet;

public class UserData {
    private double height;
    private double weight;
    private int bmi;

    public UserData() {
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public int getBmi() {
        return bmi;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setBmi(int bmi) {
        this.bmi = bmi;
    }
}
