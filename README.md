# Nature Simulation

This simple project was created to test an application of my evolutionary algorithm library.

The evolutionary algorithm library can be found and downloaded [here](https://github.com/akyriazis/evolutionary-algorithm).

##The setup

This program simulates a simplified model of how animals behave in nature, and attempts to optimize their behaviour for maximum results.

The behaviour of the model is based on simple rules.

1. An animal can do one of 4 things every iteration: eat, sleep, play, or do nothing.

  -Eating increases its health, with diminishing returns.

  -Sleeping increases health, but when sleeping, the animal is vunerable to predation.
  
  -Playing increases fitness, which helps an animal avoid being eaten.
  
  -Doing nothing does nothing.

2. At every iteration, an animal could starve if its health is low, or could be eaten if its fitness is low.

3. After 60 iterations, the animal will be awarded a score to determine its likelihood to advance to the next generation. Its score is based on its health, fitness and whether or not the animal survived 60 iterations.

##Simulation Details

-Each generation will have a population of 10 individuals. 

-An individual's behaviour is determiend by its DNA which is made up of the characters 'e','s','p','n', standing for eat, sleep, play, nothing.

-The DNA of generation 1 is determined randomly. 

-After reaching the age of 60, an animal's simulation stops and the animal is assessed.

##Simulation Results
```
Generation 1
================
epssnnnnesennesesnnpseneeppppeppesneennsnssssnspseenpppppesn - DEAD AT AGE 6 by starvation
nepeespneessennseeensnnsnpeessppeseppsnsnnsnsespseenpppppesn - DEAD AT AGE 6 by predation while asleep
nepeeepneespnepneneeseeseppnpnepsnspnnnsnsnesnssepsnennpnepe - DEAD AT AGE 3 by predation
sesspnnpnnsseenseeensnnsnpeessppeseppsnsnnsnsespseenpppppesn - DEAD AT AGE 3 by predation
sesspnnpnnsseenseeensnnsnpeessppeseppsnsnnsnsespseenpppppesn - DEAD AT AGE 3 by predation
sesspnnpnnsseenseeensnnsnpeessppeseppsnsnnsnsespsennpppppesn - DEAD AT AGE 3 by predation while asleep
sesspnnpnnsseenseeensnnsnpeessppeseppsnsnnsnsensenennnpppnnn - DEAD AT AGE 3 by predation
nepeespneespnepneneesepseppnpnepsnspnnnsnsnesnssepsneenpnepe - DEAD AT AGE 3 by predation
sesspnnpnnsseenseeensnnsnpeessppeseppsnsnnsnsespseenpppppesn - DEAD AT AGE 3 by predation
sesspnnpnnspnepneneesepseppnpnepsnspnnnsnsnesnssepsneenpnepe - DEAD AT AGE 3 by predation
```
Initially, no animal makes it past the age of 6. Cause of death is mainly predation, indicating the animals haven't 'played' enough in the beginning to gain fitness. Also note the animals are doing a lot of "nothing" which is not helping their survival.

```
Generation 10
================
epsepepneeppneppeneeneeseppnpnepsnspnnnsnsnessssnpsnennpnepe - DEAD AT AGE 24 by predation
epsepepneeppnepneneeneeseppnpnepsnspnnnsnsnessssnpsnennpnepe - DEAD AT AGE 23 by predation
epsepepneeppnepneneeneeseppnpnepsnspnnnsnsnesnssepsnennpnepe - DEAD AT AGE 22 by predation
epsepepneeppnepneneeneeseppnpnepsnspnnnsnsnessssnpsnennpnepe - DEAD AT AGE 22 by predation
epeepepneeppnepneneeneeseppnpnepsnspnnnsnnnessssnpsneenpnepe - DEAD AT AGE 21 by predation
epsepepneeppnepneneeneeseppnpnepsnspnnnsnsnessssnpsnennpnepe - DEAD AT AGE 18 by predation
epsepepneepnnepneneeneeseppnpnepenspnnnsssnessssnpsnennpnepe - DEAD AT AGE 11 by predation
epsepepneeppnepneneeneeseppnpnepsnspnnnsnsnesnssepsnennpnepe - DEAD AT AGE 11 by predation
epsepepneeppnepneneeneeseppnpnepsnspnnnsnsnessssnpsnennpnepe - DEAD AT AGE 3 by predation while asleep
epsepepneeppnepneneeneeseppnpnepsnspnnnsnsnessssnpsnennpnepe - DEAD AT AGE 3 by predation while asleep
```
By generation 10, the population has a much higher life expectency. Fitness is still the main issue.

```
Generation 50
================
eppepspsenppeepppnpenpeseppppnepsnspppnpspnesenseennssnpenpp - 227
eppepspsenppeepppnpenpeseppppnepsnnpppnpspnnpenseennssnpenpp - 216
eppepspsenppeepppnpenpeseppppnepsnspppnpspnesenseennssnpenpp - DEAD AT AGE 58 by predation
eppepspsenppeepnpnpeppeseppppnepsnspppnpspnesenseennssnpenpp - DEAD AT AGE 56 by predation
eppepspsenppeepppnpenpeseppppnepsnnppnnpspnepenseennssnpenpp - DEAD AT AGE 56 by predation
eppepspsenppeepnpnpenpeseppppnepsnspppnpspnesenseennssnppnpn - DEAD AT AGE 55 by predation
eppepspsenppeepppnpeppeseppppnepsnnpppnpspnepenseennssnpenpp - DEAD AT AGE 53 by predation while asleep
eppepspsenppeepnpnpeppeseppppnepsnspppnpspnesenseennssnpenpp - DEAD AT AGE 53 by predation while asleep
eppepspsenppeepppnpenpeseppppnepsnspppnpspnesenseennssnpenpp - DEAD AT AGE 48 by predation while asleep
eppepspsenppeepppnpenpeseppppnepsnnpppnpspnesenseennssnpenpp - DEAD AT AGE 45 by predation while asleep
```
Finally some animals are surviving for the whole simulation. The numbers next to the living animals indicate their score. Also worth noting, more animals are dying while asleep. They've become greedy and are abusing sleep for health but now are seeing the consequences of too much sleep.

```
Generation 100
================
eppepspsenppespppppenpeseppeepeppnenppnpsnpeeeepeeepssnseeep - 278
eppepspeenppespppppenpeseppeepeppnenppnpsnpeeeepeeepssnseeep - 278
eppepspeenppespppppenpeseppeepeppnenppnpsnpeeeepeeepssnseeep - 278
eppepspeenppespppppenpeseppeepeppnenppnpsnpeeeepeeepssnseeep - 278
eppepspsenppespppppenpeseppeepeppnenppnpsnpeeeepeeepssnseeep - 278
eppepspeenppespppppenpeseppeepeppnenppnpsnpeeeepeeepssnseeep - 278
eppepspsenppespppppenpeseppeepeppnenppnpsnpeeeepeeepssnseeep - 278
eppepspnenppeeppppnenpesepppeneppnepppnpsspeeeepeeepssnseeep - 276
eppepspsenppeepspppeppeseppeeneppnepppnpsspeeeepeeepssnsenep - 270
eppepspsenppespppppenpeseppeepeppnenppnpsnpeeeepeeepssnseeep - DEAD AT AGE 8 by predation while asleep
```
Most animals are surviving at this point, it's now becoming a matter of who is eating the most food. Animals are also clearly avoiding "doing nothing" which would obviously not help them. Only proactive animals survive!

```
Generation 200
================
eppepspspsppespppeeenpeppppeepeppnepppneepneeeepeeepeeeeeeee - 316
eppepspspsppespppeeenpeppppeepeppnepppnpepneeeepeeeseeeeeeee - 314
eppepspspsppespppeeenpeppppeepeppnepppnpepneeeepeeepeeeeeeee - 313
eppepspspsppespppeeenpeppppeepeppnepppnpepneeeepeeepeeeeeeee - 313
eppepspspsppespppeeenpeppppeepeppnepppnpepneeeepeeepeeeeeeee - 313
eppepspspsppespppeeenpeppppeepeppnepppnpepneeeepeeepeeeeeeee - 313
eppepspspsppespppeeespeppppeeeeppneppsnpppneeeepeeepeeeeeeee - 311
eppepspspsppsspppeeenpeppppeepeppnepppnpepneeenpeeepeeeeeeee - DEAD AT AGE 14 by starvation
eppepspspsppespppeeenpeppppeepeppnepppnpepneeeepeeepeeeeeeee - DEAD AT AGE 10 by predation while asleep
eppepspspsppespppeeenpeppppeepeppnepppnpepneeeepeeepeeeeeeee - DEAD AT AGE 10 by predation while asleep
```
This is the extent to which I've evolved this population. Their scores are definitely increasing. It is interesting to note that they are getting greedy toward the end and are eating as much as possible in the last stretch because there is no consequence of lacking fitness after the 60th iteration.

##Conclusion

The algorithm appears to be working and producing interesting results! It's hard to try to conceptually understand what the optimal solution to a problem like this might be, but evolutionary algorithms are certaintly making it clearer. This is a very simple application that was very easy to implement with my evolutionary algorithm engine. I'm interested in seeing the potential in evolutionary algorithms for more realistic models, and more significant problems. 
