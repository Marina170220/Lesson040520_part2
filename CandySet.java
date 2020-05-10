package kompjuterIya.lesson040520;

//Задание
//У нас есть заказ от кондитерской фабрики - сформировать подарочные наборы конфет нескольких типов
// - мужской (на 23 февраля), женский (на 8 марта), детский (на новый год)

//Задачи:
//1. Описать иерархию (структуру) всех данных на листочке или на компьютере
// (как удобнее, главное чтобы всё было перед глазами).
//2. Перенести всё с листа в IDE, создать объекты для проверки

//3. От заказчика имеются дополнительные требования
//a) Каждый набор должен содержать не более одной плитки шоколада
//b) Количество конфет не должно превышать 25 штук для мужских и женских наборов, 20 штук для детских
//c) Не более двух чупа-чупсов для мужского и женского наборов
//d) Ни одной конфеты с коньяком для детского набора


public abstract class CandySet {
    public Candy[] getCandyDone() {
        return candyDone;
    }

    public void setCandyDone(Candy[] candyDone) {
        this.candyDone = candyDone;
    }

    Candy[] candyDone;
    String boxShape;

    int setSize;
    int amountOfChocolateBar;
    int amountOfLollipops;
    int amountOfWrappedCandies;
    int amountOfCandiesWithAlcohol;
    int amountOfCandiesWithNuts;
    int amountOfCandiesWithCream;


    CandySet(String boxShape, int setSize, int amountOfChocolateBar, int amountOfLollipops) {
        this.boxShape = boxShape;
        this.setSize = setSize;
        this.amountOfChocolateBar = amountOfChocolateBar;
        this.amountOfLollipops = amountOfLollipops;
    }

    protected CandySet() {
    }

    public int findAmountOfWrappedCandies() {
        amountOfWrappedCandies = setSize - (amountOfLollipops + amountOfChocolateBar);
        int amountOfEachSortOfWrappedCandies = amountOfWrappedCandies / (candyDone.length - 2);
        return amountOfEachSortOfWrappedCandies;
    }

    public void congratulation() {
        System.out.println("Happy Holiday!");
    }

    void fillCandySet(Candy value) {
        int boxFilling = 0;
        amountOfCandiesWithAlcohol = 0;
        amountOfCandiesWithNuts = 0;
        amountOfCandiesWithCream = 0;
        if (value.getCandyType().equals("ChocolateBar") && amountOfChocolateBar != 0) {
            candyDone[boxFilling] = value;
            boxFilling++;
            amountOfChocolateBar--;
        }
        if (value.getCandyType().equals("Lollipop") && amountOfLollipops != 0) {
            candyDone[boxFilling] = value;
            boxFilling++;
            amountOfLollipops--;
        }
        if (value.getCandyType().equals("WrappedCandy") && value.getFilling().equals("Alcohol") && amountOfWrappedCandies != 0 && amountOfCandiesWithAlcohol <= findAmountOfWrappedCandies()) {
            candyDone[boxFilling] = value;
            boxFilling++;
            amountOfCandiesWithAlcohol++;
            amountOfWrappedCandies--;
        }
        if (value.getCandyType().equals("WrappedCandy") && value.getFilling().equals("Nuts") && amountOfWrappedCandies != 0 && amountOfCandiesWithNuts <= findAmountOfWrappedCandies()) {
            candyDone[boxFilling] = value;
            boxFilling++;
            amountOfCandiesWithNuts++;
            amountOfWrappedCandies--;
        }
        if (value.getCandyType().equals("WrappedCandy") && value.getFilling().equals("Cream") && amountOfWrappedCandies != 0 && amountOfCandiesWithCream <= findAmountOfWrappedCandies()) {
            candyDone[boxFilling] = value;
            boxFilling++;
            amountOfCandiesWithCream++;
            amountOfWrappedCandies--;
        }
        System.out.println("Add a " + value.getCandyType() + " in a set");
    }
}

class CandySetForMen extends CandySet {

    CandySetForMen(String boxShape, int setSize, int amountOfChocolateBar, int amountOfLollipops) {
        super(boxShape, setSize, amountOfChocolateBar, amountOfLollipops);
    }

    public void congratulation() {
        System.out.println("Congratulations on men's day!");
    }
}

class CandySetForWomen extends CandySet {

    CandySetForWomen(String boxShape, int setSize, int amountOfChocolateBar, int amountOfLollipops) {
        super(boxShape, setSize, amountOfChocolateBar, amountOfLollipops);
    }

    public void congratulation() {
        System.out.println("Congratulations on women's day!");
    }
}

class CandySetForChildren extends CandySet {

    CandySetForChildren(String boxShape, int setSize, int amountOfChocolateBar, int amountOfCandiesWithAlcohol) {
        this.boxShape = boxShape;
        this.setSize = setSize;
        this.amountOfChocolateBar = amountOfChocolateBar;
        this.amountOfCandiesWithAlcohol = amountOfCandiesWithAlcohol;
    }

    public int findAmountOfWrappedCandies() {
        amountOfWrappedCandies = setSize - (amountOfChocolateBar + amountOfCandiesWithAlcohol);
        int amountOfEachSortOfWrappedCandies = amountOfWrappedCandies / (candyDone.length - 2);
        return amountOfEachSortOfWrappedCandies;
    }

    void fillCandySet(Candy value) {
        int boxFilling = 0;
        amountOfCandiesWithNuts = 0;
        amountOfCandiesWithCream = 0;
        amountOfLollipops = 0;
        if (!value.getFilling().equals("Alcohol")) {
            if (value.getCandyType().equals("ChocolateBar") && amountOfChocolateBar != 0) {
                candyDone[boxFilling] = value;
                boxFilling++;
                amountOfChocolateBar--;
            }
            if (value.getCandyType().equals("Lollipop") && amountOfLollipops <= findAmountOfWrappedCandies()) {
                candyDone[boxFilling] = value;
                boxFilling++;
                amountOfLollipops++;
                amountOfWrappedCandies--;
            }

            if (value.getCandyType().equals("WrappedCandy") && value.getFilling().equals("Nuts") && amountOfWrappedCandies != 0 && amountOfCandiesWithNuts <= findAmountOfWrappedCandies()) {
                candyDone[boxFilling] = value;
                boxFilling++;
                amountOfCandiesWithNuts++;
                amountOfWrappedCandies--;
            }
            if (value.getCandyType().equals("WrappedCandy") && value.getFilling().equals("Cream") && amountOfWrappedCandies != 0 && amountOfCandiesWithCream <= findAmountOfWrappedCandies()) {
                candyDone[boxFilling] = value;
                boxFilling++;
                amountOfCandiesWithCream++;
                amountOfWrappedCandies--;
            }
            System.out.println("Add a " + value.getCandyType() + " in a set");
        }
    }

    public void congratulation() {
        System.out.println("Happy New Year!");
    }
}



