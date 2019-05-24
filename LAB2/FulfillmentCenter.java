import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class FulfillmentCenter implements Comparator<String>{
    String name;
    double maxMass;
    List<Item> listOfProducts = new ArrayList<Item>(); //mozemy wtedy korzystac z add, remove, size, get

    public FulfillmentCenter ( String name, double maxMass)
    { this.name = name;
    this.maxMass=maxMass;
    }

    @Override
    public int compare(String name, String name2) {
        return (name.compareTo(name2));

    }

    public double mass() {
        double mass = 0;
        for (int i = 0; i < listOfProducts.size(); i++)
            mass = mass + listOfProducts.get(i).mass;
        return mass;
    }


    public void addProduct(Item item) {
        int found = 0;
        if (mass() + item.quantity * item.mass <= maxMass) {
            for (Item i : listOfProducts) {
                if (i.compareTo(item) == 0) {
                    i.quantity = i.quantity + item.quantity;
                    System.out.println("ITEM ADDED. NEW QUANTITY: " + i.quantity);
                    found = 1;
                }
            }
            if (found == 0) {
                listOfProducts.add(item);
                System.out.println("NEW ITEM ADDED. QUANTITY: " + item.quantity);
            }
        } else
            System.err.println("MORE THAN MAX MASS");

    }

    public void getProduct(Item item) {
        int found = 0;
        if (listOfProducts.size() == 0)
            System.out.println("THERE IS NOTHING IN STOREHOUSE");
        else {
            for (Item i : listOfProducts) {
                if (i.compareTo(item) == 0) {
                    if (i.quantity == 1) {
                        listOfProducts.remove(i);
                        System.out.println("I REMOVED EVERYTHING, QUANTITY = 0");
                        found = 1;
                        break;
                    } else {
                        i.quantity--;
                        System.out.println("REMOVED 1 ITEM. new QUANTITY: " + i.quantity);
                        found = 1;
                        break;
                    }
                }
            }
            if (found == 0) System.out.println("THERE IS NOTHING LIKE THAT IN STOREHOUSE");
        }
    }


    public void removeProduct(Item item) {
        int found = 0;
        if (listOfProducts.size() == 0)
            System.out.println("THERE IS NOTHING IN STOREHOUSE");
        else {
            for (Item i : listOfProducts) {
                if (i.compareTo(item) == 0) {
                    listOfProducts.remove(i);
                    System.out.println("ONLY 1 IN STOREHOUSE. I REMOVED EVERYTHING. QUANTITY = 0");
                    found = 1;
                    break;
                }
            }
            if (found == 0) System.out.println("THERE IS NOTHING LIKE THAT IN STOREHOUSE");
        }
    }


    public void search(String name) {
        int found = 0;
        if (listOfProducts.size() == 0)
            System.out.println("THERE IS NOTHING IN STOREHOUSE");

        else {
            for (Item i : listOfProducts) {
                if (compare(name, i.name) == 0) {
                    System.out.println("*************************");
                    i.print();
                    found = 1;
                    break;
                }
            }
            if (found == 0) System.out.println("COUDN'T FIND ANYTHING");


        }
    }



    public void searchPartial(String name) {
        int found = 0;
        if (listOfProducts.size() == 0)
            System.out.println("THERE IS NOTHING IN STOREHOUSE");

        else {
            for (Item i : listOfProducts) {
                if (compare(name, i.name) <= 0) {
                    System.out.println("*************************");
                    i.print();
                    found = 1;
                    break;
                }
            }
            if (found == 0) System.out.println("COUDN'T FIND ANYTHING");


        }
    }

    public int countByCondition(ItemCondition itemCondition) {
        int sum = 0;
        if (listOfProducts.size() == 0)
            System.out.println("THERE IS NOTHING IN STOREHOUSE");

        else {
            for (Item i : listOfProducts) {
                if (itemCondition == i.state)
                    sum = sum + i.quantity;
            }
        }
        return sum;
    }

    public void summary() {
        for (Item i : listOfProducts)
            i.print();
    }


    /*public static Comparator<Item> COMPARE_BY_NAME = new Comparator<Item>() {
        public int compare(Item one, Item other) {
            return one.name.compareTo(other.name);
        }
    };*/


    public void sortByName(){
        List<Item> productsSortList=new ArrayList<>();
        for (Item i: listOfProducts)
            productsSortList.add(i);
        Collections.sort(productsSortList);

        for (Item i : productsSortList)
            System.out.print(i.name + " ");

        System.out.println("");

    }

    public void sortByAmmount() {
        List<Item> productsSortList=new ArrayList<>();
        for (Item i: listOfProducts)
            productsSortList.add(i);

        productsSortList.sort(Comparator.comparing(Item::getQuantity));
        Collections.reverse(productsSortList);
        for (Item i: productsSortList)
            System.out.println(i.name+ " " + i.quantity);


    }


    public void max() {
        Item tmp = Collections.max(listOfProducts, Comparator.comparing(Item::getQuantity));
        System.out.println("MAX: " +tmp.quantity);
    }
}
