package com.kgc.service.impl;

import com.kgc.entity.Goods;
import com.kgc.entity.GoodsExample;
import com.kgc.mapper.GoodsMapper;
import com.kgc.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("goodsService")
public class GoodsServiceimpl implements GoodsService {
    @Resource
    GoodsMapper goodsMapper;
    @Override
    public List<Goods> selectBygoodsdistrict(Integer goodsdistrict) {
        GoodsExample example=new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        if(goodsdistrict==1){
            criteria.andGoodsdistrictEqualTo(1);
        }else if(goodsdistrict==2){
            criteria.andGoodsdistrictEqualTo(2);
        }else if(goodsdistrict==3){
            criteria.andGoodsdistrictEqualTo(3);
        }else if(goodsdistrict==4){
            criteria.andGoodsdistrictEqualTo(4);
        }else if(goodsdistrict==5){
            criteria.andGoodsdistrictEqualTo(5);
        }
        return goodsMapper.selectByExample(example);
    }

    @Override
    public Goods selectById(int id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public void upd(Goods goods) {
        goodsMapper.updateByPrimaryKeySelective(goods);
    }
}
