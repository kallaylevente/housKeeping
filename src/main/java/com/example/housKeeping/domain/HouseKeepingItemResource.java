package com.example.housKeeping.domain;

import org.springframework.hateoas.ResourceSupport;

import lombok.Builder;

@Builder
public class HouseKeepingItemResource extends ResourceSupport {
    public String itemName;
    public String itemType;
    public Integer valueOfItem;

}
