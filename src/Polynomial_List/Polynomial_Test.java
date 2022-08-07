package Polynomial_List;

public class Polynomial_Test {

    public static void main(String[] args){
        Polynomial p1 = new Polynomial();

        System.out.println(p1.isEmpty());
        p1.addTerm(3);
        System.out.println(p1.isEmpty());
        p1.addTerm(-3, 1);
        p1.addTerm(3,3);
        p1.addTerm(4,3);

        p1.print();

    }
}