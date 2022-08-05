package Polynomial_List;

class term {

    int exp = 0;
    int coef = 0;

    term(int coef, int exp){
        this.coef = coef;
        this.exp = exp;
    }
    term(int coef){
        this.coef = coef;
        this.exp = 0;
    }

}
