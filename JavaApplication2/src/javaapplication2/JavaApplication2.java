package javaapplication2;
import java.util.*;

public class JavaApplication2 {
    public static void main(String[] args) {
        try{
        Boolean bIsInserted = false;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите верхний предел кол-ва элементов");
        int emax = in.nextInt();
        System.out.println("Введите нижний предел кол-ва элементов");
        int emin = in.nextInt();
        System.out.println("Введите число элементов, которому не должно быть равно");
        int eequal = in.nextInt();
        System.out.println("Введите кол-во чисел");
        int kol = in.nextInt();
        if (kol > emax){
            throw new Error("Верхний предел преодолен!");
        } else if (kol < emin){
            throw new Error("Нижний предел не преодолен!");
        } else if (kol == eequal){
            throw new Error("Кол-во равно числу, которое не должно быть!");
        } else {
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
        catch(Exception ex) {
          System.out.println("Ошибка!");
      }
    }
    
}
