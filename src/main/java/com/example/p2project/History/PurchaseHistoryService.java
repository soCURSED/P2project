package com.example.p2project.History;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PurchaseHistoryService {
    private ArrayList<PurchaseHistory> purchaseHistorys = new ArrayList<>();

    public ArrayList<PurchaseHistory> getPurchaseHistorys(){
        return purchaseHistorys;
    }

    public Boolean deletePurchaseHistory(String purchaseHistoryId){
        for(PurchaseHistory p: purchaseHistorys){
            if (purchaseHistoryId.equals(p.getId())){
                purchaseHistorys.remove(p);
                return true;
            }
        }
        return false;
    }

    public void addPurchaseHistory(PurchaseHistory p){
        purchaseHistorys.add(p);
    }

    public Boolean updatePurchaseHistory(Integer index, PurchaseHistory purchaseHistory){
        if(index > purchaseHistorys.size()-1){
            return false;
        }
        purchaseHistorys.set(index, purchaseHistory);
        return true;
    }



}
