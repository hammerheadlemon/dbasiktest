package com.matthewlemon.datamaps.core.fixtures;

import java.util.List;

import com.matthewlemon.datamaps.core.TestSetup;
import com.matthewlemon.datamaps.core.entities.CSVFile;
import com.matthewlemon.datamaps.core.entities.Datamap;
import com.matthewlemon.datamaps.core.entities.DatamapLine;
import com.matthewlemon.datamaps.core.exceptions.DatamapNotFoundException;
import com.matthewlemon.datamaps.core.exceptions.DuplicateDatamapException;
import com.matthewlemon.datamaps.core.parser.DatamapLineType;
import com.matthewlemon.datamaps.core.usecases.CreateableDatamapUseCase;

public class CreateableDatamapFixture {

    private CreateableDatamapUseCase useCase;

    public int canCheckCountOfLinesInDatamap(String datamapName) throws DatamapNotFoundException {
        return this.useCase.getLineCountFromDatamap(datamapName);
    }

    public void setUpFixture() {
        this.useCase = new CreateableDatamapUseCase();
        TestSetup.setupContext();
    }

    public void userAddsDataToDatamapUsingCSV(String datamapName, CSVFile csvFile) throws DatamapNotFoundException {
        useCase.addCSVDataToDatamap(datamapName, csvFile);
    }

    public void userAddsSingleLineOfDataToDatamap(String datamapName, String key, String sheetName, String cellRef, DatamapLineType type) throws DatamapNotFoundException {
        this.useCase.addLineToDatamap(datamapName, key, sheetName, cellRef, type);
    }

    public List<DatamapLine> userCanGetListOfLinesFromDatamap(String datamapName) throws DatamapNotFoundException {
        Datamap datamap = useCase.getDatamap(datamapName);
        return datamap.getDatamapLines();
    }

    public void userCreatesDatamapWithName(String datamapName) throws DuplicateDatamapException {
        useCase.createDatamap(datamapName);
    }
}
