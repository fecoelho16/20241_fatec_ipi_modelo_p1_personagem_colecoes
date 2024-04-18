import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Personagem p1 = new Personagem();
        Personagem p2 = new Personagem();
        List<Personagem> personagens = new ArrayList<>();
        personagens.add(p1);
        personagens.add(p2);

        Random random = new Random();

        while (true) {
            for (Personagem personagem : personagens) {
                int atividade = random.nextInt(3);
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
                }
            }
        }
    }
}