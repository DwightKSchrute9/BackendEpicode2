package com.example.GestioneDispositivi.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GestioneDispositivi.entity.Device;
import com.example.GestioneDispositivi.entity.DeviceStatus;
import com.example.GestioneDispositivi.entity.User;
import com.example.GestioneDispositivi.repository.DeviceRepository;
import com.example.GestioneDispositivi.repository.UserRepository;


@Service
public class DeviceService {
    
    @Autowired
    private DeviceRepository deviceRepository;
    
    @Autowired
    private UserRepository userRepository;

    public List<Device> getAvailableDevices() {
        return deviceRepository.findByStatus(DeviceStatus.AVAILABLE);
    }
    
    public List<Device> getAssignedDevices() {
        return deviceRepository.findByStatus(DeviceStatus.ASSIGNED);
    }
    
    public Device assignDeviceToDevice(Device device, User user) throws Exception {
        if (device.getStatus() == DeviceStatus.AVAILABLE) {
            device.setUser(user);
            device.setStatus(DeviceStatus.ASSIGNED);
            return deviceRepository.save(device);
        } else {
            throw new Exception("Device is not available");
        }
    }
    
    public Device returnDevice(Device device) throws Exception {
        if (device.getStatus() == DeviceStatus.ASSIGNED) {
            device.setUser(null);
            device.setStatus(DeviceStatus.AVAILABLE);
            return deviceRepository.save(device);
        } else {
            throw new Exception("Device cannot be returned because it was not assigned");
        }
    }
    
    public List<Device> getDevicesByUser(User user) {
        return deviceRepository.findByUser(user);
    }
    
    public Optional<Device> getDeviceById(Long id) {
        return deviceRepository.findById(id);
    }
    
    public Device addDevice(Device device) {
        return deviceRepository.save(device);
    }
    
    public void deleteDevice(Comparable<Long> device) {
        deviceRepository.delete((Device) device);
    }

	public Device updateDevice(Long deviceId, Device device) {
		// TODO Auto-generated method stub
		return null;
	}
}

