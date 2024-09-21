import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.util.Scanner;

public class p4p {
    // written by William Cordor
    public static void byYear(int year) {
        //  method that outputs "The Ring" Magazine's top 10 pound for pound list for every year between 1989 and 2024
        // along with information such as record, age, nationality, etc.
        String query;
        ResultSet rs;
        query = "{ CALL p4pLists(?) }";
        try (Connection conn = MySQL.getConnection();
        CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, year);
            rs = stmt.executeQuery();
            System.out.format("%-10s %-19s %13s %29s %24s %26s", "Rank", "Name", "Age", "Weight Class", "Record", "Nationality\n");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
            while (rs.next()) {
                if (rs.getString("year").equals("2008")) {
                    if (rs.getString("draws").equals("0")) {
                        System.out.println(String.format("%-10s %-23s %8s %32s %28s %19s", rs.getString("ranking"), rs.getString("firstName") +
                        " " + rs.getString("lastName"), rs.getString("age"), rs.getString("weightClass"), rs.getString("wins")
                        + "-" + rs.getString("losses") + ", " + rs.getString("KOs") + " KOs", rs.getString("nation"))
                        + "\n-----------------------------------------------------------------------------------------------------------------------------");
                    }
                    else {
                        System.out.println(String.format("%-10s %-23s %8s %32s %28s %19s", rs.getString("ranking"), rs.getString("firstName") +
                        " " + rs.getString("lastName"), rs.getString("age"), rs.getString("weightClass"), rs.getString("wins")
                        + "-" + rs.getString("losses") + "-" + rs.getString("draws") + ", " + rs.getString("KOs") + " KOs",
                        rs.getString("nation"))
                        + "\n-----------------------------------------------------------------------------------------------------------------------------");
                    }
                }
                else {
                    if (rs.getString("draws").equals("0")) {
                        System.out.println(String.format("%-10s %-23s %8s %27s %28s %24s", rs.getString("ranking"), rs.getString("firstName") +
                        " " + rs.getString("lastName"), rs.getString("age"), rs.getString("weightClass"), rs.getString("wins")
                        + "-" + rs.getString("losses") + ", " + rs.getString("KOs") + " KOs", rs.getString("nation"))
                        + "\n-----------------------------------------------------------------------------------------------------------------------------");
                    }
                    else {
                        System.out.println(String.format("%-10s %-23s %8s %27s %28s %24s", rs.getString("ranking"), rs.getString("firstName") +
                        " " + rs.getString("lastName"), rs.getString("age"), rs.getString("weightClass"), rs.getString("wins")
                        + "-" + rs.getString("losses") + "-" + rs.getString("draws") + ", " + rs.getString("KOs") + " KOs",
                        rs.getString("nation"))
                        + "\n-----------------------------------------------------------------------------------------------------------------------------");
                        }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void byDecade() {
        //method that outputs info on the "Ring" Fighter of the Decade for the 1990s, 2000s, and 2010s
        //only 3 used because p4p list started in 1989
        try (Scanner sc = new Scanner(System.in)) {
            String option = null;
            do {
                System.out.println("\nChoose a letter according to the decade. Type \"exit\" to go back.");
                System.out.println("----------------------------------------------------------------");
                System.out.println("a.) 1990s\n");
                System.out.println("b.) 2000s\n");
                System.out.println("c.) 2010s\n");
                option = sc.nextLine();
                System.out.println();
                switch (option) {
                    case "a":
                        rjj();
                        break;
                    case "b": 
                        pacquiao();
                        break;
                    case "c":
                        mayweather();
                        break;
                }
            } while (!option.equals("exit"));
        }

    }

    private static void rjj() {
        //user interface for "The Ring" Fighter of the 1990s, Roy Jones Jr.
        try (Scanner scnr = new Scanner(System.in)) {
            String way = null;
            do {
                System.out.println("\n**********************************************");
                System.out.println("\"The Ring\" Fighter of the 1990s: Roy Jones Jr.");
                System.out.println("**********************************************\n");
                System.out.println("Choose a letter according to the options. Type \"exit\" to go back");
                System.out.println("----------------------------------------------------------------");
                System.out.println("a.) Record as of 31 December 1999.\n");
                System.out.println("b.) Notable Accomplishments in 1990s\n");
                System.out.println("c.) Link to Highlights\n");
                way = scnr.nextLine();
                switch (way) {
                    case "a":
                        System.out.println("\n---------------------------------------------------------------------");
                        System.out.println("Ending 31 December 1999, Roy Jones Jr's record was 40-1, with 33 KOs.");
                        System.out.println("---------------------------------------------------------------------\n");
                        System.out.println("*His only loss to that point (DQ against Montell Griffin) was avenged ");
                        System.out.println("with a first round knockout less than 5 months later.\n");
                        System.out.println("\nEnter any key to return. Type \"exit\" to exit current program.");
                        way = scnr.nextLine();
                        break;
                    case "b":
                        System.out.println("\n1993 - Becomes IBF (International Boxing Federation) Middleweight World Champion\n");
                        System.out.println("1994 - Defeats two-division World Champion and \"The Ring\" #3 Pound for Pound James Toney");
                        System.out.println("       by 12 round unanimous decision to become new IBF Super Middleweight World Champion,");
                        System.out.println("       \"The Ring\" #2 Pound for Pound, as well as two-division World Champion\n");
                        System.out.println("1994 - Wins \"The Ring\" Fighter of the Year\n");
                        System.out.println("1995 - Defeats former two-division World Champion Vinny Pazienza by 6th Round technical");
                        System.out.println("       knockout to defend IBF Super Middleweight World Title\n");
                        System.out.println("1996 - Defeats former three-division World Champion Mike McCallum by 12 round unanimous decision");
                        System.out.println("       to become WBC (World Boxing Council) Light Heavyweight World Champion, also becoming a");
                        System.out.println("       three-division World Champion\n");
                        System.out.println("1996 - Gets upgraded to the #1 Pound for Pound fighter in the world by \"The Ring\"\n");
                        System.out.println("1998 - Defeats WBA (World Boxing Association) Light Heavyweight World Champion Lou Del Valle by 12");
                        System.out.println("       round unanimous decision to become unified WBC & WBA Light Heavyweight World Champion\n");
                        System.out.println("1999 - Defeats IBF Light Heavyweight World Champion Reggie Johnson by 12 round unanimous decision to");
                        System.out.println("       become undisputed (WBC, WBA, IBF) Light Heavyweight World Champion\n");
                        System.out.println("\nEnter any key to return. Type \"exit\" to exit current program.");
                        way = scnr.nextLine();
                        break;
                    case "c":
                        System.out.println("\n-------------------------------------------------------");
                        System.out.println("Highlights: https://www.youtube.com/watch?v=pkMAf0ZHO_k");
                        System.out.println("-------------------------------------------------------\n");
                        System.out.println("\nEnter any key besides to return. Type \"exit\" to exit current program.");
                        way = scnr.nextLine();
                        break;
                }
            } while (!way.equals("exit"));
        }
    }

    private static void pacquiao() {
        //user interface for "The Ring" Fighter of the 2000s, Manny Pacquiao
        try (Scanner nacs = new Scanner(System.in)) {
            String choice = null;
            do {
                System.out.println("\n***********************************************");
                System.out.println("\"The Ring\" Fighter of the 2000s: Manny Pacquiao");
                System.out.println("***********************************************\n");
                System.out.println("\nChoose a letter according to the options. Type \"exit\" to go back");
                System.out.println("----------------------------------------------------------------");
                System.out.println("a.) Record as of 31 December 2009.\n");
                System.out.println("b.) Notable Accomplishments in 2000s\n");
                System.out.println("c.) Link to Highlights\n");
                choice = nacs.nextLine();
                switch (choice) { 
                    case "a":
                        System.out.println("\n-------------------------------------------------------------------------");
                        System.out.println("Ending 31 December 2009, Manny Pacquiao's record was 50-3-2, with 38 KOs.");
                        System.out.println("-------------------------------------------------------------------------\n");
                        System.out.println("\nEnter any key to return. Type \"exit\" to exit current program.");
                        choice = nacs.nextLine();
                        break;
                    case "b":
                        System.out.println("\n2001 - Wins IBF (International Boxing Federation) Super Bantamweight World Title to become two-division");
                        System.out.println("       World Champion\n");
                        System.out.println("2003 - Defeats 3x World Champion, two-Division World Champion and \"The Ring\" #3 Pound for Pound Marco Antonio Barrera");
                        System.out.println("       by 11th Round technical knockout to become the new \"Ring\" Featherweight World Champion, \"The Ring\"");
                        System.out.println("       #6 Pound for Pound, as well as three-division World Champion\n");
                        System.out.println("2006 - Avenges 2005 unanimous decision loss to 5x World Champion, two-division World Champion and \"The Ring\" #6 Pound");
                        System.out.println("       for Pound Erik Morales, beating him by 10th Round technical knockout, becoming #5 Pound for Pound by \"The Ring\"\n");
                        System.out.println("2006 - Defeats Erik Morales by 3rd round knockout, besting him in the trilogy 2-1, while also moving up to");
                        System.out.println("       #2 Pound for Pound in \"The Ring\" rankings\n");
                        System.out.println("2006 - Wins BWAA (Boxing Writers Association of America) Fighter of the Year\n");
                        System.out.println("2006 - Wins \"The Ring\" Fighter of the Year\n");
                        System.out.println("2007 - Defeats now 4x World Champion, three-division World Champion and \"The Ring\" #6 Pound for Pound Marco Antonio Barrera");
                        System.out.println("       in rematch by 12 round unanimous decision\n");
                        System.out.println("2008 - Defeats two-division World Champion and \"The Ring\" #3 Pound for Pound Juan Manuel Marquez by 12 round");
                        System.out.println("       split decision, becoming new WBC (World Boxing Council) & \"The Ring\" Super Featherweight World Champion,");
                        System.out.println("       four-division World Champion, as well as becoming the #1 ranked fighter in the world pound for pound by");
                        System.out.println("       \"The Ring\"\n");
                        System.out.println("       *First match with Marquez took place in 2004, and resulted in a 12 round split decision draw\n");
                        System.out.println("2008 - Becomes WBC Lightweight World Champion, becoming five-division World Champion\n");
                        System.out.println("2008 - Defeats former 7x World Champion, record-holding six-division World Champion Oscar De La Hoya by 7th Round corner");
                        System.out.println("       retirement\n");
                        System.out.println("       *The fight did 1.25 million pay-per-view buys and generated more than $70 million in revenue, finally cementing");
                        System.out.println("        Pacquiao as one of boxing's premier superstars\n");
                        System.out.println("2008 - Becomes 2x BWAA Fighter of the Year\n");
                        System.out.println("2008 - Becomes 2x \"Ring\" Fighter of the Year\n");
                        System.out.println("2009 - Defeated two-division World Champion and \"The Ring\" #10 Pound for Pound Ricky Hatton by 2nd Round knockout");
                        System.out.println("       to become the new \"Ring\" Light Welterweight World Champion and record-tying six-division World Champion\n");
                        System.out.println("       *\"The Ring\" Knockout of the Year\n");
                        System.out.println("2009 - Defeated 3x World Champion, two-division World Champion and \"The Ring\" #8 Pound for Pound Miguel Cotto to become WBO");
                        System.out.println("       (World Boxing Organization) Welterweight World Champion, and also becoming a record-breaking seven-division World Champion\n");
                        System.out.println("       *Pacquiao earned $22 million for this fight, which was his career-high at this point\n");
                        System.out.println("2009 - Becomes 3x BWAA Fighter of the Year\n");
                        System.out.println("2009 - Becomes 3x \"Ring\" Fighter of the Year\n");
                        System.out.println("2009 - 6th highest paid athlete in the world, earning $40 million (Forbes Magazine)\n");
                        System.out.println("2009 - TIME 100 Most Influential People\n");
                        System.out.println("\nEnter any key to return. Type \"exit\" to exit current program.");
                        choice = nacs.nextLine();
                        break;
                    case "c":
                        System.out.println("\n--------------------------------------------------------------");
                        System.out.println("Highlights: https://www.youtube.com/watch?v=-a84r2kls5I&t=399s");
                        System.out.println("--------------------------------------------------------------\n");
                        System.out.println("\nEnter any key besides to return. Type \"exit\" to exit current program.");
                        choice = nacs.nextLine();
                        break;
                }
            } while (!choice.equals("exit"));
        }

    }

    private static void mayweather() {
        //user interface for "The Ring" Magazine Fighter of the 2010s, Floyd Mayweather Jr.
        try (Scanner s = new Scanner(System.in)) {
            String choice = null;
            do {
                System.out.println("\n*****************************************************");
                System.out.println("\"The Ring\" Fighter of the 2010s: Floyd Mayweather Jr.");
                System.out.println("*****************************************************\n");
                System.out.println("\nChoose a letter according to the options. Type \"exit\" to go back");
                System.out.println("----------------------------------------------------------------");
                System.out.println("a.) Record as of 31 December 2019.\n");
                System.out.println("b.) Notable Accomplishments in 2010s\n");
                System.out.println("c.) Link to Highlights\n");
                choice = s.nextLine();
                switch (choice) {
                    case "a":
                        System.out.println("\n----------------------------------------------------------------------------");
                        System.out.println("Ending 31 December 2019, Floyd Mayweather Jr's record was 50-0, with 27 KOs.");
                        System.out.println("----------------------------------------------------------------------------\n");
                        System.out.println("\nEnter any key to return. Type \"exit\" to exit current program.");
                        choice = s.nextLine();
                        break;
                    case "b":
                        System.out.println("\n2010 - Defeats 5x World Champion, three-division World Champion, and \"The Ring\" #3 Pound for Pound Shane Mosley by 12");
                        System.out.println("       round unanimous decision\n");
                        System.out.println("       *The fight did 1.4 million pay-per-view buys, generating $78.3 million in revenue. Mayweather made $22.5 million.\n");
                        System.out.println("2010 - 2nd highest paid athlete in the world, earning $65 million (Forbes)\n");
                        System.out.println("2011 - Wins WBC (World Boxing Council) Welterweight World Title to become 6x World Champion, defeating Victor Ortiz by");
                        System.out.println("       4th Round knockout\n");
                        System.out.println("       *The fight did 1.25 million pay-per-view buys, generating $78.4 million in revenue. Mayweather made up to $40 million.\n");
                        System.out.println("2012 - Defeats 4x World Champion and three-division World Champion Miguel Cotto by 12 round unanimous decision to become WBA");
                        System.out.println("       (World Boxing Association) Light Middleweight World Champion and 7x World Champion\n");
                        System.out.println("       *The fight had 1.5 million pay-per-view buys, earning $94 million in revenue. Mayweather cleared $45 million.\n");
                        System.out.println("2012 - Upgraded to #1 Pound for Pound by \"The Ring\"\n");
                        System.out.println("2012 - Highest paid athlete in the world, earning $85 million (Forbes)\n");
                        System.out.println("2013 - Defeats 4x World Champion, three-division World Champion, and \"The Ring\" #10 Pound for Pound Robert Guerrero by 12");
                        System.out.println("       round unanimous decision to become WBC & \"The Ring\" Welterweight World Champion\n");
                        System.out.println("       *The fight did 1 million pay-per-view buys, generating $60 million in revenue. Mayweather made $32 million.\n");
                        System.out.println("2013 - Becomes unified WBA, WBC, & \"The Ring\" Light Middleweight World Champion, defeating unbeaten \"The Ring\" #9 Pound for Pound");
                        System.out.println("       Canelo Alvarez by 12 round majority decision\n");
                        System.out.println("       *The fight did 2.2 million pay-per-view buys, which was 2nd at the time only to De La Hoya - Mayweather in 2007, which did");
                        System.out.println("        2.4 million.");
                        System.out.println("       *The fight made $150 million in pay-per-view revenue, which was the all-time record at the time.");
                        System.out.println("       *The fight generated $20 million in ticket sales, which was also an all-time record.");
                        System.out.println("       *Mayweather was guaranteed $41.5 million.\n");
                        System.out.println("2013 - Becomes 2x BWAA (Boxing Writers Association of America) Fighter of the Year\n");
                        System.out.println("       *Won previously in 2007\n");
                        System.out.println("2014 - Defeats 3x World Champion and two-division World Champion Marcos Maidana by majority decision to become unified");
                        System.out.println("       WBC, \"The Ring\", & WBA Welterweight World Champion\n");
                        System.out.println("       *Mayweather earned $32 million.\n");
                        System.out.println("2014 - Defeats Marcos Maidana by 12 round unanimous decision in rematch to keep unified Welterweight World Titles as well");
                        System.out.println("       as WBC Light Middleweight World Title\n");
                        System.out.println("       *Mayweather once again earned $32 million.\n");
                        System.out.println("2015 - Defeats 9x World Champion, eight-division World Champion, and \"The Ring\" #3 Pound for Pound Manny Pacquiao to become");
                        System.out.println("       unified WBA, WBC, \"The Ring\", & WBO (World Boxing Organization) Welterweight World Champion\n");
                        System.out.println("       *The fight did a record-breaking 4.6 million pay-per-view buys, also generating a record-breaking $400 million in revenue.");
                        System.out.println("       *All-time record of $72.2 million generated from ticket sales, surpassing Super Bowl XLIX.");
                        System.out.println("       *Record breaking earnings including more than $160 million for Pacquiao, and around $250 million for Mayweather");
                        System.out.println("       *Considered the most anticipated fight in boxing history by many fans.\n");
                        System.out.println("2015 - Defeated 3x World Champion Andre Berto by 12 round unanimous decision to keep unified WBA, WBC, & \"The Ring\" World Titles\n");
                        System.out.println("       *Mayweather made $32 million. Announced retirement after fight\n");
                        System.out.println("2015 - Highest paid celebrity in the world, earning a record-breaking $300 million (Forbes)\n");
                        System.out.println("2015 - Becomes 3x BWAA Fighter of the Year");
                        System.out.println("2016 - Guiness World Record for most pay-per-view revenue generated for a boxer at $1.2 billion\n");
                        System.out.println("\nEnter any key to return. Type \"exit\" to exit current program.");
                        choice = s.nextLine();
                        break;
                    case "c":
                        System.out.println("\n--------------------------------------------------------------");
                        System.out.println("Highlights: https://www.youtube.com/watch?v=tA14uRHqqWs&t=144s");
                        System.out.println("--------------------------------------------------------------\n");
                        System.out.println("\nEnter any key besides to return. Type \"exit\" to exit current program.");
                        choice = s.nextLine();
                        break;
                }
            } while (!choice.equals("exit"));
        }
    }

    public static void records() {
        // method that outputs user interface for user to access "The Ring p4p" records
        try (Scanner sc = new Scanner(System.in)) {
            String option = null;
            String query;
            ResultSet rs;
            do {
                System.out.println("\nChoose a letter according to the options. Type \"exit\" to go back.");
                System.out.println("-----------------------------------------------------------------");
                System.out.println("a.) Most appearances on Pound for Pound list\n");
                System.out.println("b.) Most appearances as Pound for Pound No. 1\n");
                System.out.println("c.) Youngest to be Pound for Pound No. 1\n");
                System.out.println("d.) Oldest to be Pound for Pound No. 1\n");
                option = sc.nextLine();
                System.out.println();
                switch (option) {
                    case "a":
                        query = "{ CALL appsList() }";
                        try (Connection conn = MySQL.getConnection();
                        CallableStatement stmt = conn.prepareCall(query)) {
                            rs = stmt.executeQuery();
                            System.out.println("\n***********************************");
                            System.out.println("Floyd Mayweather Jr: 16 appearances");
                            System.out.println("***********************************\n");
                            System.out.println("\nEnter any key to see most P4P appearances list. Type \"done\" to return.\n");
                            option = sc.nextLine();
                            if (option.equals("done")) {
                                break;
                            }
                            System.out.format("\n%s %35s %25s", "Name", "Nationality", "Total Appearances\n");
                            System.out.println("-----------------------------------------------------------------");
                            while (rs.next()) {
                                System.out.println(String.format("%-30s %-12s %21s", rs.getString("firstName") + " " + rs.getString("lastName"),
                                rs.getString("nation"), rs.getString("totalApps")) + "\n-----------------------------------------------------------------");
                            }
                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("\nEnter any key to return. Type \"exit\" to exit current program.");
                        option = sc.nextLine();
                        break;
                    case "b":
                        query = "{ CALL most1() }";
                        try (Connection conn = MySQL.getConnection();
                        CallableStatement stmt = conn.prepareCall(query)) {
                            rs = stmt.executeQuery();
                            System.out.println("\n**********************************");
                            System.out.println("Floyd Mayweather Jr: 6 appearances");
                            System.out.println("**********************************\n");
                            System.out.format("%s %10s %27s %15s", "Year", "Age", "Weight Class", "Record\n");
                            System.out.println("--------------------------------------------------------------");
                            while (rs.next()) {
                                System.out.println(String.format("%s %10s %25s %20s", rs.getString("year"), rs.getString("age"),
                                rs.getString("weightClass"), rs.getString("wins") + "-" + rs.getString("losses") + ", "
                                + rs.getString("KOs") + " KOs") + "\n--------------------------------------------------------------");
                            }
                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("\nContext: After a dominant 2007, Mayweather retired from the sport");
                        System.out.println("         at the end of the year, losing his #1 pound for pound");
                        System.out.println("         spot to Manny Pacquiao. He unretired in 2009, only to");
                        System.out.println("         be #2 to Pacquiao until 2012.\n");
                        System.out.println("\nEnter any key to see list of all P4P #1s. Type \"done\" to return.\n");
                        option = sc.nextLine();
                        if (option.equals("done")) {
                            break;
                        }
                        query = "{ CALL no1s() }";
                        try (Connection conn = MySQL.getConnection();
                        CallableStatement stmt = conn.prepareCall(query)) {
                            rs = stmt.executeQuery();
                            System.out.format("%s %35s %15s", "Name", "Nationality", "Times #1\n");
                            System.out.println("-------------------------------------------------------");
                            while (rs.next()) {
                                System.out.println(String.format("%-20s %15s %18s", rs.getString("firstName") + " " + rs.getString("lastName"),
                                rs.getString("nation"), rs.getString("p4p1")) + "\n-------------------------------------------------------");
                            }
                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("\nEnter any key to return. Type \"exit\" to exit current program.");
                        option = sc.nextLine();
                        break;
                    case "c":
                        query = "{ CALL youngestNo1() }";
                        try (Connection conn = MySQL.getConnection();
                        CallableStatement stmt = conn.prepareCall(query)) {
                            rs = stmt.executeQuery();
                            System.out.println("\n*************************");
                            System.out.println("Mike Tyson: Age 23 (1989)");
                            System.out.println("*************************\n");
                            System.out.println("\nEnter any key to see list of youngest P4P #1s. Type \"done\" to return.\n");
                            option = sc.nextLine();
                            if (option.equals("done")) {
                                break;
                            }
                            System.out.format("%s %20s %8s %23s %14s %17s", "Name", "Age", "Year", "Weight Class", "Record", "Nationality\n");
                            System.out.println("------------------------------------------------------------------------------------------");
                            while (rs.next()) {
                                System.out.println(String.format("%-20s %3s %9s %22s %18s %13s", rs.getString("firstName") + " " + rs.getString("lastName"),
                                rs.getString("age"), rs.getString("year"), rs.getString("weightClass"), rs.getString("wins") + "-"
                                + rs.getString("losses") + ", " + rs.getString("KOs") + " KOs", rs.getString("nation"))
                                + "\n------------------------------------------------------------------------------------------");
                            }
                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("\nEnter any key to return. Type \"exit\" to exit current program.");
                        option = sc.nextLine();
                    case "d":
                        query = "{ CALL oldestNo1() }";
                        try (Connection conn = MySQL.getConnection();
                        CallableStatement stmt = conn.prepareCall(query)) {
                            rs = stmt.executeQuery();
                            System.out.println("\n******************************");
                            System.out.println("Bernard Hopkins: Age 39 (2004)");
                            System.out.println("******************************\n");
                            System.out.println("\nEnter any key to see list of oldest P4P #1s. Type \"done\" to return.\n");
                            option = sc.nextLine();
                            if (option.equals("done")) {
                                break;
                            }
                            System.out.format("%s %24s %8s %27s %14s %19s", "Name", "Age", "Year", "Weight Class", "Record", "Nationality\n");
                            System.out.println("----------------------------------------------------------------------------------------------------");
                            while (rs.next()) {
                                System.out.println(String.format("%-20s %7s %9s %26s %18s %15s", rs.getString("firstName") + " " + rs.getString("lastName"),
                                rs.getString("age"), rs.getString("year"), rs.getString("weightClass"), rs.getString("wins") + "-"
                                + rs.getString("losses") + ", " + rs.getString("KOs") + " KOs", rs.getString("nation"))
                                + "\n----------------------------------------------------------------------------------------------------");
                            }
                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("\nEnter any key to return. Type \"exit\" to exit current program.");
                        option = sc.nextLine();
                }    
            } while (!option.equals("exit"));
        }
    }

    public static void main(String[] args) {
        String code = null;
        try (Scanner s = new Scanner(System.in)) {
            do {
                // "main menu" of project
                System.out.println("\nType a number according to the options. Type \"done\" when finished.");
                System.out.println("------------------------------------------------------------------");
                System.out.println("1.) \"The Ring\" Magazine Pound for Pound Rankings year by year\n");
                System.out.println("2.) \"The Ring\" Magazine Fighter of the Decade (90s, 00s, 10s)\n");
                System.out.println("3.) \"The Ring\" Magazine Pound for Pound Records\n");
                code = s.nextLine();
                System.out.println();
                switch (code) {
                    case "1":
                        do {
                            System.out.print("Choose a year (1989-2024): ");
                            int year = s.nextInt();
                            s.nextLine();
                            System.out.println("*******************************\n");
                            if (year == 2024) {
                                System.out.println("\"The Ring\" Pound for Pound Rankings as of 31 August 2024.");
                                System.out.println("*****************************************************************************************************************************");
                            }
                            byYear(year);
                            if (year == 2005) {
                                System.out.println("\n*Interesting Fact: Juan Manuel Marquez and Rafael Marquez are brothers, making them the only brothers to be on the same \"Ring\""); 
                                System.out.println("annual Pound for Pound list.\n");
                            }
                            System.out.println("\nEnter any key besides \"1\" to choose another year");
                            code = s.nextLine();
                            System.out.println();
                        } while (!code.equals("1"));
                        break;
                    case "2":
                        byDecade();
                        break;
                    case "3":
                        records();
                        break;
                }
            } while (!code.equals("done"));
        }
    }
}
