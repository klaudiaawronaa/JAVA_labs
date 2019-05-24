import java.util.Map;
import java.util.HashMap;

public class fulfillmentCenterContainer {
    String name;
    double maxMass;

    public fulfillmentCenterContainer(String name, double maxMass) {
        this.name = name;
        this.maxMass = maxMass;
    }

    Map<String, FulfillmentCenter> storehouses = new HashMap<String, FulfillmentCenter>();

    public void addCenter(String name, double weight) {
        storehouses.put(name, new FulfillmentCenter(name, weight));
        System.out.println("ADDED CENTER: " + name);
    }

    public void removeCenter(String name) {
        storehouses.remove(name);
        System.out.println("REMOVED CENTER");
    }


    public int findEmpty() {
        int sum = 0;
        for (String name : storehouses.keySet()) {
            if (storehouses.get(name).mass() == 0)
                sum++;
        }

        return sum;
    }

    public void summary() {
        for (String name : storehouses.keySet()) {
            System.out.println(name);
            System.out.println(storehouses.get(name).mass() *100 / storehouses.get(name).maxMass);
        }
    }

}
