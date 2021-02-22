import java.util.List;
import java.util.ArrayList;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.CSP;
import aima.core.search.csp.CSPStateListener;
import aima.core.search.csp.Domain;
import aima.core.search.csp.ImprovedBacktrackingStrategy;
import aima.core.search.csp.NotEqualConstraint;
import aima.core.search.csp.SolutionStrategy;
import aima.core.search.csp.Variable;

public class Main {

	private static CSP setupCSP() {
		CSP csp = null;
//		In five houses, each with a different color, live five persons of different nationality,
//		each of whom prefers a different brand of cigarettes, a different drink, and a different pet.
//		The five houses are arranged in a row (no house has more than 2 neighbors).   
//		# The Englishman lives in the red house.
//		# The Spaniard owns the dog.
//		# Coffee is drunk in the green house.
//		# The Ukrainian drinks tea.
//		# The green house is immediately to the right of the ivory house.
//		# The Old Gold smoker owns snails.
//		# Kools are smoked in the yellow house.
//		# Milk is drunk in the middle house.
//		# The Norwegian lives in the first house.
//		# The man who smokes Chesterfields lives in the house next to the man with the fox.
//		# Kools are smoked in the house next to the house where the horse is kept.
//		# The Lucky Strike smoker drinks orange juice.
//		# The Japanese smokes Parliaments.
//		# The Norwegian lives next to the blue house.
//
//		Now, who drinks water? Who owns the zebra?
				
		String[] colors = {"Red", "Green", "Ivory", "Yellow", "Blue"};
		String[] nations = {"Englishman", "Spaniard", "Norwegian", "Ukranian", "Japanese"};
		String[] cigarettes = {"Old Gold", "Kools", "Chesterfields", "Lucky Strike", "Parliaments"};
		String[] drink = {"Water", "Orange juice", "Tea", "Coffee", "Milk"};
		String[] pet = {"Zebra", "Dog", "Fox", "Snails", "Horse"};

		Variable house1 = new Variable("house1");
		Variable house2 = new Variable("house2");
		Variable house3 = new Variable("house3");
		Variable house4 = new Variable("house4");
		Variable house5 = new Variable("house5");

		Variable englishMan = new Variable(nations[0]);
		Variable spaniard = new Variable(nations[1]);
		Variable norwegian = new Variable(nations[2]);
		Variable ukranian = new Variable(nations[3]);
		Variable japanese = new Variable(nations[4]);

		Variable red = new Variable(colors[0]);
		Variable green = new Variable(colors[1]);
		Variable ivory = new Variable(colors[2]);
		Variable yellow = new Variable(colors[3]);
		Variable blue = new Variable(colors[4]);

		Variable oldGolds = new Variable(cigarettes[0]);
		Variable kools = new Variable(cigarettes[1]);
		Variable chesterfields = new Variable(cigarettes[2]);
		Variable luckyStrike = new Variable(cigarettes[3]);
		Variable parliaments = new Variable(cigarettes[4]);

		Variable water = new Variable(drink[0]);
		Variable orangeJuice = new Variable(drink[1]);
		Variable tea = new Variable(drink[2]);
		Variable coffee = new Variable(drink[3]);
		Variable milk = new Variable(drink[4]);

		Variable zebra = new Variable(pet[0]);
		Variable dog = new Variable(pet[1]);
		Variable fox = new Variable(pet[2]);
		Variable snails = new Variable(pet[3]);
		Variable horse = new Variable(pet[4]);

		List<Variable> variables = new ArrayList<>();

		variables.add(house1);
		variables.add(house2);
		variables.add(house3);
		variables.add(house4);
		variables.add(house5);

		variables.add(red);
		variables.add(green);
		variables.add(ivory);
		variables.add(yellow);
		variables.add(blue);

		variables.add(englishMan);
		variables.add(spaniard);
		variables.add(norwegian);
		variables.add(ukranian);
		variables.add(japanese);

		variables.add(oldGolds);
		variables.add(kools);
		variables.add(chesterfields);
		variables.add(luckyStrike);
		variables.add(parliaments);

		variables.add(water);
		variables.add(orangeJuice);
		variables.add(tea);
		variables.add(coffee);
		variables.add(milk);

		variables.add(zebra);
		variables.add(dog);
		variables.add(fox);
		variables.add(snails);
		variables.add(horse);
		
		csp = new CSP(variables);

		// Domain d1 = new Domain(new String[]{"foo", "bar"});

		Integer[] houseIndexes = new Integer[]{0, 1, 2, 3, 4};
		Domain domain = new Domain(houseIndexes);

		csp.setDomain(house1, domain);
		csp.setDomain(house2, domain);
		csp.setDomain(house3, domain);
		csp.setDomain(house4, domain);
		csp.setDomain(house5, domain);

		csp.setDomain(red, domain);
		csp.setDomain(green, domain);
		csp.setDomain(ivory, domain);
		csp.setDomain(yellow, domain);
		csp.setDomain(blue, domain);

		csp.setDomain(englishMan, domain);
		csp.setDomain(spaniard, domain);
		csp.setDomain(norwegian, domain);
		csp.setDomain(ukranian, domain);
		csp.setDomain(japanese, domain);

		csp.setDomain(oldGolds, domain);
		csp.setDomain(kools, domain);
		csp.setDomain(chesterfields, domain);
		csp.setDomain(luckyStrike, domain);
		csp.setDomain(parliaments, domain);

		csp.setDomain(water, domain);
		csp.setDomain(orangeJuice, domain);
		csp.setDomain(tea, domain);
		csp.setDomain(coffee, domain);
		csp.setDomain(milk, domain);

		csp.setDomain(zebra, domain);
		csp.setDomain(dog, domain);
		csp.setDomain(fox, domain);
		csp.setDomain(snails, domain);
		csp.setDomain(horse, domain);

		// Domain d2 = new Domain(new Integer[]{1, 2});
		// csp.setDomain(var2, d2);

		csp.addConstraint(new NotEqualConstraint(englishMan, spaniard));
		csp.addConstraint(new NotEqualConstraint(dog, zebra));
		csp.addConstraint(new NotEqualConstraint(zebra, fox));
		csp.addConstraint(new NotEqualConstraint(zebra, snails));
		csp.addConstraint(new NotEqualConstraint(zebra, horse));

		csp.addConstraint(new NotEqualConstraint(norwegian, englishMan));
		csp.addConstraint(new NotEqualConstraint(norwegian, spaniard));
		csp.addConstraint(new NotEqualConstraint(norwegian, ukranian));
		csp.addConstraint(new NotEqualConstraint(norwegian, japanese));

		csp.addConstraint(new SuccessorConstraint(englishMan, red)); //englishman in red house

		csp.addConstraint(new EqualConstraint(spaniard, dog)); //spaniard has a dog

		csp.addConstraint(new EqualConstraint(coffee, green)); //coffee in green house

		csp.addConstraint(new EqualConstraint(ukranian, tea)); //ukranian drinks tea

		csp.addConstraint(new SuccessorConstraint(ivory, green));

		csp.addConstraint(new EqualConstraint(oldGolds, snails)); //the guy who smokes old golds has snails

		csp.addConstraint(new EqualConstraint(kools, yellow)); //kools smoked in the yellow house

		csp.addConstraint(new EqualConstraint(milk, house3));

		csp.addConstraint(new EqualConstraint(norwegian, house1));

		csp.addConstraint(new DifferByOneConstraint(chesterfields, fox));

		csp.addConstraint(new DifferByOneConstraint(kools, horse));

		csp.addConstraint(new EqualConstraint(luckyStrike, orangeJuice));

		csp.addConstraint(new EqualConstraint(japanese, parliaments));

		csp.addConstraint(new DifferByOneConstraint(norwegian, blue));
		
		// csp.addConstraint(new NotEqualConstraint(var1, var2)); // meaning var1 != var2
		// csp.addConstraint(new EqualConstraint(var1, var2)); // meaning var1 == var2
		// csp.addConstraint(new SuccessorConstraint(var1, var2)); // meaning var1 == var2 + 1
		// csp.addConstraint(new DifferByOneConstraint(var1, var2)); // meaning var1 == var2 + 1 or var1 == var2 - 1 
		
		return csp;
	}

	private static void printSolution(Assignment solution) {
		// TODO print out useful answer
		// You can use the following to get the value assigned to a variable:
		// Object value = solution.getAssignment(englishMan);

		// For debugging it might be useful to print the complete assignment and check whether
		// it makes sense.
		System.out.println("solution:" + solution);
	}
	
	/**
	 * runs the CSP backtracking solver with the given parameters and print out some statistics
	 * @param description
	 * @param enableMRV
	 * @param enableDeg
	 * @param enableAC3
	 * @param enableLCV
	 */
	private static void findSolution(String description, boolean enableMRV, boolean enableDeg, boolean enableAC3, boolean enableLCV) {
		CSP csp = setupCSP();

		System.out.println("======================");
		System.out.println("running " + description);
		
		long startTime, endTime;
		startTime = System.currentTimeMillis();
		SolutionStrategy solver = new ImprovedBacktrackingStrategy(enableMRV, enableDeg, enableAC3, enableLCV);
		final int nbAssignments[] = {0};
		solver.addCSPStateListener(new CSPStateListener() {
			@Override
			public void stateChanged(Assignment arg0, CSP arg1) {
				nbAssignments[0]++;
			}
			@Override
			public void stateChanged(CSP arg0) {}
		});
		Assignment solution = solver.solve(csp);
		endTime = System.currentTimeMillis();
		System.out.println("runtime " + (endTime-startTime)/1000.0 + "s" + ", number of assignments (visited states):" + nbAssignments[0]);
		printSolution(solution);
	}

	/**
	 * main procedure
	 */
	public static void main(String[] args) throws Exception {
		// run solver with different parameters
		findSolution("backtracking + AC3 + most constrained variable + least constraining value", true, true, true, true);
		findSolution("backtracking + AC3 + most constrained variable", true, true, true, false);
		findSolution("backtracking + AC3", false, false, true, false);
		findSolution("backtracking + forward checking + most constrained variable + least constraining value", true, true, false, true);
		findSolution("backtracking + forward checking + most constrained variable", true, true, false, false);
		findSolution("backtracking + forward checking", false, false, false, false);
	}

}
