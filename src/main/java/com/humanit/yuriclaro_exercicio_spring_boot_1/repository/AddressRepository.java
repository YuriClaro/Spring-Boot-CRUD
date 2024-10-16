package com.humanit.yuriclaro_exercicio_spring_boot_1.repository;

import com.humanit.yuriclaro_exercicio_spring_boot_1.model.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Page<Address> findByUserAccount_Id(Long id, Pageable pageable);
}
