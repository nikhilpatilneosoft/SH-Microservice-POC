package com.example.Market.Services.ShareServiceImpl;

import com.example.Market.Models.Share;
import com.example.Market.Repositories.ShareRepository;
import com.example.Market.Services.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareServiceImpl implements ShareService {
    @Autowired
    private ShareRepository shareRepository;

    @Override
    public List<Share> getAllShares() {
        return shareRepository.findAll();
    }

    @Override
    public Share getShareById(int id) {
        return shareRepository.findById(id).orElse(null);
    }

    @Override
    public Share createShare(Share share) {
        return shareRepository.save(share);
    }

    @Override
    public Share updateShare(Share share) {
        return shareRepository.save(share);
    }

    @Override
    public Share updateAfterPlacingOrder(String name, int quantity, String type) {

        Share savedShare = shareRepository.findShareByName(name).orElseThrow(() -> new RuntimeException("Share not found"));

        if(savedShare.getNumberOfSharesLeft() >= quantity)
        {
            if (type.equals("Buy"))
                savedShare.setNumberOfSharesLeft(savedShare.getNumberOfSharesLeft() - quantity);
            else
                savedShare.setNumberOfSharesLeft(savedShare.getNumberOfSharesLeft() + quantity);

            return shareRepository.save(savedShare);
        }

        return null;
    }

    @Override
    public void deleteShare(int id) {
        shareRepository.deleteById(id);
    }
}
