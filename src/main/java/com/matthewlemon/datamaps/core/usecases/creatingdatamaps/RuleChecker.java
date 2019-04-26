package com.matthewlemon.datamaps.core.usecases.creatingdatamaps;

import java.util.Map;
import java.util.Set;

import com.matthewlemon.datamaps.core.entities.DatamapLine;
import com.matthewlemon.datamaps.core.entities.InMemoryReturn;
import com.matthewlemon.datamaps.core.exceptions.CellValueNotFoundException;
import com.matthewlemon.datamaps.core.exceptions.RuleCheckerReportNotFoundException;
import com.matthewlemon.datamaps.core.parser.DatamapLineValue;

public class RuleChecker {

	private RuleReport report;
	private InMemoryReturn rtn;

	public RuleChecker(InMemoryReturn rtn) throws CellValueNotFoundException {
		this.report = new RuleReport();
		this.rtn = rtn;
	}

	public void check(DatamapLine dml) throws CellValueNotFoundException {

		Set<DatamapLineRule> ruleSet = dml.getRuleSet().getRules();

		for (DatamapLineRule rule : ruleSet) {
			// TODO: here we need to do a switch and trigger rule based on values from the
			// return
			switch (rule.getOperator()) {
			case EQUALS:
				DatamapLineValue<?> dmlValue = rtn.getCellValue(dml.getSheetName(), dml);
				DatamapLineValue<?> valueToCompare = rtn.getCellValue(dml.getSheetName(), rule.getRootCellRef());
				if (dmlValue.getValue().equals(valueToCompare.getValue()))
					this.report.addLineToReport(rule.getRuleName(), true);
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
