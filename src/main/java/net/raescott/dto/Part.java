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

    private int pageSize;
    private int pageNumber;
    private int offset;
    private String sort;
    private Part part;

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

    @Override
    public int getOffset() {
        return offset;
    }

    @Override
    public Sort getSort() {
        Sort.Order order = new Sort.Order("asc".equalsIgnoreCase(sort) ? Sort.Direction.ASC : Sort.Direction.DESC, "partName");
        return new Sort(order);
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
