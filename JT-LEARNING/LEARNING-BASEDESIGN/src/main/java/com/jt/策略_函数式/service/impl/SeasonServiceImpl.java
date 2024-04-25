package com.jt.策略_函数式.service.impl;

import com.jt.策略_函数式.service.ISeasonService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class SeasonServiceImpl implements ISeasonService {

    private Map<String, Function<String, String>> seasonFunctionMap = new HashMap<>();

    public SeasonServiceImpl() {
        seasonFunctionMap.put("spring", this::getSpring);
        seasonFunctionMap.put("summer", this::getSummer);
        seasonFunctionMap.put("autumn", this::getAutumn);
        seasonFunctionMap.put("winter", this::getWinter);
    }

    private String getWinter(String type) {
        return "冬天";
    }

    private String getAutumn(String type) {
        return "秋天";
    }

    private String getSummer(String type) {
        return "夏天";
    }

    private String getSpring(String type) {
        return "春天";
    }

    @Override
    public String getSeason(String type) {
        Function<String, String> seasonFunctionMap = this.seasonFunctionMap.get(type);
        if(seasonFunctionMap == null) return null;
        return seasonFunctionMap.apply(type);
    }
}
