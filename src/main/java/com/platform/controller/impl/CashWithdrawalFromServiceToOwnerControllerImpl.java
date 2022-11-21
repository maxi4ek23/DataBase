package com.platform.controller.impl;

import com.platform.controller.CashWithdrawalFromServiceToOwnerController;
import com.platform.domain.CashWithdrawalFromServiceToOwner;
import com.platform.service.CashWithdrawalFromServiceToOwnerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class CashWithdrawalFromServiceToOwnerControllerImpl implements CashWithdrawalFromServiceToOwnerController {
    @Autowired
    CashWithdrawalFromServiceToOwnerService cashWithdrawalFromServiceToOwnerService;

    @Override
    public List<CashWithdrawalFromServiceToOwner> findAll() {
        return cashWithdrawalFromServiceToOwnerService.findAll();
    }

    @Override
    public Optional<CashWithdrawalFromServiceToOwner> findById(Integer id) {
        return cashWithdrawalFromServiceToOwnerService.findById(id);
    }

    @Override
    public int create(CashWithdrawalFromServiceToOwner cashWithdrawalFromServiceToOwner) {
        return cashWithdrawalFromServiceToOwnerService.create(cashWithdrawalFromServiceToOwner);
    }

    @Override
    public int update(Integer id, CashWithdrawalFromServiceToOwner cashWithdrawalFromServiceToOwner) {
        return cashWithdrawalFromServiceToOwnerService.update(id, cashWithdrawalFromServiceToOwner);
    }

    @Override
    public int delete(Integer id) {
        return cashWithdrawalFromServiceToOwnerService.delete(id);
    }
}
