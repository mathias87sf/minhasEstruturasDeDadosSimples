
public class App {
    public static void main(String[] args) throws Exception {
        //Lista<Pessoa> lstp = new ListaArray<>();
        Lista<Pessoa> lstp = new ListaLigada<>();

        lstp.add(new Pessoa("Maria",20));
        lstp.add(new Pessoa("Jorge",22));
        lstp.add(new Pessoa("Lucas",18));
        lstp.add(new Pessoa("Silvia",34));

        lstp.setCursor(1);
        lstp.insere(new Pessoa("Mathias", 34));
        

        /*
        for(int i=0;i<lstp.size();i++){
            System.out.println(lstp.get(i));
        }
        */
        
        
        lstp.reset();
        while(lstp.temProximo()){
            System.out.println(lstp.proximo());
        }
        
        System.out.println("---------------");
        lstp.setCursor(2);
        System.out.println(lstp.corrente());
        lstp.remove();

        System.out.println("---------------");

        lstp.reset();
        while(lstp.temProximo()){
            System.out.println(lstp.proximo());
        }

        
        //System.out.println();
        
        /*
        System.out.println("---------------");
        lstp.reset();   //cursor = 0
        lstp.proximo(); //cursor = 1
        lstp.proximo(); //cursor = 2
        lstp.remove(); //remove posicao 2
        lstp.reset();
        while(lstp.temProximo()){
            System.out.println(lstp.proximo());
        }
        */
    }
}
