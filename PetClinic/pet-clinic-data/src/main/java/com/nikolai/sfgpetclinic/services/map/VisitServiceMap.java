package com.nikolai.sfgpetclinic.services.map;

import com.nikolai.sfgpetclinic.model.Visit;
import com.nikolai.sfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VisitServiceMap extends AbstractServiceMap<Visit, Long> implements VisitService {
    @Override
    public Visit save(Visit object) {
        if (object.getPet() == null ||
                object.getPet().getId() == null ||
                object.getPet().getOwner() == null ||
                object.getPet().getOwner().getId() == null
        ) {
            throw new RuntimeException("Wrong Visit object");
        }
        return super.save(object);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
