import staticstack.VectorStack;
import java.util.Scanner;

public class index {
    public static void main(String[] args) {
        int qnt;
        int op;
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("1 - Jogar");
            System.out.println("0 - Sair");
            op = scanner.nextInt();

            if (op == 1){
                System.out.println("Digite a quantidade de discos: ");
                qnt = scanner.nextInt();
                VectorStack[] pinos = new VectorStack[3];
                pinos[0] = new VectorStack(qnt);
                pinos[1] = new VectorStack(qnt);
                pinos[2] = new VectorStack(qnt);
                preencherPino(pinos[0], qnt);

                boolean verificador = false;
                while (true){
                    jogada(pinos);
                    verificador = verificarFim(pinos);
                    if (verificador){
                        System.out.println("Você ganhou!");
                        printPinos(pinos);
                        break;
                    }
                }
            } else if (op == 0) {
                break;
            }
            else {
                System.out.println("Opção invalida;");
            }

        }
    }

    static void jogada(VectorStack[] pinos){
        Scanner scanner = new Scanner(System.in);
        int origem, destino;
        printPinos(pinos);
        System.out.println("Digite o pino de origem: ");
        origem = scanner.nextInt()-1;
        System.out.println("Digite o pino de destino: ");
        destino = scanner.nextInt()-1;

        if (origem < 0 || origem > 2 || destino < 0 || destino > 2){
            System.out.println("Movimento invalido");
        }
        else if (origem == destino){
            System.out.println("Movimento invalido");
        }
        else if(pinos[origem].isEmpty()){
            System.out.println("Pino de origem vazio");
        }
        else if(pinos[destino].isEmpty()){
            pinos[destino].push(pinos[origem].pop());
        }
        else if(pinos[origem].top() > pinos[destino].top()){
            System.out.println("Movimento invalido");
        }
        else{
            pinos[destino].push(pinos[origem].pop());
        }

    }

    static void printPinos(VectorStack[] pinos){
        System.out.println();
        for(int i = 0;i < pinos.length;i++){
            int j = i+1;
            System.out.println("Pino "+j+": "+ pinos[i].toString());
        }
        System.out.println();
    }

    static void preencherPino(VectorStack pilha, int n){
        for(int i = n; i > 0; i--){
            pilha.push(i);
        }
    }

    static boolean verificarFim(VectorStack[] pinos) {
        return pinos[0].isEmpty() && pinos[1].isEmpty();
    }
}
