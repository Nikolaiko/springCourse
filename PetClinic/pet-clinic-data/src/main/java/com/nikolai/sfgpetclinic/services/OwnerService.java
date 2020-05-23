package com.nikolai.sfgpetclinic.services;

import com.nikolai.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
