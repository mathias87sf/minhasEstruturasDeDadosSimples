public class ListaLigada<T> implements Lista<T> {
    
    class Nodo<D>{
        public D dado;
        public Nodo<D> ante;
        public Nodo<D> prox;

        public Nodo(D dado){
            this.dado = dado;
            this.prox = null;
            this.ante = null;
        }
    }

    private Nodo<T> prim;
    private Nodo<T> ult;
    private Nodo<T> cursor;
    private int size;

    public ListaLigada(){
        prim = null;
        ult = null;
        cursor = null;
        size = 0;
    }

    @Override
    public void add(T dado) {
        Nodo<T> novo = new Nodo<>(dado);  
        if (prim == null){      //se a lista está vazia
            prim = novo;        //adiciona na 1a posicao
            ult = novo;         //ult aponta para o ultimo elemento (que também é o primeiro, no caso)
        
        }else{                  //se a lista não está vazia
            novo.ante = ult;    //novo elemento aponta para o seu anterior, que era o ultimo elemento 
            ult.prox = novo;    //adiciona na posição posterior ao ultimo elemento
            ult = novo;         //ult passa a apontar para o ultimo elemento
        }
        size++;                  //aumenta o tamanho da lista
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int i) {
        if (i >= size){
            throw new IndexOutOfBoundsException();
        }

        Nodo<T> aux = prim;
        int p = 0;

        while(p<i){
            aux = aux.prox;     //vai iterando de prox em prox até p chegar à posição i
            p++;
        }
        return aux.dado;        //aux vai estar na posição correta e retornará o dado do Nodo que está nessa posição
    }

    @Override
    public void reset() {
        cursor = prim;     
    }

    @Override
    public T proximo() {
        T aux = cursor.dado;    //pega o dado atual
        cursor = cursor.prox;   //incrementa o cursor
        return aux;             //retorna o dado atual
    }

    @Override
    public T corrente() {
        return cursor.dado;
    }

    @Override
    public boolean temProximo() {
        return cursor != null;
    }

    //insere na posição após o cursor
	@Override
	public void insere(T dado) {
        if(cursor == null) reset();
        //if(cursor == null) throw new NullPointerException("Cursor aponta para null");

        Nodo<T> novo = new Nodo<>(dado);
        novo.ante = cursor;             //anterior ao novo elemento é o elemento para o qual o cursor aponta (insere após cursor)
        novo.prox = cursor.prox;        //próximo do novo elemento é o próximo do elemento antigo
        cursor.prox.ante = novo;        //anterior do próximo elemento ao elemento antigo é o novo elemento
        cursor.prox = novo;             //proximo elemento do elemento antigo é o novo elemento
        size++;                         //aumenta o tamanho da lista
	}

    @Override
    public void remove() {
        if(cursor == null) reset();
        //if(cursor == null) throw new NullPointerException("Cursor aponta para null");

        cursor.ante.prox = cursor.prox;     //elemento anterior ao cursor deixa de apontar para ele e aponta para o elemento seguinte ao cursor
        cursor.prox.ante = cursor.ante;     //proximo elemento ao cursor deixa de apontar para ele e aponta para o elemento anterior ao cursor
        
        cursor = cursor.ante;               //cursor passa a apontar para o elemento anterior
    } 
    
    public void setCursor(int pos){
        cursor = prim;
        for (int i = 0; i < pos; i++) {
            cursor = cursor.prox;
        }
    }
}
