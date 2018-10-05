package net.hedtech.banner.general.necc.general.Gwaesac.controller;

import morphis.foundations.core.appsupportlib.runtime.control.AbstractBlockController;
import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import morphis.core.utils.behavior.annotations.Before;
import morphis.foundations.core.appsupportlib.runtime.action.ActionTrigger;
import morphis.foundations.core.appsupportlib.runtime.action.ValidationTrigger;
import morphis.foundations.core.appsupportlib.runtime.control.AbstractBlockController;
import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import net.hedtech.banner.general.necc.general.Gwaesac.GwaesacTask;
import net.hedtech.banner.general.necc.general.Gwaesac.model.GwaesacModel;

public class GExtendedSearchBlockController extends AbstractBlockController {

	private net.hedtech.general.common.libraries.Goqolib.controller.GExtendedSearchBlockController getGoqolibGExtendedSearchBlockController() {
		return (net.hedtech.general.common.libraries.Goqolib.controller.GExtendedSearchBlockController) this.getTask().getTaskPart("GOQOLIB").getSupportCodeManager().getPackage("G$_EXTENDED_SEARCH_BLOCK");
	}	
	
	public GExtendedSearchBlockController(IFormController parentController, String name) 
	{
		super(parentController, name);
	}
		
		
		
	@Override
	public GwaesacTask getTask() {
		return (GwaesacTask)super.getTask();
	}

	public GwaesacModel getFormModel() {
		return this.getTask().getModel();
	}
		
			
	//action methods generated from triggers
	
	
	@ActionTrigger(action="LIST_VALUES", item="IDNAME_EXTSEARCH_LIST", function=KeyFunction.LIST_VALUES)
	public void idExtSearchList(){
		getGoqolibGExtendedSearchBlockController().idExtSearchList();
	}
	
	@ActionTrigger(action="WHEN-BUTTON-PRESSED", item="IDNAME_EXTSEARCH_BTN")
	public void idExtSearchListBtn_WhenButtonPressed(){
		getGoqolibGExtendedSearchBlockController().idExtSearchListBtn_WhenButtonPressed();
	}	
	

		@ActionTrigger(action="PRE-BLOCK", function=KeyFunction.BLOCK_IN)
		public void gExtendedSearchBlock_blockIn()
		{
			
			getGoqolibGExtendedSearchBlockController().gExtendedSearchBlock_blockIn();
		}

		
		@ActionTrigger(action="POST-BLOCK", function=KeyFunction.BLOCK_OUT)
		public void gExtendedSearchBlock_blockOut()
		{
			
			getGoqolibGExtendedSearchBlockController().gExtendedSearchBlock_blockOut();
		}


		@ActionTrigger(action="WHEN-NEW-BLOCK-INSTANCE", function=KeyFunction.BLOCK_CHANGE)
		public void gExtendedSearchBlock_blockChange()
		{
			
			getGoqolibGExtendedSearchBlockController().gExtendedSearchBlock_blockChange();
		}

		

		@ActionTrigger(action="WHEN-NEW-ITEM-INSTANCE", function=KeyFunction.ITEM_CHANGE)
		public void gExtendedSearchBlock_itemChange()
		{
			
			getGoqolibGExtendedSearchBlockController().gExtendedSearchBlock_itemChange();
		}


		@ActionTrigger(action="WHEN-BUTTON-PRESSED")
		public void gExtendedSearchBlock_buttonClick()
		{
			
			getGoqolibGExtendedSearchBlockController().gExtendedSearchBlock_buttonClick();
		}


		@ActionTrigger(action="KEY-CLRBLK", function=KeyFunction.CLEAR_BLOCK)
		public void gExtendedSearchBlock_keyClearBlock()
		{
			
			getGoqolibGExtendedSearchBlockController().gExtendedSearchBlock_keyClearBlock();
		}

		
		@ActionTrigger(action="KEY-CLRREC", function=KeyFunction.CLEAR_RECORD)
		public void gExtendedSearchBlock_ClearRecord()
		{
			
			getGoqolibGExtendedSearchBlockController().gExtendedSearchBlock_ClearRecord();
		}


		@ActionTrigger(action="KEY-COMMIT", function=KeyFunction.SAVE)
		public void gExtendedSearchBlock_Save()
		{
			
			getGoqolibGExtendedSearchBlockController().gExtendedSearchBlock_Save();
		}


		@ActionTrigger(action="KEY-CQUERY", function=KeyFunction.COUNT_QUERY)
		public void gExtendedSearchBlock_TotalResults()
		{
			
			getGoqolibGExtendedSearchBlockController().gExtendedSearchBlock_TotalResults();
		}

		
		@ActionTrigger(action="KEY-CREREC", function=KeyFunction.CREATE_RECORD)
		public void gExtendedSearchBlock_CreateRecord()
		{
			
			getGoqolibGExtendedSearchBlockController().gExtendedSearchBlock_CreateRecord();
		}

		
		@ActionTrigger(action="KEY-DELREC", function=KeyFunction.DELETE_RECORD)
		public void gExtendedSearchBlock_DeleteRecord()
		{
			
			getGoqolibGExtendedSearchBlockController().gExtendedSearchBlock_DeleteRecord();
		}

		
		@ActionTrigger(action="KEY-DOWN", function=KeyFunction.DOWN)
		public void gExtendedSearchBlock_MoveDown()
		{
			
			getGoqolibGExtendedSearchBlockController().gExtendedSearchBlock_MoveDown();
		}


		@ActionTrigger(action="KEY-DUP-ITEM", function=KeyFunction.DUPLICATE_ITEM)
		public void gExtendedSearchBlock_KeyDupItem()
		{
			
			getGoqolibGExtendedSearchBlockController().gExtendedSearchBlock_KeyDupItem();
		}

		
		@ActionTrigger(action="KEY-DUPREC", function=KeyFunction.DUPLICATE_RECORD)
		public void gExtendedSearchBlock_CopyRecord()
		{
			
			getGoqolibGExtendedSearchBlockController().gExtendedSearchBlock_CopyRecord();
		}

		
		@ActionTrigger(action="KEY-ENTQRY", function=KeyFunction.SEARCH)
		public void gExtendedSearchBlock_Search()
		{
			
			getGoqolibGExtendedSearchBlockController().gExtendedSearchBlock_Search();
		}


		@ActionTrigger(action="KEY-EXEQRY", function=KeyFunction.EXECUTE_QUERY)
		public void gExtendedSearchBlock_ExecuteQuery()
		{
			
			getGoqolibGExtendedSearchBlockController().gExtendedSearchBlock_ExecuteQuery();
		}

		
		@ActionTrigger(action="KEY-EXIT", function=KeyFunction.EXIT)
		public void gExtendedSearchBlock_Exit()
		{
			
			getGoqolibGExtendedSearchBlockController().gExtendedSearchBlock_Exit();
		}


		@ActionTrigger(action="KEY-F0", function=KeyFunction.KEY_F0)
		public void gExtendedSearchBlock_F0()
		{
			
			getGoqolibGExtendedSearchBlockController().gExtendedSearchBlock_F0();
		}

		
		@ActionTrigger(action="KEY-MENU")
		public void gExtendedSearchBlock_KeyMenu()
		{
			
			getGoqolibGExtendedSearchBlockController().gExtendedSearchBlock_KeyMenu();
		}

		
		@ActionTrigger(action="KEY-NXTBLK", function=KeyFunction.NEXT_BLOCK)
		public void gExtendedSearchBlock_NextBlock()
		{
			
			getGoqolibGExtendedSearchBlockController().gExtendedSearchBlock_NextBlock();
		}


		@ActionTrigger(action="KEY-NXTKEY")
		public void gExtendedSearchBlock_KeyNxtkey()
		{
			
			getGoqolibGExtendedSearchBlockController().gExtendedSearchBlock_KeyNxtkey();
		}

		

		@ActionTrigger(action="KEY-NXTSET")
		public void gExtendedSearchBlock_KeyNxtset()
		{
			
			getGoqolibGExtendedSearchBlockController().gExtendedSearchBlock_KeyNxtset();
		}


		@ActionTrigger(action="KEY-NXTREC", function=KeyFunction.NEXT_RECORD)
		public void gExtendedSearchBlock_NextRecord()
		{
			
			getGoqolibGExtendedSearchBlockController().gExtendedSearchBlock_NextRecord();
		}

		@ActionTrigger(action="KEY-PRVBLK", function=KeyFunction.PREVIOUS_BLOCK)
		public void gExtendedSearchBlock_PreviousBlock()
		{
			
			getGoqolibGExtendedSearchBlockController().gExtendedSearchBlock_PreviousBlock();
		}


		@ActionTrigger(action="KEY-PRVREC", function=KeyFunction.PREVIOUS_RECORD)
		public void gExtendedSearchBlock_PreviousRecord()
		{
			
			getGoqolibGExtendedSearchBlockController().gExtendedSearchBlock_PreviousRecord();
		}


		@ActionTrigger(action="KEY-SCRDOWN")
		public void gExtendedSearchBlock_KeyScrdown()
		{
			
			getGoqolibGExtendedSearchBlockController().gExtendedSearchBlock_KeyScrdown();
		}


		@ActionTrigger(action="KEY-SCRUP")
		public void gExtendedSearchBlock_KeyScrup()
		{
			
			getGoqolibGExtendedSearchBlockController().gExtendedSearchBlock_KeyScrup();
		}


		@ActionTrigger(action="KEY-UP", function=KeyFunction.UP)
		public void gExtendedSearchBlock_MoveUp()
		{
			
			getGoqolibGExtendedSearchBlockController().gExtendedSearchBlock_MoveUp();
		}


		@ActionTrigger(action="KEY-UPDREC")
		public void gExtendedSearchBlock_KeyUpdrec()
		{
			
			getGoqolibGExtendedSearchBlockController().gExtendedSearchBlock_KeyUpdrec();
		}

		
		@ActionTrigger(action="WHEN-LIST-CHANGED", item="IDNAME_EXTSEARCH_LIST")
		public void idnameExtsearchList_listChange()
		{
			
			getGoqolibGExtendedSearchBlockController().idnameExtsearchList_listChange();
		}


		@ActionTrigger(action="KEY-PREV-ITEM", item="IDNAME_EXTSEARCH_LIST", function=KeyFunction.PREVIOUS_ITEM)
		public void idnameExtsearchList_PreviousItem()
		{
			
			getGoqolibGExtendedSearchBlockController().idnameExtsearchList_PreviousItem();
		}


		@ActionTrigger(action="WHEN-MOUSE-CLICK", item="PERSON_DETAIL_BTN")
		@Before
		public void personDetailBtn_click()
		{
			
			getGoqolibGExtendedSearchBlockController().personDetailBtn_click();
		}


		@ActionTrigger(action="WHEN-BUTTON-PRESSED", item="PERSON_DETAIL_BTN")
		public void personDetailBtn_buttonClick()
		{
			
			getGoqolibGExtendedSearchBlockController().personDetailBtn_buttonClick();
		}

		
		@ActionTrigger(action="WHEN-MOUSE-CLICK", item="NPERSON_DETAIL_BTN")
		@Before
		public void npersonDetailBtn_click()
		{
			
			getGoqolibGExtendedSearchBlockController().npersonDetailBtn_click();
		}


		@ActionTrigger(action="WHEN-BUTTON-PRESSED", item="NPERSON_DETAIL_BTN")
		public void npersonDetailBtn_buttonClick()
		{
			
			getGoqolibGExtendedSearchBlockController().npersonDetailBtn_buttonClick();
		}

		@ActionTrigger(action="WHEN-RADIO-CHANGED", item="SEARCH_GROUP")
		public void searchGroup_radioGroupChange()
		{
			
			getGoqolibGExtendedSearchBlockController().searchGroup_radioGroupChange();
		}

		@ActionTrigger(action="WHEN-MOUSE-DOUBLECLICK", item="SR_SPRADDR_STAT_CODE")
		public void srSpraddrStatCode_doubleClick()
		{
			
			getGoqolibGExtendedSearchBlockController().srSpraddrStatCode_doubleClick();
		}


		@ActionTrigger(action="WHEN-NEW-ITEM-INSTANCE", item="SR_SPRADDR_STAT_CODE", function=KeyFunction.ITEM_CHANGE)
		public void srSpraddrStatCode_itemChange()
		{
			
			getGoqolibGExtendedSearchBlockController().srSpraddrStatCode_itemChange();
		}


		@ActionTrigger(action="G$_SEARCH_PARAMETERS", item="SR_SPRADDR_STAT_CODE")
		public void srSpraddrStatCode_GSearchParameters()
		{
			
			getGoqolibGExtendedSearchBlockController().srSpraddrStatCode_GSearchParameters();
		}


		@ActionTrigger(action="G$_SEARCH_OPTIONS", item="SR_SPRADDR_STAT_CODE")
		public void srSpraddrStatCode_GSearchOptions()
		{
			
			getGoqolibGExtendedSearchBlockController().srSpraddrStatCode_GSearchOptions();
		}

		@ActionTrigger(action="KEY-NEXT-ITEM", item="SR_SPRADDR_STAT_CODE", function=KeyFunction.NEXT_ITEM)
		public void srSpraddrStatCode_keyNexItem()
		{
			
			getGoqolibGExtendedSearchBlockController().srSpraddrStatCode_keyNexItem();
		}

		
		@ActionTrigger(action="POST-TEXT-ITEM", item="SR_SPRADDR_STAT_CODE", function=KeyFunction.ITEM_OUT)
		public void srSpraddrStatCode_itemOut()
		{
			
			getGoqolibGExtendedSearchBlockController().srSpraddrStatCode_itemOut();
		}


		@ActionTrigger(action="KEY-LISTVAL", item="SR_SPRADDR_ZIP", function=KeyFunction.LIST_VALUES)
		public void srSpraddrZip_ListValues()
		{
			
			getGoqolibGExtendedSearchBlockController().srSpraddrZip_ListValues();
		}


		@ActionTrigger(action="WHEN-MOUSE-DOUBLECLICK", item="SR_SPRIDEN_NTYP_CODE")
		public void srSpridenNtypCode_doubleClick()
		{
			
			getGoqolibGExtendedSearchBlockController().srSpridenNtypCode_doubleClick();
		}

		@ActionTrigger(action="WHEN-NEW-ITEM-INSTANCE", item="SR_SPRIDEN_NTYP_CODE", function=KeyFunction.ITEM_CHANGE)
		public void srSpridenNtypCode_itemChange()
		{
			
			getGoqolibGExtendedSearchBlockController().srSpridenNtypCode_itemChange();
		}


		@ActionTrigger(action="G$_SEARCH_PARAMETERS", item="SR_SPRIDEN_NTYP_CODE")
		public void srSpridenNtypCode_GSearchParameters()
		{
			
			getGoqolibGExtendedSearchBlockController().srSpridenNtypCode_GSearchParameters();
		}


		@ActionTrigger(action="G$_SEARCH_OPTIONS", item="SR_SPRIDEN_NTYP_CODE")
		public void srSpridenNtypCode_GSearchOptions()
		{
			
			getGoqolibGExtendedSearchBlockController().srSpridenNtypCode_GSearchOptions();
		}

		@ActionTrigger(action="KEY-NEXT-ITEM", item="SR_SPRIDEN_NTYP_CODE", function=KeyFunction.NEXT_ITEM)
		public void srSpridenNtypCode_keyNexItem()
		{
			
			getGoqolibGExtendedSearchBlockController().srSpridenNtypCode_keyNexItem();
		}

		@ActionTrigger(action="POST-TEXT-ITEM", item="SR_SPRIDEN_NTYP_CODE", function=KeyFunction.ITEM_OUT)
		public void srSpridenNtypCode_itemOut()
		{
			
			getGoqolibGExtendedSearchBlockController().srSpridenNtypCode_itemOut();
		}

		@ActionTrigger(action="WHEN-NEW-ITEM-INSTANCE", item="SR_SPBPERS_SSN", function=KeyFunction.ITEM_CHANGE)
		public void srSpbpersSsn_itemChange()
		{
			
			getGoqolibGExtendedSearchBlockController().srSpbpersSsn_itemChange();
		}


		@ActionTrigger(action="KEY-NEXT-ITEM", item="SR_SPBPERS_BIRTH_DATE", function=KeyFunction.NEXT_ITEM)
		public void srSpbpersBirthDate_keyNexItem()
		{
			
			getGoqolibGExtendedSearchBlockController().srSpbpersBirthDate_keyNexItem();
		}

		
		@ActionTrigger(action="POST-CHANGE", item="SR_SPBPERS_BIRTH_DATE")
		public void srSpbpersBirthDate_PostChange()
		{
			
			getGoqolibGExtendedSearchBlockController().srSpbpersBirthDate_PostChange();
		}

		
		@ValidationTrigger(item="SR_SPBPERS_SEX")
		public void srSpbpersSex_validate()
		{
			
			getGoqolibGExtendedSearchBlockController().srSpbpersSex_validate();
		}

		

		@ActionTrigger(action="KEY-NEXT-ITEM", item="SR_SPBPERS_SEX", function=KeyFunction.NEXT_ITEM)
		public void srSpbpersSex_keyNexItem()
		{
			
			getGoqolibGExtendedSearchBlockController().srSpbpersSex_keyNexItem();
		}


		@ActionTrigger(action="WHEN-MOUSE-CLICK", item="SR_SPRADDR_ZIP_BTN")
		@Before
		public void srSpraddrZipBtn_click()
		{
			
			getGoqolibGExtendedSearchBlockController().srSpraddrZipBtn_click();
		}


		@ActionTrigger(action="WHEN-BUTTON-PRESSED", item="SR_SPRADDR_ZIP_BTN")
		public void srSpraddrZipBtn_buttonClick()
		{
			
			getGoqolibGExtendedSearchBlockController().srSpraddrZipBtn_buttonClick();
		}

		
		@ActionTrigger(action="WHEN-MOUSE-CLICK", item="SR_SPRADDR_STAT_CODE_BTN")
		@Before
		public void srSpraddrStatCodeBtn_click()
		{
			
			getGoqolibGExtendedSearchBlockController().srSpraddrStatCodeBtn_click();
		}


		@ActionTrigger(action="WHEN-BUTTON-PRESSED", item="SR_SPRADDR_STAT_CODE_BTN")
		public void srSpraddrStatCodeBtn_buttonClick()
		{
			
			getGoqolibGExtendedSearchBlockController().srSpraddrStatCodeBtn_buttonClick();
		}


		@ActionTrigger(action="WHEN-MOUSE-CLICK", item="SR_SPRIDEN_NTYP_CODE_BTN")
		@Before
		public void srSpridenNtypCodeBtn_click()
		{
			
			getGoqolibGExtendedSearchBlockController().srSpridenNtypCodeBtn_click();
		}

		

		@ActionTrigger(action="WHEN-BUTTON-PRESSED", item="SR_SPRIDEN_NTYP_CODE_BTN")
		public void srSpridenNtypCodeBtn_buttonClick()
		{
			
			getGoqolibGExtendedSearchBlockController().srSpridenNtypCodeBtn_buttonClick();
		}


		@ActionTrigger(action="WHEN-MOUSE-CLICK", item="NARROW_SEARCH_BTN")
		@Before
		public void narrowSearchBtn_click()
		{
			
			getGoqolibGExtendedSearchBlockController().narrowSearchBtn_click();
		}


		@ActionTrigger(action="WHEN-BUTTON-PRESSED", item="NARROW_SEARCH_BTN")
		public void narrowSearchBtn_buttonClick()
		{
			
			getGoqolibGExtendedSearchBlockController().narrowSearchBtn_buttonClick();
		}

		
		@ActionTrigger(action="WHEN-MOUSE-CLICK", item="EXTSEARCH_CLEAR_BTN")
		@Before
		public void extsearchClearBtn_click()
		{
			
			getGoqolibGExtendedSearchBlockController().extsearchClearBtn_click();
		}

		
		@ActionTrigger(action="WHEN-BUTTON-PRESSED", item="EXTSEARCH_CLEAR_BTN")
		public void extsearchClearBtn_buttonClick()
		{
			
			getGoqolibGExtendedSearchBlockController().extsearchClearBtn_buttonClick();
		}

		
		@ValidationTrigger(item="SR_SPBPERS_BIRTH_DATE")
		public void srSpbpersBirthDate_validate()
		{
			

			this.srSpbpersBirthDate_PostChange();

		}

}
