package org.example;

public class AnimalManager {
    AnimalDAO animalDAO;

    public AnimalManager(AnimalDAO animalDAO) {
        this.animalDAO = animalDAO;
    }

    public void manage(){
        Animal a = new Animal("sas", 21, Animal.genderType.FEMALE);
        animalDAO.saveAnimal(a);
        Animal b = new Animal("elefánt", 22, Animal.genderType.MALE);
        animalDAO.saveAnimal(b);

        System.out.println("Animals added");

        System.out.println(animalDAO.getAnimals().size());
        for (Animal animal: animalDAO.getAnimals()){
            System.out.println(animal);
        }
        animalDAO.manageZoo();
    }
}
