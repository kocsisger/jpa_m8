package org.example;

import java.util.List;

public interface AnimalDAO {
    public void saveAnimal(Animal a);
    public List<Animal> getAnimals();
    public void updateAnimal(Animal a);
    public void deleteAnimal(Animal a);

    default public void saveZoo(Zoo zoo){}
}
