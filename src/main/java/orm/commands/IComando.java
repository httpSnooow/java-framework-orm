package orm.commands;

public interface IComando {
    boolean executar();
    boolean desfazer();
}