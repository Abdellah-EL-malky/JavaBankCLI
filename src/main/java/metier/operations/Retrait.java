package metier.operations;

import java.time.LocalDateTime;
import java.util.UUID;

public class Retrait extends Operation{
    protected String destination;

    public Retrait( double montant, String destination){
        super(UUID.randomUUID(), LocalDateTime.now(), montant);
        this.destination = destination;
    }
}