package com.platform.service.impl;

import com.platform.dao.CashWithdrawalFromLesseeToServiceDao;
import com.platform.domain.CashWithdrawalFromLesseeToService;
import com.platform.service.CashWithdrawalFromLesseeToServiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CashWithdrawalFromLesseeToServiceServiceImpl implements CashWithdrawalFromLesseeToServiceService {
    @Autowired
    private CashWithdrawalFromLesseeToServiceDao cashWithdrawalFromLesseeToServiceDao;

    @Override
    public List<CashWithdrawalFromLesseeToService> findAll() {
        return cashWithdrawalFromLesseeToServiceDao.findAll();
    }

    @Override
    public Optional<CashWithdrawalFromLesseeToService> findById(Integer id) {
        return cashWithdrawalFromLesseeToServiceDao.findById(id);
    }

    @Override
    public int create(CashWithdrawalFromLesseeToService cashWithdrawalFromLesseeToService) {
        return cashWithdrawalFromLesseeToServiceDao.create(cashWithdrawalFromLesseeToService);
    }

    @Override
    public int update(Integer id, CashWithdrawalFromLesseeToService cashWithdrawalFromLesseeToService) {
        return cashWithdrawalFromLesseeToServiceDao.update(id, cashWithdrawalFromLesseeToService);
    }

    @Override
    public int delete(Integer id) {
        return cashWithdrawalFromLesseeToServiceDao.delete(id);
    }
}
