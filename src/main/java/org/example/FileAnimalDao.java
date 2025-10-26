package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileAnimalDao implements AnimalDAO{
    @Override
    public void saveAnimal(Animal a) {
        PrintWriter pw = null;
        try {
            FileOutputStream fos = new FileOutputStream("data.txt",true);
            pw = new PrintWriter(fos);
            pw.println(a);
            System.out.println(a);
            pw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAnimal(Animal a) {
//TODO
    }

    @Override
    public void updateAnimal(Animal a) {
//TODO
    }

    @Override
    public List<Animal> getAnimals() {
        try {
            Scanner sc = new Scanner(new File("./data.txt"));
            List<Animal> animals = new ArrayList<Animal>();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] tokens = line.split(",");
                Animal animal = new Animal();
                animal.setName(tokens[0]);
                animal.setAge(Integer.parseInt(tokens[1]));
                animal.setGender(Animal.genderType.FEMALE);
                animals.add(animal);
            }
            return animals;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws Exception {
        //nothing to close
    }
}
