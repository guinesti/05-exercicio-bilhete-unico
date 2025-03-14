import java.util.Random;

public class Ticket {
    static final double TARIFF = 5.20;
    long number;
    double balance;
    User user;

    public Ticket (User user) {
        number = generateNumber();
        this.user = user;
    }

    public long generateNumber () {
        Random rd = new Random();
        return rd.nextLong(1000, 10000);
    }

    // método para carregar o bilhete
    public void refillTicket (double amount) {
        balance += amount;
    }

    // método para consultar o saldo do bilhete
    public double checkBalance () {
        return balance;
    }
    // método para passar na catraca
    public String passTheTurnstile () {
        double debit = TARIFF / 2;
        if (user.profile.equalsIgnoreCase("comum")) {
            debit = TARIFF;
        }
        if (balance >= debit) {
            balance -= debit;
            return "Catraca liberada";
        }
        return "Sem Saldo";
    }

}
