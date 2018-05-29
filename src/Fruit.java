public abstract class Fruit {
    private String name;
    private double weight;
    private boolean rotten;

    public Fruit(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isRotten(){
        return rotten;
    }

    public void setRotten(boolean isRotten) {
        rotten = isRotten;
    }

}
