import java.util.ArrayList;
import java.util.Random;

public class Juicer {
    private int fruitDispenserCapacity = 30;
    private int currentFruitDispenserFullness = 0;
    private ArrayList<Fruit> fruits = new ArrayList<>();
    private double juiceAmount;

    private static Juicer instance = null;

    private Juicer() {
    }

    public int getFruitAdded() {
        return fruits.size();
    }

    public double getJuiceAmount() {
        return juiceAmount;
    }

    public static Juicer getInstace() {
        if (instance == null) {
            instance = new Juicer();
        }
        return instance;
    }

    public void fillDispenser(Fruit fruit) {
        if (currentFruitDispenserFullness >= fruitDispenserCapacity) {
            System.out.println("Sorry but fruit dispenser is full");
        } else if (currentFruitDispenserFullness < fruitDispenserCapacity){
            currentFruitDispenserFullness += fruit.getWeight();
            fruits.add(fruit);
            System.out.println(fruit.getWeight() + " kg of fruit is added. Currently there is " + currentFruitDispenserFullness + " kg of fruit in the dispenser");
        }
    }

    public void createJuice() {
        if (currentFruitDispenserFullness == 0) {
            System.out.println("Sorry but fruit dispenser is empty");
        } else {
            int index = new Random().nextInt(fruits.size());
            Fruit fruit = fruits.get(index);
            currentFruitDispenserFullness -= fruit.getWeight();
            juiceAmount += fruit.getWeight() * 0.40;
            System.out.println("Successfully made " + String.format("%.2f",fruit.getWeight() * 0.40) + " l of juice. Now you have total of " + String.format("%.2f", juiceAmount) + " l of juice and " + currentFruitDispenserFullness + " kg of fruit in the dispenser left");
            fruits.remove(index);
        }
    }

}
