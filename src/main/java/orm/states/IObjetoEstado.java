package orm.states;
import orm.core.ObjetoPersistente;

public interface IObjetoEstado {
    boolean efetivar(ObjetoPersistente ob);
    boolean excluir(ObjetoPersistente ob);
    boolean retroceder(ObjetoPersistente ob);
    boolean salvar(ObjetoPersistente ob);
    TipoObjetoEstado tipo();
}