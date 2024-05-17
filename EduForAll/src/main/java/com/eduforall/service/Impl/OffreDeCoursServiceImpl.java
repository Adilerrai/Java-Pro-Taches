package com.eduforall.service.Impl;

import com.eduforall.repository.OffreDeCoursRepository;
import com.eduforall.service.OffreDeCoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class OffreDeCoursServiceImpl implements OffreDeCoursService {

    @Autowired
    private OffreDeCoursRepository offreDeCoursRepository;

}
