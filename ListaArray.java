public class ListaArray<T> implements Lista<T> {
    private int TAM;
    private T[] base;
    private int pos;        //sempre está na última posição do array
    private int cursor;

    public ListaArray() {
        TAM = 2;
        base = (T[]) (new Object[TAM]);
        pos = 0;
        reset();
    }

    @Override
    public void add(T dado) {
        if (pos == TAM) {
            int nTam = TAM * 2;
            T[] novaBase = (T[]) (new Object[nTam]);
            for (int i = 0; i < pos; i++) {
                novaBase[i] = base[i];
            }
            TAM = nTam;
            base = novaBase;
        }
        base[pos] = dado;
        pos++;
    }

    @Override
    public int size() {
        return pos;
    }

    @Override
    public T get(int i) {
        if (i < 0 || i >= pos) {
            throw new IndexOutOfBoundsException();
        }
        return base[i];
    }

    @Override
    public void reset() {
        cursor = 0;
    }

    @Override
    public T proximo() {
        T aux = base[cursor];   //pega o dado atual
        cursor++;               //incrementa o cursor
        return aux;             //retorna o dado atual
    }

    @Override
    public T corrente() {
        return base[cursor];
    }

    @Override
    public boolean temProximo() {
        return cursor < size();
    }

    //insere na posição posterior ao cursor
    @Override
	public void insere(T dado) {
        if(size() + 1 > TAM){                   //se a inserção for ultrapassar o tamanho do array..
            int nTam = TAM * 2;
            T[] novaBase = (T[]) (new Object[nTam]);
            for (int i = 0, j = 0; i < pos; i++, j++) {
                novaBase[i] = base[j];
                if(i == cursor){                
                    novaBase[i+1] = dado;       //adiciona uma posicao à frente do cursor
                    i++;
                    pos++;
                }                               //continua copiando
            }

            TAM = nTam;
            base = novaBase;

        } else {                                //se a inserção não for alterar o tamanho do array
            T[] aux = (T[]) (new Object[TAM]);
            for(int i = cursor+1, j = 0; i < pos; i++, j++){
                aux[j] = base[i];               //copia todos os elementos posteriores ao cursor para um array auxiliar            
            }

            base[cursor + 1] = dado;             //insere o elemento novo na posição posterior ao cursor
            pos++;

            for(int i = cursor + 2, j = 0; i < pos; i++, j++){  //copia de volta os elementos, uma posição adiante da original
                base[i] = aux[j];
            }
        }
	}

    //remove o elemento para o qual o cursor aponta
    @Override
    public void remove(){
        for (int i = cursor; i < pos; i++) {
            base[i] = base[i+1];
        }
    }

    @Override
    public void setCursor(int pos) {
        cursor = pos;
        
    }
}
