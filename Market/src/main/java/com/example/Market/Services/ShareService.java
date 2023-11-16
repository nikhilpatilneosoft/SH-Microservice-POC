package com.example.Market.Services;

import com.example.Market.Models.Share;

import java.util.List;

public interface ShareService {
    List<Share> getAllShares();

    Share getShareById(int id);

    Share createShare(Share share);

    Share updateShare(Share share);

    Share updateAfterPlacingOrder(String name, int quantity, String type);

    void deleteShare(int id);
}
