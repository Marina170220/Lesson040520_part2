package kompjuterIya.lesson040520;

public class Candy {
    public String getCandyType() {
        return candyType;
    }

    public void setCandyType(String candyType) {
        this.candyType = candyType;
    }

    String candyType;

    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    String filling;

    Candy(String candyType, String filling) {
        this.candyType = candyType;
        this.filling = filling;
    }
}
