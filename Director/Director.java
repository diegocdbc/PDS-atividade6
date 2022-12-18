package Director;

import Builder.Builder;

public class Director {
    public void constructDeckForGeneralUsage(Builder build) {
        build.mountFaces()
                .mountSuits()
                .mountDeck();
        System.out.println("Director ok!");
    }
}
