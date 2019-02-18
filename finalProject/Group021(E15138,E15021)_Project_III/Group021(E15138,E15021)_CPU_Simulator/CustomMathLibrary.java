//used to calculate integer powers of two
public class CustomMathLibrary {

    public static int twosPow(int a) {

        int val = 1;
        if (a < 0) {

            for (int i = 0; i < -a; i++) {

                val = val / 2;

            }

            return val;
        }
        if (a == 0) {
            return val;
        }

        for (int i = 0; i < a; i++) {
            val = val * 2;
        }
        return val;

    }

}
