package com.shop.service;

import com.shop.mapper.AuctionMapper;
import com.shop.pojo.Auction;
import com.shop.pojo.AuctionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionServiceImpl implements AuctionService{
    @Autowired
    private AuctionMapper auctionMapper;
    @Override
    public List<Auction> queryAuctions(Auction auction) {
        AuctionExample ae = new AuctionExample();
        AuctionExample.Criteria criteria = ae.createCriteria();

        if(auction.getAuctionname() != null && !"".equals(auction.getAuctionname())){
            criteria.andAuctionnameLike("%" + auction.getAuctionname() + "%");
        }

        if(auction.getAuctiondesc() != null && !"".equals(auction.getAuctiondesc())){
            criteria.andAuctiondescLike("%" + auction.getAuctiondesc() + "%");
        }

        if(auction.getAuctionstarttime() != null && !"".equals(auction.getAuctionstarttime())){
            criteria.andAuctionstarttimeGreaterThanOrEqualTo(auction.getAuctionstarttime());
        }

        if(auction.getAuctionendtime() != null && !"".equals(auction.getAuctionendtime())){
            criteria.andAuctionendtimeLessThanOrEqualTo(auction.getAuctionendtime());
        }

        if(auction.getAuctionstartprice() != null && !"".equals(auction.getAuctionstartprice())) {
            criteria.andAuctionstartpriceGreaterThanOrEqualTo(auction.getAuctionstartprice());
        }




        List<Auction> auctionList = auctionMapper.selectByExample(ae);

        return auctionList;
    }


}

