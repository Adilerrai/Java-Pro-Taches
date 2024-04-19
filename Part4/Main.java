import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        Transaction transaction1 = new Transaction(1, LocalDate.now(), TypeTransaction.Retrait, 1000.00);
        Transaction transaction2 = new Transaction(2, LocalDate.now(), TypeTransaction.Depot, 500.00);
        Transaction transaction3 = new Transaction(3, LocalDate.now(), TypeTransaction.Virement, 200.00);
        Transaction transaction4 = new Transaction(4, LocalDate.now(), TypeTransaction.Paiement, 300.00);
        Transaction transaction5 = new Transaction(5, LocalDate.now(), TypeTransaction.Retrait, 400.00);
        Transaction transaction6 = new Transaction(6, LocalDate.now(), TypeTransaction.Depot, 700.00);
        Transaction transaction7 = new Transaction(7, LocalDate.now(), TypeTransaction.Virement, 800.00);
        Transaction transaction8 = new Transaction(8, LocalDate.now(), TypeTransaction.Paiement, 900.00);
        Transaction transaction9 = new Transaction(9, LocalDate.now(), TypeTransaction.Retrait, 100.00);
        Transaction transaction10 = new Transaction(10, LocalDate.now(), TypeTransaction.Depot, 200.00);
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        transactions.add(transaction4);
        transactions.add(transaction5);
        transactions.add(transaction6);
        transactions.add(transaction7);
        transactions.add(transaction8);
        transactions.add(transaction9);
        transactions.add(transaction10);
        Double TotalRetrait = transactions.stream().filter(t -> t.getType() == TypeTransaction.Retrait).mapToDouble(Transaction::getMontant).sum();
        Double TotalDepot = transactions.stream().filter(t -> t.getType() == TypeTransaction.Depot).mapToDouble(Transaction::getMontant).sum();
        Double TotalVirement = transactions.stream().filter(t -> t.getType() == TypeTransaction.Virement).mapToDouble(Transaction::getMontant).sum();
        System.out.println("Total des retraits:" + TotalRetrait);
        System.out.println("Total des depots:" + TotalDepot);
        System.out.println("Total des virements:" + TotalVirement);
//        System.out.println("Liste des transactions:" + transactions);

    }
}
