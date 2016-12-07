package ru.course.selenium.domain;

import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
/**
 * Created by Aleksei.Klimenko on 06.12.2016.
 */
public class Product {

    private Boolean enabled;

    private String name;

    private String code;

    private Integer category;

    private GenderEnum gender;

    private String quantity;

    private Integer soldOutStatus;

    private LocalDate dateFrom;

    private LocalDate dateTo;

    private Integer manufacturer;

    private String keywords;

    private String shortDescription;

    private String description;

    private String headTitle;

    private String metaDescription;

    private BigDecimal purchasePrice;

    private CurrencyEnum currency;

    private BigDecimal price;

    private Product(){
        //Do nothing
    }

    public static Product getDefault(){
        Product product = new Product();
        product.enabled = Boolean.TRUE;
        product.name = "Duck-" + RandomStringUtils.randomNumeric(5);
        product.code = RandomStringUtils.randomNumeric(5);
        product.category = 0;
        product.gender = GenderEnum.MALE;
        product.quantity = "123";
        product.soldOutStatus = 1;
        product.dateFrom = LocalDate.now();
        product.dateTo = LocalDate.now().plusMonths(3);
        product.manufacturer = 1;
        product.keywords = "keyword";
        product.shortDescription = "Short description";
        product.description = "Description";
        product.headTitle = "Head title";
        product.metaDescription = "Meta";
        product.purchasePrice = new BigDecimal(100);
        product.currency = CurrencyEnum.USD;
        product.price = new BigDecimal(100);
        return product;
    }

    public Boolean getEnabled() {
        return enabled;
    }


    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Integer getCategory() {
        return category;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public String getQuantity() {
        return quantity;
    }

    public Integer getSoldOutStatus() {
        return soldOutStatus;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public Integer getManufacturer() {
        return manufacturer;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public String getHeadTitle() {
        return headTitle;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
