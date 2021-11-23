package mix_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Function;
import java.util.function.Predicate;

class Recursive <T>{
    public T func;
}

public class JavaPredicateFlexPortQuestion{

        public static void main(String[] a) {
            Recursive<Function<Integer, Integer>> r = new Recursive<Function<Integer, Integer>>();
            r.func = n -> n <= 1 ? 1 : n * r.func.apply(n - 1);


            int g = r.func.apply(4);
            System.out.println(g);


            List<String> w = new ArrayList<>(Arrays.asList("Hello", "World"));
            for (int i = 0; i < w.size(); i++) {
                String word = new StringBuilder(w.get(i)).reverse().toString();
                word.toLowerCase();
                w.set(i, word);
            }

            for (int i = 0; i < w.size(); i++) {
                System.out.println(w.get(i));
            }
            List<Integer> rr  = new ArrayList<>();

            System.out.println(hasPosNeg( rr)[0]);



        }


        public static Boolean[] hasPosNeg(List<Integer> l){
            boolean hasPos=false;
            boolean hasNeg=false;
            for(int i=0;i<l.size();i++){
                hasPos= l.get(i)>0;
                hasNeg = l.get(i)<0;
            }
            return new Boolean[]{hasPos, hasNeg};
        }


        public static void exampoel(Predicate<Integer> f, ArrayList<Integer>items){
            int i=0;
            for(int item: items){
                if(f.test(item)){
                    items.set(i, item);
                    i+=1;
                }
            }
            items.subList(i, items.size()).clear();
        }



    public static void javaPredicate(String[] a) throws InterruptedException {
        String[] y = {"1", "2", "15", "-7"};
        Arrays.sort(y);
        System.out.println(y[0] + "   " + y[1]);

        BlockingQueue<Integer> q = new LinkedBlockingQueue<>();
        Arrays.asList(3,2,1).forEach((d)->{
            new Thread(()->{
                try{
                    Thread.sleep(d*1000);

                }catch (Exception e){

                }
                q.add(d);
            }).start();
        });
        System.out.println(q.take());


        List<Integer> b= new ArrayList<>();
        int aa=0;
        func(aa,b);
        System.out.println(aa + b.toString());
    }
    public static void func(int a, List<Integer>b){
        a+=1;
        b.add(1);
    }
}
