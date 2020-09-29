import java.util.ArrayList;

/**
 * Country class
 * The responsibility for this class is to manage a single country.
 *
 * @author Dominik Wawak
 * @version 1.0.0 (9.Mar.2020)
 */
public class Country {


    private String name;
    private ArrayList<Mep> meps;
    private int noMEPs;

    /**
     * Country Constructor
     * Used to make the country object
     *
     * @param name   is of type String
     *               It stores the name of the country if it is valid, has less than 30 chars.
     * @param noMEPs is of type int
     *               It stores the max number of meps a country is allowed to store, it has to be a positive number.
     * @return Country object.
     */

    public Country(String name, int noMEPs) {
        this.meps = new ArrayList<>();
        this.name = Utilities.max30Chars(name);
        if (Utilities.validIntNonNegative(noMEPs))
            this.noMEPs = noMEPs;

    }

    /**
     * Mutators with validation from the Utilities class.
     * used to access the fields of the Country class
     */


    public void setMeps(ArrayList<Mep> meps) {
        this.meps = meps;
    }

    public void setName(String name) {

        this.name = Utilities.max30Chars(name);
    }

    public void setNoMEPs(int noMEPs) {
        if (Utilities.validIntNonNegative(noMEPs))
            this.noMEPs = noMEPs;
    }

    public int getNoMEPs() {
        return noMEPs;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Mep> getMeps() {
        return meps;
    }

    public Mep getMEP(int i) {
        if (meps.size() > 0) {
            return meps.get(i);
        } else {
            return null;
        }
    }

    /**
     * addMEP
     * The method checks if the max number of meps hasn't been exceeded.
     * Then adds the mep to the arraylist of meps
     *
     * @param mep a MEP object that will be added to the arrayList.
     */


    public void addMEP(Mep mep) {
        if (meps.size() < noMEPs)
            meps.add(mep);
    }

    /**
     * removeMEP
     * deletes and mep from the arrayList.
     *
     * @param i of type int represents the index of an Mep object in the arrayList.
     * @return boolean if the index is valid the method will remove the mep at tht index from the arrayList.
     * and return true, false otherwise.
     */
    public boolean removeMEP(int i) {
        if (Utilities.validIndex(i, meps)) {
            meps.remove(i);
            return true;
        } else {
            return false;
        }
    }

    /**
     * numberOfMEPs
     * Returns the size of mep arrayList as an int.
     *
     * @return int which is the size of the mep arrayList.
     */

    public int numberOfMEPs() {
        return meps.size();
    }

    /**
     * listOfMEPs
     * Lists all the meps in the ArrayList
     *
     * @return String , which is a list of meps.
     */
    public String listOfMEPs() {
        if (meps.size() != 0) {
            String listOfMEPs = "";
            for (int i = 0; i < meps.size(); i++) {
                listOfMEPs = listOfMEPs + i + ": " + meps.get(i) + "\n";
            }
            return listOfMEPs;
        } else {
            return "no meps";
        }
    }

    /**
     * listOfMEPsByParty
     * <p>
     * This method returns a list of meps in a specific party provided as a parameter.
     *
     * @param party, is a party object.
     * @return String , which is a list of the meps in the given party.
     */
    public String listOfMEPsByParty(Party party) {
        if (meps.size() > 0) {

            String list = "";
            for (int i = 0; i < meps.size(); i++) {

                if (meps.get(i).getMEPParty().getPartyName().equals(party.getPartyName())) {
                    list = list + meps.get(i) + "\n";

                }
            }
            return list;

        } else {
            return null;
        }
    }

    /**
     * noOfMEPsByParty
     * <p>
     * The method calculates the number of meps in a given party
     *
     * @param party is a Party object
     * @return int which is the calculated number of meps in the party.
     */


    public int noOfMEPsByParty(Party party) {
        int noMEP = 0;
        for (int i = 0; i < meps.size(); i++) {
            //weird bug with .equals
            if (meps.get(i).getMEPParty().getPartyName().equals(party.getPartyName())) {
                noMEP++;
            }

        }
        return noMEP;
    }


    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", meps=" + meps +
                ", noMEPs=" + noMEPs +
                '}';
    }
}
