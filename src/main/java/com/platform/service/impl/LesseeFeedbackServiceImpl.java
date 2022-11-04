package com.platform.service.impl;

import com.platform.dao.LesseeFeedbackDao;
import com.platform.domain.LesseeFeedback;
import com.platform.service.LesseeFeedbackService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LesseeFeedbackServiceImpl implements LesseeFeedbackService {
    @Autowired
    private LesseeFeedbackDao lesseeFeedbackDao;

    @Override
    public List<LesseeFeedback> findAll() {
        return lesseeFeedbackDao.findAll();
    }

    @Override
    public Optional<LesseeFeedback> findById(Integer id) {
        return lesseeFeedbackDao.findById(id);
    }

    @Override
    public int create(LesseeFeedback lesseeFeedback) {
        return lesseeFeedbackDao.create(lesseeFeedback);
    }

    @Override
    public int update(Integer id, LesseeFeedback lesseeFeedback) {
        return lesseeFeedbackDao.update(id, lesseeFeedback);
    }

    @Override
    public int delete(Integer id) {
        return lesseeFeedbackDao.delete(id);
    }
}
