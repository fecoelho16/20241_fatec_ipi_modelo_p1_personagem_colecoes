import java.util.Arrays;

public class VetorDinamico<T> {
    //variáveis de instância
    private int qtde;
    private int cap;
    private T[] elementos;

    //variável de classe
    private static final int CAP_MINIMA = 4;

    //construtor
    VetorDinamico(){
        cap = CAP_MINIMA;
        qtde = 0;
        elementos = (T[]) new Object[cap];
    }

    VetorDinamico(int capMinima){
        double aux = capMinima;
        while (aux >= 2)
            aux /= 2;
        cap = aux == 1 && capMinima > 3 ? capMinima : CAP_MINIMA;
    }

    //método adicionar
    void adicionar(T elemento){
        //se estiver cheio, redimensionar antes de adicionar
        if(estaCheio()) redimensionar();
        elementos[qtde] = elemento;
        qtde++;
    }

    //método redimensionar
    private void redimensionar(){
        //alocar um vetor com o dobro da capacidade atual chamado auxiliar
        T[] aux = (T[]) new Object[cap * 2];

        //copiar todo mundo do vetor elementos para o vetor auxiliar
        for(int i = 0; i < cap; i++){
            aux[i] = elementos[i];
        }

        //ajustar a capacidade para que ela tenha o valor novo, dobrado
        cap *= 2;

        //ajustar o ponteiro elementos para que ele aponte para o novo vetor
        elementos = aux;
    }

    //método estaCheio
    boolean estaCheio(){
        //decidir se o vetor está cheio ou não olhando para cap e qtde
        if(qtde == cap)
            return true;
        return false;
    }

    //método tamanho
    int tamanho(){
        return qtde;
    }

    //método getElementos
    T[] getElementos(){
        return Arrays.copyOf(elementos, cap);
    }

    //método removerNoFinal
    void removerNoFinal(){
        if(qtde > 0)
            qtde--;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Qtde: ").append(qtde).append("\n");
        sb.append("Cap: ").append(cap).append("\n");
        sb.append("Elementos: ");
        for (int i = 0; i < qtde; i++){
            sb.append(elementos[i]).append(" ");
        }
        return sb.toString();
    }
}