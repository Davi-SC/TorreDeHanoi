import staticstack.VectorStack;
import java.util.Scanner;

public class index {
    public static void main(String[] args) {
        int qnt;
        int op;
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Digite a quantidade de discos: ");
            qnt = scanner.nextInt();
            VectorStack[] pinos = new VectorStack[3];
            pinos[0] = new VectorStack(qnt);
            pinos[1] = new VectorStack(qnt);
            pinos[2] = new VectorStack(qnt);
            preencherPino(pinos[0], qnt);

            System.out.println("1 - Jogar");
            System.out.println("0 - Sair");
            op = scanner.nextInt();

            if (op == 1){
                System.out.println("Sua jogada deve ser no seguinte formato: 1 3" +
                        "\nSignifica que voce quer mover o disco superior do pino 1 para o pino 3 ");
                jogar(qnt, pinos);

            } else if (op == 0) {
                break;
            }
            else {
                System.out.println("Opção invalida;");
            }

        }
    }

    static void jogar(int tam, VectorStack[] pinos){
        String jogada ;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite X para sair");
        jogada = scanner.nextLine();
        jogada = jogada.toLowerCase();
        if (jogada.equals("x")) {
            System.out.println("ate mais");
            return;
        }
        int sai, recebe;
        String[] movimentos = jogada.split(" ");
        sai = Integer.parseInt(movimentos[0]) ; // o menos 1 é pq o usuario pode digitar pino 1 para 3, mas os indices são entre 0 e 2
        recebe = Integer.parseInt(movimentos[1]) ;

        if ((recebe >2 && recebe <0) || (sai >2 && sai <0)) {
            System.out.println("Movimento invalido");
//        }else if (pinos[sai].top() > pinos[recebe].top() && pinos[recebe].top() != 0){
//            System.out.println("Movimento invalido");
        }else {
            int elemento = pinos[sai].pop();
            pinos[recebe].push(elemento);
            printPinos(pinos);
        }

    }

    static void printPinos(VectorStack[] pinos){
        System.out.println();
        for(int i =0;i< pinos.length;i++){
            System.out.println("Pino "+i+": "+ pinos[i].toString());
        }
        System.out.println();
    }

    static void preencherPino(VectorStack pilha, int n){
        for(int i = n; i > 0; i--){
            pilha.push(i);
        }
    }

    static boolean verificarFim(int tam, VectorStack[] pinos){
        return pinos[0].isEmpty() && pinos[1].isEmpty();
    }

}
