package Lecture_3.Service;

import Lecture_3.Model.Conta;
import Lecture_3.Repository.ContaRepository;
import Lecture_3.Utils.Criptografia;

public class DefinirSenha {

    public Conta execute(Conta conta, String senha) {
        ContaRepository repository = new ContaRepository();
        conta.setSenha(Criptografia.criptografar(senha));
        return repository.update(conta);
    }

}
