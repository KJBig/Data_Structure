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

    // 항 추가 시 배열의 길이 증가
    term[] increaseSize() {
        term[] temp = new term[++this.size];

        for (int i = 0; i < this.poly.length; i++) {
            temp[i] = this.poly[i];
        }

        return temp;
    }

    // 다항식에 항 추가

        // 일반 경우
    void addTerm(int coef, int exp) {
        if (this.size == 0 || this.poly[size - 1] != null) {
            this.poly = increaseSize();
        }
        term t1 = new term(coef, exp);

        this.poly[++now] = t1;
        this.order();
        this.arrange();
    }

        // 상수항의 경우
    void addTerm(int coef) {
        if (this.size == 0 || this.poly[size - 1] != null) {
            this.poly = increaseSize();
        }
        term t1 = new term(coef);

        this.poly[++now] = t1;
        this.order();
        this.arrange();
    }

    // n번째 항 삭제
    void delTerm(int n) {
        term temp = this.poly[n];

        for(int i=n; i<this.now; i++){
            this.poly[n] = this.poly[n+1];
        }
        now--;
    }

    // 다항식을 exp 순으로 정렬
    void order(){
        term max;
        int max_where = 0;

        term temp;

        for(int i=0; i<=this.now; i++){
            max = this.poly[i];

            for(int j=i+1; j<=this.now; j++){
                if(this.poly[j].exp > max.exp){
                    max = this.poly[j];
                    max_where = j;
                }
            }

            temp = max;

            this.poly[max_where] = this.poly[i];
            this.poly[i] = temp;

        }
    }

    // 다항식에서 같은 exp를 정리
    void arrange(){

        for(int i=0; i<=this.now; i++){
            for (int j=i+1; j<=this.now; j++){
                if(this.poly[i].exp == this.poly[j].exp){
                    this.poly[i].coef += this.poly[j].coef;
                    for (int k=j; k<this.now; k++){
                        this.poly[k] = this.poly[k+1];
                        this.test_p();
                    }
                    this.poly[now--] = null;

                }
            }

        }

    }
    /*
    void test_p(){
        System.out.println("==============");
        for (int i = 0; i<=now; i++){
            System.out.println("["+ i + "] :" +  this.poly[i].coef + ", " + this.poly[i].exp);
        }
        System.out.println("==============");
    }

     */

    // 다항식 x값에 상수 대입
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
        for (int i = 0; i <= this.now; i++) {
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
        System.out.println();


    }
}

