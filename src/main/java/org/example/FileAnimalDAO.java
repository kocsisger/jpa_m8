package org.example;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileAnimalDAO implements AnimalDAO{
    @Override
    public void saveAnimal(Animal a) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("data.txt", true);
            PrintWriter pw = new PrintWriter(fos);
            pw.println(a);
            pw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Animal> getAnimals() {
        Scanner sc = new Scanner("data.txt");
        List<Animal> animals = new ArrayList<>();
        int i = 0;
        while (sc.hasNextLine()){
            Animal a = new Animal();
            a.setName("Animal " + i++);
            animals.add(a);
        }
        return animals;
    }

    @Override
    public void updateAnimal(Animal a) {
        //TODO
    }

    @Override
    public void deleteAnimal(Animal a) {
        //TODO
    }
}
