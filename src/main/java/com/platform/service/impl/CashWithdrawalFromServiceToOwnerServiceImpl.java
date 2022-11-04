package com.platform.service.impl;

import com.platform.dao.CashWithdrawalFromServiceToOwnerDao;
import com.platform.domain.CashWithdrawalFromServiceToOwner;
import com.platform.service.CashWithdrawalFromServiceToOwnerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CashWithdrawalFromServiceToOwnerServiceImpl implements CashWithdrawalFromServiceToOwnerService {
    @Autowired
    private CashWithdrawalFromServiceToOwnerDao cashWithdrawalFromServiceToOwnerDao;

    @Override
    public List<CashWithdrawalFromServiceToOwner> findAll() {
        return cashWithdrawalFromServiceToOwnerDao.findAll();
    }

    @Override
    public Optional<CashWithdrawalFromServiceToOwner> findById(Integer id) {
        return cashWithdrawalFromServiceToOwnerDao.findById(id);
    }

    @Override
    public int create(CashWithdrawalFromServiceToOwner cashWithdrawalFromServiceToOwner) {
        return cashWithdrawalFromServiceToOwnerDao.create(cashWithdrawalFromServiceToOwner);
    }

    @Override
    public int update(Integer id, CashWithdrawalFromServiceToOwner cashWithdrawalFromServiceToOwner) {
        return cashWithdrawalFromServiceToOwnerDao.update(id, cashWithdrawalFromServiceToOwner);
    }

    @Override
    public int delete(Integer id) {
        return cashWithdrawalFromServiceToOwnerDao.delete(id);
    }
}
