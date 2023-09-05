package dev.shegami.profileservice.services;

import dev.shegami.profileservice.entities.Address;

import java.util.List;

public interface AddressService {
    List<Address> addAddress(Address address);
}
