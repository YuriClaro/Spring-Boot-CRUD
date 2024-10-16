package com.humanit.yuriclaro_exercicio_spring_boot_1.repository;

import com.humanit.yuriclaro_exercicio_spring_boot_1.model.UserAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserAccount, Long> {
    Page<UserAccount> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName,
                                                                                        String lastName,
                                                                                        Pageable pageable);
}
