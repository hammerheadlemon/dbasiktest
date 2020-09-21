/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matthewlemon.datamaps.core.repositories;

import com.matthewlemon.datamaps.core.entities.CSVFile;
import com.matthewlemon.datamaps.core.entities.Datamap;
import com.matthewlemon.datamaps.core.entities.DatamapLine;
import com.matthewlemon.datamaps.core.exceptions.DatamapLineNotFoundException;
import com.matthewlemon.datamaps.core.exceptions.DatamapNotFoundException;
import com.matthewlemon.datamaps.core.exceptions.DuplicateDatamapException;
import com.matthewlemon.datamaps.core.parser.DatamapLineType;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author lemon
 */
public class FileDatamapRepository implements DatamapRepository {

	@Override
	public void addDataToDatamapWithCSV(String datamapName, CSVFile csvFile) throws DatamapNotFoundException {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void addLineToDatamap(String datamapName, String key, String sheetName, String cellRef, DatamapLineType text) throws DatamapNotFoundException {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Datamap createDatamap(String datamapName) throws DuplicateDatamapException {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public int datamapCount() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean datamapExists(String datamapName) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void deleteAllDatamaps() throws Exception {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void deleteAllLinesIn(String test_datamap) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public List<DatamapLine> getDataLinesFor(String datamapName) throws DatamapNotFoundException {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Datamap getDatamap(String test_datamap) throws DatamapNotFoundException {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public DatamapLine getDatamapLineFrom(String datamapName, String key) throws DatamapLineNotFoundException, DatamapNotFoundException {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Object save(Object entity) {
		return null;
	}

	@Override
	public Iterable saveAll(Iterable entities) {
		return null;
	}

	@Override
	public Optional findById(Object o) {
		return Optional.empty();
	}

	@Override
	public boolean existsById(Object o) {
		return false;
	}

	@Override
	public Iterable findAll() {
		return null;
	}

	@Override
	public Iterable findAllById(Iterable iterable) {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void deleteById(Object o) {

	}

	@Override
	public void delete(Object entity) {

	}

	@Override
	public void deleteAll(Iterable entities) {

	}

	@Override
	public void deleteAll() {

	}
}
