package com.hr_management.hr_management.mapper;

import com.hr_management.hr_management.model.dto.LocationDTO;
import com.hr_management.hr_management.model.entity.Location;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {
    public LocationDTO toLocationDto(Location location) {
        LocationDTO dto = new LocationDTO();
        dto.setLocationId(location.getLocationId());
        dto.setCity(location.getCity());
        dto.setStreetAddress(location.getStreetAddress());
        dto.setPostalCode(location.getPostalCode());
        dto.setCountry(location.getCountry());
        dto.setCity(location.getCity());
        return dto;
    }

    public Location toLocation(LocationDTO dto) {
        Location location = new Location();
        location.setLocationId(dto.getLocationId());
        location.setCity(dto.getCity());
        location.setStreetAddress(dto.getStreetAddress());
        location.setPostalCode(dto.getPostalCode());
        location.setStateProvince(dto.getStateProvince());
        location.setCountry(dto.getCountry());
        return location;
    }
}
