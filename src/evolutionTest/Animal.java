package evolutionTest;

import com.alexkyriazis.evolution.Evolver;

public class Animal extends Evolver {
	
	public static final double PROBABILITY_EATEN_DURING_SLEEP = 0.95;
	public static final double PROBABILITY_EATEN_WHEN_WEAK = 0.6;
	
	private int maxAge;

	private int health;
	private int fitness;
	private int age;
	
	Boolean dead;
	String deathType = "Not Dead";

	public Animal(String dna) {
		super(dna);
		this.reset();
		maxAge = dna.length();
	}

	@Override
	protected int computeFitness() {
		
		if (this.dead) {
			return this.age;
		}
		
		return maxAge + this.health + (int) 0.1*this.fitness;
	}

	@Override
	protected void defineBehaviour() {
		
		//ANIMAL EATS
		this.defineAction('e', new Action(){
			public void act() {
				if (Animal.this.dead) {return;}
				
				//Increase health by an amount that is subject to diminishing returns
				Animal.this.health+=(int) (50*((double) Animal.this.age/Animal.this.health - 0.1)); 
				
				Animal.this.update();
			}
		});
		
		//ANIMAL SLEEPS
		this.defineAction('s', new Action(){
			public void act() {
				if (Animal.this.dead) return;
				
				//benefit from the sleep
				Animal.this.health++; 	
				
				//chance animal will get eaten during sleep
				if (Math.random() > PROBABILITY_EATEN_DURING_SLEEP){
					Animal.this.die("predation while asleep");
				}
				
				Animal.this.update();
			}
		});
		
		//ANIMAL PLAYS
		this.defineAction('p', new Action(){
			public void act() {
				if (Animal.this.dead) return;
				
				//increases fitness level
				Animal.this.fitness+=5;
				//decreases health (gets hungry)
				Animal.this.health--;
				
				Animal.this.update();
			}
		});	

		//ANIMAL DOES NOTHING
		this.defineAction('n', new Action(){
			public void act() {
				if (Animal.this.dead) return;
				Animal.this.update();
			}
		});			
		
	}
	
	private void update() {
		if (dead) return;
		
		this.age++;
		
		//die if you haven't eaten enough food
		if (Math.round(this.health / this.age) < 2) {
			this.die("starvation");
		}
		
		//random chance you get attacked by a predator. If you're not fit enough, you die.
		if (Math.round(this.fitness/this.age) < 2) {
			if (Math.random() > PROBABILITY_EATEN_WHEN_WEAK){
				this.die("predation");
			}
		}
	}
	
	private void die(String cause){
		this.dead = true;
		this.deathType = cause;
	}
	
	public String getCauseOfDeath(){
		return this.deathType;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public Boolean isDead() {
		return this.dead;
	}

	@Override
	protected void reset() {
		health = 5;
		age = 1;	
		fitness = 5;
		dead = false;
		deathType = "Not Dead";
	}

}
