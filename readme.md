# Lab 4 - Constraint Satisfaction Problem

## Tasks

### 1. Modeling the problem as a CSP

by reading the set of rules of the game:

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

The variables can be defined as:
$$
X = \{Na, C, P, S, D, N_1, N_2\}
$$
where Na is the nationality of the owner of the house of color C, owns a pet P, smokes S, drinks D, and has two neighbors, $N_1$ and $N_2$.

We also have the domain defined as:
$$
D_{Na} = \{\text{English}, \text{Spanish},\text{Ukranian}, \text{Norwegian}, \text{Japanese}\}\\
D_{C} = \{\text{Red}, \text{Green}, \text{Ivory}, \text{Yellow}, \text{Blue}\}\\
D_P = \{\text{Dog}, \text{Snails}, \text{Fox}, \text{Horse}, \text{Zebra}\}\\
D_{S} = \{\text{Old Gold}, \text{Kools}, \text{Chesterfields}, \text{Lucky Strike}, \text{Parliament}\}\\
D_D = \{\text{Coffee}, \text{Tea}, \text{Milk}, \text{Orange Juice}, \text{Water}\}\\
N_1 = D_{Na}\\
N_2 = D_{Na}
$$

### 2. Size of the State Space

### 3. Implementation

### 4. Results Comparison
