package jana60;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Vacanza {
    private final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private String destinazione;
    private String dataInizio;
    private String dataFine;


    //constructor
    public Vacanza(String destinazione, String dataInizio, String dataFine)
            throws IllegalArgumentException,DateTimeParseException {
        validDest(destinazione);
        validInizio(dataInizio);
        validFine(dataFine , dataInizio);
        this.destinazione = destinazione;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;

    }

    //getter/setter

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) throws IllegalArgumentException {
        validDest(destinazione);
        this.destinazione = destinazione;
    }

    public String getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(String dataInizio) throws IllegalArgumentException, DateTimeParseException {
        validInizio(dataInizio);
        this.dataInizio = dataInizio;
    }

    public String getDataFine() {
        return dataFine;
    }

    public void setDataFine(String dataFine) throws IllegalArgumentException,DateTimeParseException {
        validFine(dataFine,dataInizio);
        this.dataFine = dataFine;
    }

    //validator
    private void validInizio (String dataInizio)
            throws IllegalArgumentException, DateTimeParseException {
        LocalDate today = LocalDate.now();
        if (dataInizio==null)
            throw new IllegalArgumentException("Il campo data inizio non può essere vuoto");
        if (LocalDate.parse(dataInizio, format).isBefore(today))
            throw new IllegalArgumentException("La data di partenza non può essere nel passato");
    }
    private void validFine (String dataFine , String dataInizio)
            throws IllegalArgumentException,DateTimeParseException {
        if (dataFine==null)
            throw new IllegalArgumentException("Il campo data fine non può essere vuoto");
        if (LocalDate.parse(dataFine, format).isBefore(LocalDate.parse(dataInizio, format)))
            throw new IllegalArgumentException("La data di ritorno non può essere prima di quella di partenza");
    }
    private void validDest (String destinazione) throws IllegalArgumentException {
        if (destinazione.equals("")) // non serve il null perchè equals ritorna false in caso di null
            throw new IllegalArgumentException("Il campo destinazione non può essere vuoto");
    }
    //altri

    @Override
    public String toString() {
        return "Programmata vacanza a "+destinazione+" con partenza il "+dataInizio+" e ritorno il "+dataFine;
    }
}

