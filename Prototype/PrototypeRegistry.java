package Prototype;

import java.util.HashMap;

/**
 * Classe reponsável por ser um repositório de protótipos além de facilitar clonagem dos objetos.
 * 
 * @author diegocdbc
 */
public class PrototypeRegistry {
    private HashMap<String, Prototype> prototypes = new HashMap<String, Prototype>();


    /**
     * Método responsável por fazer a adição de um novo prototipo
     * 
     * @param nome
     * @param prototype
     */
    public void addPrototype(String nome, Prototype prototype){
        this.prototypes.put(nome, prototype);
    }

    /**
     * Método para acessar, recuperar e criar um clone de um protótipo baseado na sua key "nome"
     * 
     * @param nome
     * @return
     */
    public Prototype getPrototype(String nome){
        return this.prototypes.get(nome).clone();
    }

    /**
     * Método reponsável por remover um protótipo da coleção a partir de seu nome.
     * 
     * @param nome
     */
    public void removeProtype(String nome){
        this.prototypes.remove(nome);
    }
}
