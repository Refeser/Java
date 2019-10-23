package lr2;

import java.util.Scanner;

public class Lr2 {
    public static void main(String[] args) {
        int sum1 = 0, sum2 = 0;
        Scanner in = new Scanner(System.in);
        try{
        System.out.println("Введите максимальное возможное вводимое число:");
        int max = in.nextInt();
        System.out.println("Введите последовательность целых чисел (конец ввода - число 0):");
        int num = in.nextInt();
        if(num == 0){
            System.out.println("Ввод завершен!\nСумма чётных и отрицательных = 0.\nСумма нечётных и отрицательных = 0.");
            in.close();
        } else if(num > max){
            throw new Error("Введено число больше максимально возможной!");
        } else {
            while(num != 0){
                if(num > max){
                    throw new Error("Введено число больше максимально возможной!");
                } else if((num < 0) && (num % 2 == 0)){
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
        }catch(Exception ex){
                System.out.println("Ошибка! Введены символы или литеры!");
                }
    }   
}
