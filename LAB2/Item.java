
public class Item implements Comparable<Item> {
    String name;
    ItemCondition state;  //stan
    double mass;
    int quantity;

    public Item(String name, ItemCondition state, double mass, int quantity)
    {
        this.name = name;
        this.state = state;
        this.mass = mass;
        this.quantity = quantity;
    }

    public void print(){
        System.out.println("NAME: "+ name);
        System.out.println("MASS: "+ mass);
        System.out.println("QUANTITY: "+ quantity);
        System.out.println("**********************");
    }

    public int getQuantity(){
        return quantity;
    }

    @Override
    public int compareTo(Item object) {
        return name.compareTo(object.name);
    }
}
