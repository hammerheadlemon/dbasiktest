package com.matthewlemon.datamaps.core.usecases.creatingdatamaps;

import com.matthewlemon.datamaps.core.entities.DatamapLine;
import com.matthewlemon.datamaps.core.entities.InMemoryReturn;
import com.matthewlemon.datamaps.core.exceptions.CellValueNotFoundException;
import com.matthewlemon.datamaps.core.exceptions.RuleCheckerReportNotFoundException;
import com.matthewlemon.datamaps.core.parser.DatamapLineValue;
import java.util.Map;
import java.util.Set;

public class RuleChecker {

	private final RuleReport report;
	private final InMemoryReturn rtn;

	public RuleChecker(InMemoryReturn rtn) throws CellValueNotFoundException {
		this.report = new RuleReport();
		this.rtn = rtn;
	}

	public void check(DatamapLine dml) throws CellValueNotFoundException {

		// TODO: need to check types of values coming into this method
		Set<DatamapLineRule> ruleSet = dml.getRuleSet().getRules();
		DatamapLineValue<?> dmlValue;
		DatamapLineValue<?> valueToCompare;
		Comparable left;
		Comparable right;

		for (DatamapLineRule rule : ruleSet) {
			// TODO: here we need to do a switch and trigger rule based on values from the
			// return
			switch (rule.getOperator()) {
			case EQUALS:
				dmlValue = rtn.getCellValue(dml.getSheetName(), dml);
				valueToCompare = rtn.getCellValue(dml.getSheetName(), rule.getRootCellRef());
				left = (Comparable)dmlValue.getValue();
				right = (Comparable)valueToCompare.getValue();
				if (left.compareTo(right) == 0)
					this.report.addLineToReport(rule.getRuleName(), Boolean.TRUE);
				break;
			case GREATER:
				dmlValue = rtn.getCellValue(dml.getSheetName(), dml);
				valueToCompare = rtn.getCellValue(dml.getSheetName(), rule.getRootCellRef());
				left = (Comparable)dmlValue.getValue();
				right = (Comparable)valueToCompare.getValue();
				if (left.compareTo(right) > 0)
					this.report.addLineToReport(rule.getRuleName(), Boolean.TRUE);
				break;
			case LESS:
				dmlValue = rtn.getCellValue(dml.getSheetName(), dml);
				valueToCompare = rtn.getCellValue(dml.getSheetName(), rule.getRootCellRef());
				left = (Comparable)dmlValue.getValue();
				right = (Comparable)valueToCompare.getValue();
				if (left.compareTo(right) < 0)
					this.report.addLineToReport(rule.getRuleName(), Boolean.TRUE);
				break;
			case EARLIER:
				dmlValue = rtn.getCellValue(dml.getSheetName(), dml);
				valueToCompare = rtn.getCellValue(dml.getSheetName(), rule.getRootCellRef());
				left = (Comparable)dmlValue.getValue();
				right = (Comparable)valueToCompare.getValue();
				if (left.compareTo(right) < 0)
					this.report.addLineToReport(rule.getRuleName(), Boolean.TRUE);
				break;
			case LATER:
				dmlValue = rtn.getCellValue(dml.getSheetName(), dml);
				valueToCompare = rtn.getCellValue(dml.getSheetName(), rule.getRootCellRef());
				left = (Comparable)dmlValue.getValue();
				right = (Comparable)valueToCompare.getValue();
				if (left.compareTo(right) > 0)
					this.report.addLineToReport(rule.getRuleName(), Boolean.TRUE);
				break;
			}
		}
	}

	public int getReportSize() {
		return this.report.getReportSize();
	}

	public Boolean getReportWithString(String reportName) throws RuleCheckerReportNotFoundException {
		Boolean reportToReturn = this.report.getReport().get(reportName);
		if (reportToReturn == null) {
			throw new RuleCheckerReportNotFoundException("Cannot find report for " + reportName);
		} else {
			return reportToReturn;
		}
	}

	public Map<String, Boolean> getReport() {
		return this.report.getReport();
	}
}
