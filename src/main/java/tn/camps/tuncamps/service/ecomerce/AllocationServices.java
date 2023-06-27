package tn.camps.tuncamps.service.ecomerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.camps.tuncamps.persistence.entity.ecomerce.Allocation;

import tn.camps.tuncamps.persistence.repository.ecomerce.AllocationRepository;


import java.util.Optional;

@Service

public class AllocationServices extends Abstarctservices<Allocation> {
    @Autowired
    private AllocationRepository ar;

    @Override
    public Iterable<Allocation> findAll() {
        // TODO Auto-generated method stub
        return ar.findAll();
    }

    @Override
    public Optional<Allocation> findbyid(int id) {
        // TODO Auto-generated method stub
        return ar.findById(id);
    }

    @Override
    public boolean Delete(int id) {
        // TODO Auto-generated method stub
        ar.deleteById(id);
        return true;
    }

    @Override
    public Allocation update(Allocation a) {
        // TODO Auto-generated method stub
        return ar.save(a);
    }

    @Override
    public Allocation create(Allocation a) {
        // TODO Auto-generated method stub
        return ar.save(a);
    }
}
