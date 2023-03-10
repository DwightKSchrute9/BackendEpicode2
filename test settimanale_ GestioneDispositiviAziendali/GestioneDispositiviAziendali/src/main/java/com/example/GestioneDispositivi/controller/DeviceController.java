package com.example.GestioneDispositivi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GestioneDispositivi.entity.Device;
import com.example.GestioneDispositivi.service.DeviceService;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping("/")
    public List<Device> getAllDevices() {
        return deviceService.getAssignedDevices();
    }

    @GetMapping("/{deviceId}")
    public Optional<Device> getDeviceById(@PathVariable Long deviceId) {
        return deviceService.getDeviceById(deviceId);
    }

    @PostMapping("/")
    public Device createDevice(@RequestBody Device device) {
        return deviceService.addDevice(device);
    }

    @PutMapping("/{deviceId}")
    public Device updateDevice(@PathVariable Long deviceId, @RequestBody Device device) {
        return deviceService.updateDevice(deviceId, device);
    }

    @DeleteMapping("/{deviceId}")
    public void deleteDevice(@PathVariable Long deviceId) {
        deviceService.deleteDevice(deviceId);
    }
}
