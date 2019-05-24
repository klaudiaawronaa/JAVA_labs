import java.util.Scanner;

public class projekt1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("**********************************************");
            System.out.println("1. CLOSE");
            System.out.println("2. CHOOSE FIGURE");
            System.out.println("Enter number:");
            char choice1 = scanner.next().charAt(0);

            switch (choice1) {
                case '1':
                    loop = false;
                    break;
                case '2':
                    System.out.println("1. Triangle");
                    System.out.println("2. Circle");
                    System.out.println("3. Square");
                    char choice2 = scanner.next().charAt(0);

                    switch (choice2) {
                        case '1':
                            System.out.println("Enter height, basis, second side, third side");
                            double heightByUser = scanner.nextDouble();
                            double basisByUser = scanner.nextDouble();
                            double sideSecondByUser = scanner.nextDouble();
                            double sideThirdByUser = scanner.nextDouble();

                            try {
                                Triangle triangleByUser = new Triangle(
                                        heightByUser,
                                        basisByUser,
                                        sideSecondByUser,
                                        sideThirdByUser);
                                triangleByUser.print();
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                            break;


                        case '2':
                            System.out.println("Enter radius");
                            double radiusByUser = scanner.nextDouble();
                            try {
                                Circle circleByUser = new Circle(radiusByUser);
                                circleByUser.print();
                            } catch (Exception e){
                                System.out.println(e.getMessage());
                            }
                            break;

                        case '3':
                            System.out.println("Enter lenght");
                            double lenghtByUser = scanner.nextDouble();
                            try {
                                Square squareByUser = new Square(lenghtByUser);
                                squareByUser.print();
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        default:
                            System.out.println("WRONG NUMBER, DO IT AGAIN");
                    }
                    break;

                default:
                    System.out.println("WRONG NUMBER, DO IT AGAIN");

            }

        }
    }
}
