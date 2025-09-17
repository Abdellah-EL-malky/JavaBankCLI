package metier.operations;

import java.time.LocalDateTime;
import java.util.UUID;

public class Versement extends Operation{
    protected String source;

    public Versement(double montant, String source) {
        super(UUID.randomUUID(), LocalDateTime.now(), montant);
        this.source = source;
    }
}