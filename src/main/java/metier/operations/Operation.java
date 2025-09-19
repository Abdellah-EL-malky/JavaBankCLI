package metier.operations;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Operation {
    protected UUID numero;
    protected LocalDateTime date;
    protected double montant;

    public Operation(UUID numero, LocalDateTime date, double montant){
        this.numero = numero;
        this.date = date;
        this.montant = montant;
    }
}