package io.github.some_example_name.serializationPurpose;

import io.github.some_example_name.Bird;
import io.github.some_example_name.Block;
import io.github.some_example_name.Pig;

import java.io.Serializable;
import java.util.ArrayList;

public class SerializableLevel implements Serializable {
    public int levelNumber;
    public ArrayList<BirdDTO> birds = new ArrayList<>();
    public ArrayList<PigDTO> pigs = new ArrayList<>();
    public ArrayList<BlockDTO> blocks = new ArrayList<>();

    public SerializableLevel(int levelNumber, ArrayList<BirdDTO> birds, ArrayList<PigDTO> pigs, ArrayList<BlockDTO> blocks) {
        this.levelNumber = levelNumber;
        this.birds = birds;
        this.pigs = pigs;
        this.blocks = blocks;
    }

    public ArrayList<BirdDTO> getBirdDTOs() {return birds;
    }public ArrayList<PigDTO> getPigDTO() {return pigs;
    }public ArrayList<BlockDTO> getBlockDTO() {return blocks;
    }
}

