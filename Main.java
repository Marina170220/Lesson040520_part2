package kompjuterIya.lesson040520;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner;
    static List<Candy> candyAll=new ArrayList<>();

    public static void main(String[] args) {
        {
            try {
                scanner = new Scanner(new File("src\\Candy.txt"));
                while (scanner.hasNext()) {
                    candyAll.add(new Candy(scanner.next(), scanner.next()));
                }
                scanner.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        CandySet setForMan = new CandySetForMen("Square", 25);
        setForMan.setCandyDone(new Candy[setForMan.setSize]);
        setForMan.congratulation();
        for (int j = 0; j < setForMan.setSize; j++) {
            for (int i = 0; i < candyAll.size(); i++) {
                setForMan.fillCandySet(candyAll.get(i));
            }
        }
        setForMan.showInfo();

        CandySet setForWoman = new CandySetForWomen("Heart", 25);
        setForWoman.setCandyDone(new Candy[setForWoman.setSize]);
        setForWoman.congratulation();
        for (int j = 0; j < setForWoman.setSize; j++) {
            for (int i = 0; i < candyAll.size(); i++) {
                setForWoman.fillCandySet(candyAll.get(i));
            }
        }
        setForWoman.showInfo();

        CandySet setForKid = new CandySetForChildren("House", 20);
        setForKid.setCandyDone(new Candy[setForKid.setSize]);
        setForKid.congratulation();
        for (int j = 0; j < setForKid.setSize; j++) {
            for (int i = 0; i < candyAll.size(); i++) {
                setForKid.fillCandySet(candyAll.get(i));
            }
        }
        setForKid.showInfo();
    }
}

