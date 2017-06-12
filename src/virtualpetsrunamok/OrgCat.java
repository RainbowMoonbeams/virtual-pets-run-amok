package virtualpetsrunamok;

public class OrgCat extends Cat implements OrganicPet {
	protected int hunger;
	protected int thirst;

	public OrgCat(String nameParam, String descriptionParam) {
		super(nameParam, descriptionParam);
		hunger = 50;
		thirst = 50;
	}

	public void decreaseHealth() {
		health -= 10;
	}

	@Override
	public void feed() {
		hunger -= 20;
		thirst += 5;
		mood += 10;
		health += 10;
	}

	@Override
	public void water() {
		thirst -= 20;
		hunger += 5;
		mood += 10;
		health += 10;
	}

	@Override
	public void play() {
		mood += 20;
		hunger += 10;
		thirst += 10;
		health += 5;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getHealth() {
		return health;
	}

	@Override
	public int getMood() {
		return mood;
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
	public int tick() {
		hunger += (generateRandom());
		thirst += (generateRandom());
		mood -= (generateRandom());
		health -= 3;
		return 5;
	}

	@Override
	public int generateRandom() {
		return generator.nextInt(10);
	}

}