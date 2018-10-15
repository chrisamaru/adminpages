package net.hedtech.banner.general.necc.general.Gwaesac.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.general.necc.general.Gwaesac.GwaesacTask;
import net.hedtech.banner.general.necc.general.Gwaesac.model.GwaesacModel;
import net.hedtech.banner.general.necc.general.Gwaesac.model.GwreabrAdapter;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;
import morphis.foundations.core.appdatalayer.events.BeforeRowInsert;
import morphis.foundations.core.appdatalayer.events.BeforeRowUpdate;
import morphis.foundations.core.appsupportlib.runtime.events.RecordCreated;
import morphis.foundations.core.types.NDate;

import static morphis.foundations.core.appsupportlib.Globals.getGlobal;

import java.util.EventObject;

public class GwreabrController extends DefaultBlockController {

	public GwreabrController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public GwaesacTask getTask() {
		return (GwaesacTask) super.getTask();
	}

	public GwaesacModel getFormModel() {
		return getTask().getModel();
	}

	@BeforeRowInsert
	public void gwreabr_BeforeRowInsert(RowAdapterEvent rowAdapterEvent) {
		GwreabrAdapter gwreabrElement = (GwreabrAdapter) this.getFormModel().getGwreabr().getRowAdapter(true);
		gwreabrElement.setGwreabrActivityDate(NDate.getNow());
		gwreabrElement.setGwreabrUser(getGlobal("CURRENT_USER"));		
	}

	@BeforeRowUpdate
	public void gwreabr_BeforeRowUpdate(RowAdapterEvent rowAdapterEvent) {
		GwreabrAdapter gwreabrElement = (GwreabrAdapter) this.getFormModel().getGwreabr().getRowAdapter(true);
		gwreabrElement.setGwreabrActivityDate(NDate.getNow());
		gwreabrElement.setGwreabrUser(getGlobal("CURRENT_USER"));		
	}
	
}