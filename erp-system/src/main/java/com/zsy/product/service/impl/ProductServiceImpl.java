package com.zsy.product.service.impl;

import java.util.List;

import com.zsy.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zsy.product.mapper.ProductMapper;
import com.zsy.product.domain.Product;
import com.zsy.product.service.IProductService;
import com.zsy.common.core.text.Convert;

/**
 * 商品信息Service业务层处理
 *
 * @author cloud
 * @date 2020-03-25
 */
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductMapper productMapper;

    /**
     * 查询商品信息
     *
     * @param id 商品信息ID
     * @return 商品信息
     */
    @Override
    public Product selectProductById(Long id) {
        return productMapper.selectProductById(id);
    }

    /**
     * 查询商品信息列表
     *
     * @param product 商品信息
     * @return 商品信息
     */
    @Override
    public List<Product> selectProductList(Product product) {
        return productMapper.selectProductList(product);
    }

    /**
     * 新增商品信息
     *
     * @param product 商品信息
     * @return 结果
     */
    @Override
    public int insertProduct(Product product) {
        product.setCreateTime(DateUtils.getNowDate());
        return productMapper.insertProduct(product);
    }

    /**
     * 修改商品信息
     *
     * @param product 商品信息
     * @return 结果
     */
    @Override
    public int updateProduct(Product product) {
        product.setUpdateTime(DateUtils.getNowDate());
        return productMapper.updateProduct(product);
    }

    /**
     * 删除商品信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProductByIds(String ids) {
        return productMapper.deleteProductByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品信息信息
     *
     * @param id 商品信息ID
     * @return 结果
     */
    @Override
    public int deleteProductById(Long id) {
        return productMapper.deleteProductById(id);
    }
}
