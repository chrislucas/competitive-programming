package com.br.algo.math.sites.mathspp

/**

- Throwing dice is hard
If you roll one (fair, six-sided) die, what is the probability of the result being 1?
We can answer this if we have a bit of knowledge about probability.

A die has six sides and only one of them is a 1.
Because all sides have the same chance of being the side that is face up, the probability of the result being 1 is 1/6.

This was a fairly simple probability question with a fairly simple answer.
However, it doesn't take much for a probability question to become cumbersome and/or very difficult to answer!
Here is an example:

This is not a simple problem!
It is also not very difficult, it is just very annoying to solve by hand.

O problema
Se jodamos 20 vezes um dado de seis lados, qual a probabilidade de que a soma dos numeros
seja exatamente 73 ?




- Estimating the answer

If you need an exact answer, you will need to do some cumbersome computations or you will have to look the answer up online.
However, if you only need the result up to a couple of decimal places, then you can just estimate the answer!
But how?

Write a Python program, of course!

You can write a function that simulates throwing 20 dice and then adding the results up:

from random import randint
def throw_and_sum(n):
"""Throw n dice and sum their results."""
return sum(randint(1, 6) for _ in range(n))

print(throw_and_sum(20))  # 78
Next, you can write a loop that calls this function many times and checks how often the result is exactly 73!
The proportion of times the result is 73 will give you an estimate of the correct answer:

N = 1_000_000
hits = 0
for _ in range(N):
if throw_and_sum(20) == 73:
hits += 1

print(hits / N)  # 0.047812
According to the print above, the probability is going to be around 4.78%.

Is this number correct?
​No.
It is just an estimate of the correct answer.
However, the larger the value of N, the more accurate the result gets.
Reversely, if we set N to a small number, the result loses accuracy.

The most extreme example of this is if we set N to 1!
If we do that, the only simulation will either match 73 or not, which means our estimate will either be of 100% or 0%.

On the other hand, if we increase the value of N, we get more accurate results.
I tried increasing N to 10,000,000 and the result I got was 0.0480522.
Now, the correct answer seems to be around 4.81%.

Monte Carlo method
This type of program, where you run a random simulation multiple times to observe the results you get,
is called a Monte Carlo simulation or a Monte Carlo experiment.

The structure of a Monte Carlo simulation is pretty much always the same:

Start with a problem for which it is hard (or impossible!) to compute the exact answer. (In
our case, that was the problem of knowing the probability of a roll of 20 dice summing up to 73.)
Write code that mimics the event you are working with. (In our case, that was the function throw_and_sum that mimics the rolling of 20 dice and then summing up the results.)
Define a (large) number of repetitions for your experiment. (That was our N.)
Run your experiment the defined number of times.
Use the results to estimate the answer you care about. (In the dice example, we counted how many times the result of the throw and sum was exactly 73.)
The Monte Carlo method is widely used, with applications in areas from computer graphics to finance.
I use it from time to time in my own projects.

Have you ever used the Monte Carlo method?
If you haven't, I have a small challenge for you:

A challenge for you
Here is a challenge for you to solve with the Monte Carlo method:

Start rolling a die until the result of a throw is less than the result of the previous throw.
On average, how many times do you have to roll the die until you stop?
Just reply to this email with your code/estimated solution!

Thanks for reading, and I'll see you next time!

Rodrigo.


 */