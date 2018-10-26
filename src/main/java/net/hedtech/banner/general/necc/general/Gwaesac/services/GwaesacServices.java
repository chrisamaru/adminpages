package net.hedtech.banner.general.necc.general.Gwaesac.services;

import morphis.foundations.core.appdatalayer.data.DataCursor;
import morphis.foundations.core.appsupportlib.runtime.MessageServices;

import static morphis.foundations.core.appsupportlib.Globals.getGlobal;
import static morphis.foundations.core.types.Types.*;
import morphis.foundations.core.appdatalayer.data.ResultSet;
import morphis.foundations.core.appsupportlib.exceptions.ApplicationException;
import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import morphis.foundations.core.appsupportlib.runtime.controlsModel.alerts.AlertDescriptor;
import morphis.foundations.core.types.NNumber;
import morphis.foundations.core.types.NString;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;
import net.hedtech.banner.general.necc.general.Gwaesac.GwaesacTask;
import net.hedtech.banner.general.necc.general.Gwaesac.model.GwaesacModel;
import net.hedtech.general.common.dbservices.GNls;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;
import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.*;
import javax.activation.*;

public class GwaesacServices extends DefaultSupportCodeObject {

	public GwaesacServices(ISupportCodeContainer container) {
		super(container);
	}

	public GwaesacTask getTask() {
		return (GwaesacTask) super.getContainer();
	}

	public void showTicketAlert(NString message) {
		AlertDescriptor alertId= null;
		NNumber alertButton= NNumber.getNull();
		alertId = MessageServices.findAlert("G$_INFO_ALERT");
		if ( (alertId == null) ) {
			MessageServices.errorMessage(GNls.Fget(toStr("GWAESAC-0049"), toStr("FORM"),
		toStr("*ERROR* G$_INFO_ALERT Alert does not exist, cannot continue")));
		throw new ApplicationException();
		}
		MessageServices.setAlertMessageText(alertId, GNls.Fget(toStr("GWAESAC-0050"), toStr("FORM"),
				message
		));
		//
		alertButton = toNumber(MessageServices.showAlert(alertId));
		if ( alertButton.equals(MessageServices.BUTTON1) ) {
		// do something if they select yes
		}		
	}

	public GwaesacModel getFormModel() {
		return getTask().getModel();
	}

	public NString getCurrentDwAccess() {
		NString currentDwAccess = NString.EmptyString;

		String dwAccessC = "SELECT shp_filter\r\n" + 
				"  FROM shp_user_mst@dwrpt  dwac\r\n" + 
				"       JOIN spriden iden\r\n" + 
				"           ON     TRIM (dwac.SHP_ACCESS_ID) = iden.SPRIDEN_ID\r\n" + 
				"              AND iden.SPRIDEN_CHANGE_IND IS NULL\r\n" + 
				" WHERE iden.SPRIDEN_PIDM = :PIDM";
		DataCursor dwAccessCursor = new DataCursor(dwAccessC);
		try {
			// Setting query parameters
			dwAccessCursor.addParameter("PIDM", getFormModel().getKeyBlock().getPidm());
			dwAccessCursor.open();
			ResultSet dwAccessCResults = dwAccessCursor.fetchInto();
			if (dwAccessCResults != null) {
				currentDwAccess = dwAccessCResults.getStr(0);
			} else {
				currentDwAccess = toStr("NONE");
			}
		} finally {
			dwAccessCursor.close();
		}
				
		return currentDwAccess;
	}
	
	public boolean openTicket(NNumber pidm, NString ticketAction, NString requestedDwAccess) {
		String usrNeccId;
		String usrFullName;
		String subEmalAddress;
				;
		String getInfoC = "SELECT SUBSTR (\r\n" + 
				"           WTAILOR.TWBKNECC.F_GETEMAILADDRESSH (eacc.gobeacc_pidm, 'WORK'),\r\n" + 
				"           1,\r\n" + 
				"             LENGTH (\r\n" + 
				"                 WTAILOR.TWBKNECC.F_GETEMAILADDRESSH (eacc.gobeacc_pidm,\r\n" + 
				"                                                      'WORK'))\r\n" + 
				"           - 1)\r\n" + 
				"           AS sub_emal_addr,\r\n" + 
				"       goksels.f_name_bio_value ( :PIDM, 'ID')\r\n" + 
				"           AS usr_necc_id,\r\n" + 
				"       f_format_name ( :PIDM, 'FML')\r\n" + 
				"           AS usr_full_name\r\n" + 
				"  FROM gobeacc eacc\r\n" + 
				" WHERE eacc.GOBEACC_USERNAME = :USERNAME";
		DataCursor getInfoCursor = new DataCursor(getInfoC);
		try {
			// Setting query parameters
			getInfoCursor.addParameter("PIDM", getFormModel().getKeyBlock().getPidm());
			getInfoCursor.addParameter("USERNAME", getGlobal("CURRENT_USER"));
			getLogger().debug(this, "***** Opening getInfoCusor *****\r\n");
			getInfoCursor.open();
			getLogger().debug(this, "***** Opened getInfoCusor *****\r\n");
			ResultSet getInfoCResults = getInfoCursor.fetchInto();
			if (getInfoCResults != null) {
				getLogger().debug(this, "***** Getting data for getInfoCusor *****\r\n");
				subEmalAddress = getInfoCResults.getString("sub_emal_addr");
				usrNeccId = getInfoCResults.getString("usr_necc_id");
				usrFullName = getInfoCResults.getString("usr_full_name");
				getLogger().debug(this, "***** Got data for getInfoCusor *****\r\n");
			} else {
				// Logged in user has no email address. Fail with alert.
				showTicketAlert(toStr("GWAESAC-0051: Currently logged in user has no email address. Ticket can not be created."));
				return false;
			}
		} finally {
			getInfoCursor.close();
		}
		
		getLogger().debug(this, "***** Starting to send email *****");
		
		// Recipient's email ID needs to be mentioned.
		String to = "neccitservicedesk@necc.mass.edu";

		// Sender's email ID needs to be mentioned
		String from = "mis@necc.mass.edu";

		// Assuming you are sending email from localhost
		String host = "havsmtp.necc.mass.edu";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("Automated ticket creation from Banner");
			
			// Set the CC
			message.addRecipient(RecipientType.CC, new InternetAddress(
		            "camaru@necc.mass.edu"));


			// Now set the actual message
			String body = "";
			if (ticketAction.equals(toStr("G"))) {
				body = "@title=Degreeworks access request\r\n" + 
						"@category=Degreeworks::Access Rights::" + requestedDwAccess + "\r\n" + 
						"@submitter=" + subEmalAddress + "\r\n" + 
						"@owner=mis@necc.mass.edu\r\n" + 
						"@due_date=10/27/2018\r\n" + 
						"\r\n" + 
						"Please grant/change Degreeworks access for the following employee:\r\n" +
						"NECC ID: " + usrNeccId + "\r\n" +
						"NAME: " + usrFullName + "\r\n" +
						"ACCESS: " + requestedDwAccess;
			}
			if (ticketAction.equals(toStr("R"))) {
				body = "@title=Degreeworks access request\r\n" + 
						"@category=Degreeworks::Access Rights::" + requestedDwAccess + "\r\n" + 
						"@submitter=" + subEmalAddress + "\r\n" + 
						"@owner=mis@necc.mass.edu\r\n" + 
						"@due_date=10/27/2018\r\n" + 
						"\r\n" + 
						"Please revoke Degreeworks access for the following employee:\r\n" +
						"NECC ID: " + usrNeccId + "\r\n" +
						"NAME: " + usrFullName + "\r\n";
			}
			message.setText(body);

			// Send message
			Transport.send(message);
			getLogger().debug(this, "***** Sent email *****\r\n");
			return true;
		} catch (MessagingException mex) {
			getLogger().debug(this, "***** Error sending email *****\r\n");
			getLogger().debug(this, "ERROR: " + mex.getMessage() + "\r\n");
			getLogger().debug(this, "***** START STACK TRACE *****\r\n");
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			mex.printStackTrace(pw);
			getLogger().debug(this, sw.toString());
			getLogger().debug(this, "***** END STACK TRACE *****\r\n");
			return false;
		}
	}
}