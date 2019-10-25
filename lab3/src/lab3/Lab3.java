package lab3;
import java.util.*;

public class Lab3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;
        Watcher w = new Watcher();
        beWatched bw = new beWatched();
        bw.addObserver(w);
        System.out.println("1-vvod s konsoli, 2-vivod v konsol, 3-chislo elementov ravno 3");
        bw.notifyConsoleOut();
        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.println("Vvedite spisok (konec spiska 99999)");
        bw.notifyConsoleOut();
        int num = in.nextInt();
        bw.notifyConsoleIn();
        count++;
        if(num == 99999){
            System.out.println("Spisok pust!");
        } else {
            while(num!=99999){
                if(num!=99999){
                    numbers.add(num);
                    num = in.nextInt();
                    bw.notifyConsoleIn();
                    count++;
                }
                if(count == 3){
                    bw.notifyElems();
                }
            }
            Collections.sort(numbers);
            Collections.reverse(numbers);
            System.out.println("Rezultat:");
            System.out.println(numbers);
        }
    }
}

class beWatched extends Observable {
    void notifyConsoleIn(){
        setChanged();
        notifyObservers(1);
    }
    void notifyConsoleOut(){
        setChanged();
        notifyObservers(2);
    }
    void notifyElems(){
        setChanged();
        notifyObservers(3);
    }
}

class Watcher implements Observer {
    @Override
    public void update(Observable obs, Object arg){
        System.out.println("received " + ((Integer)arg));
    }
}