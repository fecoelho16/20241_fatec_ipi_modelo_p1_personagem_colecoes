import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Personagem p1 = new Personagem(Scooby);
        Personagem p2 = new Personagem(Sheldon);
        List<Personagem> personagens = new ArrayList<>();
        personagens.add(p1);
        personagens.add(p2);

        Random random = new Random();

        while (true) {
            for (Personagem personagem : personagens) {
                int atividade = random.nextInt(4);
                switch (atividade) {
                    case 0:
                        personagem.comer();
                        break;
                    case 1:
                        personagem.cacar();
                        break;
                    case 2:
                        personagem.dormir();
                        break;
                    case 3:
                        // sortear um número para decidir qual personagem vai atacar
                        int atacante = random.nextInt(2);
                        personagens.get(atacante).atacar(personagens.get(1 - atacante));
                        break;
                }

                // verificar se algum personagem morreu
                if (personagem.energia <= 0) {
                    if (personagens.size() == 1) {
                        System.out.printf("O jogo acabou! %s venceu!\n", personagem.nome);
                        System.exit(0);
                    } else {
                        personagens.remove(personagem);
                    }
                }
            }
        }
    }
}
