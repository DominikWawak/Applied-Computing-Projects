import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * EuDriver class
 * Manager for all the classes.
 * Is responsible for displaying a menu to the user and
 * letting the user choose a option and preform operation on the given classes.
 *
 * @author Dominik Wawak
 * @version 1.0.0 (9.Mar.2020)
 */

public class EUDriver {
    private Scanner input = new Scanner(System.in);
    private ArrayList<Country> euCountries;
    private PartyList partyList;

    public ArrayList<Country> getEuCountries() {
        return euCountries;
    }

    public void setEuCountries(ArrayList<Country> euCountries) {
        this.euCountries = euCountries;
    }

    public PartyList getPartyList() {
        return partyList;
    }

    public void setPartyList(PartyList partyList) {
        this.partyList = partyList;
    }


    public EUDriver() {
        euCountries = new ArrayList<Country>();
        partyList = new PartyList();

        runMenu();
    }

    public EUDriver(int i) {
        euCountries = new ArrayList<Country>();
    }

    public static void main(String[] args) {
        new EUDriver();
    }

    private int mainMenu() {
        System.out.println("EU Menu");
        System.out.println("---------");
        System.out.println("  1) Add a country to EU");
        System.out.println("  2) Remove a country from the EU");
        System.out.println("  3) Update an EU country's information");
        System.out.println("  4) List all the EU Countries");
        System.out.println("  --------------------");
        System.out.println("Country Menu");
        System.out.println("  5) Add a MEP");
        System.out.println("  6) Remove a MEP");
        System.out.println("  7) Update the information on a MEP");
        System.out.println("  8) List all MEP's in this country");
        System.out.println("  --------------------");
        System.out.println("Party Menu");
        System.out.println("  9) Add a New party");
        System.out.println("  10) Remove a Party");
        System.out.println("  11) Update the Party information");
        System.out.println("  12) List all parties");
        System.out.println("  --------------------");
        System.out.println("Report Menu");
        System.out.println("  13) Print all the parties in the EU");
        System.out.println("  14) Calculate and print the party with most local Representatives");
        System.out.println("  15) Calculate and print the party with the most MEP's");
        System.out.println("  16) List all parties of a given Genre");
        System.out.println("  17) List all MEP's of a given party");
        System.out.println("  18) Calculate and print the number of MEP's in given party");
        System.out.println("  --------------------");
        System.out.println("  20) Save to XML");
        System.out.println("  21) Load from XML");
        System.out.println("  --------------------");
        System.out.println("  0) Exit");


        return ScannerInput.readNextInt("==>");

    }

    private void runMenu() {
        int option = mainMenu();
        while (option != 0) {

            switch (option) {
                case 1:
                    addCountry();
                    break;
                case 2:
                    deleteCountry();
                    break;
                case 3:

                    updateCountry();

                    break;
                case 4:
                    System.out.println(listCountries());

                    break;
                case 5:
                    addMEP();

                    break;
                case 6:
                    deleteMEP();

                    break;
                case 7:
                    updateMEP();

                    break;
                case 8:
                    listMEPSOfCountry();

                    break;
                case 9:
                    addNewParty();

                    break;
                case 10:
                    deleteParty();

                    break;
                case 11:
                    updateParty();

                    break;
                case 12:
                    System.out.println(listOfParties());

                    break;
                case 13:
                    System.out.println(listOfParties());

                    break;
                case 14:
                    System.out.println(largestParty());

                    break;
                case 15:
                    System.out.println(mostMEPs());


                    break;
                case 16:
                    System.out.println(listPartyByGenre());


                    break;
                case 17:
                    System.out.println(listMEPsbyPartyName());

                    break;
                case 18:
                    System.out.println(noMEPSByParty());

                    break;
                case 20:
                    try {
                        saveCountries();
                        savePartyList();
                    } catch (Exception e) {
                        System.err.println("Error writing to file: " + e);
                    }
                    break;
                case 21:
                    try {
                        loadCountries();
                        loadPartyList();
                    } catch (Exception e) {
                        System.err.println("Error reading from file: " + e);
                    }
                    break;

                default:
                    System.out.println("Invalid option entered: " + option);
                    break;
            }


            //pause
            //System.out.println("\nPress any key to continue...");

            String empty = ScannerInput.readNextString("\nPress any key to continue...");


            //display the main menu again
            option = mainMenu();
        }

        //option 0
        System.out.println("Exiting... bye");
        System.exit(0);
    }

    private void addCountry() {
        String countryName = ScannerInput.readNextString("Enter Country name ==> ");


        int numberOfSeats = ScannerInput.readNextInt("Enter number of seats ==> ");

        System.out.println("The country has been added successfully");


        euCountries.add(new Country(countryName, numberOfSeats));


    }

    private void deleteCountry() {

        if (euCountries.size() > 0) {

            System.out.println(listCountries());

            int index = ScannerInput.readNextInt("Please choose a country to delete ==> ");
            if (index <= euCountries.size()) {
                euCountries.remove(index);
                System.out.println("Country has been deleted");
            } else {
                System.out.println("There is no Country for this index number");
            }
        } else {
            System.out.println("There are no countries");
        }

    }

    private void updateCountry() {

        if (euCountries.size() > 0) {

            System.out.println(listCountries());

            int index = ScannerInput.readNextInt("Please choose a country to update ==> ");
            if (index <= euCountries.size()) {

                int numOfSeats = ScannerInput.readNextInt("You can now enter the number of mep's for this country ==> ");
                Country country = euCountries.get(index);
                country.setNoMEPs(numOfSeats);
                System.out.println("Country has been updated");
            } else {
                System.out.println("This country is not recognised");
            }
        } else {
            System.out.println("There are no countries");
        }


    }


    public String listCountries() {
        if (euCountries.size() == 0) {
            return "No Countries exist";
        } else {
            String listOfCountries = "";
            for (int i = 0; i < euCountries.size(); i++) {
                listOfCountries = listOfCountries + i + euCountries.get(i) + "\n";


            }
            return listOfCountries;
        }
    }

    public Country findCountry(String countryName) {
        //Choosing a country
        if (euCountries.size() > 0) {
            int correctCountry = 0;

            for (int i = 0; i < euCountries.size(); i++) {
                if (euCountries.get(i).getName().toUpperCase().equals(countryName.toUpperCase())) {
                    correctCountry = i;

                }

            }
            return euCountries.get(correctCountry);

        } else {
            return null;
        }
    }

    private void addMEP() {

        if (euCountries.size() > 0) {
            System.out.println(listCountries());

            String country = ScannerInput.readNextString("Please enter the NAME of the country ==> ");

            findCountry(country);


            if (findCountry(country).getMeps().size() + 1 > findCountry(country).getNoMEPs())
                System.out.println("Sorry no more Meps can be added");

            else if (findCountry(country).getName().toUpperCase().equals(country.toUpperCase())) {


                String name = ScannerInput.readNextString("Enter the name of the MEP ==> ");

                String number = ScannerInput.readNextString("Enter the phone number of the MEP ==> ");

                String email = ScannerInput.readNextString("Enter the email of the MEP ==> ");

                System.out.println(partyList.listOfParties());

                int partyIndex = ScannerInput.readNextInt("please choose a party ==>");


                findCountry(country).addMEP(new Mep(name, email, number, partyList.getParty(partyIndex), partyList));


            } else {
                System.out.println(" invalid name");
            }
        } else {
            System.out.println("no countries exist, please add a country first");
        }
    }


    private void deleteMEP() {

        System.out.println(listCountries());

        int index = ScannerInput.readNextInt("Please choose a country to delete a Mep ==> ");
        if (Utilities.validIndex(index, euCountries)) {
            System.out.println(euCountries.get(index).listOfMEPs());

            int mepIndex = ScannerInput.readNextInt("Please choose a Mep to delete ==> ");
            if (Utilities.validIndex(mepIndex, euCountries.get(index).getMeps())) {
                if (euCountries.get(index).getMeps().size() > 0) {
                    //euCountries.remove(index);

                    euCountries.get(index).removeMEP(index);

                    System.out.println("Mep has been deleted successfully");


                }

            } else {
                System.out.println("invalid index");
            }


        } else {
            System.out.println("There is no country for this index number");
        }
    }


    private void updateMEP() {

        listMEPSOfCountry();

        if (euCountries.size() > 0) {


            int countryIndex = ScannerInput.readNextInt("Please enter the country index again   ==> ");
            if (euCountries.get(countryIndex).getMeps().size() > 0) {

                int mepIndex = ScannerInput.readNextInt("Please enter the Mep index to update  ==> ");

                if (Utilities.validIndex(mepIndex, euCountries.get(countryIndex).getMeps())) {


                    String name = ScannerInput.readNextString("Enter the name of the MEP ==> ");

                    String number = ScannerInput.readNextString("Enter the phone number of the MEP ==> ");

                    String email = ScannerInput.readNextString("Enter the email of the MEP ==> ");

                    System.out.println(partyList.listOfParties());

                    int partyIndex = ScannerInput.readNextInt("please choose a party ==>");

                    Mep mep = euCountries.get(countryIndex).getMEP(mepIndex);
                    mep.setMEPEmail(email);
                    mep.setMEPName(name);
                    mep.setMEPParty(partyList.getParty(partyIndex).getPartyName(), partyList);
                    mep.setMEPPhone(number);

                    System.out.println("MEP updated successfully");

                }
            }
        } else {
            System.out.println("There is no MEP for this index number");
        }


    }


    private void listMEPSOfCountry() {

        System.out.println(listCountries());
        if (euCountries.size() > 0) {

            int index = ScannerInput.readNextInt("Please choose the index of a country  ==> ");
            if (Utilities.validIndex(index, euCountries)) {

                String listMEPSOfCountry = "";
                for (int i = 0; i < euCountries.get(index).getMeps().size(); i++) {
                    listMEPSOfCountry = listMEPSOfCountry + i + euCountries.get(index).getMEP(i) + "\n";


                }

                System.out.println(listMEPSOfCountry);


            } else {
                System.out.println("this country has no meps");
            }
        }
    }


    private void addNewParty() {


        String partyName = ScannerInput.readNextString("Enter the Party Name ==> ");

        String partyLeader = ScannerInput.readNextString("Enter the Party Leaders ==> ");

        String partyGenre = ScannerInput.readNextString("Enter the Party Genre ==>  ");

        int numLocalReps = ScannerInput.readNextInt("number of local representatives ==> ");


        partyList.addParty(new Party(partyName, partyLeader, partyGenre, numLocalReps));

        System.out.println("party added successfully");


    }


    private void deleteParty() {


        System.out.println(partyList.listOfParties());
        if (partyList.getPartyList().size() > 0) {

            int index = ScannerInput.readNextInt("Choose a party you want to remove ==> ");
            if (Utilities.validIndex(index, partyList.getPartyList())) {

                partyList.removeParty(index);
                // partyList.getPartyList().remove(index);
                System.out.println("Party has been deleted successfully");


            } else {
                System.out.println("There is no party for this index number");
            }


        }

    }

    private void updateParty() {

        System.out.println(partyList.listOfParties());
        if (partyList.getPartyList().size() > 0) {

            int index = ScannerInput.readNextInt("Choose a party you want to update ==> ");
            if (Utilities.validIndex(index, partyList.getPartyList())) {


                String partyName = ScannerInput.readNextString("Enter the Party Name ==> ");

                String partyLeader = ScannerInput.readNextString("Enter the Party Leaders ==> ");

                String partyGenre = ScannerInput.readNextString("Enter the Party Genre ==>  ");

                int numLocalReps = ScannerInput.readNextInt("number of local representatives ==> ");

                Party party = partyList.getParty(index);
                party.setPartyName(partyName);
                party.setPartyLeader(partyLeader);
                party.setPartyGenre(partyGenre);
                party.setNumLocalReps(numLocalReps);


            } else {
                System.out.println("There is no Party for this index number");
            }


        }

    }


    private String listOfParties() {
        return partyList.listOfParties();
    }

    private Party largestParty() {

        return partyList.largestParty();
    }

    private Party mostMEPs() {
        return partyList.mostMEPs(euCountries);
    }


    private String listPartyByGenre() {


        String genre = ScannerInput.readNextString("Please enter the party genre ==> ");
        return partyList.listPartiesBySpecificGenre(genre);
    }

    public String listMEPsbySpecificParty(String party) {


        Party chosenParty = partyList.getParty(0);

        for (int i = 0; i < partyList.getPartyList().size(); i++) {
            if (partyList.getPartyList().get(i).getPartyName().equals(party)) {
                chosenParty = partyList.getParty(i);

            }
        }


        String list = "";
        for (Country country : euCountries) {
            list = list + country.listOfMEPsByParty(chosenParty);
        }
        return list;


    }


    private String listMEPsbyPartyName() {


        String party = ScannerInput.readNextString("Please enter the party name ==> ");
        Party tempParty = Utilities.validParty(party, partyList);
        if (tempParty != null)
            return listMEPsbySpecificParty(party);
        else {
            return "not a valid party";
        }

    }

    public int noMEPSBySpecificParty(String party) {


        int mepCounter = 0;
        Party correctParty = partyList.getParty(0);
        for (int i = 0; i < partyList.getPartyList().size(); i++) {
            if (partyList.getPartyList().get(i).getPartyName().equals(party)) {
                correctParty = partyList.getParty(i);
                for (int j = 0; j < euCountries.size(); j++) {

                    mepCounter = mepCounter + euCountries.get(j).noOfMEPsByParty(correctParty);
                }

            }


        }
        return mepCounter;
    }

    private int noMEPSByParty() {
        String party = ScannerInput.readNextString("please enter a party name ==> ");
        return noMEPSBySpecificParty(party);
    }


    public void loadCountries() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("euCountries.xml"));
        euCountries = (ArrayList<Country>) is.readObject();

        is.close();
    }

    public void saveCountries() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("euCountries.xml"));
        out.writeObject(euCountries);

        out.close();
    }

    public void loadPartyList() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("partyList.xml"));

        partyList = (PartyList) is.readObject();
        is.close();
    }

    public void savePartyList() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("partyList.xml"));

        out.writeObject(partyList);
        out.close();
    }


}
