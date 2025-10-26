package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaAnimalDAO implements AnimalDAO {

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();


    @Override
    public void saveAnimal(Animal a) {
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteAnimal(Animal a) {
        entityManager.getTransaction().begin();
        entityManager.remove(a);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateAnimal(Animal a) {
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Animal> getAnimals() {
        TypedQuery<Animal> query = entityManager.createQuery("SELECT a FROM Animal a", Animal.class);
        List<Animal> animals = query.getResultList();
        return animals;
    }

    @Override
    public void manageZoo() {
        Zoo zoo = new Zoo();
        zoo.setName("Debrecen Zoo");
        zoo.getAnimals().add(new Animal("Sanyi", 22, Animal.genderType.MALE));
            entityManager.getTransaction().begin();
            entityManager.persist(zoo);
            entityManager.getTransaction().commit();
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
        System.out.println("Database closed");
    }
}
