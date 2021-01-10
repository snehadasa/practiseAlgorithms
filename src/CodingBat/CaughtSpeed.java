package CodingBat;

public class CaughtSpeed {
    public int caughtSpeeding(int speed, boolean isBirthday) {
        //int val = (boolean) ? 1 : 0;

        if (!isBirthday) {
            if (speed <= 60) {
                return 0;
            } else
            if(speed > 60 && speed <= 80) {
                return 1;
            }
            if (speed > 80) {
                return 2;
            }
        } else
        if (isBirthday) {
            if (speed <= 65) {
                return 0;
            } else
            if(speed > 65 && speed <= 85) {
                return 1;
            }
            if (speed > 85) {
                return 2;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        CaughtSpeed res = new CaughtSpeed();
        System.out.println(res.caughtSpeeding(99, true));
    }
}
