package com.shop.controller;

import com.shop.pojo.Auction;
import com.shop.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AuctionController {
    @Autowired
    private AuctionService auctionService;
    @RequestMapping("/queryAuctions")
    public String queryAuctions(Model model, @ModelAttribute("condition") Auction auction, BindingResult bindingResult){
        List<Auction> auctionList = auctionService.queryAuctions(auction);

        model.addAttribute("autionList",auctionList);

        return "/index";
    }
}

