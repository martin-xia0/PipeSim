<link href="./docs/style.css" rel="stylesheet"></link>

# PipeSim

## Getting Started
With urban civil water demand increase, the burden of the previous water supply system is becoming heavier. Planning in advance is becoming increasingly important in the construction and renovation of the city water distribution network. 

The main mission for PipeSim is to help water companies to make the right planning and control the water loss. PipeSim incorporates hydraulic models and data mining models to do hydraulic simulation and water loss detection.

## Functions
### Hydraulic simulation
Hydraulic simulation mainly depends on the calculation of frictional headloss and local headloss. With pipeline diagrams, required quantities and initial pressure of the network, the pressure distribution of the network can be simulated and you can check headloss in any pipeline or pressure in any pipenode.

To simulate the network pressure distribution, first, you need to import the pipeline diagrams. Then set the initial pressure and the demand quantity. Finally, choose the target pipeline or key porint or a branch you want to check and you can get the theorical pressure.
### Water loss detection

## Models
### Hydraulic models
Hydraulic models mainly depend on modern fluid mechanics theory.The frictional head loss is mainly calculated in two ways which can be selected -- the more accurate one, Darcy-Weisbach Formula and the more convenient one, Hazen-Wllliams Formula. The local headloss can also be calculated accurately by using the experimental coefficient table or just take it appoximately 8%-12% of the total frictional head loss.
### Data mining models
- space-time probabilistic model