package recursion;

/**
 * Created by zafar.imam on 20-09-2017.
 */

class Factorial {

    public int fact(int i) {
        int result;
        if (i == 1)
            return 1;
        result = fact(i - 1) * i;
        return result;
    }

}
