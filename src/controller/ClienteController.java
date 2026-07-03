package controller;

import model.Cliente;
import repository.ClienteRepository;
import java.util.List;

public class ClienteController {

    private ClienteRepository repository;

    public ClienteController() {
        repository = new ClienteRepository();
    }

    public void cadastrar(int codigo,
                          String nome,
                          String telefone) {

        Cliente cliente =
                new Cliente(codigo, nome, telefone);

        repository.salvar(cliente);
    }

    public List<Cliente> listar() {
        return repository.listar();
    }

    public Cliente buscar(int codigo) {
        return repository.buscarPorCodigo(codigo);
    }

    public boolean alterar(int codigo,
                           String nome,
                           String telefone) {

        Cliente cliente =
                repository.buscarPorCodigo(codigo);

        if (cliente == null) {
            return false;
        }

        cliente.setNome(nome);
        cliente.setTelefone(telefone);

        return true;
    }

    public boolean excluir(int codigo) {

        Cliente cliente =
                repository.buscarPorCodigo(codigo);

        if (cliente == null) {
            return false;
        }

        repository.remover(cliente);

        return true;
    }
}
