# Virtual Agent Visual Recollection

Logan Peterson

Release: Dec 13, 2021

Platform: Minecraft Java Edition

Website: https://github.com/Dudblockman/AgentRecollection/

## Pitch:

This project is a memory system to assist in the recollection of objects viewed by an autonomous agent in a virtual environment to allow it to operate off an imperfect subset of knowledge of the environment around it, making for an artificial intelligence that can act in a more realistic manner in this environment.

## History:

This project is an extension of other research into artificial intelligence, an attempt to utlize Virtual Reality techniques to augment and improve our approach to the problems we currently face in our system.

## Features:

This system can recognize parts of its environment that are within the agent's field of view, which can be customized from a full 360 degree scan (for ease of use and minimizing camera angle management) to a more restrictive angle allowing you to simulate a more human-like agent.

The system can account for the angle between the object and the look vector of the agent, allowing it to assign values based on how in-focus the object is, simulating a 'fovea' for the agent.

The system also records timestamps of when things are observed, allowing the agent to apply a level of fuzziness to its recollection or reason about things that may have changed since it was last observed while the agent wasn't looking. Fortunately in the case of Minecraft, things infrequently change without the direct involvement of the player.

## About:

Developed independently by Logan Peterson

Credits due to Mojang, the Minecraft Fabric team (https://github.com/FabricMC/), Baritone team (https://github.com/cabaletta/baritone)

Faculty Sponsor, Rogelio E. Cardona-Rivera, Ph.D. (rogelio@cs.utah.edu)