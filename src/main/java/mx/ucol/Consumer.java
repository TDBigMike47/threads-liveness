package mx.ucol;

import java.util.Random;

public class Consumer implements Runnable {
    private Drop drop;
    private int number;

    public Consumer(Drop drop, int number) {
        this.drop = drop;
        this.number = number;
    }

    public void run() {
        Random random = new Random();

        for(String [] datos = drop.take(); datos[0] != "DONE"; datos = drop.take()){
            for (String dato: datos) {
                System.out.format("Thread %d: Consumiendo %s%n",this.number, dato);

                try {
                    Thread.sleep(random.nextInt(5000));
                } catch (InterruptedException e) {}
            }
        }
    }
}