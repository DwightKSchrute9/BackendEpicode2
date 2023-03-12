package com.example.GestioneDispositivi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.GestioneDispositivi.entity.Device;
import com.example.GestioneDispositivi.entity.User;
import com.example.GestioneDispositivi.repository.DeviceRepository;
import com.example.GestioneDispositivi.repository.UserRepository;

@DataJpaTest
public class DeviceTest {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveDevice() {
        Device device = new Device();
        device.setName("Device Test");
        device.setDescription("Device Test Description");

        Device savedDevice = deviceRepository.save(device);

        assertNotNull(savedDevice.getId());
        assertEquals(device.getName(), savedDevice.getName());
        assertEquals(device.getDescription(), savedDevice.getDescription());
    }

    @Test
    public void testGetDeviceById() {
        Device device = new Device();
        device.setName("Device Test");
        device.setDescription("Device Test Description");

        Device savedDevice = deviceRepository.save(device);

        Optional<Device> foundDevice = deviceRepository.findById(savedDevice.getId());

        assertNotNull(foundDevice);
        assertEquals(device.getName(), foundDevice.get().getName());
        assertEquals(device.getDescription(), foundDevice.get().getDescription());
    }

    @Test
    public void testGetAllDevices() {
        Device device1 = new Device();
        device1.setName("Device Test 1");
        device1.setDescription("Device Test Description 1");

        Device device2 = new Device();
        device2.setName("Device Test 2");
        device2.setDescription("Device Test Description 2");

        deviceRepository.save(device1);
        deviceRepository.save(device2);

        List<Device> devices = deviceRepository.findAll();

        assertNotNull(devices);
        assertEquals(2, devices.size());
    }

    @Test
    public void testUpdateDevice() {
        Device device = new Device();
        device.setName("Device Test");
        device.setDescription("Device Test Description");

        Device savedDevice = deviceRepository.save(device);

        savedDevice.setName("Updated Device Test");
        savedDevice.setDescription("Updated Device Test Description");

        Device updatedDevice = deviceRepository.save(savedDevice);

        assertNotNull(updatedDevice.getId());
        assertEquals(savedDevice.getId(), updatedDevice.getId());
        assertEquals(savedDevice.getName(), updatedDevice.getName());
        assertEquals(savedDevice.getDescription(), updatedDevice.getDescription());
    }

    @Test
    public void testDeleteDevice() {
        Device device = new Device();
        device.setName("Device Test");
        device.setDescription("Device Test Description");

        Device savedDevice = deviceRepository.save(device);

        deviceRepository.deleteById(savedDevice.getId());

        Optional<Device> foundDevice = deviceRepository.findById(savedDevice.getId());

        assertNull(foundDevice.orElse(null));
    }

    @Test
    public void testAssignDeviceToUser() {
        Device device = new Device();
        device.setName("Device Test");
        device.setDescription("Device Test Description");

        User user = new User();
        user.setUsername("Test User");
        user.setEmail("test@test.com");

        userRepository.save(user);

        device.setUser(user);

        Device savedDevice = deviceRepository.save(device);

        Optional<Device> foundDevice = deviceRepository.findById(savedDevice.getId());

        assertNotNull(foundDevice.get().getUser());
        assertEquals(user.getId(), foundDevice.get().getUser().getId());
    }
}
