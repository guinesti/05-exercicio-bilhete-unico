import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;

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
                        emitTicket();
                        break;

                    case 2:
                        refillTicket();
                        break;

                    case 3:
                        checkBalance();
                        break;

                    case 4:
                        passTheTurnstile ();
                        break;
                }
            }
        }
    }

    public void passTheTurnstile () {
        int position = search();
        if (position != -1) {
            showMessageDialog(null, ticket[position].passTheTurnstile());
        }
    }

    public void emitTicket () {
        if (index < ticket.length) {
            String name = showInputDialog("Nome");
            String profile = showInputDialog("Perfil --> comum ou estudante ou professor");
            long cpf = parseLong(showInputDialog("CPF"));
            User user = new User(name, profile, cpf);
            ticket[index] = new Ticket(user); index++;
        }
        else {
            showMessageDialog(null, "Bilhete não emitido");
        }
    }

    public void checkBalance () {
        int position = search();
        if (position == -1) {
            showMessageDialog(null,"CPF não encontrado");
        }
        else {
            showMessageDialog(null, ticket[position].checkBalance());
        }
    }

    public int search () {
        int position = -1;
        long cpf = parseLong(showInputDialog("CPF para pesquisa"));
        for (int i = 0; i < index; i++) {
            if (ticket[i].user.cpf == cpf) {
                return i;
            }
        }
        return -1;
    }

    public void refillTicket () {
        int position = search();
        double amount;
        if (position != -1) {
            amount = parseDouble(showInputDialog("Valor para carregar o bilhete"));
            ticket[position].refillTicket(amount);
        }
        else {
            showMessageDialog(null,"CPF não encontrado");
        }
    }
}
