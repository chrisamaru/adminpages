package net.hedtech.banner.general.necc.general.Gjapctl.controller;

import morphis.foundations.core.appsupportlib.runtime.ITask;
import net.hedtech.banner.general.necc.general.Gjapctl.GjapctlTask;
import net.hedtech.banner.general.necc.general.Gjapctl.model.GjapctlModel;

public class GjapctlFormController extends net.hedtech.banner.general.Gjapctl.controller.GjapctlFormController {

	public GjapctlFormController(ITask task) {
		super(task);
	}

	@Override
	public GjapctlTask getTask() {
		return (GjapctlTask) super.getTask();
	}

	public GjapctlModel getFormModel() {
		return getTask().getModel();
	}
}