package net.hedtech.banner.general.necc.general.Gwaesac.controller;

import morphis.foundations.core.appsupportlib.runtime.ITask;
import net.hedtech.general.common.forms.controller.DefaultFormController;
import net.hedtech.banner.general.necc.general.Gwaesac.GwaesacTask;
import net.hedtech.banner.general.necc.general.Gwaesac.model.GwaesacModel;
import net.hedtech.banner.general.necc.general.Gwaesac.model.GwbesacAdapter;
import morphis.foundations.core.appsupportlib.runtime.action.ActionTrigger;
import morphis.foundations.core.appsupportlib.runtime.action.ValidationTrigger;

import static morphis.foundations.core.appsupportlib.Globals.*;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import static morphis.foundations.core.types.Types.*;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.exceptions.ApplicationException;
import static morphis.foundations.core.appsupportlib.runtime.TaskServices.*;
import static morphis.foundations.core.appsupportlib.runtime.ItemServices.*;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.*;
import static morphis.foundations.core.appsupportlib.runtime.MessageServices.*;
import java.util.EventObject;
import morphis.core.utils.behavior.annotations.Before;
import morphis.foundations.core.appdatalayer.data.DataCursor;
import morphis.foundations.core.appdatalayer.data.ResultSet;
import morphis.foundations.core.appdatalayer.events.BeforeRowInsert;
import morphis.foundations.core.appdatalayer.events.BeforeRowUpdate;
import morphis.foundations.core.appdatalayer.events.CancelEvent;
import morphis.foundations.core.appdatalayer.events.QueryExecute;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;
import morphis.foundations.core.appsupportlib.model.AfterCommit;
import morphis.foundations.core.appsupportlib.model.BeforeCommit;
import morphis.foundations.core.appsupportlib.model.OnRollback;
import morphis.foundations.core.appsupportlib.runtime.events.OnError;
import morphis.foundations.core.appsupportlib.runtime.events.TaskEnded;
import morphis.foundations.core.appsupportlib.runtime.events.TaskStarted;
import morphis.foundations.core.appsupportlib.runtime.events.TaskStartedPre;
import net.hedtech.general.common.dbservices.GNls;
import net.hedtech.general.common.libraries.Goqolib.services.*;
import morphis.foundations.core.appsupportlib.model.AfterDatabaseCommit;

public class GwaesacFormController extends DefaultFormController {

	public GwaesacFormController(ITask task) {
		super(task);
	}

	@Override
	public GwaesacTask getTask() {
		return (GwaesacTask) super.getTask();
	}

	public GwaesacModel getFormModel() {
		return getTask().getModel();
	}

	private GFormClass getGFormClass() {
		return (GFormClass) this.getTask().getTaskPart("GOQOLIB").getSupportCodeManager().getPackage("G$_FORM_CLASS");
	}

	private GApplFormClass getGApplFormClass() {
		return (GApplFormClass) this.getTask().getTaskPart("GOQOLIB").getSupportCodeManager()
				.getPackage("G$_APPL_FORM_CLASS");
	}

	private GCodeClass getGCodeClass() {
		return (net.hedtech.general.common.libraries.Goqolib.services.GCodeClass) this.getTask().getTaskPart("GOQOLIB")
				.getSupportCodeManager().getPackage("G$_CODE_CLASS");
	}

	private GDescClass getGDescClass() {
		return (net.hedtech.general.common.libraries.Goqolib.services.GDescClass) this.getTask().getTaskPart("GOQOLIB")
				.getSupportCodeManager().getPackage("G$_DESC_CLASS");
	}

	private GIconBtnClass getGIconBtnClass() {
		return (net.hedtech.general.common.libraries.Goqolib.services.GIconBtnClass) this.getTask()
				.getTaskPart("GOQOLIB").getSupportCodeManager().getPackage("G$_ICON_BTN_CLASS");
	}

	@ActionTrigger(action = "DISABLE_KEYS")
	public void Gwaesac_DisableKeys() {

	}

	@ActionTrigger(action = "ENABLE_KEYS")
	public void Gwaesac_EnableKeys() {

	}

	@ActionTrigger(action = "WHEN_NEW_BLOCK_INSTANCE_TRG")
	public void Gwaesac_WhenNewBlockInstanceTrg() {
		if (getFormModel().getButtonControlBlock().getCheckKeys().equals("Y")) {
			getFormModel().getButtonControlBlock().setCheckKeys(toStr("N"));
			goBlock(toStr("KEY_BLOCK"));
			executeAction("CHECK_KEYS");
			getTask().getGoqrpls().gCheckFailure();

			nextBlock();
			executeQuery();

			getFormModel().getButtonControlBlock().setCheckKeys(toStr("N"));
			executeAction("DISABLE_KEYS");
			getTask().getGoqrpls().gCheckFailure();
		}
	}

	@ActionTrigger(action = "LOAD_CURRENT_RELEASE")
	public void Gwaesac_LoadCurrentRelease() {
		getFormModel().getFormHeader().setCurrentRelease(toStr("8.5"));
	}

	@ActionTrigger(action = "KEY-CLRFRM", function = KeyFunction.CLEAR_FORM)
	public void Gwaesac_ClearTask() {
		executeAction("SAVE_KEYS");
		getTask().getGoqrpls().gCheckFailure();
		executeAction("ENABLE_KEYS");
		getTask().getGoqrpls().gCheckFailure();

		clearTask();
		getTask().getGoqrpls().gCheckFailure();

		executeAction("LOAD_FORM_HEADER");
		getTask().getGoqrpls().gCheckFailure();
		executeAction("GLOBAL_COPY");
		getTask().getGoqrpls().gCheckFailure();
	}

	@ActionTrigger(action = "KEY-NXTBLK", function = KeyFunction.NEXT_BLOCK)
	public void Gwaesac_NextBlock() {
		getGFormClass().nextBlock();
	}

	@ActionTrigger(action = "G$_VERIFY_ACCESS")
	public void Gwaesac_GVerifyAccess() {
		getGFormClass().gVerifyAccess();
	}

	@TaskStartedPre
	public void Gwaesac_TaskStartedPre(EventObject args) {
		getGFormClass().taskStartedPre(args);
	}

	@ActionTrigger(action = "PRE_FORM_TRG")
	public void Gwaesac_PreFormTrg() {
		getGFormClass().preFormTrg();
	}

	@TaskEnded
	public void Gwaesac_TaskEnded(EventObject args) {
		getGFormClass().taskEnded(args);
	}

	@ActionTrigger(action = "POST_FORM_TRG")
	public void Gwaesac_PostFormTrg() {
		getGFormClass().postFormTrg();
	}

	@ActionTrigger(action = "PRE-BLOCK", function = KeyFunction.BLOCK_IN)
	@Before
	public void Gwaesac_blockIn() {
		getGFormClass().blockIn();
	}

	@ActionTrigger(action = "PRE_BLOCK_TRG")
	public void Gwaesac_PreBlockTrg() {
		getGFormClass().preBlockTrg();
	}

	@ActionTrigger(action = "POST-BLOCK", function = KeyFunction.BLOCK_OUT)
	@Before
	public void Gwaesac_blockOut() {
		getGFormClass().blockOut();
	}

	@ActionTrigger(action = "POST_BLOCK_TRG")
	public void Gwaesac_PostBlockTrg() {
		getGFormClass().postBlockTrg();
	}

	@BeforeCommit
	public void Gwaesac_BeforeCommit(CancelEvent args) {
		getGFormClass().beforeCommit(args);
	}

	@ActionTrigger(action = "PRE_COMMIT_TRG")
	public void Gwaesac_PreCommitTrg() {
		getGFormClass().preCommitTrg();
	}

	@OnRollback
	public void Gwaesac_OnRollback(EventObject args) {
		getGFormClass().onRollback();
	}

	@ActionTrigger(action = "ON_ROLLBACK_TRG")
	public void Gwaesac_OnRollbackTrg() {
		getGFormClass().onRollbackTrg();
	}

	@ActionTrigger(action = "ON-SELECT")
	public void Gwaesac_OnSelect() {
		getGFormClass().onSelect();
	}

	@AfterCommit
	public void Gwaesac_AfterCommit(EventObject args) {
		getGFormClass().afterCommit(args);
	}

	@ActionTrigger(action = "POST_FORMS_COMMIT_TRG")
	public void Gwaesac_PostFormsCommitTrg() {
		getGFormClass().postFormsCommitTrg();
	}

	@ActionTrigger(action = "WHEN-BUTTON-PRESSED")
	public void Gwaesac_buttonClick() {
		getGFormClass().click();
	}

	@ActionTrigger(action = "WHEN-NEW-BLOCK-INSTANCE", function = KeyFunction.BLOCK_CHANGE)
	@Before
	public void Gwaesac_blockChange() {
		getGFormClass().blockChange();
	}

	@ActionTrigger(action = "WHEN-WINDOW-ACTIVATED")
	public void Gwaesac_WhenWindowActivated() {
		getGFormClass().whenWindowActivated();
	}

	@ActionTrigger(action = "WHEN-WINDOW-CLOSED")
	public void Gwaesac_WhenWindowClosed() {
		getGFormClass().whenWindowClosed();
	}

	@ActionTrigger(action = "KEY-PRVBLK", function = KeyFunction.PREVIOUS_BLOCK)
	public void Gwaesac_PreviousBlock() {
		getGFormClass().previousBlock();
	}

	//
	// copy the following two methods to get LOV to work in keyBlock
	//
	@ActionTrigger(action = "KEY-LISTVAL", function = KeyFunction.LIST_VALUES)
	public void Gwaesac_ListValues() {

		getGFormClass().listValues();
	}

	@ActionTrigger(action = "LIST_VALUES_COPY")
	public void Gwaesac_ListValuesCopy() {
		getGFormClass().listValuesCopy();
	}

	@ActionTrigger(action = "SAVE_KEYS")
	public void Gwaesac_SaveKeys() {
		setGlobal("KEY_IDNO", getFormModel().getKeyBlock().getId());
	}

	@ActionTrigger(action = "GLOBAL_COPY")
	public void Gwaesac_GlobalCopy() {
		if (!getGlobal("KEY_IDNO").isNull()) {
			getFormModel().getKeyBlock().setId(getGlobal("KEY_IDNO"));
		}
	}

	@ActionTrigger(action = "CHECK_KEYS")
	public void Gwaesac_CheckKeys() {
		getGApplFormClass().checkKeys();
	}

	@ActionTrigger(action = "KEY-EXIT", function = KeyFunction.EXIT)
	public void Gwaesac_Exit() {

		getTask().getGoqrpls().gDetermineEraseGlobal();
		executeAction("SAVE_KEYS");
		getTask().getGoqrpls().getGGoqolibKeyTrigger().b2kExitForm();
	}

	@TaskStarted
	public void Gwaesac_TaskStarted(EventObject args) {
		executeAction("LOAD_FORM_HEADER");
		getTask().getGoqrpls().gCheckFailure();
		executeAction("GLOBAL_COPY");
		getTask().getGoqrpls().gCheckFailure();
	}

	@ActionTrigger(action = "G$_SEARCH_PARAMETERS", item = "GWBESAC_DW_ACCESS")
	public void gwaesac_GSearchParameters() {
		getGCodeClass().gSearchParameters();
	}

	@ActionTrigger(action = "WHEN-MOUSE-DOUBLECLICK", item = "GWBESAC_DW_ACCESS")
	public void gwbesacDwAccess_doubleClick() {
		getGCodeClass().doubleClick();
	}

	@ActionTrigger(action = "WHEN-NEW-ITEM-INSTANCE", item = "GWBESAC_DW_ACCESS", function = KeyFunction.ITEM_CHANGE)
	public void gwbesacDwAccess_itemChange() {
		getGCodeClass().itemChange();
	}

	@ActionTrigger(action = "KEY-NEXT-ITEM", item = "GWBESAC_DW_ACCESS", function = KeyFunction.NEXT_ITEM)
	public void gwbesacDwAccess_keyNexItem() {
		GwbesacAdapter gwbesacElement = (GwbesacAdapter) this.getFormModel().getGwbesac().getRowAdapter(true);
		String gwvdwrlC = "select dwrl.GWVDWRL_DESC\r\n" + "from gwvdwrl dwrl\r\n"
				+ "where dwrl.GWVDWRL_CODE = :DW_ACCESS";
		NString dwAccessDesc = NString.getNull();
		DataCursor gwvdwrlCursor = new DataCursor(gwvdwrlC);
		try {
			// Setting query parameters
			gwvdwrlCursor.addParameter("DW_ACCESS", gwbesacElement.getGwbesacDwAccess());
			gwvdwrlCursor.open();
			ResultSet gwvdwrlCResults = gwvdwrlCursor.fetchInto();
			if (gwvdwrlCResults != null) {
				dwAccessDesc = gwvdwrlCResults.getStr(0);
				gwbesacElement.setDwAccessDesc(dwAccessDesc);
				getGCodeClass().nextItem();
			} else {
				errorMessage(GNls.Fget(toStr("GWAESAC-0002"), toStr("FORM"),
						toStr("*ERROR* Invalid Degreeworks Access; press LIST for valid codes.")));
				throw new ApplicationException();
			}
		} finally {
			gwvdwrlCursor.close();
		}
	}

//	@ActionTrigger(action = "POST-TEXT-ITEM", item = "GWBESAC_DW_ACCESS", function = KeyFunction.ITEM_OUT)
//	public void gwbesacDwAccess_itemOut() {
//		GwbesacAdapter gwbesacElement = (GwbesacAdapter) this.getFormModel().getGwbesac().getRowAdapter(true);
//		if (gwbesacElement.getGwbesacDwAccess().isNull()) {
//			gwbesacElement.setDwAccessDesc(toStr(""));
//		} else {
//			getTask().getGoqrpls().getGSearch().postTextCode();
//			getTask().getGoqrpls().gCheckFailure();
//		}
//	}

//	@ActionTrigger(action = "POST-CHANGE", item = "GWBESAC_DW_ACCESS")
//	public void gwbesacDwAccess_PostChange() {
//
//		GwbesacAdapter gwbesacElement = (GwbesacAdapter) this.getFormModel().getGwbesac().getRowAdapter(true);
//		String gwvdwrlC = "select dwrl.GWVDWRL_DESC\r\n" + "from gwvdwrl dwrl\r\n"
//				+ "where dwrl.GWVDWRL_CODE = :DW_ACCESS";
//		NString dwAccessDesc = NString.getNull();
//		DataCursor gwvdwrlCursor = new DataCursor(gwvdwrlC);
//		try {
//			// Setting query parameters
//			gwvdwrlCursor.addParameter("DW_ACCESS", gwbesacElement.getGwbesacDwAccess());
//			gwvdwrlCursor.open();
//			ResultSet gwvdwrlCResults = gwvdwrlCursor.fetchInto();
//			if (gwvdwrlCResults != null) {
//				dwAccessDesc = gwvdwrlCResults.getStr(0);
//				gwbesacElement.setDwAccessDesc(dwAccessDesc);
//			} else {
//				errorMessage(GNls.Fget(toStr("GWAESAC-0002"), toStr("FORM"),
//						toStr("*ERROR* Invalid Degreeworks Access; press LIST for valid codes.")));
//				throw new ApplicationException();
//			}
//		} finally {
//			gwvdwrlCursor.close();
//		}
//
//	}

	@ActionTrigger(action = "WHEN-MOUSE-CLICK", item = "GWBESAC_DW_ACCESS_LBT")
	public void gwbesacDwAccess_Lbt_click() {
		getGIconBtnClass().whenMouseClick();
	}

	@ValidationTrigger(item = "GWBESAC_DW_ACCESS")
	public void gwbesacDwAccess_validation() {
		GwbesacAdapter gwbesacElement = (GwbesacAdapter) this.getFormModel().getGwbesac().getRowAdapter(true);

		if (gwbesacElement == null)
			return;
		if (gwbesacElement.getGwbesacDwAccess().isNull()) {
			gwbesacElement.setDwAccessDesc(toStr(""));
			return;
		}

		String sqlptiCursor = "select dwrl.GWVDWRL_DESC\r\n" + "from gwvdwrl dwrl\r\n"
				+ "where dwrl.GWVDWRL_CODE = :DW_ACCESS";
		DataCursor ptiCursor = new DataCursor(sqlptiCursor);
		try {
			// Setting query parameters
			ptiCursor.addParameter("DW_ACCESS", gwbesacElement.getGwbesacDwAccess());
			ptiCursor.open();
			ResultSet ptiCursorResults = ptiCursor.fetchInto();
			if (ptiCursorResults != null) {
				gwbesacElement.setDwAccessDesc(ptiCursorResults.getStr(0));
			} else {
				errorMessage(GNls.Fget(toStr("GWAESAC-0002"), toStr("FORM"),
						toStr("*ERROR* Invalid Degreeworks Access; press LIST for valid codes.")));
				throw new ApplicationException();
			}
		} catch (Exception e) {
			// Dump the exception to the error stream
			e.printStackTrace();
			// Dump exception so it can be seen via console.
			System.out.println("Error - Degreeworks Access validation : " + e);
			throw new ApplicationException();
		} finally {
			ptiCursor.close();
		}
	}

	@AfterDatabaseCommit
	public void gwaesac_AfterDatabaseCommit(EventObject eventObject) {
		GwbesacAdapter gwbesacElement = (GwbesacAdapter) this.getFormModel().getGwbesac().getRowAdapter(true);
		NString currentDwAccess = getTask().getServices().getCurrentDwAccess();
		NString dwEnabledInd = gwbesacElement.getGwbesacDwEnabledInd();
		NString requestedDwAccess = gwbesacElement.getGwbesacDwAccess();
		NNumber pidm = getFormModel().getKeyBlock().getPidm();
		
		// If Degreeworks is enabled
		// Open a ticket in KACE to request access only if current Degreeworks access is different from requested Degreeworks access
		if (dwEnabledInd.equals("Y")) {
			// Degreeworks is enabled
			if (currentDwAccess.notEquals(requestedDwAccess)) {
				// Open the ticket and pop an alert with the ticket # (?) telling the user that a ticket has been opened
				if (getTask().getServices().openTicket(pidm, toStr("G"), requestedDwAccess)) {
					getTask().getServices().showTicketAlert(toStr("A ticket has been opened to give the user Degreeworks access. Please allow 1-2 business days for this to be process."));
				}
			}
		} else {
			// Degreeworks is not enabled, so open a ticket to revoke the user's access
			// pop an alert saying that a ticket has been opened to revoke the user's access to Degreeworks
			if (getTask().getServices().openTicket(pidm, toStr("R"), null)) {
				getTask().getServices().showTicketAlert(toStr("A ticket has been opened to revoke the user's Degreeworks access. Please allow 1-2 business days for this to be process."));
			}
		}
	}
}