package virtualpetsrunamok;

import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {

		VirtualPetShelter shelter = new VirtualPetShelter();
		Scanner input = new Scanner(System.in);

		OrganicPet mike = new OrgDog("Mike", "is a dog: spotted Great Dane");
		shelter.intake(mike);
		RoboticPet carol = new RoboDog("Carol", "is a robo-dog: matte rose gold Standard Poodle");
		shelter.intake(carol);
		OrganicPet greg = new OrgDog("Greg", " is a dog: chocolate labrador retreiver");
		shelter.intake(greg);
		RoboticPet marcia = new RoboCat("Marcia", "is a robo-cat: shiny blonde siamese cat");
		shelter.intake(marcia);
		RoboticPet peter = new RoboDog("Peter", "is a robo-dog: matte brindle old english bulldog");
		shelter.intake(peter);
		OrganicPet jan = new OrgCat("Jan", "is a cat: powder grey Scottish fold kitty cat");
		shelter.intake(jan);
		RoboticPet bobby = new RoboCat("Bobby", "is a robo-cat: rustic Maine Coon cat");
		shelter.intake(bobby);
		OrganicPet cindy = new OrgCat("Cindy", "is a cat: blonde exotic shorthair kitty");
		shelter.intake(cindy);
		RoboticPet alice = new RoboCat("Alice", "is a robo-cat: dusty gold Burmese cat");
		shelter.intake(alice);
		RoboticPet sam = new RoboDog("Sam", "is a robo dog: rambunctious pug with a few dings");
		shelter.intake(sam);

		boolean quit = false;

		writeLine("Thank you for volunteering at the Animals Must be OK Shelter! AMOK for short. \nIf you are receiving this message in error, we sorry for the mix-up.\nSince you are already here, you may as well learn how to care for our pets...");
		writeLine("\nThis shelter caters to robotic cats & dogs as well as organic cats & dogs. Things 'bout to get cray cray up in here.");
		do {
			if (shelter.getLitterBox() >= 100) {
				System.out.println("The litterbox is really freaking dirty. Cats are not happy... Clean it!");
				for (OrganicPet currentPet : shelter.organicCats()) {
					((OrgCat) currentPet).decreaseHealth();
				}
			}
			for (OrganicPet currentPet : shelter.organicDogs()) {
				if (((OrgDog) currentPet).getCageMessiness() >= 100) {
					System.out.println("The organic dog " + currentPet + "'s cage needs cleaning.");
					((OrgDog) currentPet).decreaseHealth();
				}
			}

			writeLine("\nTake a second to review the chart below to determine the pets' needs:\n");
			writeLine("\t\t\t|   2\t|   3\t|   10\t|   7");
			writeLine("Name\t|Mood\t|Health\t|Hunger\t|Thirst\t|OilLvl\t|CageMess");
			writeLine("--------|-------|-------|-------|-------|-------|-------");

			for (OrganicPet currentPet : shelter.organicDogs()) {
				writeLine(currentPet.getName() + "\t|  " + ((VirtualPet) currentPet).getMood() + "\t|  "
						+ ((VirtualPet) currentPet).getHealth() + "\t|  " + currentPet.getHunger() + "\t|  "
						+ currentPet.getThirst() + "\t|  " + "--" + "\t|  " + ((OrgDog) currentPet).getCageMessiness());
			}
			for (OrganicPet currentPet : shelter.organicCats()) {
				writeLine(currentPet.getName() + "\t|  " + ((VirtualPet) currentPet).getMood() + "\t|  "
						+ ((VirtualPet) currentPet).getHealth() + "\t|  " + currentPet.getHunger() + "\t|  "
						+ currentPet.getThirst() + "\t|  " + "--" + "\t|  " + "--");
			}
			for (RoboticPet currentPet : shelter.roboticDogs()) {
				writeLine(currentPet.getName() + "\t|  " + ((VirtualPet) currentPet).getMood() + "\t|  "
						+ ((VirtualPet) currentPet).getHealth() + "\t|  " + "--" + "\t|  " + "--" + "\t|  "
						+ currentPet.getOilLevel() + "\t|  " + "--");
			}
			for (RoboticPet currentPet : shelter.roboticCats()) {
				writeLine(currentPet.getName() + "\t|  " + ((VirtualPet) currentPet).getMood() + "\t|  "
						+ ((VirtualPet) currentPet).getHealth() + "\t|  " + "--" + "\t|  " + "--" + "\t|  "
						+ currentPet.getOilLevel() + "\t|  " + "--");
			}
			System.out.println("\nThe litterbox is: " + shelter.getLitterBox());
			writeLine("\nWhat would you like to do next?");
			writeLine("\n1 Meet 'n Greet\n2 Feed the organic pets\n3 Water the organic pets\n4 Play with a pet"
					+ "\n5 Adopt a pet\n6 Admit a pet\n7 Clean Cages\n8 Clean Litterbox"
					+ "\n9 Walk Dogs\n10 Maintain all RoboPets\n11 Do nothing\n99 Quit");
			String response = input.nextLine();

			switch (response) {
			case "1":
				writeLine("Meet - n - greet our pets! Take a minute to get to know the pets we have at the shelter\n");
				for (VirtualPet currentPet : shelter.pets()) {
					System.out.println(currentPet.name + currentPet.description);
				}
				writeLine("-----");
				break;
			case "2":
				shelter.feedAllOrganic();
				System.out.println("You fed all the organic pets!");
				break;
			case "3":
				shelter.waterAllOrganic();
				System.out.println("You watered all the organic pets!");
				break;
			case "4": // play
				writeLine("Ok, so you'd like to play with a pet. Please choose one.\n");
				displayPets(shelter);
				writeLine("\nWhich pet would you like to play with?");
				String petName = input.nextLine();
				shelter.playOne(shelter.getPet(petName));
				if (petName.equalsIgnoreCase("Marcia")) {
					System.out.println("Jan says, \"Marcia, Marcia, Marcia!\"");
				}
				System.out.println("What kind of game would you like to play with " + petName + "?");
				System.out.println("\n1 Fetch\n2 Obstacle course\n3 Red laser pointer\n4 Teach a new trick");
				String playGame = input.nextLine();
				if (playGame.equals("1")) {
					writeLine("You played fetch with " + petName + ".");
				}
				if (playGame.equals("2")) {
					writeLine("You ran " + petName + " through the obstacle course. You're both exhausted.");
				}
				if (playGame.equals("3")) {
					writeLine("You managed to exhaust " + petName + "! Well done.");
				}
				if (playGame.equals("4")) {
					writeLine("You taught " + petName + " a new trick!");
				}
				break;
			case "5": // adopt
				writeLine("You'd like to adopt a pet! Please choose one.\n");
				displayPets(shelter);
				writeLine("\nWhich pet would you like to adopt?");
				String nameToAdopt = input.nextLine();
				if (nameToAdopt.equalsIgnoreCase("Greg")) {
					System.out.println("Just one word... Groovy.");
				}
				if (nameToAdopt.equalsIgnoreCase("Marcia")) {
					System.out.println("Jan says, \"Marcia, Marcia, Marcia!\" Maybe you should adopt her too...");
				}
				if (nameToAdopt.equalsIgnoreCase("Peter")) {
					System.out.println("Bratty. Typical middle-child syndrome. Good luck with that one...");
				}
				if (nameToAdopt.equalsIgnoreCase("Jan")) {
					System.out.println("She's a sassy one!");
				}
				if (nameToAdopt.equalsIgnoreCase("Bobby")) {
					System.out.println("Don't let him do your laundry, he'll end up flooding the place!");
				}
				if (nameToAdopt.equalsIgnoreCase("Cindy")) {
					System.out.println("Lisp and all, she will tattle.");
				}
				
				VirtualPet x = shelter.getPet(nameToAdopt);
				shelter.adoptPet(x);
				writeLine("You adopted " + nameToAdopt + "! You're gonna be the best pet parent ever.");
				break;
			case "6":// intake
				System.out.println("Ok you have a pet for us! Is it organic or robotic?");
				String response2 = input.nextLine();
				if (response2.equalsIgnoreCase("organic")) {
					System.out.println("Great! Is your organic pet a cat or a dog?");
					String response3 = input.nextLine();
					if (response3.equalsIgnoreCase("dog")) {
						System.out.println("And what is the dog's name?");
						String name = input.nextLine();
						System.out.println("Please tell us about your dog's personality & demeanor:");
						String description = input.nextLine();
						OrganicPet d = new OrgDog(name, description);
						shelter.intake(d);
						System.out.println(name + " is going to fit right in here. A big, warm welcome!");
					} else if (response3.equalsIgnoreCase("cat")) {
						System.out.println("And what is the cat's name?");
						String name = input.nextLine();
						System.out.println("Please tell us about your cat's personality & demeanor:");
						String description = input.nextLine();
						OrganicPet c = new OrgCat(name, description);
						shelter.intake(c);
						System.out.println(name + " is going to fit right in here. A big, warm welcome!");
					}

				} else if (response2.equalsIgnoreCase("robotic")) {
					System.out.println("Great! Is your robotic pet a cat or a dog?");
					String response3 = input.nextLine();

					if (response3.equalsIgnoreCase("dog")) {
						System.out.println("And what is the robo-dog's name?");
						String name = input.nextLine();
						System.out.println("Please tell us about your robo-dog's personality & demeanor:");
						String description = input.nextLine();
						RoboticPet d = new RoboDog(name, description);
						shelter.intake(d);
						System.out.println(name + " is going to fit right in here. A big, warm welcome!");
					} else if (response3.equalsIgnoreCase("cat")) {
						System.out.println("And what is the robo-cat's name?");
						String name = input.nextLine();
						System.out.println("Please tell us about your robo-cat's personality & demeanor:");
						String description = input.nextLine();
						RoboticPet c = new RoboCat(name, description);
						shelter.intake(c);
						System.out.println(name + " is going to fit right in here. A big, warm welcome!");
					}
				}
				break;
			case "7":
				shelter.cleanDogCages();
				System.out.println("That was ruff - you cleaned all the dog cages! ");
				break;
			case "8":
				shelter.cleanLitterBox();
				System.out.println("Thank you meow-y much - you cleaned the litterbox!");
				break;
			case "9":
				shelter.walkDogs();
				System.out.println("You walked ALL the dogs. Now we're pooped.");
				break;
			case "10":
				shelter.maintainAllRobo();
				System.out.println("Squeaky clean! You maintained all robotic pets.");
				break;
			case "11":
				// tick
				break;
			case "99":
				writeLine("You've quit the game. It's a lot to handle... why do you think I'm teaching YOU to take care of this place.");
				System.exit(0);
			default:
				writeLine("Sorry, didn't catch that. Try again.");
				break;

			}
			shelter.tickAllPets();

		} while (!quit);
		input.close();

	}

	private static void displayPets(VirtualPetShelter shelter) {
		for (VirtualPet currentPet : shelter.pets()) {
			System.out.println(currentPet);
		}
	}

	public static void writeLine(String message) {
		System.out.println(message);
	}
}
