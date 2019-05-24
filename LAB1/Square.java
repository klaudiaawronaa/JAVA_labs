public class Square extends Figure implements Print{

    double basis;

    double calculateArea(){
        return basis*basis;
    }

    double calculatePerimeter(){
        return (basis*4);
    }

    public Square(double basisByUser) throws Exception
    {
        if (basisByUser<=0)
            throw new Exception ("Less or equal 0 ");
        basis=basisByUser;

    }

    public void print(){
        System.out.println("Perimeter: " + calculatePerimeter());
        System.out.println("Area: " + calculateArea());
    }
}

