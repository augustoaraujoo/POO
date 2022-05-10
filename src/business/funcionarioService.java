package business;

public class funcionarioService {

    public boolean verificarSalario(double salario) {
        if (salario >= 20000) {
            return true;
        }
        return false;

    }

}
