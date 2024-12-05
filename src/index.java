import staticstack.VectorStack;
import java.util.Scanner;

public class index {
    public static void main(String[] args) {
        int n ;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a quantidade de discos: ");
        n = scanner.nextInt();

        VectorStack pilhaA = new VectorStack(n);
        VectorStack pilhaB = new VectorStack(n);
        VectorStack pilhaC = new VectorStack(n);

        pilhaA = preencherPilha(pilhaA, n);
        printPilha(pilhaA, pilhaB, pilhaC);
        System.out.println("Resolvendo a Torre de Hanoi: \n");
        hanoi(n, pilhaA, pilhaB, pilhaC);
    }

    static void hanoi(int n, VectorStack pilhaA, VectorStack pilhaB, VectorStack pilhaC){
        if(n==1){
            pilhaC.push(pilhaA.pop());
            printPilha(pilhaA, pilhaB, pilhaC);
        }else{
            hanoi(n-1, pilhaA, pilhaC, pilhaB);
            pilhaC.push(pilhaA.pop());
            printPilha(pilhaA, pilhaB, pilhaC);
            hanoi(n-1, pilhaB, pilhaA, pilhaC);
        }

    }

    static void printPilha(VectorStack pilhaA, VectorStack pilhaB, VectorStack pilhaC){
        System.out.println();
        System.out.println("Pilha A: " + pilhaA.toString());
        System.out.println("Pilha B: " + pilhaB.toString());
        System.out.println("Pilha C: " + pilhaC.toString());
        System.out.println();
    }

    static VectorStack preencherPilha(VectorStack pilha, int n){
        for(int i = n; i > 0; i--){
            pilha.push(i);
        }
        return pilha;
    }
}
