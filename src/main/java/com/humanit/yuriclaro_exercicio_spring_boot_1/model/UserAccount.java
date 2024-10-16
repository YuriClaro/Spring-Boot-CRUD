package com.humanit.yuriclaro_exercicio_spring_boot_1.model;

import com.humanit.yuriclaro_exercicio_spring_boot_1.enumearator.Role;
import jakarta.persistence.*;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "tb_user")
@Audited
@AuditTable(value = "user_account_audit")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @NotAudited
    @OneToMany(mappedBy = "userAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;

    public UserAccount() {}

    public UserAccount(Long id,
                       String username,
                       String password,
                       String firstName,
                       String lastName,
                       String email,
                       String phoneNumber,
                       LocalDate birthDate,
                       Role role,
                       List<Address> addresses) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.role = role;
        this.addresses = addresses;
    }

    public Long getId() {
        return id;
    }

    public UserAccount setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserAccount setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserAccount setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserAccount setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserAccount setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserAccount setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserAccount setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public UserAccount setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public UserAccount setRole(Role role) {
        this.role = role;
        return this;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public UserAccount setAddresses(List<Address> addresses) {
        this.addresses = addresses;
        return this;
    }
}
