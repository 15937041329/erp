package com.zsy.product.domain;

import com.zsy.common.annotation.Excel;
import com.zsy.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品信息对象 zsy_product
 *
 * @author cloud
 * @date 2020-03-25
 */
public class Product extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 商品唯一识别码  中国为69开头 13位 用EAN生成器生成即可
     */
    @Excel(name = "商品唯一识别码  中国为69开头 13位 用EAN生成器生成即可")
    private String externalProductId;

    /**
     * 商品唯一识别码类型 全球通用 中国为69开头 13位
     */
    @Excel(name = "商品唯一识别码类型 全球通用 中国为69开头 13位")
    private String externalProductIdType;

    /**
     * 商品sku
     */
    @Excel(name = "商品sku")
    private String itemSku;

    /**
     * 商品名称
     */
    @Excel(name = "商品名称")
    private String itemName;

    /**
     * 品牌名称
     */
    @Excel(name = "品牌名称")
    private String brandName;

    /**
     * 厂商名 生产厂家的名字 可以用中文拼音和品牌名组合
     */
    @Excel(name = "厂商名 生产厂家的名字 可以用中文拼音和品牌名组合")
    private String manufacturer;

    /**
     * 厂商编号
     */
    @Excel(name = "厂商编号")
    private String partNumber;

    /**
     * 产品描述
     */
    @Excel(name = "产品描述")
    private String productDescription;

    /**
     * 商品大分类 务必要准确 作为关键词被搜索
     */
    @Excel(name = "商品大分类 务必要准确 作为关键词被搜索")
    private String feedProductType;

    /**
     * 币别
     */
    @Excel(name = "币别")
    private String currency;

    /**
     * 网站发货重量
     */
    @Excel(name = "网站发货重量")
    private String websiteShippingWeight;

    /**
     * 网站发货重量的计量单位
     */
    @Excel(name = "网站发货重量的计量单位")
    private String websiteShippingWeightUnitOfMeasure;

    /**
     * 产品重量
     */
    @Excel(name = "产品重量")
    private String itemWeight;

    /**
     * 产品重量的计量单位
     */
    @Excel(name = "产品重量的计量单位")
    private String itemWeightUnitOfMeasure;

    /**
     * 产品特点-1
     */
    @Excel(name = "产品特点-1")
    private String bulletPoint1;

    /**
     * 产品特点-2
     */
    @Excel(name = "产品特点-2")
    private String bulletPoint2;

    /**
     * 产品特点-3
     */
    @Excel(name = "产品特点-3")
    private String bulletPoint3;

    /**
     * 产品特点-4
     */
    @Excel(name = "产品特点-4")
    private String bulletPoint4;

    /**
     * 产品特点-5
     */
    @Excel(name = "产品特点-5")
    private String bulletPoint5;

    /**
     * 商品关键字-1
     */
    @Excel(name = "商品关键字-1")
    private String genericKeywords1;

    /**
     * 商品关键字-2
     */
    @Excel(name = "商品关键字-2")
    private String genericKeywords2;

    /**
     * 商品关键字-3
     */
    @Excel(name = "商品关键字-3")
    private String genericKeywords3;

    /**
     * 商品关键字-4
     */
    @Excel(name = "商品关键字-4")
    private String genericKeywords4;

    /**
     * 商品关键字-5
     */
    @Excel(name = "商品关键字-5")
    private String genericKeywords5;

    /**
     * 推荐浏览-1
     */
    @Excel(name = "推荐浏览-1")
    private String recommendedBrowseNodes1;

    /**
     * 推荐浏览-2
     */
    @Excel(name = "推荐浏览-2")
    private String recommendedBrowseNodes2;

    /**
     * 商品主图
     */
    @Excel(name = "商品主图")
    private String mainImageUrl;

    /**
     * 样本图片
     */
    @Excel(name = "样本图片")
    private String swatchImageUrl;

    /**
     * 其他图片-1
     */
    @Excel(name = "其他图片-1")
    private String otherImageUrl1;

    /**
     * 其他图片-2
     */
    @Excel(name = "其他图片-2")
    private String otherImageUrl2;

    /**
     * 其他图片-3
     */
    @Excel(name = "其他图片-3")
    private String otherImageUrl3;

    /**
     * 其他图片-4
     */
    @Excel(name = "其他图片-4")
    private String otherImageUrl4;

    /**
     * 其他图片-5
     */
    @Excel(name = "其他图片-5")
    private String otherImageUrl5;

    /**
     * 其他图片-6
     */
    @Excel(name = "其他图片-6")
    private String otherImageUrl6;

    /**
     * 其他图片-7
     */
    @Excel(name = "其他图片-7")
    private String otherImageUrl7;

    /**
     * 其他图片-8
     */
    @Excel(name = "其他图片-8")
    private String otherImageUrl8;

    /**
     * 成本价
     */
    @Excel(name = "成本价")
    private Double standardPrice;

    /**
     * 销售价
     */
    @Excel(name = "销售价")
    private Double sellPrice;

    /**
     * 库存
     */
    @Excel(name = "库存")
    private Long quantity;

    /**
     * 固定值 更新 删除用delete 部分更新用partiaupdate
     */
    @Excel(name = "固定值 更新 删除用delete 部分更新用partiaupdate")
    private String updateDelete;

    /**
     * 条件类型
     */
    @Excel(name = "条件类型")
    private String conditionType;

    /**
     * 条件说明
     */
    @Excel(name = "条件说明")
    private String conditionNote;

    /**
     * 父id
     */
    @Excel(name = "父id")
    private Long parentId;

    /**
     * 直属关系
     */
    @Excel(name = "直属关系")
    private String parentChild;

    /**
     * 父sku
     */
    @Excel(name = "父sku")
    private String parentSku;

    /**
     * 关系类型
     */
    @Excel(name = "关系类型")
    private String relationshipType;

    /**
     * 变化主题
     */
    @Excel(name = "变化主题")
    private String variationTheme;

    /**
     * 颜色名称
     */
    @Excel(name = "颜色名称")
    private String colorName;

    /**
     * 颜色map
     */
    @Excel(name = "颜色map")
    private String colorMap;

    /**
     * 尺寸名称
     */
    @Excel(name = "尺寸名称")
    private String sizeName;

    /**
     * 尺寸map
     */
    @Excel(name = "尺寸map")
    private String sizeMap;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExternalProductId() {
        return externalProductId;
    }

    public void setExternalProductId(String externalProductId) {
        this.externalProductId = externalProductId;
    }

    public void setExternalProductIdType(String externalProductIdType) {
        this.externalProductIdType = externalProductIdType;
    }

    public String getExternalProductIdType() {
        return externalProductIdType;
    }

    public void setItemSku(String itemSku) {
        this.itemSku = itemSku;
    }

    public String getItemSku() {
        return itemSku;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setFeedProductType(String feedProductType) {
        this.feedProductType = feedProductType;
    }

    public String getFeedProductType() {
        return feedProductType;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setWebsiteShippingWeight(String websiteShippingWeight) {
        this.websiteShippingWeight = websiteShippingWeight;
    }

    public String getWebsiteShippingWeight() {
        return websiteShippingWeight;
    }

    public void setWebsiteShippingWeightUnitOfMeasure(String websiteShippingWeightUnitOfMeasure) {
        this.websiteShippingWeightUnitOfMeasure = websiteShippingWeightUnitOfMeasure;
    }

    public String getWebsiteShippingWeightUnitOfMeasure() {
        return websiteShippingWeightUnitOfMeasure;
    }

    public void setItemWeight(String itemWeight) {
        this.itemWeight = itemWeight;
    }

    public String getItemWeight() {
        return itemWeight;
    }

    public void setItemWeightUnitOfMeasure(String itemWeightUnitOfMeasure) {
        this.itemWeightUnitOfMeasure = itemWeightUnitOfMeasure;
    }

    public String getItemWeightUnitOfMeasure() {
        return itemWeightUnitOfMeasure;
    }

    public void setBulletPoint1(String bulletPoint1) {
        this.bulletPoint1 = bulletPoint1;
    }

    public String getBulletPoint1() {
        return bulletPoint1;
    }

    public void setBulletPoint2(String bulletPoint2) {
        this.bulletPoint2 = bulletPoint2;
    }

    public String getBulletPoint2() {
        return bulletPoint2;
    }

    public void setBulletPoint3(String bulletPoint3) {
        this.bulletPoint3 = bulletPoint3;
    }

    public String getBulletPoint3() {
        return bulletPoint3;
    }

    public void setBulletPoint4(String bulletPoint4) {
        this.bulletPoint4 = bulletPoint4;
    }

    public String getBulletPoint4() {
        return bulletPoint4;
    }

    public void setBulletPoint5(String bulletPoint5) {
        this.bulletPoint5 = bulletPoint5;
    }

    public String getBulletPoint5() {
        return bulletPoint5;
    }

    public void setGenericKeywords1(String genericKeywords1) {
        this.genericKeywords1 = genericKeywords1;
    }

    public String getGenericKeywords1() {
        return genericKeywords1;
    }

    public void setGenericKeywords2(String genericKeywords2) {
        this.genericKeywords2 = genericKeywords2;
    }

    public String getGenericKeywords2() {
        return genericKeywords2;
    }

    public void setGenericKeywords3(String genericKeywords3) {
        this.genericKeywords3 = genericKeywords3;
    }

    public String getGenericKeywords3() {
        return genericKeywords3;
    }

    public void setGenericKeywords4(String genericKeywords4) {
        this.genericKeywords4 = genericKeywords4;
    }

    public String getGenericKeywords4() {
        return genericKeywords4;
    }

    public void setGenericKeywords5(String genericKeywords5) {
        this.genericKeywords5 = genericKeywords5;
    }

    public String getGenericKeywords5() {
        return genericKeywords5;
    }

    public void setRecommendedBrowseNodes1(String recommendedBrowseNodes1) {
        this.recommendedBrowseNodes1 = recommendedBrowseNodes1;
    }

    public String getRecommendedBrowseNodes1() {
        return recommendedBrowseNodes1;
    }

    public void setRecommendedBrowseNodes2(String recommendedBrowseNodes2) {
        this.recommendedBrowseNodes2 = recommendedBrowseNodes2;
    }

    public String getRecommendedBrowseNodes2() {
        return recommendedBrowseNodes2;
    }

    public void setMainImageUrl(String mainImageUrl) {
        this.mainImageUrl = mainImageUrl;
    }

    public String getMainImageUrl() {
        return mainImageUrl;
    }

    public void setSwatchImageUrl(String swatchImageUrl) {
        this.swatchImageUrl = swatchImageUrl;
    }

    public String getSwatchImageUrl() {
        return swatchImageUrl;
    }

    public void setOtherImageUrl1(String otherImageUrl1) {
        this.otherImageUrl1 = otherImageUrl1;
    }

    public String getOtherImageUrl1() {
        return otherImageUrl1;
    }

    public void setOtherImageUrl2(String otherImageUrl2) {
        this.otherImageUrl2 = otherImageUrl2;
    }

    public String getOtherImageUrl2() {
        return otherImageUrl2;
    }

    public void setOtherImageUrl3(String otherImageUrl3) {
        this.otherImageUrl3 = otherImageUrl3;
    }

    public String getOtherImageUrl3() {
        return otherImageUrl3;
    }

    public void setOtherImageUrl4(String otherImageUrl4) {
        this.otherImageUrl4 = otherImageUrl4;
    }

    public String getOtherImageUrl4() {
        return otherImageUrl4;
    }

    public void setOtherImageUrl5(String otherImageUrl5) {
        this.otherImageUrl5 = otherImageUrl5;
    }

    public String getOtherImageUrl5() {
        return otherImageUrl5;
    }

    public void setOtherImageUrl6(String otherImageUrl6) {
        this.otherImageUrl6 = otherImageUrl6;
    }

    public String getOtherImageUrl6() {
        return otherImageUrl6;
    }

    public void setOtherImageUrl7(String otherImageUrl7) {
        this.otherImageUrl7 = otherImageUrl7;
    }

    public String getOtherImageUrl7() {
        return otherImageUrl7;
    }

    public void setOtherImageUrl8(String otherImageUrl8) {
        this.otherImageUrl8 = otherImageUrl8;
    }

    public String getOtherImageUrl8() {
        return otherImageUrl8;
    }

    public void setStandardPrice(Double standardPrice) {
        this.standardPrice = standardPrice;
    }

    public Double getStandardPrice() {
        return standardPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setUpdateDelete(String updateDelete) {
        this.updateDelete = updateDelete;
    }

    public String getUpdateDelete() {
        return updateDelete;
    }

    public void setConditionType(String conditionType) {
        this.conditionType = conditionType;
    }

    public String getConditionType() {
        return conditionType;
    }

    public void setConditionNote(String conditionNote) {
        this.conditionNote = conditionNote;
    }

    public String getConditionNote() {
        return conditionNote;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentChild(String parentChild) {
        this.parentChild = parentChild;
    }

    public String getParentChild() {
        return parentChild;
    }

    public void setParentSku(String parentSku) {
        this.parentSku = parentSku;
    }

    public String getParentSku() {
        return parentSku;
    }

    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }

    public String getRelationshipType() {
        return relationshipType;
    }

    public void setVariationTheme(String variationTheme) {
        this.variationTheme = variationTheme;
    }

    public String getVariationTheme() {
        return variationTheme;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorMap(String colorMap) {
        this.colorMap = colorMap;
    }

    public String getColorMap() {
        return colorMap;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeMap(String sizeMap) {
        this.sizeMap = sizeMap;
    }

    public String getSizeMap() {
        return sizeMap;
    }

}
