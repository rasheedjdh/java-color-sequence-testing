Checks for a given sequence of colors, whether the maximal capacity in a moving sized window of is satisfied.

Example: 

Capacity rule: {window_with: 3, color: r, max_capacity: 2}
colors: {r, r, r, g}

windows:

1) |r, r, r| g

2)  r| r, r, g|

3)  r, r| r, g  |

4)  r, r, r| g    |


// 1st window: r, r, r -> 1 red too much

// 2nd window: r, r, g -> 0 no penalty

// 3rd window: r, g, . -> 0 no penalty

// 4th window: g, ., . -> 0 no penalty

Your task is to write the algorithm, and the test cases.



