package lab1;
import java.util.*;

public class Lab1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        System.out.println("Vvedite spisok (konec spiska 99999)");
        int num = in.nextInt();
        if(num == 99999){
            System.out.println("Spisok pust!");
        } else {
            while(num!=99999){
                if(num!=99999){
                    numbers.add(num);
                    num = in.nextInt();
                } else continue;
            }
            Collections.sort(numbers);
            Collections.reverse(numbers);
            System.out.println("Rezultat:");
            System.out.println(numbers);
        }
    }
}
