package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author wzf
 * @description te
 * @date 2023-12-09 12:16
 */
@Controller
public class Index {
    @Autowired
    private StockCrawlerServiceImpl stockCrawlerService;

    //public String index(){
    //
    //    List<StockInfo> stockList = stockCrawlerService.getStockList();
    //
    //    return "hello world!";
    //}
}

