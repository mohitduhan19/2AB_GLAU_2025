
package AB.Lec5;

import java.util.Stack;

public class Largest_Rectangle_Histogtam {
    public void rightsmaller(int[] height,int[] rsm){
        Stack<Integer> s = new Stack<>();
        s.push(0);

        for(int i = 1; i < height.length;i++){
            while(!s.isEmpty() && height[i] < height[s.peek()]){
                rsm[s.peek()] = i-1;
                s.pop();
            }
            s.push(i);
        }
        while(s.size() > 0){
            rsm[s.peek()] = height.length-1;
            s.pop();
        }
    }
    public void leftsmaller(int[] height,int[] lsm){
        Stack<Integer> s = new Stack<>();
        s.push(height.length-1);

        for(int i = height.length-2; i >= 0;i--){
            while(!s.isEmpty() && height[i] < height[s.peek()]){
                lsm[s.peek()] = i+1;
                s.pop();
            }
            s.push(i);
        }
        while(s.size() > 0){
            lsm[s.peek()] = 0;
            s.pop();
        }
    }
    public int largestRectangleArea(int[] height) {
        int[] lsm = new int[height.length];
        int[] rsm = new int[height.length];

        leftsmaller(height,lsm);
        rightsmaller(height,rsm);
        int max = 0;

        for(int i = 0; i < height.length;i++){
            int len = rsm[i] - lsm[i] + 1;

            max = Math.max(max , height[i] * len);

        }
        return max;

    }
}
