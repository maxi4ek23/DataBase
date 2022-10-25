package com.platform.controller.impl;

import com.platform.controller.CashWithdrawalFromLesseeToServiceController;
import com.platform.domain.CashWithdrawalFromLesseeToService;
import com.platform.service.CashWithdrawalFromLesseeToServiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class CashWithdrawalFromLesseeToServiceControllerImpl implements CashWithdrawalFromLesseeToServiceController {
    @Autowired
    CashWithdrawalFromLesseeToServiceService cashWithdrawalFromLesseeToServiceService;

    @Override
    public List<CashWithdrawalFromLesseeToService> findAll() {
        return cashWithdrawalFromLesseeToServiceService.findAll();
    }

    @Override
    public Optional<CashWithdrawalFromLesseeToService> findById(Integer id) {
        return cashWithdrawalFromLesseeToServiceService.findById(id);
    }

    @Override
    public int create(CashWithdrawalFromLesseeToService cashWithdrawalFromLesseeToService) {
        return cashWithdrawalFromLesseeToServiceService.create(cashWithdrawalFromLesseeToService);
    }

    @Override
    public int update(Integer id, CashWithdrawalFromLesseeToService cashWithdrawalFromLesseeToService) {
        return cashWithdrawalFromLesseeToServiceService.update(id, cashWithdrawalFromLesseeToService);
    }

    @Override
    public int delete(Integer id) {
        return cashWithdrawalFromLesseeToServiceService.delete(id);
    }
}
