package net.hedtech.banner.general.necc.general.Gjapctl.controller;

import morphis.foundations.core.appsupportlib.runtime.action.ValidationTrigger;
import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.banner.general.necc.general.Gjapctl.GjapctlTask;
import net.hedtech.banner.general.necc.general.Gjapctl.model.GjapctlModel;
import morphis.foundations.core.appsupportlib.runtime.TaskServices;
import morphis.foundations.core.appsupportlib.runtime.action.ActionTrigger;

public class KeyBlockController extends net.hedtech.banner.general.Gjapctl.controller.KeyBlockController {

	public KeyBlockController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public GjapctlTask getTask() {
		return (GjapctlTask) super.getTask();
	}

	public GjapctlModel getFormModel() {
		return getTask().getModel();
	}

//	@Override
//	@ValidationTrigger(item="KEYBLCK_JOB")
//	public void keyblckJob_validate(){
//		this.getLogger().trace(this, "**** Executing KEYBLCK_JOB Validate ****");
//		TaskServices.showDocument("http://webtools.necc.mass.edu/storage/banner/twaemal.html", "Basic HTML Info");
//		super.keyblckJob_validate();
//	}
//
//	@ActionTrigger(item = "KEYBLCK_JOB", action = "keyblck_job_action")
//	public void keyblck_job_action() {
//		this.getLogger().trace(this, "**** Executing Job Action ****");
//		TaskServices.showDocument("http://webtools.necc.mass.edu/storage/banner/twaemal.html", "Basic HTML Info");
//	}
//
//	@ActionTrigger(item = "KEYBLCK_JOB", action = "keyblck_job_postChange")
//	public void keyblck_job_postChange() {
//		this.getLogger().trace(this, "**** Executing Job Action ****");
//		TaskServices.showDocument("http://webtools.necc.mass.edu/storage/banner/twaemal.html", "Basic HTML Info");
//	}
	
}