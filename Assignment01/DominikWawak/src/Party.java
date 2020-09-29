

/**
 * Party Class
 * The responsibility for this class is to manage a single Party.
 *
 * @author Dominik Wawak
 * @version 1.0.0 (9.Mar.2020)
 */


public class Party {


    private String partyName;
    private String partyLeader;
    private String partyGenre;
    private int numLocalReps;

    /**
     * Party Constructor
     * <p>
     * validation provided by the Utilities Class
     *
     * @param partyName    of type String with validation of max 30 letters.
     * @param partyLeader  of type String with validation of max 30 letters.
     * @param partyGenre   of type String has to be a valid Genre of a set of Genres.
     * @param numLocalReps of type int has to be a positive number.
     */


    public Party(String partyName, String partyLeader, String partyGenre, int numLocalReps) {


        this.partyName = Utilities.max30Chars(partyName);

        this.partyLeader = Utilities.max30Chars(partyLeader);

        this.partyGenre = Utilities.validGenre(partyGenre);

        if (Utilities.validIntNonNegative(numLocalReps))
            this.numLocalReps = numLocalReps;


    }

    /**
     * Mutators
     * Used to access the fields of the Party Class.
     * Validation made by the Utilities Class.
     */


    public void setNumLocalReps(int numLocalReps) {
        if (Utilities.validIntNonNegative(numLocalReps))
            this.numLocalReps = numLocalReps;
    }

    public void setPartyGenre(String partyGenre) {
        if (partyGenre.toUpperCase().equals(Utilities.validGenre(partyGenre))) {
            this.partyGenre = Utilities.validGenre(partyGenre);
        }
    }

    public void setPartyLeader(String partyLeader) {
        this.partyLeader = Utilities.max30Chars(partyLeader);
    }

    public void setPartyName(String partyName) {

        this.partyName = Utilities.max30Chars(partyName);
    }


    public int getNumLocalReps() {
        return numLocalReps;
    }

    public String getPartyGenre() {
        return partyGenre;
    }

    public String getPartyLeader() {
        return partyLeader;
    }

    public String getPartyName() {
        return partyName;
    }


    public String toString() {
        return "Party{" +
                "partyName='" + partyName + '\'' +
                ", partyLeader='" + partyLeader + '\'' +
                ", partyGenre='" + partyGenre + '\'' +
                ", numLocalReps=" + numLocalReps +
                '}';
    }
}
