package gymApp;
//JAMES BEHNKE

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class gymApp {

	public static void main(String[] args) {
		String menuPrint = "\nMain menu \n\nSelect one of the following options:";

		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String name;
		int grade;
		int nameCounter = 0;
		int repCounter = 0;
		int gradeSelect = 0;
		int weightAmount=0;

		ArrayList<String> namesList = new ArrayList<>();
		ArrayList<Double> weightList = new ArrayList<>();
		

		ArrayList<Integer> repsList = new ArrayList<>();

		while (true) {

			
			int value = 0;
				
			System.out.println(menuPrint + "\n1. Add an exersise\n2. Edit past submissions grades\n3. How many reps should I do next week?\n4. Exit");
			try {
				value = input.nextInt();
			} catch(Exception e){
				System.out.println("You must enter an integer. Please try again.");
				break;
			}
			
			if (value == 1) {
				System.out.println("Please enter the exercise's name:");
				namesList.add(input.next());
				input.nextLine();

				nameCounter++;
				name = namesList.get(nameCounter - 1);
				System.out.println(name + " ----How many reps did you complete? ");
				try{
					repsList.add(input.nextInt());
				}catch(Exception e){
					System.out.println("You must enter an integer");
					break;
				}
				input.nextLine();

				repCounter++;
				grade = repsList.get(repCounter - 1);
				
				System.out.println("How much weight on each rep? Pounds");
				weightList.add(input.nextDouble());
				input.nextLine();
				
				
				
			} else if (value == 2) {
				System.out.println("What exercise would you like to change reps for? \n");
				for(int i=0; i < namesList.size(); i++){
					System.out.println((i +1 + ") " + namesList.get(i) + " - " + repsList.get(i) + " repetitions at " + weightList.get(i) + "lbs"));
				}
				
				gradeSelect = input.nextInt();
				input.nextLine();

				String student = "";
				try{
					student = namesList.get(gradeSelect - 1);
				} catch (Exception e){
					System.out.println("That location is not available.");
					break;
				}
				// Fixes Student grade at specified element
				System.out.println("Please enter a number for " + student);
				repsList.set(gradeSelect - 1, input.nextInt());
				// System.out.println("Enter the grade for " + name);

				} 
				else if(value ==3){
				System.out.println("Next week you should lift: ");
				
				for(int i=0; i < namesList.size(); i++){
					if(repsList.get(i) <= 5){
						System.out.println((i +1 + ") " + namesList.get(i) + " - " + repsList.get(i) + " repetitions at " + weightList.get(i) + "lbs"));

					}else
					System.out.println((i +1) + ". " + namesList.get((i)) + " - " + (repsList.get(i)+5) + " repetitions at " + (weightList.get(i)+2.5) + " lbs");
				}
				System.out.println("Keep it up!");
				}
				else if (value == 4) {
				System.out.println("Thanks, bye! \n\n\nCreated by James Behnke :)");
				break;
			}
		}
	}
}
