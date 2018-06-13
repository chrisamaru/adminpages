package net.hedtech.banner.general.necc.general.Gjapctl.controller;

import morphis.foundations.core.appsupportlib.runtime.TaskServices;
import morphis.foundations.core.appsupportlib.runtime.action.ActionTrigger;
import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import morphis.foundations.core.types.NInteger;
import morphis.foundations.core.types.NNumber;
import morphis.foundations.core.types.NString;
import net.hedtech.banner.general.necc.general.Gjapctl.GjapctlTask;
import net.hedtech.banner.general.necc.general.Gjapctl.model.GjapctlModel;
import morphis.foundations.core.appdatalayer.events.CancelEvent;
import static morphis.foundations.core.types.Types.toStr;

import static morphis.foundations.core.appsupportlib.Globals.getGlobal;

import morphis.foundations.core.appdatalayer.data.DataCursor;
import morphis.foundations.core.appdatalayer.data.ResultSet;
import morphis.foundations.core.appdatalayer.data.TableRow;
import morphis.foundations.core.appdatalayer.events.BeforeSave;

public class SubmitBlkController extends net.hedtech.banner.general.Gjapctl.controller.SubmitBlkController {

	public SubmitBlkController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public GjapctlTask getTask() {
		return (GjapctlTask) super.getTask();
	}

	public GjapctlModel getFormModel() {
		return getTask().getModel();
	}

	@Override
	@ActionTrigger(action="KEY-COMMIT",function=KeyFunction.SAVE)
	public void submitBlk_Save(){	
		// Get the ONE_UP_NO from the header
		NInteger oneUpNo = this.getFormModel().getFormHeader().getOneUpNo();
		NString apiUrl = toStr("");

		super.submitBlk_Save();
		
		// Code to check if this was an Argos report and run it via API
		NString jobTypeInd = NString.EmptyString;				
		NString job = getFormModel().getKeyBlock().getKeyblckJob();

		String currentJobC = "SELECT GJBJOBS_JOB_TYPE_IND\r\n" + 
				"           AS job_type_ind,\r\n" + 
				"          (SELECT uprf.GURUPRF_VALUE\r\n" + 
				"             FROM guruprf uprf\r\n" + 
				"            WHERE     uprf.GURUPRF_USER_ID = 'BASELINE'\r\n" + 
				"                  AND uprf.GURUPRF_GROUP = 'ARGSRPT'\r\n" + 
				"                  AND uprf.GURUPRF_STRING = 'ARGS_SERVER')\r\n" + 
				"       || args.GTZARGS_REPORT_ID\r\n" + 
				"       || '&'\r\n" + 
				"       || (SELECT LISTAGG (\r\n" + 
				"                         'Parm'\r\n" + 
				"                      || prun.GJBPRUN_NUMBER\r\n" + 
				"                      || '='\r\n" + 
				"                      || prun.GJBPRUN_VALUE,\r\n" + 
				"                      CHR (38))\r\n" + 
				"                      WITHIN GROUP (ORDER BY prun.gjbprun_number)\r\n" + 
				"                      AS parm_string\r\n" + 
				"             FROM gjbprun prun\r\n" + 
				"            WHERE     prun.GJBPRUN_ONE_UP_NO = :ONE_UP_NO\r\n" + 
				"                  AND prun.GJBPRUN_VALUE IS NOT NULL)\r\n" + 
				"       || '&format='\r\n" + 
				"       || args.GTZARGS_REPORTFORMAT\r\n" + 
				"           AS api_url\r\n" + 
				"  FROM gjbjobs  jobs\r\n" + 
				"       LEFT JOIN baninst1.gtzargs args ON gjbjobs_name = gtzargs_name\r\n" + 
				" WHERE jobs.GJBJOBS_NAME = :JOB_NAME";
		DataCursor currentJobCursor = new DataCursor(currentJobC);
		try {
			// Setting query parameters
			currentJobCursor.addParameter("JOB_NAME", job);
			currentJobCursor.addParameter("ONE_UP_NO", oneUpNo);
			currentJobCursor.open();
			ResultSet currentJobCResults = currentJobCursor.fetchInto();
			if (currentJobCResults != null) {
				jobTypeInd = currentJobCResults.getStr("JOB_TYPE_IND");
				apiUrl = currentJobCResults.getStr("API_URL");
			}
		} finally {
			currentJobCursor.close();
		}		

		this.getLogger().debug(this, "job="+job);
		this.getLogger().debug(this, "jobTypeInd="+jobTypeInd);
		this.getLogger().debug(this, "oneUpNum="+oneUpNo);
		this.getLogger().debug(this, "apiUrl="+apiUrl);

		if (jobTypeInd.equals(toStr("A"))) {
			this.getLogger().debug(this, "<<<<<<<<<< Popping browser window with Argos Report >>>>>>>>>>");
			TaskServices.showDocument(apiUrl, job);
		}
	}
}