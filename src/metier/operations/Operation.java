package metier.operations;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Operation {
    UUID numero;
    LocalDateTime date;
    double montant;
}