# Lab 4 - Constraint Satisfaction Problem

## Tasks

### 1. Modeling the problem as a CSP

by reading the constraint of the game (with a few extra constraints for the implementation):

1. There are five houses.
2. The Englishman lives in the red house.
3. The Spaniard owns the dog.
4. Coffee is drunk in the green house.
5. The Ukrainian drinks tea.
6. The green house is immediately to the right of the ivory house.
7. The Old Gold smoker owns snails.
8. Kools are smoked in the yellow house.
9. Milk is drunk in the middle house.
10. The Norwegian lives in the first house.
11. The man who smokes Chesterfields lives in the house next to the man with the fox.
12. Kools are smoked in the house next to the house where the horse is kept.
13. The Lucky Strike smoker drinks orange juice.
14. The Japanese smokes Parliaments.
15. The Norwegian lives next to the blue house.
16. No two people live in the same house
17. Each person smokes a different cigarette

To get to a unique solution, we assume that each of the five houses has a different color, each
of the five inhabitants has a different nationality, prefers a different brand of cigarettes, a different
drink, and owns a different pet. The five houses are arranged in a row (no house has more than
2 neighbors, two houses have just 1 neighbor), left and right are from your point of view, the first
house is the left-most one.

The variables can be defined as:
$$
X = \{Na, C, P, S, D, N_1, N_2\}
$$
where Na is the nationality of the owner of the house of color C, owns a pet P, smokes S, drinks D, and has two neighbors, $N_1$ and $N_2$.

We also have the domain, which is shared by all variables:
$$
D_{Na}=D_C=D_P= D_S= D_D=N_1=N_2=\{0, 1,\dots,4\}
$$
Some key facts of the exercise is that no two people live in the same house, have the same pet, drink the same drink, smoke the same cigarettes, or that two houses have the same color.

This means that since all of these variables share the same domain, what we are trying to represent is the house index to which these variables correspond to (1 to 1 relation)

### 2. Size of the State Space



### 3. Implementation

### 4. Results Comparison
