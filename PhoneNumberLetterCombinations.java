/* 
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * 
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * 
 * Constraints:
 *
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 * 
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberLetterCombinations {
    public static final Map<Integer, List<String>> numberMap = new HashMap<>();
    static {
        numberMap.put(2, List.of("a", "b", "c"));
        numberMap.put(3, List.of("d", "e", "f"));
        numberMap.put(4, List.of("g", "h", "i"));
        numberMap.put(5, List.of("j", "k", "l"));
        numberMap.put(6, List.of("m", "n", "o"));
        numberMap.put(7, List.of("p", "q", "r", "s"));
        numberMap.put(8, List.of("t", "u", "v"));
        numberMap.put(9, List.of("w", "x", "y", "z"));
    }

    public static void main(String[] args){
        PhoneNumberLetterCombinations solution = new PhoneNumberLetterCombinations();
        String digits = "22";
        System.out.println(solution.letterCombinations(digits));
    }
        
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if(digits.length() == 0){
            return combinations;
        }
        List<List<String>> letterSet = new ArrayList<>();
        String[] nums = digits.split("");
        for(String num : nums){
            letterSet.add(numberMap.get(Integer.valueOf(num)));
        }
        
        for(List<String> letters : letterSet){
            if(combinations.size() == 0){
                combinations.addAll(letters);
            } else {
                List<String> temp = new ArrayList<>();
                for(String letter : letters){
                    for(String combination : combinations){
                        temp.add(combination + letter);
                    }
                }
                combinations = temp;
            }
        }
        return combinations;
    }
}
