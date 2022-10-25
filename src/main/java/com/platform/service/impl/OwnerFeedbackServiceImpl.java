package com.platform.service.impl;

import com.platform.dao.OwnerFeedbackDao;
import com.platform.domain.OwnerFeedback;
import com.platform.service.OwnerFeedbackService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerFeedbackServiceImpl implements OwnerFeedbackService {
    @Autowired
    private OwnerFeedbackDao ownerFeedbackDao;

    @Override
    public List<OwnerFeedback> findAll() {
        return ownerFeedbackDao.findAll();
    }

    @Override
    public Optional<OwnerFeedback> findById(Integer id) {
        return ownerFeedbackDao.findById(id);
    }

    @Override
    public int create(OwnerFeedback ownerFeedback) {
        return ownerFeedbackDao.create(ownerFeedback);
    }

    @Override
    public int update(Integer id, OwnerFeedback ownerFeedback) {
        return ownerFeedbackDao.update(id, ownerFeedback);
    }

    @Override
    public int delete(Integer id) {
        return ownerFeedbackDao.delete(id);
    }
}
