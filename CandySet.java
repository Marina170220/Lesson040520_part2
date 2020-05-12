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
    int boxFilling;

    CandySet(String boxShape, int setSize) {
        this.boxShape = boxShape;
        this.setSize = setSize;
    }

    public int findAmountOfWrappedCandies() {
        amountOfWrappedCandies = setSize - (amountOfLollipops + amountOfChocolateBar);
        return amountOfWrappedCandies / (Main.candyAll.length - 2);
    }

    public void congratulation() {
        System.out.println("Happy Holiday!");
    }

    void fillCandySet(Candy value) {
        boolean typeWrappedCandy = value.getCandyType().equals("WrappedCandy");
        boolean checkAmountOfCandies = boxFilling < setSize;
        if (checkAmountOfCandies) {
            if (value.getCandyType().equals("ChocolateBar") && amountOfChocolateBar < 1) {
                candyDone[boxFilling] = value;
                boxFilling++;
                amountOfChocolateBar++;
            }
            if (value.getCandyType().equals("Lollipop") && amountOfLollipops < 2) {
                candyDone[boxFilling] = value;
                boxFilling++;
                amountOfLollipops++;
            }
            if (typeWrappedCandy) {
                switch (value.getFilling()) {
                    case "Alcohol":
                        if (amountOfCandiesWithAlcohol <= findAmountOfWrappedCandies()) {
                            candyDone[boxFilling] = value;
                            boxFilling++;
                            amountOfCandiesWithAlcohol++;
                        }
                        break;
                    case "Nuts":
                        if (amountOfCandiesWithNuts <= findAmountOfWrappedCandies()) {
                            candyDone[boxFilling] = value;
                            boxFilling++;
                            amountOfCandiesWithNuts++;
                        }
                        break;
                    case "Cream":
                        if (amountOfCandiesWithCream <= findAmountOfWrappedCandies()) {
                            candyDone[boxFilling] = value;
                            boxFilling++;
                            amountOfCandiesWithCream++;
                        }
                        break;
                }
            }
        }
    }

    public void showInfo() {
        System.out.println("Candy set contains " + boxFilling + " candies" +
                "\nincluding " + amountOfChocolateBar + " chocolate bar," +
                "\n" + amountOfLollipops + " lollipops," +
                "\n" + amountOfCandiesWithAlcohol + " wrapped candies with alcohol filling," +
                "\n" + amountOfCandiesWithNuts + " wrapped candies with nut filling," +
                "\n" + amountOfCandiesWithCream + " wrapped candies with cream filling,\n");
    }
}

class CandySetForMen extends CandySet {

    CandySetForMen(String boxShape, int setSize) {
        super(boxShape, setSize);
    }

    public void congratulation() {
        System.out.println("Congratulations on men's day!");
    }
}

class CandySetForWomen extends CandySet {

    CandySetForWomen(String boxShape, int setSize) {
        super(boxShape, setSize);
    }

    public void congratulation() {
        System.out.println("Congratulations on women's day!");
    }
}

class CandySetForChildren extends CandySet {

    CandySetForChildren(String boxShape, int setSize) {
        super(boxShape, setSize);
    }

    public int findAmountOfWrappedCandies() {
        amountOfWrappedCandies = setSize - amountOfChocolateBar;
        return amountOfWrappedCandies / (Main.candyAll.length - 2);
    }

    void fillCandySet(Candy value) {
        boolean checkCandiesWithAlcohol = !value.getFilling().equals("Alcohol");
        boolean typeWrappedCandy = value.getCandyType().equals("WrappedCandy");
        boolean checkAmountOfCandies = boxFilling < setSize;
        if (checkAmountOfCandies) {
            if (checkCandiesWithAlcohol) {
                if (value.getCandyType().equals("ChocolateBar") && amountOfChocolateBar < 1) {
                    candyDone[boxFilling] = value;
                    boxFilling++;
                    amountOfChocolateBar++;
                }
                if (value.getCandyType().equals("Lollipop") && amountOfLollipops <= findAmountOfWrappedCandies()) {
                    candyDone[boxFilling] = value;
                    boxFilling++;
                    amountOfLollipops++;
                }
                if (typeWrappedCandy) {
                    switch (value.getFilling()) {
                        case "Nuts":
                            if (amountOfCandiesWithNuts <= findAmountOfWrappedCandies()) {
                                candyDone[boxFilling] = value;
                                boxFilling++;
                                amountOfCandiesWithNuts++;
                            }
                            break;
                        case "Cream":
                            if (amountOfCandiesWithCream <= findAmountOfWrappedCandies()) {
                                candyDone[boxFilling] = value;
                                boxFilling++;
                                amountOfCandiesWithCream++;
                            }
                            break;
                    }
                }
            }
        }
    }

    public void congratulation() {
        System.out.println("Happy New Year!");
    }
}



