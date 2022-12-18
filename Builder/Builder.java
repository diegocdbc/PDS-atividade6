package Builder;

import BuiltDeck.BuildDeck;

public interface Builder {

    /**
     * Monta o Deck.
     * 
     * @return
     */
    Builder mountDeck();

    /**
     * Monta os Naipes que serão utilizados por cada baralho.
     * 
     * @return
     */
    Builder mountSuits();

    /**
     * monta as faces que serão utilizadas por cada baralho.
     * 
     * @return
     */
    Builder mountFaces();

    BuildDeck getResultDeck();

}
