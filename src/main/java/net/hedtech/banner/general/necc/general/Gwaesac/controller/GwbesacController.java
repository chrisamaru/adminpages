package net.hedtech.banner.general.necc.general.Gwaesac.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.general.necc.general.Gwaesac.GwaesacTask;
import net.hedtech.banner.general.necc.general.Gwaesac.model.GwaesacModel;
import morphis.foundations.core.appsupportlib.runtime.action.*;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import morphis.foundations.core.types.NDate;
import morphis.foundations.core.types.NString;

import static morphis.foundations.core.types.Types.*;

import org.jfree.util.Log;

import morphis.core.utils.behavior.annotations.*;
import morphis.foundations.core.appdatalayer.data.*;
import morphis.foundations.core.appsupportlib.exceptions.ApplicationException;
import morphis.foundations.core.appsupportlib.model.IDBBusinessObject;
import net.hedtech.general.common.dbservices.GNls;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.nextBlock;
import static morphis.foundations.core.appsupportlib.runtime.MessageServices.errorMessage;
import morphis.foundations.core.appsupportlib.Lib;
import morphis.foundations.core.appsupportlib.runtime.*;
import net.hedtech.banner.general.necc.general.Gwaesac.model.*;
import morphis.foundations.core.appdatalayer.events.BeforeQuery;
import morphis.foundations.core.appdatalayer.events.QueryEvent;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;
import morphis.foundations.core.appdatalayer.events.AfterQuery;
import morphis.foundations.core.appdatalayer.events.BeforeRowInsert;
import morphis.foundations.core.appdatalayer.events.BeforeRowUpdate;
import static morphis.foundations.core.appsupportlib.Globals.getGlobal;
import morphis.foundations.core.appsupportlib.runtime.events.RecordCreated;
import java.util.EventObject;
import morphis.foundations.core.appdatalayer.events.AfterRowDelete;

public class GwbesacController extends DefaultBlockController {

	public GwbesacController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public GwaesacTask getTask() {
		return (GwaesacTask) super.getTask();
	}

	public GwaesacModel getFormModel() {
		return getTask().getModel();
	}

	@After
	@ActionTrigger(action = "PRE-BLOCK", function = KeyFunction.BLOCK_IN)
	public void gwbesac_blockIn() {
		// TODO to be filled by the user
	}

	@BeforeQuery
	public void gwbesac_BeforeQuery(QueryEvent queryEvent) {
		((IDBBusinessObject) queryEvent.getSource()).getSelectCommandParams().add(DbManager.getDataBaseFactory()
				.createDataParameter("PIDM", this.getFormModel().getKeyBlock().getPidm()));
	}

	@AfterQuery
	public void gwbesac_AfterQuery(RowAdapterEvent rowAdapterEvent) {
		GwbesacAdapter gwbesacElement = (GwbesacAdapter) this.getFormModel().getGwbesac().getRowAdapter(true);
		
		// Retrieve the data from SPRIDEN
		String spridenC = "select iden.SPRIDEN_ID, f_format_name(iden.spriden_pidm, 'LFMI')\r\n" + 
				"from spriden iden\r\n" + 
				"where iden.SPRIDEN_PIDM = :KEY_BLOCK_PIDM\r\n" + 
				"and iden.SPRIDEN_CHANGE_IND IS NULL";
		DataCursor spridenCursor = new DataCursor(spridenC);
		NString id = NString.getNull();
		NString fullName = NString.getNull();
		try {
			// Setting query parameters
			spridenCursor.addParameter("KEY_BLOCK_PIDM", getFormModel().getKeyBlock().getPidm());
			spridenCursor.open();
			ResultSet spridenCResults = spridenCursor.fetchInto();
			if (spridenCResults != null) {
				id = spridenCResults.getStr(0);
				fullName = spridenCResults.getStr(1);
				gwbesacElement.setNeccId(id);
				gwbesacElement.setFullName(fullName);
			}
		} finally {
			spridenCursor.close();
		}
		
		// Retrieve the data from SIRASGN
		String sirasgnC = "SELECT NVL(inst.SIBINST_ADVR_IND, 'N'),\r\n" + 
				"       NVL(inst.SIBINST_SCHD_IND, 'N')\r\n" + 
				"  FROM sibinst inst\r\n" + 
				" WHERE     inst.SIBINST_PIDM = :KEY_BLOCK_PIDM\r\n" + 
				"       AND inst.SIBINST_TERM_CODE_EFF =\r\n" + 
				"           (SELECT MAX (ins1.SIBINST_TERM_CODE_EFF)\r\n" + 
				"              FROM sibinst ins1\r\n" + 
				"             WHERE ins1.SIBINST_PIDM = inst.SIBINST_PIDM)";
		DataCursor sirasgnCursor = new DataCursor(sirasgnC);
		NString advisorInd = NString.getNull();
		NString facultyInd = NString.getNull();
		try {
			// Setting query parameters
			sirasgnCursor.addParameter("KEY_BLOCK_PIDM", getFormModel().getKeyBlock().getPidm());
			sirasgnCursor.open();
			ResultSet sirasgnCResults = sirasgnCursor.fetchInto();
			if (sirasgnCResults != null) {
				advisorInd = sirasgnCResults.getStr(0);
				facultyInd = sirasgnCResults.getStr(1);
				gwbesacElement.setAdvisorInd(advisorInd);
				gwbesacElement.setFacultyInd(facultyInd);
			}
		} finally {
			sirasgnCursor.close();
		}

	}

	@BeforeRowInsert
	public void gwbesac_BeforeRowInsert(RowAdapterEvent rowAdapterEvent) {
		GwbesacAdapter gwbesacElement = (GwbesacAdapter) this.getFormModel().getGwbesac().getRowAdapter(true);
		gwbesacElement.setGwbesacActivityDate(NDate.getNow());
		gwbesacElement.setGwbesacUser(getGlobal("CURRENT_USER"));		
	}

	@BeforeRowUpdate
	public void gwbesac_BeforeRowUpdate(RowAdapterEvent rowAdapterEvent) {
		GwbesacAdapter gwbesacElement = (GwbesacAdapter) this.getFormModel().getGwbesac().getRowAdapter(true);
		gwbesacElement.setGwbesacActivityDate(NDate.getNow());
		gwbesacElement.setGwbesacUser(getGlobal("CURRENT_USER"));		
	}

}