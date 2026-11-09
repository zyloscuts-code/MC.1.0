# OceanRaftSurvival (Paper 1.21.11)

A Paper plugin project for an ocean-only raft survival start.

## Features
- Creates a separate `RaftOcean` world using the normal overworld terrain generator and a deep-ocean-only biome provider.
- Builds a 3x3 waterlogged oak-slab starter raft at the world spawn.
- Teleports joining and respawning players to the raft and gives them a fishing rod.
- Spawns floating resource item entities within 20 blocks. Item entities are set to unlimited lifetime.
- Resource pool contains 2 diamond entries in a 50-entry pool (about 4% per resource roll).
- Spawns 4-7 loot-filled barrel blocks every Minecraft day (24,000 ticks).
- Rare shark encounters are represented by named, persistent Drowned mobs that are spawned well away from the raft and are prevented from targeting players near the raft.

## Important implementation notes
- Vanilla oak planks cannot be waterlogged. The starter raft therefore uses waterlogged oak slabs, which visually read as a low oak-plank raft.
- Barrels are real, openable barrel blocks placed at the ocean surface. They are not physics-based dropped entities.
- Vanilla Minecraft has no shark mob. The current shark implementation uses a named Drowned as a functional placeholder. A custom resource pack/model would be needed for a true shark appearance.
- The ocean world keeps Minecraft's normal overworld terrain generator while forcing the biome to `DEEP_OCEAN`. It should generate ocean terrain, but always test a fresh world before using it on a live server.
- Daily barrels spawn as a batch once every 24,000 server ticks (one Minecraft day), not spread evenly through the day.

## Build
Requires JDK 21 and Maven 3.9+.

From this folder run:

```bash
mvn clean package
```

The plugin JAR will be in `target/ocean-raft-survival-1.0.0.jar`.

## Install
1. Back up your server.
2. Build the project.
3. Copy the JAR from `target/` into the Paper server's `plugins/` folder.
4. Start Paper 1.21.11.
5. The plugin creates and uses the `RaftOcean` world automatically.
6. Set your server's default world/spawn routing to `RaftOcean` if you want all first-time joins to start there.

## Commands
- `/raft` — teleport yourself to the raft (OP/admin).
- `/raft reload` — reload `config.yml` and restart resource/shark timers (OP/admin).

## Configuration
Edit `plugins/OceanRaftSurvival/config.yml`. Values are documented inline.
