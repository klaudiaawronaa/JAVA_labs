import java.util.Map;
import java.util.HashMap;
import java.util.*;
public class main {
    public static void main(String[] args)
    {
    FulfillmentCenter x = new FulfillmentCenter("NAME", 50);
    Item book1 = new Item("Book", ItemCondition.NEW, 23.9, 1);
    x.addProduct(book1);
    Item book2 = new Item("Book", ItemCondition.REFURBISHED, 1, 5);
    x.addProduct(book2);
    Item pen1 = new Item("Pen", ItemCondition.REFURBISHED, 1, 2);
    x.addProduct((pen1));
    Item notebook = new Item("Notebook", ItemCondition.REFURBISHED, 1, 5);
    x.addProduct(notebook);
    x.addProduct(notebook);

        x.getProduct(notebook);
        //x.getProduct(pen1);
        //x.getProduct(pen1);
        x.searchPartial("Pe");
        //System.out.println(x.countByCondition(ItemCondition.NEW));
        x.summary();
        x.sortByName();
        x.sortByAmmount();
        x.max();

        fulfillmentCenterContainer container = new fulfillmentCenterContainer("NEW", 2000);
        container.addCenter("FIRST CENTER", 23);
        container.storehouses.get("FIRST CENTER").addProduct(book2);
        container.addCenter("SECOND CENTER", 100);
        System.out.println(container.findEmpty());
        container.summary();


    }



}
