package seminars.second.hw;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/*
2) Проект Vehicle:
Написать следующие тесты c использованием Junit5:
- проверка того, что экземпляр объекта Car также является экземпляром транспортного средства; (instanceof)
- проверка того, объект Car создается с 4-мя колесами
- проверка того, объект Motorcycle создается с 2-мя колесами
- проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
- проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
- проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина
 останавливается (speed = 0)
- проверить, что в режиме парковки (сначала testDrive, потом park т.е эмуляция движения транспорта) мотоцикл
 останавливается (speed = 0)
 */


class VehicleTest {
    @Test
    public void testCarIsInstanceOfVehicle() {
        Car car = new Car("Dodge", "Ram", 2010);
        assertTrue(car instanceof Vehicle);
    }

    @Test
    void testCarHaveFourWheels(){
        Car car = new Car("Dodge", "Ram", 2010);
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    @Test
    void testMotorcycleHaveTwoWheels(){
        Motorcycle mc = new Motorcycle("Ducatti", "Demon", 2020);
        assertThat(mc.getNumWheels()).isEqualTo(2);
    }

    @Test
    void testCarCanTestDriveSpeed(){
        Car car = new Car("Dodge", "Ram", 2010);
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    @Test
    void testMotorcycleCanTestDriveSpeed() {
        Motorcycle mc = new Motorcycle("Ducatti", "Demon", 2020);
        mc.testDrive();
        assertThat(mc.getSpeed()).isEqualTo(75);
    }

    @Test
    void testCarCanParkSpeed(){
        Car car = new Car("Dodge", "Ram", 2010);
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    @Test
    void testMotorcycleParkSpeed() {
        Motorcycle mc = new Motorcycle("Ducatti", "Demon", 2020);
        mc.testDrive();
        mc.park();
        assertThat(mc.getSpeed()).isEqualTo(0);
    }
}