package com.example
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@MicronautTest
class DemoTest {

    @Inject
    lateinit var application: EmbeddedApplication<*>

    @Inject
    lateinit var repository: AnimalRepository

    @Test
    fun testItWorks() {
        Assertions.assertTrue(application.isRunning)
    }

    @Test
    fun createAndFindAll() {
        val animal = repository.save(Animal(null))

        val foundAnimals = repository.findAll()
        Assertions.assertTrue(foundAnimals.any { it.id == animal.id })
    }

    @Test
    fun createAndFindById() {
        val animal = repository.save(Animal(null))
        Assertions.assertTrue(animal.id != null)

        val foundAnimal = repository.findById(animal.id)
        Assertions.assertTrue(foundAnimal.isPresent)
        Assertions.assertTrue(foundAnimal.get().id == animal.id)
    }

    @Test
    fun createAndExistsById() {
        val animal = repository.save(Animal(null))
        Assertions.assertTrue(animal.id != null)

        val exists = repository.existsById(animal.id)
        Assertions.assertTrue(exists)
    }
}
