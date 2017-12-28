package com.lunchmaster.api.balance.controller;

import com.lunchmaster.api.Response;
import com.lunchmaster.api.balance.dto.Balance;
import com.lunchmaster.api.balance.dto.ThinDish;
import com.lunchmaster.api.balance.dto.ThinOrder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by m.slefarski on 2017-12-28.
 */


@RestController
@RequestMapping("/api/balance")
public class BalanceController {

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Balance showBalance(){
        //dupa
        return Balance.getDummy();

    }
}
