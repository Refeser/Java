package lab2;
import java.util.*;

public class Lab2 {
    public static void main(String[] args) {
        try{
        Scanner in = new Scanner(System.in);
        int num;
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        System.out.println("Vvedite spisok (konec spiska 99999 i ne bolee 10, nelzya vvodit chislo 666)");
        num = in.nextInt();
        int kol = 0;
        if(num == 99999){
            System.out.println("Spisok pust!");
        } else {
            while(num!=99999){
                if(num == 666){
                    throw new Error("Vvedeno chislo 666!");
                }
                if(num!=99999){
                    kol++;
                    numbers.add(num);
                    num = in.nextInt();
                    if(kol >= 10){
                        throw new Error("Kol-vo chisel bolshe 10!");
                    }
                } else continue;
            }
            Collections.sort(numbers);
            Collections.reverse(numbers);
            System.out.println("Rezultat:");
            System.out.println(numbers);
        }
        } 
        catch(Exception ex){
            System.out.println("Error! Vveden liter!");
        }
    }
}
