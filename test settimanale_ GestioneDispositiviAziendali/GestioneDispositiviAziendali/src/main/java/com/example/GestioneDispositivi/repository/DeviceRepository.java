
package com.example.GestioneDispositivi.repository;


import com.example.GestioneDispositivi.entity.Device;
import com.example.GestioneDispositivi.entity.DeviceStatus;
import com.example.GestioneDispositivi.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    List<Device> findByStatus(DeviceStatus status);

    List<Device> findByUserId(Long userId);

    Optional<Device> findByIdAndUserId(Long id, Long userId);

	List<Device> findByUser(User user);

}
