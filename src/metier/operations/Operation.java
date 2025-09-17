package metier.operations;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Operation {
    protected UUID numero;
    protected LocalDateTime date;
    protected double montant;
}