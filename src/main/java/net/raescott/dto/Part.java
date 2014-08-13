package net.raescott.dto;

/**
 * @author Richard Scott Smith <scott.smith@isostech.com>
 */
public class Part implements Dto {
    private String partNumber;
    private String partName;

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
}
