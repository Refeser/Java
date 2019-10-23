package javaapplication3;
import java.util.*;
import java.io.*;

public class JavaApplication3 {
    public static void main(String[] args) {
        Boolean bIsInserted = false;
        System.out.println("1 - консольный ввод 2 - изменение переменной (кол-ва) 3 - вызов функции");
        Watcher w = new Watcher();
        beWatched bw = new beWatched();
        bw.addObserver(w);
        int kol = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите кол-во чисел");
        kol = in.nextInt();
        bw.notifyVarChanged();
        bw.notifyConsoleIn();
        bw.notifyFunc();
        int[] mas = new int[kol];
        System.out.println("Введите неубывающую последовательность");
        for (int i = 0; i < kol; i++){
            int num = in.nextInt();
            bw.notifyConsoleIn();
            bw.notifyFunc();
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
        bw.notifyConsoleIn();
        bw.notifyFunc();
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

class beWatched extends Observable {
    void notifyConsoleIn(){
        setChanged();
        notifyObservers(new Integer(1));
    }
    void notifyVarChanged(){
        setChanged();
        notifyObservers(new Integer(2));
    }
    void notifyFunc(){
        setChanged();
        notifyObservers(new Integer(3));
    }
}

class Watcher implements Observer {
    public void update(Observable obs, Object arg){
        System.out.println("received " + ((Integer)arg).intValue());
    }
}
