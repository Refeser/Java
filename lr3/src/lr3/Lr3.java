package lr3;

import java.util.*;
import java.io.*;

public class Lr3 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("-16 : встреча числа -16, 1 : запись в файл, 2 : чтение из файла");
        int sum1 = 0, sum2 = 0;
        Watcher w = new Watcher();
        beWatched bw = new beWatched();
        bw.addObserver(w);
        String filename = "log.txt";
        File f = new File(filename);
            if(!f.exists()) f.createNewFile();
            PrintWriter pw = new PrintWriter(f.getAbsoluteFile());
                pw.println("12");
                bw.notifyObsWrite();
                pw.println("-4");
                bw.notifyObsWrite();
                pw.println("-16");
                bw.notifyObsWrite();
                bw.notifyObs();
                pw.println("-21");
                bw.notifyObsWrite();
                pw.println("-5");
                bw.notifyObsWrite();
            StringBuilder sb = new StringBuilder();
            if(f.exists()){
                    BufferedReader br = new BufferedReader(new FileReader(f.getAbsoluteFile()));
                    String s;
                    while((s = br.readLine()) != null){
                        bw.notifyObsRead();
                        if((Integer.parseInt(s) < 0) && (Integer.parseInt(s) % 2 == 0))
                            sum1 += Integer.parseInt(s);
                        else if((Integer.parseInt(s) < 0) && (Integer.parseInt(s) % 2 != 0))
                            sum2 += Integer.parseInt(s);
                            br.close();
                    System.out.println(sum1);
                    System.out.println(sum1);
                }
            }
        }
    }
    class beWatched extends Observable {
        void notifyObs(){
            setChanged();
            notifyObservers(new Integer(-16));
        }
        void notifyObsRead(){
            setChanged();
            notifyObservers(new Integer(2));
        }
        void notifyObsWrite(){
            setChanged();
            notifyObservers(new Integer(1));
        }
    }
    class Watcher implements Observer {
        public void update(Observable obs, Object arg){
            System.out.println("received " + ((Integer)arg).intValue());
        }
    }

