package com.platform.controller.impl;

import com.platform.controller.LesseeFeedbackController;
import com.platform.domain.LesseeFeedback;
import com.platform.service.LesseeFeedbackService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class LesseeFeedbackControllerImpl implements LesseeFeedbackController {
    @Autowired
    LesseeFeedbackService lesseeFeedbackService;

    @Override
    public List<LesseeFeedback> findAll() {
        return lesseeFeedbackService.findAll();
    }

    @Override
    public Optional<LesseeFeedback> findById(Integer id) {
        return lesseeFeedbackService.findById(id);
    }

    @Override
    public int create(LesseeFeedback lesseeFeedback) {
        return lesseeFeedbackService.create(lesseeFeedback);
    }

    @Override
    public int update(Integer id, LesseeFeedback lesseeFeedback) {
        return lesseeFeedbackService.update(id, lesseeFeedback);
    }

    @Override
    public int delete(Integer id) {
        return lesseeFeedbackService.delete(id);
    }
}
