import java.util.Random;

public class Personagem{
    //variáveis de instância
    String nome;
    int energia;
    private int fome;
    private int sono;
    private VetorDinamico<String> itens;

    //esse é o construtor padrão
    //criado automaticamente pelo compilador, ainda que não seja escrito explicitamente
    Personagem(){
        nome = null;
        energia = 10;
        fome = 0;
        sono = 0;
        itens = new VetorDinamico<String>(4);
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            switch (random.nextInt(5)) {
                case 0:
                    itens.adicionar("Javali selvagem");
                    break;
                case 1:
                    itens.adicionar("Amora");
                    break;
                case 2:
                    itens.adicionar("Batata frita");
                    break;
                case 3:
                    itens.adicionar("Coelho");
                    break;
                case 4:
                    itens.adicionar("Erva medicinal");
                    break;
            }
        }
    }

    //construtor personalizado
    //o que viabiliza a sua existência é a sobrecarga de construtores
    Personagem(int energia, int fome, int sono){
        if (energia >= 0 && energia <= 10)
            this.energia = energia;
        if (fome >= 0 && fome <= 10)
            this.fome = fome;
        if (sono >= 0 && sono <= 10)
            this.sono = sono;
    }

    void cacar(){
        if(energia <= 0) {
            System.out.printf("%s morreu... Fim de jogo!\n", nome);
            System.exit(0);
        }
        if(energia >= 2){
            System.out.printf("%s esta cacando...\n", nome);
            energia -= 2; // energia = energia - 2;
            Random random = new Random();
            String[] itensDisponiveis = {"Javali selvagem", "Amora", "Batata frita", "Coelho", "Erva medicinal"};
            itens.adicionar(itensDisponiveis[random.nextInt(5)]);
}
        else{
            System.out.printf("%s sem energia para cacar...\n", nome);
        }
        fome = Math.min(fome + 1, 10);
        sono = sono < 10 ? sono + 1 : sono;
    }

    void comer() {
        // se não houver itens, não é possível comer
        if (itens.tamanho() == 0) {
            System.out.printf("%s não tem itens para comer.\n", nome);
            return;
        }

        // come o último item da coleção
        String ultimoItem = itens.getElementos()[itens.tamanho() - 1];
        System.out.printf("%s come %s.\n", nome, ultimoItem);

        // remove o último item da coleção
        itens.removerNoFinal();

        // reduz o valor de fome em 1
        fome--;

        // aumenta o valor de energia em 1
        energia = Math.min(energia + 1, 10);
    }

    void dormir(){
        if(sono >= 1){
            System.out.printf("%s esta dormindo...\n", nome);
            sono -= 1;
            energia = Math.min(energia + 1, 10);
        }
        else{
            System.out.printf("%s sem sono...\n", nome);
        }
    }

    void atacar(Personagem outroPersonagem) {
        if (outroPersonagem.energia > 0) {
            outroPersonagem.energia--;
            System.out.printf("%s atacou %s e reduziu sua energia em 1 ponto.\n", nome, outroPersonagem.nome);
        } else {
            System.out.printf("%s atacou %s, mas ele já estava sem energia.\n", nome, outroPersonagem.nome);
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(nome).append(": (e:").append(energia).append(", f:").append(fome).append(", s:").append(sono).append(")\n");
        sb.append("Itens: ");
        for (int i= 0; i < itens.tamanho(); i++) {
            sb.append(itens.getElementos()[i]).append(" ");
        }
        return sb.toString();
    }
}