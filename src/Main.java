import java.util.Random;

public class Main {

    private static Random rand = null;

    public static void main(String[] args) {
        //instantiate singleton
        Juicer juicer = Juicer.getInstace();
        if(rand == null) {
            rand = new Random();
        }

        //adding fruit and making juice 100 times
        for (int i = 0; i < 100; i++) {
            try {
                Fruit fruit = new Apple("Apple", getRandomNumberInRange(1, 3));
                if (getRandomNumberInRange(1, 5) == 1){
                    fruit.setRotten(true);
                }
                if (rand.nextInt(100) < 70){
                    if (!fruit.isRotten()) {
                        juicer.fillDispenser(fruit);
                    } else {
                        System.out.println("Apple is rotten. Thrown away");
                    }
                }
                if (rand.nextInt(100) < 30){
                    juicer.createJuice();
                }
            } catch (Exception e) {
                System.out.println(e.toString());
                System.out.println("Exception while making juice...");
            }
        }

        //prints amount of juice at the end
        System.out.println("At the end you made " + juicer.getJuiceAmount() + " l of juice");
    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        if(rand == null) {
            rand = new Random();
        }
        return rand.nextInt((max - min) + 1) + min;
    }
}