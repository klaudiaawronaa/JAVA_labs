public class Triangle extends Figure implements Print {

    double height;
    double basis;
    double sideSecond;
    double sideThird;


    double calculateArea(){
        return 0.5*height*basis;
    }

    double calculatePerimeter(){
        return (sideSecond+sideThird+basis);
    }

    public Triangle(double heightByUser, double basisByUser, double sideSecondByUser, double sideThirdByUser) throws Exception
    {
        if (heightByUser<=0 || basisByUser<=0 || sideSecondByUser<=0 || sideThirdByUser<=0)
            throw new Exception ("Less or equal 0 ");
        height=heightByUser;

        basis=basisByUser;
        sideSecond=sideSecondByUser;
        sideThird=sideThirdByUser;
    }

    public void print(){
        System.out.println("Perimeter: " + calculatePerimeter());
        System.out.println("Area: " + calculateArea());
    }
}
