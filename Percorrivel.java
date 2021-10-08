public interface Percorrivel<T> {
    void reset();
    T proximo();
    T corrente();
    void remove();        //remove o dado corrente (da posicao do cursor)
    void insere(T dado);    //insere um dado logo após o elemento corrente (posição do cursor)
    boolean temProximo();
}
