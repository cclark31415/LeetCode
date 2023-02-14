import java.util.List;
import java.util.ArrayList;

public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger solution = new ReverseInteger();
        int[] integers = {123, -123, 1534236469, -2147483648};
        for(int thisInt : integers){
            System.out.println(solution.reverse(thisInt));
        }
    }

    public int reverse(int inputInteger) {
        boolean negative = false;
        
        if (outOfBounds(inputInteger)) {
            return 0;
        }

        if(inputInteger < 0){
            if (outOfBounds(Math.abs(Long.valueOf(inputInteger).longValue()))) {
                return 0;
            }
            negative = true;
            inputInteger *= -1;
        }

        List<Integer> numStack = new ArrayList<>();
        collectDigits(inputInteger, numStack);
        int output = reverseDigits(numStack);

        if(negative){
            output *= -1;
        }

        return output;        
    }

    public boolean outOfBounds(long value){
        if(value < Math.pow(-2, 31) || value > (Math.pow(2, 31) - 1)){
            return true;
        } else {
            return false;
        }
    }

    public void collectDigits(int num, List<Integer> numStack) {
        if(num / 10 > 0) {
            collectDigits(num / 10, numStack);
        } 
        numStack.add(0, num % 10);
    }

    public int reverseDigits(List<Integer> numStack){
        int output = 0;
        int s = 0; 
        for(int i = numStack.size() - 1; i >= 0; i--){
            int multiplier = (int) Math.floor(Math.pow(10, i));
            if(!outOfBounds(output + numStack.get(s).longValue() * multiplier)){
                output += numStack.get(s).intValue() * multiplier;
            } else {
                return 0;
            }
            s++;
        }
        return output;
    }
}