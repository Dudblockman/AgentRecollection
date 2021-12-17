# Virtual Agent Visual Recollection Systen

Logan Peterson

Release: Dec 13, 2021

Platform: Minecraft Java Edition

Website: https://github.com/Dudblockman/AgentRecollection/

## Pitch:

This project is a memory system to assist in the recollection of objects viewed by an autonomous agent in a virtual environment to allow it to operate off an imperfect subset of knowledge of the environment around it, making for an artificial intelligence that can act in a more realistic manner in this environment.

## History:

This project is an extension of other research into artificial intelligence, an attempt to utlize Virtual Reality techniques to augment and improve our approach to the problems we currently face in our system.

## Features:

<img src="https://cdn.discordapp.com/attachments/268437195176673280/921212675759947786/2021-12-16_18.29.15.png">

This system can recognize parts of its environment that are within the agent's field of view, which can be customized from a full 360 degree scan (for ease of use and minimizing camera angle management) to a more restrictive angle allowing you to simulate a more human-like agent.

<img src="https://cdn.discordapp.com/attachments/268437195176673280/921212353117315082/2021-12-16_18.27.11.png">

The system can account for the angle between the object and the look vector of the agent, allowing it to assign values based on how in-focus the object is, simulating a 'fovea' for the agent.

<img src="https://cdn.discordapp.com/attachments/268437195176673280/921212353738055740/2021-12-16_18.27.58.png">

The system also records timestamps of when things are observed, allowing the agent to apply a level of fuzziness to its recollection or reason about things that may have changed since it was last observed while the agent wasn't looking. Fortunately in the case of Minecraft, things infrequently change without the direct involvement of the player.

<img src="https://cdn.discordapp.com/attachments/268437195176673280/921212353738055740/2021-12-16_18.27.58.png">

This system can be used to remember key blocks in a location that may represent the agent's dwelling

<img src="https://cdn.discordapp.com/attachments/268437195176673280/921213229462601788/2021-12-16_18.32.13.png">

Or it may be used to remember spotting rare blocks within the world they may wish to refer to later, such as ores spotted when exploring a cave system.

<img src="https://cdn.discordapp.com/attachments/268437195176673280/921213814056304660/2021-12-16_18.34.31.png">

Video: https://cdn.discordapp.com/attachments/552532614062276639/920090486901989377/Loganpeterson-1.mp4

## About:

Developed independently by Logan Peterson

Credits due to Mojang, the Minecraft Fabric team (https://github.com/FabricMC/), Baritone team (https://github.com/cabaletta/baritone)

Faculty Sponsor, Rogelio E. Cardona-Rivera, Ph.D. (rogelio@cs.utah.edu)
