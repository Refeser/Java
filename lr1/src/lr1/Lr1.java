package lr1;

import java.util.Scanner;

public class Lr1 {
    public static void main(String[] args) {
        int sum1 = 0, sum2 = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите последовательность целых чисел (конец ввода - число 0):");
        int num = in.nextInt();
        if(num == 0){
            System.out.println("Ввод завершен!\nСумма чётных и отрицательных = 0.\nСумма нечётных и отрицательных = 0.");
            in.close();
        } else{
            while(num != 0){
                if((num < 0) && (num % 2 == 0)){
                    sum1 += num;
                    num = in.nextInt();
                } else if((num < 0) && (num % 2 != 0)){
                    sum2 += num;
                    num = in.nextInt();
                } else num = in.nextInt();
            }
            System.out.println("Ввод завершен!\nСумма чётных и отрицательных = " + sum1 + ".\nСумма нечётных и отрицательных = " + sum2 + ".");
            in.close();
        }
    }
    
}
