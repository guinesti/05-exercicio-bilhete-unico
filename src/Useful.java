import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class Useful {

    private Ticket[] ticket = new Ticket[5];
    private int index = 0;

    public void mainMenu () {
        String aux = "Escolha uma opção\n";
        aux += "1. Emitir bilhete\n";
        aux += "2. Carregar bilhete\n";
        aux += "3. Consultar bilhete\n";
        aux += "4. Passar na Catraca\n";
        aux += "5. Finalizar\n";
        int option;

        while (true) {
            option = parseInt(showInputDialog(aux));
            if (option == 5) {
                break;
            }
            if (option < 1 || option > 5) {
                showMessageDialog(null, "Opção inválida");
            }
            else {
                switch (option) {
                    case 1:
                        emitTicket ();
                        break;
                }
            }
        }

        public void emitTicket () {
            String name = showInputDialog("Nome");
            String profile = showInputDialog("Perfil --> comum ou estudante ou professor");
            long cpf = parseLong(showInputDialog("CPF"));
            User user = new User(name, profile, cpf);
            ticket[index] = new Ticket(user);
            index++;
        }
    }
}
