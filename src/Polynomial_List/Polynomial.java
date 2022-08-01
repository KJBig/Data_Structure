package Polynomial_List;

class term{

    int exp;
    int coef;
    
}


public class Polynomial {
    int size = 0;
    term[] poly;


    Polynomial(int size){
        this.size = size;
        poly = new term[this.size];
    }

    boolean isEmpty(){ // 다항식이 비어있는지 확인
        if (this.size == 0){
            return true;
        }else{
            return false;
        }
    }

    int coef(Polynomial P, int n){
        return P.poly[n].coef;
    }

    public static void main(String[] args){


    }
}
