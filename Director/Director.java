package Director;

import Builder.Builder;
/**
 * Classe director responsável por determinar a ordem de passos para a construção dos decks
 * 
 * @author diegocdbc
 */
public class Director {
    /**
     * Método para construção de deck .
     * 
     * @param build
     */
    public void make(Builder build){
        build.mountFaces();
        build.mountSuits();
        build.mountDeck();
    }
}
