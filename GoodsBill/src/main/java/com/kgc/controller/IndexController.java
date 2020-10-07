package com.kgc.controller;

import com.kgc.entity.Goods;
import com.kgc.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class IndexController {

    @Resource
    GoodsService goodsService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/ins")
    public String ins(Model model,
                      @RequestParam(value = "goodsdistrict", required = false, defaultValue = "0") Integer goodsdistrict) {
        List<Goods> goodsList = goodsService.selectBygoodsdistrict(goodsdistrict);
        model.addAttribute("pageInfo", goodsList);
        return "ins";
    }

    @RequestMapping("/upd")
    public String upd(int id, Model model) {
        Goods goods=goodsService.selectById(id);
        model.addAttribute("book",goods);
        return "upd";
    }
    @RequestMapping("/updlist")
    public String updlist(Goods goods){
        goodsService.upd(goods);
        return "redirect:/ins";
    }
}
