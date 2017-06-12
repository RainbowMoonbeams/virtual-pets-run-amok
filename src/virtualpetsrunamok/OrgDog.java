package virtualpetsrunamok;

public class OrgDog extends Dog implements OrganicPet {

	protected int cageMessiness;
	protected int hunger;
	protected int thirst;

	public OrgDog(String nameParam, String descriptionParam) {
		super(nameParam, descriptionParam);
		cageMessiness = 50;
		hunger = 50;
		thirst = 50;

	}
	public void decreaseHealth() {
		health -= 10;
	}

	public void feed() {
		hunger -= 20;
		thirst += 5;
		mood += 10;
		health += 15;
		cageMessiness += 10;
	}

	public void water() {
		hunger +=5;
		thirst -= 20;
		mood += 10;
		health += 15;
		cageMessiness += 10;
	}

	@Override
	public void walk() {
		hunger += 5;
		thirst += 5;
		mood += 20;
		health += 20;
		cageMessiness -= 5;
	}

	@Override
	public void play() {
		mood += 20;
		hunger += 10;
		thirst += 10;
		health += 15;
	}

	public void cleanCage() {
		cageMessiness = 0;
		mood += 10;
		health += 10;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getHunger() {
		return hunger;
	}

	@Override
	public int getThirst() {
		return thirst;
	}

	@Override
	public int getHealth() {
		return health;
	}

	@Override
	public int getMood() {
		return mood;
	}

	public int getCageMessiness() {
		return cageMessiness;
	}


	@Override
	public int tick() {
		hunger += (generateRandom());
		thirst += (generateRandom());
		mood -= (generateRandom());
		health -= 3;
		cageMessiness += (5 + generateRandom());
		return cageMessiness;
	}

	@Override
	public int generateRandom() {
		return generator.nextInt(10);
	}
}
