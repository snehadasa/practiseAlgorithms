package CodingBat;

public class CloseFar {
    public boolean closeFar(int a, int b, int c) {
        if (diff(diff(a, b), c) <= 1) {
            return true;
        } else
        if (diff(a, b) <= 1 && diff(b, c) <= 1) {
            return false;
        } else
        if (diff(a, b) <= 1 && diff(a, c) <= 1) {
            return false;
        } else
        if (diff(a, c) <= 1 && diff(b, c) <= 1) {
            return false;
        } else
        if (diff(a, b) <= 1 && diff(diff(a,b), c) >= 2) {
            return true;
        } else
        if (diff(b, c) <= 1 && diff(diff(c,b), a) >= 2) {
            return true;
        } else
        if (diff(a, c) <= 1 && diff(diff(a,c), b) >= 2) {
            return true;
        }
        return false;
    }

    public int diff(int num1, int num2) {
        int different = Math.abs(num1 - num2);
        return different;
    }

//    public boolean closeFar(int a, int b, int c) {
//        return !close(b,c)&(close(a,b)^close(a,c));
//    }
//    public boolean close(int a, int b) {
//        return Math.abs(a-b)<=1;
//    }

//    return Math.abs(a-b)<=1 && Math.abs(a-c)>=2 && Math.abs(b-c)>=2 || Math.abs(a-c)<=1 && Math.abs(a-b)>=2 && Math.abs(b-c)>=2;

//    public boolean closeFar(int a, int b, int c) {
//
//        if (Math.abs(a - b) <= 1 && Math.abs(a - c) >= 2 && Math.abs(b - c) >= 2){
//            return true;
//        } else if (Math.abs(a - c) <= 1 && Math.abs(a - b) >= 2 && Math.abs(b - c) >= 2){
//            return true;
//        }else{
//            return false;
//        }
//    }


    public static void main(String[] args) {
        CloseFar res = new CloseFar();
        System.out.println(res.closeFar(10, 8, 9));
    }
}
