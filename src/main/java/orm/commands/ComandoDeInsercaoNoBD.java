package orm.commands;
import orm.core.ObjetoPersistente;
import orm.states.TipoObjetoEstado;

public class ComandoDeInsercaoNoBD extends ComandoDeBDAdapter {
    public ComandoDeInsercaoNoBD(ObjetoPersistente ob) {
        super(ob);
    }
    
    @Override
    public boolean executar() {
        return objeto.efetivar();
    }
}