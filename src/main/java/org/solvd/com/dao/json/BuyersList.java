package org.solvd.com.dao.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class BuyersList {


    @JsonProperty("buyer")
    private List<Buyer> buyersList = new ArrayList<>();

    public List<Buyer> getBuyersList() {
        return buyersList;
    }

    public void setBuyersList(List<Buyer> buyersList) {
        this.buyersList = buyersList;
    }
}

