package net.raescott.dto;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Richard Scott Smith <scott.smith@isostech.com>
 */
@Document
public class Part implements Dto, Pageable {
    private String partNumber;
    private String partName;
    private String img;
    private String line;
    private String productNameInfo;

    private int pageSize;
    private int pageNumber;
    private int offset;
    private String sort;

    public Part(){
      pageSize = 10; // TODO Default to default maximum 
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getImg() {
      return img;
    }
  
    public void setImg(String img) {
      this.img = img;
    }

    public String getLine(){
      return line;
    }

    public void setLine(String line){
      this.line = line;
    }

    public String getProductNameInfo(){
      return productNameInfo;
    }
 
    public void setProductNameInfo(String productNameInfo){
      this.productNameInfo = productNameInfo;
    }

    @Override
    public int getPageNumber() {
        if (getPageSize() > 0) {
            return offset / pageSize;
        } else {
            return 0;
        }
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

    @Override
    public int getOffset() {
        return offset;
    }

	public void setOffset(int offset) {
		this.offset = offset;
	}

    @Override
    public Sort getSort() {
        Sort.Order order = new Sort.Order("desc".equalsIgnoreCase(sort) ? Sort.Direction.DESC : Sort.Direction.ASC, "partNumber");
        return new Sort(order);
    }

	public void setSort(String sort) {
		this.sort = sort;
	}

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }
}
