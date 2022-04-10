package com.homeproject.homeproject.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid")
    @Column(columnDefinition = "BINARY(16)")
    @NotNull
    @NotBlank
    private UUID id;

    @Column(length =150)
    private String streetDescription;

    @Column(length =30)
    private String county;

    @Column(length =30)
    private String city;

    @Column(length =6)
    private String postalCode;


}
