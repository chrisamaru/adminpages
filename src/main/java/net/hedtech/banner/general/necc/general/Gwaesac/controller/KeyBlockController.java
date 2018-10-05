package net.hedtech.banner.general.necc.general.Gwaesac.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.general.necc.general.Gwaesac.GwaesacTask;
import net.hedtech.banner.general.necc.general.Gwaesac.model.GwaesacModel;
import morphis.foundations.core.appsupportlib.runtime.action.*;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import morphis.foundations.core.types.NNumber;
import morphis.foundations.core.types.NString;
import morphis.foundations.core.util.Ref;

import static morphis.foundations.core.types.Types.*;
import morphis.core.utils.behavior.annotations.*;
import morphis.foundations.core.appdatalayer.data.*;
import morphis.foundations.core.appsupportlib.exceptions.ApplicationException;
import net.hedtech.general.common.dbservices.GNls;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.nextBlock;
import static morphis.foundations.core.appsupportlib.runtime.MessageServices.errorMessage;
import morphis.foundations.core.appsupportlib.Lib;
import morphis.foundations.core.appsupportlib.runtime.*;
import net.hedtech.general.common.libraries.Goqolib.services.GCodeClass;
import net.hedtech.general.common.libraries.Goqolib.services.GIdClass;
import net.hedtech.general.common.libraries.Goqolib.services.GKeyBlockClass;
import net.hedtech.general.common.libraries.Goqolib.services.GNameClass;
import static morphis.foundations.core.appsupportlib.Globals.*;
import static net.hedtech.general.common.forms.services.BaseTaskServices.*;

public class KeyBlockController extends DefaultBlockController {

	private GKeyBlockClass getGKeyBlockClass() {
		return (net.hedtech.general.common.libraries.Goqolib.services.GKeyBlockClass) this.getTask().getTaskPart("GOQOLIB").getSupportCodeManager().getPackage("G$_KEY_BLOCK_CLASS");
	}	
	private GIdClass getGIdClass() {
		return (net.hedtech.general.common.libraries.Goqolib.services.GIdClass) this.getTask().getTaskPart("GOQOLIB").getSupportCodeManager().getPackage("G$_ID_CLASS");
	}	
	private GNameClass getGNameClass() {
		return (net.hedtech.general.common.libraries.Goqolib.services.GNameClass) this.getTask().getTaskPart("GOQOLIB").getSupportCodeManager().getPackage("G$_NAME_CLASS");
	}	
	private GCodeClass getGCodeClass() {
		return (net.hedtech.general.common.libraries.Goqolib.services.GCodeClass) this.getTask().getTaskPart("GOQOLIB").getSupportCodeManager().getPackage("G$_CODE_CLASS");
	}


	public KeyBlockController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public GwaesacTask getTask() {
		return (GwaesacTask) super.getTask();
	}

	public GwaesacModel getFormModel() {
		return getTask().getModel();
	}

	@ActionTrigger(action="KEY-NXTBLK", function=KeyFunction.NEXT_BLOCK)
	public void keyBlock_NextBlock()
	{
		nextBlock();
	}

	@ActionTrigger(action="POST-BLOCK", function=KeyFunction.BLOCK_OUT)
	public void keyBlock_blockOut()
	{
		getFormModel().getButtonControlBlock().setCheckKeys(toStr("Y"));
	}

	private void fetchIdAndName() {
		NString lvConfidInd = NString.getNull();
		NString lvDeceasedInd = NString.getNull();
		Ref<NString> pId_ref = new Ref<NString>(getFormModel().getKeyBlock().getId());
		Ref<NNumber> pPidm_ref = new Ref<NNumber>(getFormModel().getKeyBlock().getPidm());
		Ref<NString> pFullName_ref = new Ref<NString>(getFormModel().getKeyBlock().getFullName());
		Ref<NString> pConfidInd_ref = new Ref<NString>(lvConfidInd);
		Ref<NString> pDcsdInd_ref = new Ref<NString>(lvDeceasedInd);
		getTask().getSoqrpls().sValidId(pId_ref, pPidm_ref, pFullName_ref, pConfidInd_ref, pDcsdInd_ref);
		getFormModel().getKeyBlock().setId(pId_ref.val);
		getFormModel().getKeyBlock().setPidm(pPidm_ref.val);
		getFormModel().getKeyBlock().setFullName(pFullName_ref.val);
		lvConfidInd = pConfidInd_ref.val;
		lvDeceasedInd = pDcsdInd_ref.val;
		}

	//
	// ID Event Handlers
	@ActionTrigger(action="POST-CHANGE", item="ID")
	public void id_PostChange()
	{
		
		getGIdClass().postChange();
		fetchIdAndName();

	}
	
	@ActionTrigger(action="PRE-TEXT-ITEM", item="ID", function=KeyFunction.ITEM_IN)
	public void id_itemIn()
	{
		
		getGIdClass().itemIn();
	}

	@ValidationTrigger(item="ID")
	public void id_validate()
	{
		
		this.id_PostChange();

		getGIdClass().validate();
		

		}

	@ActionTrigger(action="KEY-NEXT-ITEM", item="ID", function=KeyFunction.NEXT_ITEM)
	public void id_keyNexItem()
	{
		getGIdClass().nextItem();
		fetchIdAndName();

	}
	
	@ActionTrigger(item = "ID", action = "id_itemOut")
	public void id_itemOut() {
		
		id_keyNexItem();		

	}

	@ActionTrigger(action="KEY-LISTVAL", item="ID", function=KeyFunction.LIST_VALUES)
	public void id_ListValues()
	{
		
		getTask().getGoqrpls().gCopyFldAttr();
		executeAction("G$_REVOKE_ACCESS");
		getTask().getGoqrpls().gCheckFailure();
		getTask().getGoqrpls().gSecuredFormCall(getGlobal("CURRENT_USER"), toStr("SOAIDEN"), toStr("QUERY"));
		getTask().getGoqrpls().gResetGlobal();
		// 
		if ( !getGlobal("VALUE").isNull() )
		{
			executeAction("LIST_VALUES_COPY");
			getTask().getGoqrpls().gCheckFailure();
			// 
			//  MW 08/06/2001 Added the following line of code to fix defect 49622. 
			setGlobal("KEY_IDNO", toStr(""));
			// 
			//nextItem();
			id_keyNexItem();
		}
		// 
		getFormModel().getButtonControlBlock().setCheckKeys(toStr("N"));
		getTask().getGoqrpls().gCheckFailure();
	}

	@ActionTrigger(action="WHEN-MOUSE-DOUBLECLICK", item="ID")
	public void id_doubleClick()
	{
		id_ListValues();
		//getGCodeClass().doubleClick();
	}

	@ActionTrigger(action="KEY-NEXT-ITEM", item="FULL_NAME", function=KeyFunction.NEXT_ITEM)
	public void fullName_keyNexItem()
	{
		
		getGNameClass().keyNexItem();
	}

}