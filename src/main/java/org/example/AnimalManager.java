package org.example;

public class AnimalManager {
    private AnimalDAO animalDAO;

    public AnimalManager(AnimalDAO animalDAO) {
        this.animalDAO = animalDAO;
    }

    public void manage(){
        Animal a = new Animal("eagle", 21, Animal.genderType.FEMALE);
        animalDAO.saveAnimal(a);
        Animal b = new Animal("rabbit", 6, Animal.genderType.MALE);
        animalDAO.saveAnimal(b);

        for (Animal animal : animalDAO.getAnimals())
            System.out.println(animal);

        Animal c = new Animal("lion", 6, Animal.genderType.MALE);

        Zoo zoo = new Zoo("Debrecen Zoo");
        zoo.getAnimals().add(a);
        zoo.getAnimals().add(b);
        zoo.getAnimals().add(c);

        animalDAO.saveZoo(zoo);
    }
}
