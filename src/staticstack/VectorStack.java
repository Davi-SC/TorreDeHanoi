package staticstack;

import java.util.Arrays;

public class VectorStack implements IStack {
    //Classe que representa a pilha

//    @Override
//    public int size() {
//        throw new UnsupportedOperationException("...");
//    }

//    @Override
//    public boolean isEmpty() {
//        throw new UnsupportedOperationException("...");
//    }

    int capacidade;
    int[] inteiros = new int[capacidade];
    int size = 0;

    public VectorStack(int capacidade) {
        this.capacidade = capacidade;
        inteiros = new int[capacidade];
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public int top(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return inteiros[size - 1];
    }

    @Override
    public void push(int element){
        if(size == capacidade){
            throw new FullStackException();
        }
        inteiros[size] = element;
        size++;
    }

    @Override
    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int element = top();
        inteiros[size - 1] = 0;
        size--;
        return element;
    }

    @Override
    public String toString() {
        return Arrays.toString(inteiros);
    }
}
