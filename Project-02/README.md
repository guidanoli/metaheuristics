# Second Project - MSSC

## Problem statement

Given:
* A set of n entities O = {o<sub>1</sub>,o<sub>2</sub>,...,o<sub>n</sub>} at given points pi= (p<sub>ik</sub>,k=1,...,s) of R<sup>s</sup> for i=1,...,n
* A fixed number c of clusters. The objective is to find c cluster centres located in points z<sub>j</sub> ∈ R<sup>s</sup> for j=1,...,c in order to minimize

![Minimizing goal equation](https://i.imgur.com/e2it5SM.png)

where the binary variables w<sub>ij</sub> express the assignment of the entity o<sub>i</sub> to the cluster j.

## Instances

I'll be using UCI instances since some of them are thankfully small enough to put on the repository. Some of them are quite big and I found not interesting to upload them. If you wish to download all of them, access the lecturer's website [here](https://w1.cirrelt.ca/~vidalt/en/research-data.html).

**Disclaimer:** Bigger instances cannot be uploaded to GitHub directly. Therefore, you must download them through the link provided in the data/MSSC folder. Text files are ignored on that folder so it's advised to extract them there.

## Running the program

See Project 01 README.md file. Many of the arguments are the same, but are problem-specific, so be sure to consult all of them by adding the `-help` argument.