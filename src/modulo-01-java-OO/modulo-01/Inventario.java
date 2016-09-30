import java.util.ArrayList;

public class Inventario {
    private ArrayList<Item> itens;

    public Inventario() {
        itens = new ArrayList<>();
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void removerItem(Item item) {
        itens.remove(item);
    }

    public String getDescricoesItens() {
        //"Adaga,Escudo,Bracelete"
        String resultado = "";

        /*for (int i = 0; i < itens.size(); i++) {
        Item itemAtual = itens.get(i);
        resultado += String.format("%s,", itemAtual.getDescricao());
        }*/

        /*int i = 0;
        while (i < itens.size()) {
        Item itemAtual = itens.get(i);
        resultado += String.format("%s,", itemAtual.getDescricao());
        i++;
        }*/

        /*int i = 0;
        do {
        Item itemAtual = itens.get(i);
        resultado += String.format("%s,", itemAtual.getDescricao());
        i++;
        } while (i < itens.size());*/

        for (Item itemAtual : itens) {
            resultado += String.format("%s,", itemAtual.getDescricao());
        }

        return resultado.isEmpty() ? resultado : resultado.substring(0, resultado.length() - 1);
    }
    
    public void aumentarUnidadesDosItens(int unidades) {
        for (Item item : itens) {
            item.aumentarUnidades(unidades);
        }
    }
    
    public Item getItemComMaiorQuantidade() {
        // maiorAteAgora = 0
        // percorro todos os itens verificando se existe alguém maior que o até agora
        // caso existir, atualiza a variável
        // retorna no final
        int indice = 0, maiorQtdAteAgora = 0;
        
        for (int i = 0; i < itens.size(); i++) {
            int qtdAtual = itens.get(i).getQuantidade();
            if (qtdAtual > maiorQtdAteAgora) {
                maiorQtdAteAgora = qtdAtual;
                indice = i;
            }
        }
        
        boolean temItens = !itens.isEmpty();
        return temItens ? itens.get(indice) : null;
    }
}
