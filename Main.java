package kompjuterIya.lesson040520;

public class Main {
    public static void main(String[] args) {

        Candy[] candyAll = new Candy[5];
        candyAll[0] = new Candy("ChocolateBar", "Chocolate");
        candyAll[1] = new Candy("Lollipop", "Gum");
        candyAll[2] = new Candy("WrappedCandy", "Alcohol");
        candyAll[3] = new Candy("WrappedCandy", "Nuts");
        candyAll[4] = new Candy("WrappedCandy", "Cream");


        CandySet setForMan = new CandySetForMen("Square", 25, 1, 2);
        setForMan.setCandyDone(new Candy[setForMan.setSize]);
        setForMan.congratulation();
        setForMan.fillCandySet(candyAll[0]);

        CandySet setForWoman = new CandySetForWomen("Heart", 25, 1, 2);
        setForWoman.setCandyDone(new Candy[setForWoman.setSize]);
        setForWoman.congratulation();
        setForWoman.fillCandySet(candyAll[1]);

        CandySet setForKid = new CandySetForChildren("House", 20, 1, 0);
        setForKid.setCandyDone(new Candy[setForKid.setSize]);
        setForKid.congratulation();
        setForKid.fillCandySet(candyAll[3]);
    }
}

