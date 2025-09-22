import java.util.Scanner;

public class PlayerSelection {
    public static void main(String[] args) {
        // Create Scanner to read input
        Scanner input = new Scanner(System.in);

        // Step 1(from task 1): Ask for player details
        System.out.print("Enter player name: ");
        String name = input.nextLine();

        System.out.print("Enter player age: ");
        int age = input.nextInt();

        System.out.print("Enter player height (in meters): ");
        float height = input.nextFloat();

        System.out.print("Enter player weight (in pounds): ");
        float weight = input.nextFloat();

        System.out.print("Enter player jersey number: ");
        int jerseyNumber = input.nextInt();

        // * Step 2: Convert units
        final float POUND = 0.45359237f;
        final int METER = 100;

        float weightKg = weight * POUND; // converting pounds to kg
        float heightCm = height * METER; // converting meters to cm

        //  Step 3: Determine age category
        String category;
        if (age < 18) {
            category = "Rising star";
        }
        else if (age <= 30) {
            category = "Prime Player";
        }
        else {
            category = "Veteran";
        }

        // Step 4: Decide position using switch
        String position;
        switch (jerseyNumber) {
            case 1:
                position = "Goalkeeper";
                break;
            case 2:
            case 5:
                position = "Defender";
                break;
            case 6:
            case 8:
                position = "Midfielder";
                break;
            case 7:
            case 11:
                position = "Winger";
                break;
            case 9:
                position = "Striker";
                break;
            case 10:
                position = "Playmaker";
                break;
            default:
                position = "Unknown position";
        }

        // Step 5: Check attacker status (is the jersey for attacking players?from research )
        String isAttacker = (jerseyNumber == 7 || jerseyNumber == 9 || jerseyNumber == 10 || jerseyNumber == 11)? "Yes" : "No";

        //  Step 6: Check eligibility (age >= 18 and weight < 90)
        boolean eligible = (age >= 18 && weightKg < 90) ;


        //  Step 7: Nested if for lineup decision
        String lineupDecision;
        if (category.equals("Prime Player")) {
            if (weightKg < 80) {
                lineupDecision = "Starting Lineup";
            } else {
                lineupDecision = "Bench";
            }
        } else {
            lineupDecision = "Bench";
        }

        //  Step 8(from task 9): Ternary operator for final decision
        String finalDecision = eligible? "Play" : "Rest";

        // * Step 9: Print Player Report
        System.out.println("\nPLAYER REPORT ");
        System.out.println("Player: " + name);
        System.out.println("Age: " + age + " (" + category + ")");
        System.out.println("Height: " + heightCm + " cm");
        System.out.println("Weight: " + weightKg + " kg");
        System.out.println("Jersey: " + jerseyNumber);
        System.out.println("Position: " + position);
        System.out.println("Attacker jersey: " + isAttacker);
        System.out.println("Eligibility: " + (eligible? "Eligible" : "Not Eligible"));
        System.out.println("Lineup Decision: " + lineupDecision);
        System.out.println("Final Decision: " + finalDecision);

        // * Step 10: Closing Scanner at the end
        input.close();
    }
}
