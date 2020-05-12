package kompjuterIya.lesson040520;

public class Main {

    static Candy[] candyAll = new Candy[5];

    public static void main(String[] args) {

        candyAll[0] = new Candy("ChocolateBar", "Chocolate");
        candyAll[1] = new Candy("Lollipop", "Gum");
        candyAll[2] = new Candy("WrappedCandy", "Alcohol");
        candyAll[3] = new Candy("WrappedCandy", "Nuts");
        candyAll[4] = new Candy("WrappedCandy", "Cream");


        CandySet setForMan = new CandySetForMen("Square", 25);
        setForMan.setCandyDone(new Candy[setForMan.setSize]);
        setForMan.congratulation();
        for (int j = 0; j < setForMan.setSize; j++) {
            for (int i = 0; i < candyAll.length; i++) {
                setForMan.fillCandySet(candyAll[i]);
            }
        }
        setForMan.showInfo();

        CandySet setForWoman = new CandySetForWomen("Heart", 25);
        setForWoman.setCandyDone(new Candy[setForWoman.setSize]);
        setForWoman.congratulation();
        for (int j = 0; j < setForWoman.setSize; j++) {
            for (int i = 0; i < candyAll.length; i++) {
                setForWoman.fillCandySet(candyAll[i]);
            }
        }
        setForWoman.showInfo();

        CandySet setForKid = new CandySetForChildren("House", 20);
        setForKid.setCandyDone(new Candy[setForKid.setSize]);
        setForKid.congratulation();
        for (int j = 0; j < setForKid.setSize; j++) {
            for (int i = 0; i < candyAll.length; i++) {
                setForKid.fillCandySet(candyAll[i]);
            }
        }
        setForKid.showInfo();
    }
}

