package com.platform.controller.impl;

import com.platform.controller.LesseeController;
import com.platform.domain.Lessee;
import com.platform.service.LesseeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class LesseeControllerImpl implements LesseeController {
    @Autowired
    LesseeService lesseeService;

    @Override
    public List<Lessee> findAll() {
        return lesseeService.findAll();
    }

    @Override
    public Optional<Lessee> findById(Integer id) {
        return lesseeService.findById(id);
    }

    @Override
    public int create(Lessee lessee) {
        return lesseeService.create(lessee);
    }

    @Override
    public int update(Integer id, Lessee lessee) {
        return lesseeService.update(id, lessee);
    }

    @Override
    public int delete(Integer id) {
        return lesseeService.delete(id);
    }
}
