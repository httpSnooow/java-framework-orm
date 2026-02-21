package orm.mappers;
import orm.core.Oid;
import orm.core.ObjetoPersistente;

public interface IMapeador {
    boolean inserir(Object obj);
    boolean atualizar(Object obj);
    boolean excluir(Object obj);
    Object obter(Oid oid);
    void recarregar(ObjetoPersistente obj);
}