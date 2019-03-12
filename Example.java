package src;

import java.util.HashMap;

public class Example {
    public void arrayTestException() {
        int[] arr={5,18,95};
        try {
            for (int i = 0; i < 3; i++) {
                System.out.print(arr[i] + " ");
            }
            double v=8/4;
            System.out.println(v);
            int x=-56;
            if(x<=0) throw new ArithmeticException("Log cannot pass a  negative param");
            v=Math.log10(x);
            System.out.println(v);
        }catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e.toString());
        }catch(ArithmeticException e){
            System.out.println(e.toString());
        }
        System.out.println("hello");

        String str= "java awf";
        HashMap<Character, Integer> counter = new HashMap();
        for(char chr : str.toCharArray()){
            if(!counter.containsKey(chr)){
                counter.put(chr, 1);
            }else{
                counter.put(chr, counter.get(chr)+1);
            }
        }
        System.out.println(counter);
        int a=10;
        while(a<24){
            System.out.print("M ");
            a++;
            if(a%3==0) continue;
            if(a%5==0) break;
            System.out.print("X ");
        }
    }
}