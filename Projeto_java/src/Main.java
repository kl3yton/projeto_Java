import Model.Colaborador;

public class Main {
    public static void main(String[] args) {
        Colaborador colaborador1 = new Colaborador(1, "Ana silva", "ana@gmail.com");

        System.out.println("ID: " + colaborador1.getId());
        System.out.println("Nome: " + colaborador1.getNome());
        System.out.println("E-mail: " + colaborador1.getEmail());

        colaborador1.setNome("ana souza");

        System.out.println("\n Dados atualizados");
        System.out.println("Nome: " + colaborador1.getNome());
        System.out.println("Email: " + colaborador1.getEmail());

    }      
}