package mx.ucol;

import java.util.Random;

public class Producer implements Runnable {
    private Drop drop;

    public Producer(Drop drop) {
        this.drop = drop;
    }

    public void run() {
        String songs[] = {
                "Song 1",
                "Song 2",
                "Song 3",
                "Song 4",
                "Song 5",
                "Song 6",
                "Song 7",
                "Song 8",
                "Song 9",
                "Song 10"
        };

        String Games[] = {
                "Juego 1",
                "Juego 2",
                "Juego 3",
                "Juego 4",
                "Juego 5",
                "Juego 6",
                "Juego 7",
                "Juego 8",
                "Juego 9",
                "Juego 10"
        };


        String[][] datos = new String[][] { songs, Games };
        Random random = new Random();

        for (String[] array: datos) {
            drop.put(array);

            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
        }

        drop.put(new String[]{"DONE"});
    }
}