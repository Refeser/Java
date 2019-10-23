package javaapplication1;
import java.util.*;

public class JavaApplication1 {
    public static void main(String[] args) {
        Boolean bIsInserted = false;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите кол-во чисел");
        int kol = in.nextInt();
        int[] mas = new int[kol];
        System.out.println("Введите неубывающую последовательность");
        for (int i = 0; i < kol; i++){
            int num = in.nextInt();
            if(i == 0){
                mas[i] = num;
            } else if(num < mas[i-1]){
                System.out.println("Порядок должен быть неубывающим");
                i--;
            } else {
                mas[i] = num;
            }
        }
        System.out.println("Введите число b");
        int b = in.nextInt();
        System.out.println("Массив до изменения:");
        for (int i = 0; i < kol; i++){
            System.out.print(mas[i]);
        }
        System.out.println("Массив до изменения:");
        for (int i = 0; i < kol; i++){
            if(i == kol-1 && bIsInserted == false){
                System.out.print(mas[i]);
                System.out.print(b);
            } else
            if((b > mas[i] && b < mas[i+1])||(b > mas[i] && b == mas[i+1])){
                System.out.print(mas[i]);
                System.out.print(b);
                bIsInserted = true;
            } else
            System.out.print(mas[i]);
        }
    }
    
}
