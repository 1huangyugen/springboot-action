package com.shop.service;

import com.shop.pojo.Auction;

import java.util.List;

public interface AuctionService {
    List<Auction> queryAuctions(Auction auction);
}
