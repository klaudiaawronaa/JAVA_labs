
public class Circle extends Figure implements Print{

    double radius;

    double calculateArea(){
        return (radius*radius*Math.PI);
    }

    double calculatePerimeter(){
        return (2*Math.PI*radius);
    }

    public Circle(double radiusByUser) throws Exception
    {
        if (radiusByUser <= 0)
            throw new Exception ("Less or equal 0 ");
        radius=radiusByUser;

    }

    public void print(){
        System.out.println("Perimeter: " + calculatePerimeter());
        System.out.println("Area: " + calculateArea());
    }
}

