package com.shaman;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;

import com.shaman.configs.Config;
import com.shaman.icons.Icon;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.layout.GridData;

public class SystemPreferences {

	private Shell sShell = null;  //  @jve:decl-index=0:visual-constraint="27,13"
	private Label refrashIntervalLabel = null;
	private Spinner refrashIntervalSpinner = null;
	private Button saveButton = null;
	private Button cancelButton = null;
	/**
	 * This method initializes sShell
	 */
	
	public SystemPreferences(Shell parent) {
	//private void createSShell() {
		GridData gridData3 = new GridData();
		gridData3.horizontalAlignment = GridData.FILL;
		gridData3.verticalAlignment = GridData.CENTER;
		GridData gridData2 = new GridData();
		gridData2.horizontalAlignment = GridData.FILL;
		gridData2.grabExcessHorizontalSpace = false;
		gridData2.verticalAlignment = GridData.CENTER;
		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.END;
		gridData1.grabExcessHorizontalSpace = false;
		gridData1.grabExcessVerticalSpace = true;
		gridData1.verticalAlignment = GridData.END;
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.BEGINNING;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.verticalAlignment = GridData.END;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		sShell = new Shell(SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		sShell.setLocation(parent.getDisplay().getCursorLocation());
		sShell.setImages(Icon.SystemPreferences.getImages());
		sShell.setText("System Preference");
		sShell.setLayout(gridLayout);
		sShell.setSize(new Point(232, 112));
		refrashIntervalLabel = new Label(sShell, SWT.NONE);
		refrashIntervalLabel.setText("Refrash Interval (ms)");
		refrashIntervalLabel.setLayoutData(gridData3);
		refrashIntervalLabel.setToolTipText("");
		refrashIntervalSpinner = new Spinner(sShell, SWT.BORDER);
		refrashIntervalSpinner.setMinimum(1);
		refrashIntervalSpinner.setMaximum(10000);
		refrashIntervalSpinner.setSelection(Config.getGeneralRefrash());
		refrashIntervalSpinner.setLayoutData(gridData2);
		saveButton = new Button(sShell, SWT.NONE);
		saveButton.setText("Save");
		saveButton.setLayoutData(gridData1);
		saveButton.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				Config.setGeneralRefrash(refrashIntervalSpinner.getSelection());
			}
		});
		cancelButton = new Button(sShell, SWT.NONE);
		cancelButton.setText("Cancel");
		cancelButton.setLayoutData(gridData);
		cancelButton
				.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
					public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
						Close();
					}
				});
	}
	public void Open()
	{
		sShell.open();
	}
	public void Close()
	{
		sShell.close();
	}

}
