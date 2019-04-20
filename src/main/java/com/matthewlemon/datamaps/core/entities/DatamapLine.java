package com.matthewlemon.datamaps.core.entities;

import com.matthewlemon.datamaps.core.parser.DatamapLineType;

public class DatamapLine {

    private String key;
    private String sheetName;
    private String cellRef;
	private DatamapLineType type;


    public DatamapLine(String key, String sheetName, String cellRef) {
        this.key = key;
        this.sheetName = sheetName;
        this.cellRef = cellRef;
	}

	public DatamapLine(String key, String sheetName, String cellRef, DatamapLineType type) {
        this.key = key;
        this.sheetName = sheetName;
        this.cellRef = cellRef;
        this.type = type;
	}
	
	public DatamapLineType getDatamapType() {
		return this.type;
	}

	public String getSheetName() {
		return sheetName;
	}

	public String getCellRef() {
		return cellRef;
	}

    public String getKey() {
        return this.key;
    }
}
