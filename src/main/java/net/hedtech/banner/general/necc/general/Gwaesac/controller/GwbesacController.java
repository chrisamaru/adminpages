package net.hedtech.banner.general.necc.general.Gwaesac.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.general.necc.general.Gwaesac.GwaesacTask;
import net.hedtech.banner.general.necc.general.Gwaesac.model.GwaesacModel;
import morphis.foundations.core.appsupportlib.runtime.action.*;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import static morphis.foundations.core.types.Types.*;
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
	@ActionTrigger(action="PRE-BLOCK", function=KeyFunction.BLOCK_IN)
	public void gwbesac_blockIn()
	{
		//TODO to be filled by the user
	}

	@BeforeQuery
	public void gwbesac_BeforeQuery(QueryEvent queryEvent) {
		((IDBBusinessObject)queryEvent.getSource()).getSelectCommandParams().
		add(DbManager.getDataBaseFactory().createDataParameter("PIDM",
		this.getFormModel().getKeyBlock().getPidm()));
	}
	
}