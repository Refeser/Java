package labil;
import java.util.Scanner;

public class Labil {

    public static void main(String[] args) 
    {
         
         int dlina;
        Scanner in = new Scanner(System.in);
        System.out.println("Vvedite dlinu massiva");
        dlina = in.nextInt();
        int[] myList = new int[dlina];
        System.out.println("Vvedite massiv");
        myList[0] = in.nextInt();
        int min = myList[0];
        for(int i = 1; i < dlina; i++){
            myList[i] = in.nextInt();
            if(myList[i] < min){
                min = myList[i];
            }
        }
        System.out.println("Minimalnij elemet:" + min);
        System.out.println("Massiv bez minimalnogo elementa:");
        for(int i = 0; i < dlina; i++){
            if(myList[i] > min){
                System.out.println(myList[i]);
            }
        }
    }
}
    

   