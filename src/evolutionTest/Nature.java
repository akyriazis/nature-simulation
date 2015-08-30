package evolutionTest;

import java.util.List;

import com.alexkyriazis.evolution.Evolution;
import com.alexkyriazis.evolution.Evolver;

public class Nature {
	
	public static final String STARTING_DNA = "psepseeesppepeppspeppeepsppspspepspeppspeppspepspessssssep";
	public static final int POP_SIZE = 10;
	public static final int NUM_GEN = 200;

	public static void main(String[] args) {
		Evolution zoo = new Evolution(Animal.class,POP_SIZE,STARTING_DNA);
		
		for (int i = 0; i < NUM_GEN; i++) {
			zoo.evolve(1);
			System.out.println("Generation " + zoo.getGenerationCount());
			printGen((List<Animal>)zoo.getCurrentGeneration());	
		}
	}

	public static void printGen(List<Animal> generation) {
		System.out.println("================");
		for (Animal animal : generation) {
			if (animal.isDead()) {
				System.out.println(animal.getDna() + " - " + "DEAD AT AGE " + animal.getAge());
			}else{
				System.out.println(animal.getDna() + " - " + animal.getFitness());
			}
		}
		System.out.println();
	}
	
}
