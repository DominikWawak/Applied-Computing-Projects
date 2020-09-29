import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * PartyList class
 * The responsibility for this class is to manage and preform calculations on all the parties.
 * It makes a arrayList of objects of type Party.
 *
 * @author Dominik Wawak
 * @version 1.0.0 (9.Mar.2020)
 */

public class PartyList {

    private ArrayList<Party> parties;

    /**
     * PartyList Constructor
     * creates an new arrayList of parties.
     */

    public PartyList() {
        this.parties = new ArrayList<>();

    }

    /**
     * Mutators.
     *
     * @return the arrayList
     */

    public ArrayList<Party> getPartyList() {
        return parties;
    }

    public void setParties(ArrayList<Party> parties) {
        this.parties = parties;
    }

    /**
     * addParty
     * Method that adds an object to the arrayList
     *
     * @param party of type Party object.
     */

    public void addParty(Party party) {
        parties.add(party);

    }

    /**
     * getParty.
     * Method that returns a specific party object at the specified index.
     *
     * @param index of type int specifies the index the object is stored in the arrayList
     * @return Party or null,  a Party Object if the index is valid, otherwise returns null
     */

    public Party getParty(int index) {
        if (Utilities.validIndex(index, parties))
            return parties.get(index);

        else {
            return null;

        }

    }

    /**
     * removeParty
     * Method that deletes a party if the index is valid.
     *
     * @param index of type int specifies the index the object is stored in the arrayList
     * @return boolean if the party was removed successfully it returns true , else it returns false.
     */

    public boolean removeParty(int index) {
        if (Utilities.validIndex(index, parties)) {
            parties.remove(index);
            return true;

        } else {
            return false;
        }
    }

    /**
     * numberOfParties
     *
     * @return the amount of party objects inside the parties arrayLisy.
     */

    public int numberOfParties() {
        return parties.size();

    }

    /**
     * listOfParties
     * The method lists all parties with their index number
     *
     * @return String , lists of all the parties.
     */

    public String listOfParties() {

        if (parties.size() != 0) {
            String listOfParties = "";
            for (int i = 0; i < parties.size(); i++) {
                listOfParties = listOfParties + i + ": " + parties.get(i) + "\n";
            }
            return listOfParties;
        } else {
            return "no parties";
        }

    }

    /**
     * listPartiesBySpecificGene
     * A method that tries to match a given genre with a party(or parties) with the same genre.
     *
     * @param genre of type String that is checked against the valid genres.
     * @return String listOfParties  in the form of a list containing all that parties with that genre.
     */

    public String listPartiesBySpecificGenre(String genre) {
        if (parties.size() != 0) {
            String listOfParties = "";
            for (int i = 0; i < parties.size(); i++) {
                if (Utilities.validGenre(genre).equals(parties.get(i).getPartyGenre())) {
                    listOfParties = listOfParties + i + ": " + parties.get(i) + "\n";
                }
            }
            return listOfParties;
        } else if (parties.size() > 0) {
            return "no party exists of the given name";
        } else {
            return "no parties exist";
        }
    }

    public Party largestParty() {
        int largestParty = 0;
        if (parties.size() != 0) {
            for (int i = 0; i < parties.size(); i++) {
                if (parties.get(i).getNumLocalReps() > parties.get(largestParty).getNumLocalReps()) {
                    largestParty = i;
                }
            }
            return parties.get(largestParty);

        } else {
            return null;
        }

    }

    /**
     * mostMEPs
     * A method that loops through two arrayLists to get at the noOfMEPsByParty method from the Country class.
     * The method then goes through each loop and gets the party with the largest number of MEPs.
     *
     * @param euCountries is the arrayList of Country objects.
     * @return Party object - largestPartySoFar ie. the prty with most MEPs.
     */

    public Party mostMEPs(ArrayList<Country> euCountries) {
        if (parties.size() > 0 && euCountries.size() > 0) {
            Party largestPartySoFar = parties.get(0);
            int largestSoFar = 0;

            for (Party party : parties) {
                int noMep = 0;
                for (Country country : euCountries) {
                    noMep = noMep + country.noOfMEPsByParty(party);

                    if (noMep > largestSoFar) {
                        largestPartySoFar = party;
                        largestSoFar = noMep;

                    }
                }

            }
            return largestPartySoFar;
        } else {
            return null;
        }


    }


    @Override
    public String toString() {
        return "PartyList{" +
                "parties=" + parties +
                '}';
    }
}
