import java.util.ArrayList;


/**
 * Mep class
 * The responsibility for this class is to manage a single Mep.
 *
 * @author Dominik Wawak
 * @version 1.0.0 (9.Mar.2020)
 */

public class Mep {
    private String MEPName;
    private String MEPEmail;
    private String MEPPhone;
    private Party MEPParty;

    /**
     * Mep Constructor
     * Used to make mep an object
     * Validation provided by the Utilities class.
     *
     * @param MEPName   of type String with validation up to 30 letters.
     * @param MEPEmail  of type String with validation that it must contain an '@' and '.'.
     * @param MEPPhone  of type int with validation that it must be numbers only.
     * @param MEPParty  of type Party it has to be a valid party from the partyList.
     * @param partyList pf type PartyList which stores all the parties, used for validation.
     */



    public Mep(String MEPName, String MEPEmail, String MEPPhone, Party MEPParty, PartyList partyList) {

        this.MEPName = Utilities.max30Chars(MEPName);

        if (Utilities.validEmail(MEPEmail)) {
            this.MEPEmail = MEPEmail.toLowerCase();
        }

        if (Utilities.onlyContainsNumbers(MEPPhone)) {
            this.MEPPhone = MEPPhone.toLowerCase();
        }
        if (Utilities.validParty(MEPParty.getPartyName(), partyList) == MEPParty)
            this.MEPParty = MEPParty;
        //else{this.MEPParty = null;}

    }


    /**
     * Mutators
     * used to access the fields of the Mep class
     * With validation from Utilities Class
     */

    public String getMEPName() {
        return MEPName;

    }

    public String getMEPEmail() {
        return MEPEmail;

    }

    public String getMEPPhone() {
        return MEPPhone;

    }

    public Party getMEPParty() {
        return MEPParty;
    }


    public void setMEPName(String MEPName) {
        this.MEPName = Utilities.max30Chars(MEPName);
    }

    public void setMEPEmail(String MEPEmail) {
        if (Utilities.validEmail(MEPEmail)) {
            this.MEPEmail = MEPEmail;
        }
    }

    public void setMEPPhone(String MEPPhone) {

        if (Utilities.onlyContainsNumbers(MEPPhone)) {
            this.MEPPhone = MEPPhone;
        }
    }

    /**
     * setMEPParty
     * Method firstly needs to check if the entered party name is valid.
     *
     * @param party     of type String its the name of the party what will be set.
     * @param partyList used to check if the party exists and a mep can be set to it.
     */

    public void setMEPParty(String party, PartyList partyList) {
        Party newParty = partyList.getParty(0);
        for (int i = 0; i < partyList.getPartyList().size(); i++) {

            if (partyList.getParty(i).getPartyName() == party) {
                newParty = partyList.getParty(i);
                this.MEPParty = newParty;
            }
            //Doesn't change
            else {
                this.MEPParty = MEPParty;
            }

        }
    }

    @Override
    public String toString() {
        return "MEP{" +
                "MEPName='" + MEPName + '\'' +
                ", MEPEmail='" + MEPEmail + '\'' +
                ", MEPPhone='" + MEPPhone + '\'' +
                ", MEPParty='" + MEPParty + '\'' +
                '}';
    }
}
