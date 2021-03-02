import java.util.*;

/*
 *  CCC: N/A
 *  DMOJ: 50/50 (0.758s, 60.66 MB)
 *  Problem Type: Simple Math
 */

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<Character, Integer> rNums = new HashMap<Character, Integer>();
        rNums.put('I', 1);
        rNums.put('V', 5);
        rNums.put('X', 10);
        rNums.put('L', 50);
        rNums.put('C', 100);
        rNums.put('D', 500);
        rNums.put('M', 1000);
        String in = scan.nextLine();
        String[] nums = new String[in.length() / 2];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.substring(i * 2, i * 2 + 2);
        }
        int out = 0;
        for (int i = 0; i < nums.length; i++) {
            int v = Integer.parseInt(nums[i].substring(0,1)) * rNums.get(nums[i].charAt(1));
            //System.out.println(v);
            if (i < nums.length - 1 && rNums.get(nums[i].charAt(1)) < rNums.get(nums[i+1].charAt(1)))
                out -= v*2;
            out += v;
        }
        System.out.println(out);
    }
}