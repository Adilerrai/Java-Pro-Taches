import java.time.LocalDate;

public class Transaction {
    private int Id;
    private LocalDate Date;
    private TypeTransaction Type;
    private double Montant;



    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public TypeTransaction getType() {
        return Type;
    }

    public void setType(TypeTransaction type) {
        Type = type;
    }

    public double getMontant() {
        return Montant;
    }

    public void setMontant(double montant) {
        Montant = montant;
    }

    public Transaction(int id, LocalDate date, TypeTransaction type, double montant) {
        Id = id;
        Date = date;
        Type = type;
        Montant = montant;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "Date=" + Date +
                ", Type=" + Type +
                ", Montant=" + Montant +
                '}';
    }
}
