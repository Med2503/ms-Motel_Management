package com.att.Guest;


import com.att.Guest.exception.GuestNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class GuestService {

    private final GuestRepository repository;
    private final GuestMapper mapper;

    public GuestService(GuestRepository repository, GuestMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public String createGuest(GuestRequest request) {
        var guest = this.repository.save(mapper.toGuest(request));
        return guest.getId();
    }

    public void updateGuest(GuestRequest request) {
        var guest = this.repository.findById(request.id()).orElseThrow(() ->
                new GuestNotFoundException(String.format("guest with id %s not found!", request.id())));
        update(guest, request);
        this.repository.save(guest);
    }

    private void update(Guest guest, GuestRequest request) {
        if (StringUtils.isNotBlank(request.firstname())) {
            guest.setFirstname(request.firstname());
        }
        if (StringUtils.isNotBlank(request.lastname())) {
            guest.setLastname(request.lastname());
        }
        if (StringUtils.isNotBlank(request.email())) {
            guest.setEmail(request.email());
        }
        if (request.location() != null) {
            guest.setLocation(request.location());
        }
    }

    public List<GuestResponse> findAll() {
        return this.repository.findAll().stream()
                .map(mapper::fromGuest)
                .collect(Collectors.toList());

    }

    public boolean existsById(String guestId) {
        return this.repository.findById(guestId)
                .isPresent();
    }

    public GuestResponse findById(String guestId) {
        return this.repository.findById(guestId)
                .map(mapper::fromGuest)
                .orElseThrow(() -> new GuestNotFoundException(String.format("cannot find guest with id %s", guestId)));
    }


    public void deleteGuest(String guestId) {
        this.repository.deleteById(guestId);
    }
}
