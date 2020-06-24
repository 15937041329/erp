package com.zsy.product.service;

import java.util.List;
import com.zsy.product.domain.Product;

/**
 * 商品信息Service接口
 * 
 * @author cloud
 * @date 2020-03-25
 */
public interface IProductService 
{
    /**
     * 查询商品信息
     * 
     * @param id 商品信息ID
     * @return 商品信息
     */
    public Product selectProductById(Long id);

    /**
     * 查询商品信息列表
     * 
     * @param product 商品信息
     * @return 商品信息集合
     */
    public List<Product> selectProductList(Product product);

    /**
     * 新增商品信息
     * 
     * @param product 商品信息
     * @return 结果
     */
    public int insertProduct(Product product);

    /**
     * 修改商品信息
     * 
     * @param product 商品信息
     * @return 结果
     */
    public int updateProduct(Product product);

    /**
     * 批量删除商品信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProductByIds(String ids);

    /**
     * 删除商品信息信息
     * 
     * @param id 商品信息ID
     * @return 结果
     */
    public int deleteProductById(Long id);
}
