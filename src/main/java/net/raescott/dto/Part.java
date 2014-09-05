package net.raescott.dto;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * @author Richard Scott Smith <scott.smith@isostech.com>
 */
@Document
public class Part implements Dto, Pageable {
    static final int MAX_SIZE = 100;
    private String partNumberDisplay;
    private String partNumberDescription;
    private String suggestedOrderQty;
    private String shortDescription;
    private String brandCode;
    private String partNumber;
    private String productFeatures;
    private String imgOrientationId;
    private String partNumberImage;
    private String partNumberThumbnail;
    private String primaryImage;
    private String representationId;

    private int pageSize;

    @JsonIgnore
    private int offset;

    @JsonIgnore
    private String sort;

    public Part(){
      pageSize = MAX_SIZE;
      offset = 0;
      sort = "asc";      
    }

    @JsonIgnore
    public int getPageSize() {
        return pageSize;
    }

  	public void setPageSize(int pageSize) {
      if(pageSize > MAX_SIZE)
        this.pageSize = MAX_SIZE;
      else
	    	this.pageSize = pageSize;
  	}

    @JsonIgnore
    @Override
    public int getOffset() {
        return offset;
    }

  	public void setOffset(int offset) {
  		this.offset = offset;
  	}

  	public void setSort(String sort) {
  		this.sort = sort;
   	}
 
    public Pageable next() {
      setPageNumber(getPageNumber() + 1);
      return this;
    }

    @Override
    public Pageable previousOrFirst() {
      int page = getPageNumber();

      if(page > 0)
        setPageNumber(page - 1);
        
      return this;
    }

    @Override
    public Pageable first() {
      setPageNumber(0);
      return this;
    }

    @Override
    public boolean hasPrevious() {
      return getPageNumber() > 0;
    }


    @JsonIgnore
    @Override
    public int getPageNumber() {
        if (getPageSize() > 0) {
            return offset / pageSize;
        } else {
            return 0;
        }
    }
 
    private void setPageNumber(int page){
      offset = pageSize * page;
    }

    @JsonIgnore
    @Override
    public Sort getSort() {
        Sort.Order order = new Sort.Order("desc".equalsIgnoreCase(sort) ? Sort.Direction.DESC : Sort.Direction.ASC, "partNumber");
        return new Sort(order);
    }
    public String getPartNumberDisplay(){
      return partNumberDisplay;
    }
    public String getPartNumberDescription(){
      return partNumberDescription;
    }
    public String getSuggestedOrderQty(){
      return suggestedOrderQty;
    }
    public String getShortDescription(){
      return shortDescription;
    }
    public String getBrandCode(){
      return brandCode;
    }
    public String getPartNumber(){
      return partNumber;
    }
    public String getProductFeatures(){
      return productFeatures;
    }
    public String getImgOrientationId(){
      return imgOrientationId;
    }
    public String getPartNumberImage(){
      return partNumberImage;
    }
    public String getPartNumberThumbnail(){
      return partNumberThumbnail;
    }
    public String getPrimaryImage(){
      return primaryImage;
    }
    public String getRepresentationId(){
      return representationId;
    }
    public void setPartNumberDisplay(String partNumberDisplay){
      this.partNumberDisplay = partNumberDisplay;
    }
    public void setPartNumberDescription(String partNumberDescription){
      this.partNumberDescription = partNumberDescription;
    }
    public void setSuggestedOrderQty(String suggestedOrderQty){
      this.suggestedOrderQty = suggestedOrderQty;
    }
    public void setShortDescription(String shortDescription){
      this.shortDescription = shortDescription;
    }
    public void setBrandCode(String brandCode){
      this.brandCode = brandCode;
    }
    public void setPartNumber(String partNumber){
      this.partNumber = partNumber;
    }
    public void setProductFeatures(String productFeatures){
      this.productFeatures = productFeatures;
    }
    public void setImgOrientationId(String imgOrientationId){
      this.imgOrientationId = imgOrientationId;
    }
    public void setPartNumberImage(String partNumberImage){
      this.partNumberImage = partNumberImage;
    }
    public void setPartNumberThumbnail(String partNumberThumbnail){
      this.partNumberThumbnail = partNumberThumbnail;
    }
    public void setPrimaryImage(String primaryImage){
      this.primaryImage = primaryImage;
    }
    public void setRepresentationId(String representationId){
      this.representationId = representationId;
    }
}

