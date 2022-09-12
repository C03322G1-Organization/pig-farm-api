package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.repository.IPlacementRepository;
import vn.codegym.pig_farm.service.IPlacementService;

@Service
public class PlacementServiceImpl implements IPlacementService {
    @Autowired
    private IPlacementRepository placementRepository;
}
