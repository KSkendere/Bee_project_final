import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Bee_project {
    private static DbConnection dbConnection;

    public static void main(String[] args) throws ParseException {
        dbConnection = new DbConnection();
//  CREATE OBJECT FROM CLASS COLONY
        Colony colony = new Colony();
//  CREATE OBJECT FROM CLASS LOCATION
        Location location = new Location();
//  CREATE OBJECTS FROM CLASS HIVE, HISTORY, LOCATION, METHODS ETC.
        Hive hive = new Hive();
        History history = new History();
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        Methods methods = new Methods();
//  ADD SCANNER
        Scanner scanner = new Scanner(System.in);
//  Creating a MENU
        int menu;
        do {
            System.out.println("Welcome to BeeMaster!");
            System.out.println("Please select what you would like to do:");
            System.out.println("Select 1 to show a general information about my bee hives");
            System.out.println("Select 2 to show information about specific location");
            System.out.println("Select 3 to show history of beekeeping");
            System.out.println("Select 4 to show and edit the information about the bee colony");
            System.out.println("Select 5 to add a new bee hive to the location");
            System.out.println("Select 6 to delete an existing bee hive");
            System.out.println("Select 7 to add a new location");
            System.out.println("Select 8 to delete a location");
            System.out.println("Select 0 to exit the application");
            menu = methods.validatorForIntegers(scanner);
            switch (menu) {
                case 1:
//  CREATE NESTED SWITCH
                    int menu2;
                    do {
                        System.out.println("Please choose what you want to see from general section! ");
                        System.out.println("");
                        System.out.println("Please select 1 if you want to see how many bee hives you have");
                        System.out.println("Please select 2 if you want to see total amount of honey and pollen in kg for all bee hives");
                        System.out.println("Please select 3 if you want to see 3 strongest bee hives");
                        System.out.println("Please select 4 if you want to see information about varroa treatment in your bee hives");
                        System.out.println("Please select 0 to exit general section");
                        menu2 = methods.validatorForIntegers(scanner);

                        switch (menu2) {
                            case 1:
                                System.out.println("Information about how many bee hives you have");
                                System.out.println("");
                                //RUN METHOD COUNT HIVE
                                hive.countHive(hive, dbConnection);
                                break;
                            case 2:
                                System.out.println("Information about total amount of honey and pollen in kg for all bee hives");
                                System.out.println("");
                                //RUN METHOD SUM OF HONEY AND POLLEN
                                Colony.honeyAndPollenSum(colony, dbConnection);
                                break;
                            case 3:
                                System.out.println("Information about 3 strongest bee hives");
                                System.out.println("");
                                //RUN METHOD PRINT OUT 3 STRONGEST HIVES
                                colony.strongestHivesByHoney(colony, location, hive, dbConnection);
                                break;
                            case 4:
                                System.out.println("Information about varroa treatment in your bee hives");
                                System.out.println("");
                                //RUN METHOD VARROA TREATMENT COUNT
                                colony.varroaTreatmentCount(colony, dbConnection);
                                methods.getPercentsOfVarroaTreatement(colony, dbConnection);
                                break;
                            default:
                                if (menu2 == 0) {
                                    System.out.println("Going back to main menu.");
                                    System.out.println();
                                } else {
                                    System.out.println("No such option!");
                                }
                        }
                    } while (menu2 != 0);
                    break;
                case 2:
                    int menu1;
                    do {
                        System.out.println("Please choose what information about bee hive locations you want to know!");
                        System.out.println("");
                        System.out.println("Please select 1 if you want to see information about number of bee hives in each location");
                        System.out.println("Please select 2 if you want to see information about total amount of honey in each location");
                        System.out.println("Please select 3 if you want to see information about total amount of pollen in each location");
                        System.out.println("Please select 0 to exit locations section");
                        menu1 = methods.validatorForIntegers(scanner);
                        switch (menu1) {
                            case 1:
                                System.out.println("Information about number of bee hives in each location:");
                                System.out.println("");
                                location.hivesInLocations(hive, location, dbConnection);
                                System.out.println("");
                                break;
                            case 2:
                                System.out.println("Information about total amount of honey in each location:");
                                System.out.println("");
                                location.countHoneyInLocation(location, hive, colony, dbConnection);
                                System.out.println("");
                                break;
                            case 3:
                                System.out.println("Information about total amount of pollen in each location:");
                                System.out.println("");
                                location.countPollenInLocation(location, hive, colony, dbConnection);
                                System.out.println("");
                                break;
                            default:
                                if (menu1 == 0) {
                                    System.out.println("Going back to main menu.");
                                    System.out.println();
                                } else {
                                    System.out.println("No such option!");
                                }
                        }
                    } while (menu1 != 0);
                    break;
                case 3:
                    int historyMenu;
                    do {
                        System.out.println("");
                        System.out.println("Please select 1 if you want to see information from history table about specific date");
                        System.out.println("Please select 2 if you want to see information from history table about last visit");
                        System.out.println("Please select 3 if you want to see all information from history table");
                        System.out.println("Please select 4 if you want to see dates when actions were done");
                        System.out.println("Please select 0 to exit history section");
                        historyMenu = Methods.validatorForIntegers(scanner);
                        switch (historyMenu) {
                            case 1:
                                history.getInfoFromHistoryTableAboutData(history, scanner, dbConnection);
                                break;
                            case 2:
//                                dbConnection.allActionsInLastVisit(history);
                                history.actionsInLastVisit(dbConnection,history);
                                break;
                            case 3:
                                history.allInfoFromHistory(dbConnection,history);
                                break;
                            case 4:
                                history.datesWhenActionsWhereDone(dbConnection,history);
                                break;
                            default:
                                if (historyMenu == 0) {
                                    System.out.println("Going back to update menu.");
                                    System.out.println();
                                } else {
                                    System.out.println("No such option!");
                                }
                        }
            } while (historyMenu != 0) ;

            break;
            case 4:
                int hiveMenu;
                do {
                    System.out.println("");
                    System.out.println("Choose what exactly you want to do with the colony");
                    System.out.println("");
                    System.out.println("Select 1 to show info of colony in specific hive");
                    System.out.println("Select 2 to add new colony");
                    System.out.println("Select 3 to update information about colony");
                    System.out.println("Select 0 to exit back to main menu");

                    hiveMenu = methods.validatorForIntegers(scanner);

                    switch (hiveMenu) {
//  CREATE NESTED SWITCH
                        case 1:
//  PRINT INFORMATION ABOUT SELECTED COLONY
                            System.out.println("");
                            methods.printInfoAboutColony(scanner, colony, methods, dbConnection);
                            break;
                        case 2:
//  ADD COLONY
                            System.out.println("");
                            colony.addColony(colony, scanner, hive, history, location, localDateTime, dateTimeFormatter, methods, dbConnection);
                            break;
                        case 3:
                            colony.hiveIdForAddingValues(scanner, colony, dbConnection, hive);
                            Integer menu4;
                            do {
                                System.out.println("Please select what information you want to update!");
                                System.out.println("");
                                System.out.println("Select 1 to update colony's origin");
                                System.out.println("Select 2 to update queen's breed");
                                System.out.println("Select 3 to update queen's year");
                                System.out.println("Select 4 to update number of supers ");
                                System.out.println("Select 5 to update number of frames ");
                                System.out.println("Select 6 to update number of bees ");
                                System.out.println("Select 7 to update number of brood ");
                                System.out.println("Select 8 to update kg of honey ");
                                System.out.println("Select 9 to update pollen ");
                                System.out.println("Select 10 to update varroa treatment ");
                                System.out.println("Select 11 to update food ");
                                System.out.println("Select 0 to go back to colony menu");
                                menu4 = methods.validatorForIntegers(scanner);
                                switch (menu4) {
                                    case 1:
                                        //ADD COLONY ORIGIN
                                        System.out.println("");
                                        System.out.println("Adding colony origin: ");
                                        colony.addColonyOrigin(scanner, colony, history, localDateTime, dateTimeFormatter, methods, dbConnection);
                                        dbConnection.attachColonyOrigin(colony);
                                        break;
                                    case 2:
                                        System.out.println("");
                                        System.out.println("Updating queen's breed: ");
                                        colony.addQueenBreed(scanner, colony, history, localDateTime, dateTimeFormatter, methods, dbConnection);
                                        dbConnection.attachQueenBreed(colony);
                                        System.out.println();
                                        break;
                                    case 3:
                                        System.out.println("");
                                        System.out.println("Updating queen's year: ");
                                        colony.addQueenYear(scanner, colony, history, localDateTime, dateTimeFormatter, methods, dbConnection);
                                        dbConnection.attachQueenYear(colony);
                                        break;
                                    case 4:
                                        System.out.println("");
                                        System.out.println("Updating number of supers: ");
                                        colony.addNumOfSupers(scanner, colony, history, localDateTime, dateTimeFormatter, methods, dbConnection);
                                        dbConnection.attachNumOfSupers(colony);
                                        break;
                                    case 5:
                                        System.out.println("");
                                        System.out.println("Updating number of frames: ");
                                        colony.addNumOfFrames(scanner, colony, history, localDateTime, dateTimeFormatter, methods, dbConnection);
                                        dbConnection.attachNumOfFrames(colony);
                                        break;
                                    case 6:
                                        System.out.println("");
                                        System.out.println("Updating number of bees: ");
                                        colony.addNumOfBees(scanner, colony, history, localDateTime, dateTimeFormatter, methods, dbConnection);
                                        dbConnection.attachNumOfBees(colony);
                                        break;
                                    case 7:
                                        System.out.println("");
                                        System.out.println("Updating number of brood: ");
                                        colony.addNumOfBrood(scanner, colony, history, localDateTime, dateTimeFormatter, methods, dbConnection);
                                        dbConnection.attachNumOfBrood(colony);
                                        break;
                                    case 8:
                                        System.out.println("");
                                        System.out.println("Updating kg of honey: ");
                                        colony.addKgHoney(scanner, colony, history, localDateTime, dateTimeFormatter, methods, dbConnection);
                                        dbConnection.attachKgHoney(colony);
                                        break;
                                    case 9:
                                        System.out.println("");
                                        System.out.println("Updating pollen: ");
                                        colony.addPollen(scanner, colony, history, localDateTime, dateTimeFormatter, methods, dbConnection);
                                        dbConnection.attachPollen(colony);
                                        break;
                                    case 10:
                                        System.out.println("");
                                        System.out.println("Updating varroa treatment: ");
                                        colony.addVarroaTreatment(scanner, colony, history, localDateTime, dateTimeFormatter, methods, dbConnection);
                                        dbConnection.attachVarroaTreatment(colony);
                                        break;
                                    case 11:
                                        System.out.println("");
                                        System.out.println("Updating food: ");
                                        colony.addFoodAdded(scanner, colony, history, localDateTime, dateTimeFormatter, methods, dbConnection);
                                        dbConnection.attachFoodAdded(colony);
                                        break;
                                    //                            case 12:
                                    //                                System.out.println("");
                                    //                                System.out.println("Please enter next visits date: ");
                                    //                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY");
                                    //                                String dateOne = "";
                                    //                                dateOne = scanner.nextLine();
                                    //                                Date date = simpleDateFormat.parse(dateOne);
                                    //                                break;
                                    default:
                                        if (menu4 == 0) {
                                            System.out.println("Going back to update menu.");
                                            System.out.println();
                                        } else {
                                            System.out.println("No such option!");
                                        }
                                }
                            } while (menu4 != 0);
                            break;
                        default:
                            if (hiveMenu == 0) {
                                System.out.println("Going back to main menu.");
                                System.out.println();
                            } else {
                                System.out.println("No such option!");
                            }
                    }
                }
                while (hiveMenu != 0);
                break;
            case 5:
//RUN METHOD ADD NEW HIVE
                hive.addNewHive(scanner, hive, history, location, localDateTime, dateTimeFormatter, methods, dbConnection);
                break;
            case 6:
//RUN METHOD DELETE NEW HIVE
                hive.deleteHive(scanner, hive, location, colony, history, localDateTime, dateTimeFormatter, methods, dbConnection);
                break;
            case 7:
//RUN METHOD ADD NEW LOCATION
                location.addNewLocation(scanner, location, history, localDateTime, dateTimeFormatter, dbConnection);
                break;
            case 8:
//RUN METHOD TO PRINT OUT ALL LOCATIONS
                methods.printLocation1(location, dbConnection);
//RUN METHOD DELETE LOCATION
                location.deleteLocation(scanner, location, hive, colony, history, localDateTime, dateTimeFormatter, dbConnection);
                break;
            default:
                System.out.println("This menu item does not exist");
                System.out.println("Please double check the number you have entered!");
        }
    } while(menu !=0);
}
}