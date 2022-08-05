package Polynomial_List;

class Polynomial {
    int size;
    int now;
    term[] poly;

    Polynomial() {
        size = 0;
        now = -1;
        poly = new term[this.size];

    }

    boolean isEmpty() { // 다항식이 비어있는지 확인
        if (this.now == -1) {
            return true;
        } else {
            return false;
        }
    }

    int coef(Polynomial P, int n) {
        return P.poly[n].coef;
    }

    term maxExp() { // exp가 가장 높은 항 반환
        int max = 0;
        int max_n = 0;

        for (int i = 0; i < size; i++) {
            if (max < poly[i].exp) {
                max = poly[i].exp;
                max_n = i;
            }
        }

        return poly[max_n];
    }

    term[] increaseSize() {
        term[] temp = new term[++this.size];

        for (int i = 0; i < this.poly.length; i++) {
            temp[i] = this.poly[i];
        }

        return temp;
    }

    void addTerm(int coef, int exp) { // 다항식에 항 추가
        if (this.size == 0 || this.poly[size - 1] != null) {
            this.poly = increaseSize();
        }
        term t1 = new term(coef, exp);

        this.poly[++now] = t1;
    }
    void addTerm(int coef) { // 다항식에 항 추가
        if (this.size == 0 || this.poly[size - 1] != null) {
            this.poly = increaseSize();
        }
        term t1 = new term(coef);

        this.poly[++now] = t1;
    }

    term delTerm(int exp) { // 다항식에 항 제거, 제거된 항 반환
        term temp = null;
        int target = 0;

        for (int i = 0; i < size; i++) {
            if (this.poly[i].exp == exp) {
                temp.exp = this.poly[i].exp;
                temp.coef = this.poly[i].coef;

                target = i;

                break;
            }
        }

        for (int i = target; this.poly[i] != null; i++) {
            this.poly[i].exp = this.poly[i + 1].exp;
            this.poly[i].coef = this.poly[i + 1].coef;

            if (i < size - 2) {
                this.poly[size - 1] = null;
                break;
            }
        }


        return temp;

    }

    int Eval(int n) {
        int result = 0;

        for (int i = 0; i < this.size; i++) {
            result += (this.poly[i].coef * Math.pow(n, this.poly[i].exp));
        }

        return result;
    }

    /*
    term[] polyAdd(Polynomial p) { // 다항식과 다항식의 합
        term[] temp = null;
        if (this.poly.length > p.poly.length) {
            temp = new term[this.poly.length];
        } else {
            temp = new term[p.poly.length];
        }

        for (int i = 0; i < this.poly.length; i++) {
            for (int j = 0; j < p.poly.length; j++) {

            }
        }

        return temp;

    }
    */
    void polyMul(Polynomial p) { // 다항식과 다항식의 고

    }


    void print() { // 다항식 출력
        for (int i = 0; i < this.size; i++) {
            if(i != 0){
                if(this.poly[i].coef > 0 ){
                    System.out.print("+");
                }
            }

            if (this.poly[i].exp == 0) {
                System.out.print(this.poly[i].coef);
            } else if (this.poly[i].exp == 1) {
                System.out.print(this.poly[i].coef + "x");
            } else {
                System.out.print(this.poly[i].coef + "x^" + this.poly[i].exp);
            }


        }


    }
}


