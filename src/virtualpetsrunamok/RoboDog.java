package virtualpetsrunamok;

public class RoboDog extends Dog implements RoboticPet {
	int oilLevel;

	public RoboDog(String nameParam, String descriptionParam) {
		super(nameParam, descriptionParam);
		oilLevel = 50;
	}

	@Override
	public void walk() {
		mood += 20;
		health += 10;
		oilLevel -= 5;
	}

	@Override
	public void play() {
		mood += 20;
		oilLevel -= 5;
	}

	@Override
	public void oilPet() {
		oilLevel += 20;
		mood += 5;
	}

	@Override
	public void recharge() {
		mood += 10;
		health += 10;
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
	public int getOilLevel() {
		return oilLevel;
	}

	@Override
	public int tick() {
		mood -= (generateRandom());
		oilLevel -= (generateRandom());
		health -= 2;
		return 0;
	}

	@Override
	public int generateRandom() {
		return generator.nextInt(10);
	}
}