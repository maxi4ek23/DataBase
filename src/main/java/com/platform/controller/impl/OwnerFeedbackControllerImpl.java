package com.platform.controller.impl;

import com.platform.controller.OwnerFeedbackController;
import com.platform.domain.OwnerFeedback;
import com.platform.service.OwnerFeedbackService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class OwnerFeedbackControllerImpl implements OwnerFeedbackController {
    @Autowired
    OwnerFeedbackService ownerFeedbackService;

    @Override
    public List<OwnerFeedback> findAll() {
        return ownerFeedbackService.findAll();
    }

    @Override
    public Optional<OwnerFeedback> findById(Integer id) {
        return ownerFeedbackService.findById(id);
    }

    @Override
    public int create(OwnerFeedback ownerFeedback) {
        return ownerFeedbackService.create(ownerFeedback);
    }

    @Override
    public int update(Integer id, OwnerFeedback ownerFeedback) {
        return ownerFeedbackService.update(id, ownerFeedback);
    }

    @Override
    public int delete(Integer id) {
        return ownerFeedbackService.delete(id);
    }
}
