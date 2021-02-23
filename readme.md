# Lab 4 - Constraint Satisfaction Problem

Wojciech Woźniak
Ermir Pellumbi
Yann Le Lorier

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
18. No pet lives in the same house
19. every person has a different drink
20. No house is the same color

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

The size of the state space is given by two cases:

**With repetition**:

We consider that two or more houses can be blue, or that two people can have a dog, for example.
$$
S_S = 5^5 \times 5^5 \times5^5 \times 5^5 \times 5^5 = 3\times10^{17}
$$
**Without repetition**:

We consider that no two houses can have the same color, or that no two people can live in the same house
$$
S_S = 5! \times 5! \times 5! \times 5! \times 5! = 2.5\times10^{10}
$$
Where the number 5 comes from the five possible values that a variable can take, whether it is with replacement -factorial- or not -power of 5-

### 3. Implementation

### 4. Results Comparison

Example output:

```
======================
running backtracking + AC3 + most constrained variable + least constraining value
runtime 0.021s, number of assignments (visited states):31
=======House0========
Norwegian | House index = 0
house0 | House index = 0
Kools | House index = 0
Yellow | House index = 0
Water | House index = 0
Fox | House index = 0
=======House1========
Blue | House index = 1
house1 | House index = 1
Horse | House index = 1
Ukranian | House index = 1
Chesterfields | House index = 1
Tea | House index = 1
=======House2========
Milk | House index = 2
house2 | House index = 2
Englishman | House index = 2
Red | House index = 2
Old Gold | House index = 2
Snails | House index = 2
=======House3========
house3 | House index = 3
Ivory | House index = 3
Lucky Strike | House index = 3
Spaniard | House index = 3
Orange juice | House index = 3
Dog | House index = 3
=======House4========
house4 | House index = 4
Green | House index = 4
Coffee | House index = 4
Japanese | House index = 4
Parliaments | House index = 4
Zebra | House index = 4
======================
running backtracking + AC3 + most constrained variable
runtime 0.006s, number of assignments (visited states):46
=======House0========
Norwegian | House index = 0
house0 | House index = 0
Kools | House index = 0
Yellow | House index = 0
Water | House index = 0
Fox | House index = 0
=======House1========
Blue | House index = 1
house1 | House index = 1
Horse | House index = 1
Ukranian | House index = 1
Chesterfields | House index = 1
Tea | House index = 1
=======House2========
Milk | House index = 2
house2 | House index = 2
Englishman | House index = 2
Red | House index = 2
Old Gold | House index = 2
Snails | House index = 2
=======House3========
house3 | House index = 3
Ivory | House index = 3
Lucky Strike | House index = 3
Spaniard | House index = 3
Orange juice | House index = 3
Dog | House index = 3
=======House4========
house4 | House index = 4
Green | House index = 4
Coffee | House index = 4
Japanese | House index = 4
Parliaments | House index = 4
Zebra | House index = 4
======================
running backtracking + AC3
runtime 0.004s, number of assignments (visited states):30
=======House0========
house0 | House index = 0
Yellow | House index = 0
Norwegian | House index = 0
Kools | House index = 0
Water | House index = 0
Fox | House index = 0
=======House1========
house1 | House index = 1
Blue | House index = 1
Ukranian | House index = 1
Chesterfields | House index = 1
Tea | House index = 1
Horse | House index = 1
=======House2========
house2 | House index = 2
Red | House index = 2
Englishman | House index = 2
Old Gold | House index = 2
Milk | House index = 2
Snails | House index = 2
=======House3========
house3 | House index = 3
Ivory | House index = 3
Spaniard | House index = 3
Lucky Strike | House index = 3
Orange juice | House index = 3
Dog | House index = 3
=======House4========
house4 | House index = 4
Green | House index = 4
Japanese | House index = 4
Parliaments | House index = 4
Coffee | House index = 4
Zebra | House index = 4
======================
running backtracking + forward checking + most constrained variable + least constraining value
#... (runs indefinitely - we only waited for 10 minutes or so)
```



| Heuristics           | Experiment 1 | Experiment 2 | Experiment 3 | Experiment 4 | # visited states |
| -------------------- | ------------ | ------------ | ------------ | ------------ | ---------------- |
| BT + AC3 + MCV + LCV | 0.021s       | 0.023s       | 0.016s       | 0.018s       | 31               |
| BT + AC3 + MCV       | 0.006s       | 0.008s       | 0.007s       | 0.005s       | 46               |
| BT + AC3             | 0.004s       | 0.003s       | 0.003s       | 0.003s       | 30               |
| BT + FW checking     | 0.031s       | 0.032s       | 0.04         | 0.035s       | 2340             |



We did not bother in adding the other rows to this table as the execution of the program was going on indefinitely, this is due to the fact that some heuristics were deactivated in the `ImprovedBacktrackingStrategy` function call, and made the algorithm very slow.

**Note on the heuristics:**

The difference between the multiple runs of the algorithms lies on the activation of the heuristics that speed up the search noticeably. It is important then to choose carefully the heuristics we are going to use.

**Note on the Propagation algorithms**

The propagation algorithms do not serve a good purpose or bad in every single scenario, but rather, some are better suited to some scenarios than others.

