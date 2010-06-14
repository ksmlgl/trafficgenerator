package com.shaman;

import java.io.IOException;
import java.net.SocketException;
import java.util.Hashtable;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.layout.GridData;

import com.shaman.configs.Config;
import com.shaman.enums.ProtocolType;
import com.shaman.icons.Icon;
import com.shaman.multicast.BroadcastClient;
import com.shaman.multicast.BroadcastServer;
import com.shaman.tcp.TCPClient;
import com.shaman.tcp.TCPServer;
import com.shaman.udp.EchoClient;
import com.shaman.udp.EchoServer;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class Main {

	// RECIEVER
	EchoServer es;
	TCPServer tcps;
	BroadcastClient bcc;

	static Hashtable<Long, EchoServer> esHT = new Hashtable<Long, EchoServer>(); // @jve:decl-index=0:
	static Hashtable<Long, TCPServer> tcpsHT = new Hashtable<Long, TCPServer>(); // @jve:decl-index=0:
	static Hashtable<Long, BroadcastClient> bccHT = new Hashtable<Long, BroadcastClient>(); // @jve:decl-index=0:

	// SENDER
	EchoClient ec;
	TCPClient tcpc;
	BroadcastServer bcs;

	static Hashtable<Long, EchoClient> ecHT = new Hashtable<Long, EchoClient>(); // @jve:decl-index=0:
	static Hashtable<Long, TCPClient> tcpcHT = new Hashtable<Long, TCPClient>(); // @jve:decl-index=0:
	static Hashtable<Long, BroadcastServer> bcsHT = new Hashtable<Long, BroadcastServer>(); // @jve:decl-index=0:

	private Shell sShell = null; // @jve:decl-index=0:visual-constraint="13,9"
	private SashForm sashForm = null;
	private Group sendGroup = null;
	private Menu menuBar = null;
	private Menu fileMenu = null;
	private Label sendIPLabel = null;
	private Text sendIPText = null;
	private Label sendPortLabel = null;
	private Text sendPortText = null;
	private Label sendNetworkInterfaceLabel = null;
	private Combo sendNetworkInterfaceCombo = null;
	private Label sendProtoclTypeLabel = null;
	private Combo sendProtocolTypeCombo = null;
	private Button sendInterfaceRefreshButton = null;
	private Label sendPackNoLabel = null;
	private Spinner sendPackNoSpinner = null;
	private Label sendBufferSizeLabel = null;
	private Spinner sendBufferSizeSpinner = null;
	private Label sendPackTimerLabel = null;
	private Spinner sendPackTimerSpinner = null;
	private Button sendStartButton = null;
	private Group recieveGroup = null;
	private Label recieveIPLabel = null;
	private Text recieveIPText = null;
	private Label filler11 = null;
	private Label recievePortLabel = null;
	private Text recievePortText = null;
	private Label filler5 = null;
	private Label recieveNetworkInterfaceLabel = null;
	private Combo recieveNetworkInterfaceCombo = null;
	private Button recieveInterfaceRefreshButton = null;
	private Label recieveProtoclTypeLabel = null;
	private Combo recieveProtocolTypeCombo = null;
	private Label filler21 = null;
	private Label filler31 = null;
	private Button recieveStartButton = null;
	private Label sendEstimateBPSLabel = null;
	private Label sendEstimateBPSValueLabel = null;
	private static Table sendTable = null;
	private static Table recieveTable = null;

	/**
	 * This method initializes sendNetworkInterfaceCombo
	 * 
	 * @throws SocketException
	 * 
	 */
	private void createSendNetworkInterfaceCombo() {
		GridData gridData3 = new GridData();
		gridData3.horizontalAlignment = GridData.FILL;
		gridData3.verticalAlignment = GridData.CENTER;
		sendNetworkInterfaceCombo = new Combo(sendGroup, SWT.READ_ONLY
				| SWT.BORDER);
		sendNetworkInterfaceCombo.setLayoutData(gridData3);
		Network.GetNetworkInterface(sendNetworkInterfaceCombo);
	}

	/**
	 * This method initializes sendProtocolTypeCombo
	 * 
	 */
	private void createSendProtocolTypeCombo() {
		GridData gridData4 = new GridData();
		gridData4.horizontalAlignment = GridData.FILL;
		gridData4.verticalAlignment = GridData.CENTER;
		sendProtocolTypeCombo = new Combo(sendGroup, SWT.READ_ONLY | SWT.BORDER);
		sendProtocolTypeCombo.setLayoutData(gridData4);
		for (Enum e : ProtocolType.values()) {
			sendProtocolTypeCombo.add(e.toString());
		}
		sendProtocolTypeCombo.select(0);
	}

	/**
	 * This method initializes recieveGroup
	 * 
	 */
	private void createRecieveGroup() {
		GridData gridData7 = new GridData();
		gridData7.horizontalAlignment = GridData.FILL;
		gridData7.grabExcessHorizontalSpace = false;
		gridData7.grabExcessVerticalSpace = true;
		gridData7.horizontalSpan = 6;
		gridData7.verticalAlignment = GridData.FILL;
		GridData gridData6 = new GridData();
		gridData6.horizontalAlignment = GridData.BEGINNING;
		gridData6.grabExcessHorizontalSpace = true;
		gridData6.verticalAlignment = GridData.CENTER;
		GridData gridData411 = new GridData();
		gridData411.horizontalAlignment = GridData.CENTER;
		gridData411.horizontalSpan = 4;
		gridData411.verticalAlignment = GridData.CENTER;
		GridData gridData21 = new GridData();
		gridData21.horizontalAlignment = GridData.FILL;
		gridData21.verticalAlignment = GridData.CENTER;
		GridData gridData11 = new GridData();
		gridData11.horizontalAlignment = GridData.FILL;
		gridData11.verticalAlignment = GridData.CENTER;
		GridLayout gridLayout1 = new GridLayout();
		gridLayout1.numColumns = 6;
		recieveGroup = new Group(sashForm, SWT.NONE);
		recieveGroup.setText("Recieve");
		recieveGroup.setLayout(gridLayout1);
		recieveIPLabel = new Label(recieveGroup, SWT.NONE);
		recieveIPLabel.setText("IP");
		recieveIPText = new Text(recieveGroup, SWT.BORDER);
		recieveIPText.setText("225.0.0.1");
		recieveIPText.setEnabled(true);
		recieveIPText.setLayoutData(gridData11);
		filler11 = new Label(recieveGroup, SWT.NONE);
		Label filler6 = new Label(recieveGroup, SWT.NONE);
		Label filler23 = new Label(recieveGroup, SWT.NONE);
		Label filler35 = new Label(recieveGroup, SWT.NONE);
		recievePortLabel = new Label(recieveGroup, SWT.NONE);
		recievePortLabel.setText("Port");
		recievePortText = new Text(recieveGroup, SWT.BORDER);
		recievePortText.setText("5000");
		recievePortText.setLayoutData(gridData21);
		filler5 = new Label(recieveGroup, SWT.NONE);
		Label filler8 = new Label(recieveGroup, SWT.NONE);
		filler8.setLayoutData(gridData6);
		Label filler22 = new Label(recieveGroup, SWT.NONE);
		Label filler34 = new Label(recieveGroup, SWT.NONE);
		recieveNetworkInterfaceLabel = new Label(recieveGroup, SWT.NONE);
		recieveNetworkInterfaceLabel.setText("Network Interface");
		createRecieveNetworkInterfaceCombo();
		recieveInterfaceRefreshButton = new Button(recieveGroup, SWT.NONE);
		recieveInterfaceRefreshButton
				.setToolTipText("Refresh Network Interface");
		recieveInterfaceRefreshButton.setImage(Icon.iSync.getX16());
		recieveInterfaceRefreshButton
				.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						Network
								.GetNetworkInterface(recieveNetworkInterfaceCombo);
					}
				});
		Label filler10 = new Label(recieveGroup, SWT.NONE);
		Label filler20 = new Label(recieveGroup, SWT.NONE);
		Label filler33 = new Label(recieveGroup, SWT.NONE);
		recieveProtoclTypeLabel = new Label(recieveGroup, SWT.NONE);
		recieveProtoclTypeLabel.setText("Protocol Type");
		createRecieveProtocolTypeCombo();
		filler21 = new Label(recieveGroup, SWT.NONE);
		filler31 = new Label(recieveGroup, SWT.NONE);
		Label filler19 = new Label(recieveGroup, SWT.NONE);
		Label filler32 = new Label(recieveGroup, SWT.NONE);
		recieveStartButton = new Button(recieveGroup, SWT.NONE);
		recieveStartButton.setText("Start Recieve");
		recieveStartButton.setLayoutData(gridData411);
		Label filler18 = new Label(recieveGroup, SWT.NONE);
		Label filler311 = new Label(recieveGroup, SWT.NONE);
		recieveTable = new Table(recieveGroup, SWT.BORDER | SWT.FULL_SELECTION);
		recieveTable.setHeaderVisible(true);
		recieveTable.setLayoutData(gridData7);
		recieveTable.setLinesVisible(true);
		TableColumn recievePIDColumn = new TableColumn(recieveTable, SWT.NONE);
		recievePIDColumn.setText("PID");
		recievePIDColumn.setWidth(30);
		TableColumn tableColumn1 = new TableColumn(recieveTable, SWT.NONE);
		tableColumn1.setWidth(60);
		tableColumn1.setText("Protocol");
		TableColumn recieveIPPortColumn = new TableColumn(recieveTable,
				SWT.NONE);
		recieveIPPortColumn.setText("IP:Port");
		recieveIPPortColumn.setWidth(120);
		TableColumn recieveNICColumn = new TableColumn(recieveTable, SWT.NONE);
		recieveNICColumn.setText("NIC:Port");
		recieveNICColumn.setWidth(120);
		TableColumn recieveProgressColumn = new TableColumn(recieveTable,
				SWT.NONE);
		recieveProgressColumn.setText("Progress");
		recieveProgressColumn.setWidth(80);
		recieveStartButton
				.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						TableItem item;
						String ip = recieveIPText.getText();
						int port = Integer.parseInt(recievePortText.getText());
						String nic = recieveNetworkInterfaceCombo
								.getItem(recieveNetworkInterfaceCombo
										.getSelectionIndex());
						String select = recieveProtocolTypeCombo
								.getItem(recieveProtocolTypeCombo
										.getSelectionIndex());
						MessageBox mess = new MessageBox(sShell, SWT.ICON_ERROR);
						mess.setText("Error");
						mess.setMessage("Port " + port
								+ " is binded for another process!!");
						switch (ProtocolType.valueOf(select)) {
						case UDP:
							try {
								es = new EchoServer(nic, port);
								item = new TableItem(recieveTable, SWT.NONE);
								item.setText(0, "" + es.getId());
								item.setText(1, ProtocolType.UDP.toString());
								// item.setText(2,
								// es.getAddress().getHostAddress()+":"+ec.getPort());
								item.setText(3, es.getLocalAddr()
										.getHostAddress()
										+ ":" + es.getLocalPort());
								item.setText(4, "" + es.getRecievNoPacket());
								es.start();
								esHT.put(es.getId(), es);
							} catch (SocketException e2) {
								mess.open();
								e2.printStackTrace();
							}

							break;
						case TCP:
							try {
								tcps = new TCPServer(nic, port);
								item = new TableItem(recieveTable, SWT.NONE);
								item.setText(0, "" + tcps.getId());
								item.setText(1, ProtocolType.TCP.toString());
								// item.setText(2,
								// tcpc.getAddress().getHostAddress()+":"+tcpc.getPort());
								item.setText(3, tcps.getLocalAddr()
										.getHostAddress()
										+ ":" + tcps.getLocalPort());
								// item.setText(4,
								// tcpc.getSendNoPack()+"/"+tcpc.getPackNo());
								tcps.start();
								tcpsHT.put(tcps.getId(), tcps);
							} catch (IOException e1) {
								mess.open();
								e1.printStackTrace();
							}

							break;
						case MULTICAST:
							try {
								bcc = new BroadcastClient(ip, nic, port);
								item = new TableItem(recieveTable, SWT.NONE);
								item.setText(0, "" + bcc.getId());
								item.setText(1, ProtocolType.MULTICAST
										.toString());
								item.setText(2, bcc.getAddress()
										.getHostAddress());
								item.setText(3, bcc.getLocalAddr()
										.getHostAddress()
										+ ":" + bcc.getLocalPort());
								item.setText(4, bcc.getRecieveNoPacket() + "");
								bcc.start();
								bccHT.put(bcc.getId(), bcc);
							} catch (IOException e1) {
								mess.open();
								e1.printStackTrace();
							}

							break;
						}
					}
				});
		Menu recievePopUp = new Menu(sShell, SWT.POP_UP);
		MenuItem item = new MenuItem(recievePopUp, SWT.PUSH);
		item.setText("Delete");
		item.addSelectionListener(new SelectionListener() {
			

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				int index = recieveTable.getSelectionIndex();
				if (index != -1) {
					Long pid = Long.parseLong(recieveTable.getItem(
							index).getText(0));
					String pt = recieveTable
							.getItem(index).getText(1);
					recieveTable.remove(index);
					switch (ProtocolType.valueOf(pt)) {
					case UDP:
						esHT.get(pid).exit();
						esHT.remove(pid);
						break;
					case TCP:
						tcpsHT.get(pid).exit();
						tcpsHT.remove(pid);
						break;
					case MULTICAST:
						bccHT.get(pid).exit();
						bccHT.remove(pid);
						break;
					}
				} else {
					MessageBox m = new MessageBox(sShell);
					m.setText("Send Process");
					m.setMessage("Please select Process");
					m.open();
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});
		recieveTable.setMenu(recievePopUp);
		
	}

	/**
	 * This method initializes recieveNetworkInterfaceCombo
	 * 
	 */
	private void createRecieveNetworkInterfaceCombo() {
		GridData gridData32 = new GridData();
		gridData32.horizontalAlignment = GridData.FILL;
		gridData32.verticalAlignment = GridData.CENTER;
		recieveNetworkInterfaceCombo = new Combo(recieveGroup, SWT.READ_ONLY
				| SWT.BORDER);
		recieveNetworkInterfaceCombo.setLayoutData(gridData32);
		Network.GetNetworkInterface(recieveNetworkInterfaceCombo);
	}

	/**
	 * This method initializes recieveProtocolTypeCombo
	 * 
	 */
	private void createRecieveProtocolTypeCombo() {
		GridData gridData42 = new GridData();
		gridData42.horizontalAlignment = GridData.FILL;
		gridData42.verticalAlignment = GridData.CENTER;
		recieveProtocolTypeCombo = new Combo(recieveGroup, SWT.READ_ONLY
				| SWT.BORDER);
		recieveProtocolTypeCombo.setLayoutData(gridData42);
		for (Enum e : ProtocolType.values()) {
			recieveProtocolTypeCombo.add(e.toString());
		}
		recieveProtocolTypeCombo.select(0);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main thisClass = new Main();
		final Display display = Display.getDefault();
		thisClass.createSShell();
		thisClass.sShell.open();

		Thread t = new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(Config.getGeneralRefrash());
					} catch (Exception e) {
					}
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {

							// Client
							if (!ecHT.isEmpty())
								for (EchoClient ec : ecHT.values())
									for (TableItem ti : sendTable.getItems())
										if (ti.getText(0).equals(""+ec.getId()))
											ti.setText(4, ec.getSendNoPack()+ "/" + ec.getPackNo());

							if (!tcpcHT.isEmpty())
								for (TCPClient tcpc : tcpcHT.values()) 
									for (TableItem ti : sendTable.getItems())
										if (ti.getText(0).equals(""+tcpc.getId())) 
											ti.setText(4, tcpc.getSendNoPack()+ "/" + tcpc.getPackNo());
							
							if (!bcsHT.isEmpty())
								for (BroadcastServer bcs : bcsHT.values()) 
									for (TableItem ti : sendTable.getItems())
										if (ti.getText(0).equals(""+bcs.getId())) 
											ti.setText(4, bcs.getSendNoPack()+ "/" + bcs.getPackNo());
							// Server
							if (!esHT.isEmpty())
								for (EchoServer es : esHT.values()) 
									for (TableItem ti : recieveTable.getItems())
										if (ti.getText(0).equals(""+es.getId()))
											ti.setText(4, ""+ es.getRecievNoPacket());
										
								
							if (!tcpsHT.isEmpty())
								for (TCPServer tcps : tcpsHT.values()) 
									for (TableItem ti : recieveTable.getItems())
										if (ti.getText(0).equals(""+tcps.getId())) 
											 ti.setText(4, "");										
								
							if (!bccHT.isEmpty())
								for (BroadcastClient bcc : bccHT.values()) 
									for (TableItem ti : recieveTable.getItems())
										if (ti.getText(0).equals(""+bcc.getId())) 
											ti.setText(4, bcc.getRecieveNoPacket()+ "");
						}
					});
				}
			}
		});
		t.start();

		while (!thisClass.sShell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
		t.stop();
		if (!ecHT.isEmpty())
			for (EchoClient ec : ecHT.values()) {
				ec.exit();
			}
		if (!tcpcHT.isEmpty())
			for (TCPClient tcpc : tcpcHT.values()) {
				tcpc.exit();
			}
		if (!esHT.isEmpty())
			for (EchoServer es : esHT.values()) {
				es.exit();
			}
		if (!tcpsHT.isEmpty())
			for (TCPServer tcps : tcpsHT.values()) {
				tcps.exit();
			}
		if (!bccHT.isEmpty())
			for (BroadcastClient bbc : bccHT.values()) {
				bbc.exit();
			}
		if (!bcsHT.isEmpty())
			for (BroadcastServer bbs : bcsHT.values()) {
				bbs.exit();
			}
	}

	/**
	 * This method initializes sShell
	 */
	private void createSShell() {
		sShell = new Shell();
		sShell.setText("Traffic Generator");
		sShell.setSize(new Point(943, 414));
		sShell.setMinimumSize(new Point(943, 414));
		sShell.setLayout(new FillLayout());
		sShell.setImages(Icon.NetworkUtility.getImages());
		createSashForm();
		menuBar = new Menu(sShell, SWT.BAR);
		MenuItem file = new MenuItem(menuBar, SWT.CASCADE);
		file.setText("File");
		fileMenu = new Menu(file);
		MenuItem preferenceButton = new MenuItem(fileMenu, SWT.PUSH);
		preferenceButton.setText("Preference");
		preferenceButton.setImage(Icon.SystemPreferences.getX16());
		preferenceButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				SystemPreferences systemPreferencesShell = new SystemPreferences(sShell);
				systemPreferencesShell.Open();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				
			}
		});
		file.setMenu(fileMenu);
		MenuItem eXit = new MenuItem(menuBar, SWT.PUSH);
		eXit.setText("About");
		sShell.setMenuBar(menuBar);

	}

	/**
	 * This method initializes sashForm
	 * 
	 */
	private void createSashForm() {
		sashForm = new SashForm(sShell, SWT.NONE);
		createSendGroup();
		createRecieveGroup();
	}

	/**
	 * This method initializes sendGroup
	 * 
	 */
	private void createSendGroup() {
		GridData gridData13 = new GridData();
		gridData13.horizontalAlignment = GridData.FILL;
		gridData13.grabExcessHorizontalSpace = true;
		gridData13.horizontalSpan = 5;
		gridData13.grabExcessVerticalSpace = true;
		gridData13.verticalAlignment = GridData.FILL;
		GridData gridData12 = new GridData();
		gridData12.horizontalAlignment = GridData.FILL;
		gridData12.grabExcessHorizontalSpace = false;
		gridData12.verticalAlignment = GridData.CENTER;
		GridData gridData41 = new GridData();
		gridData41.horizontalSpan = 5;
		gridData41.verticalAlignment = GridData.CENTER;
		gridData41.horizontalAlignment = GridData.CENTER;
		GridData gridData31 = new GridData();
		gridData31.horizontalAlignment = GridData.FILL;
		gridData31.verticalAlignment = GridData.CENTER;
		GridData gridData5 = new GridData();
		gridData5.horizontalAlignment = GridData.FILL;
		gridData5.verticalAlignment = GridData.CENTER;
		GridData gridData2 = new GridData();
		gridData2.horizontalAlignment = GridData.FILL;
		gridData2.verticalAlignment = GridData.CENTER;
		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.FILL;
		gridData1.verticalAlignment = GridData.CENTER;
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.CENTER;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 5;
		sendGroup = new Group(sashForm, SWT.NONE);
		sendGroup.setText("Send");
		sendGroup.setLayout(gridLayout);
		sendIPLabel = new Label(sendGroup, SWT.NONE);
		sendIPLabel.setText("IP");
		sendIPText = new Text(sendGroup, SWT.BORDER);
		sendIPText.setText("127.0.0.1");
		sendIPText.setLayoutData(gridData1);
		Label filler1 = new Label(sendGroup, SWT.NONE);
		sendPackNoLabel = new Label(sendGroup, SWT.NONE);
		sendPackNoLabel.setText("Number of Packets");
		sendPackNoSpinner = new Spinner(sendGroup, SWT.BORDER);
		sendPortLabel = new Label(sendGroup, SWT.NONE);
		sendPortLabel.setText("Port");
		sendPortText = new Text(sendGroup, SWT.BORDER);
		sendPortText.setText("5000");
		sendPortText.setLayoutData(gridData2);
		Label filler = new Label(sendGroup, SWT.NONE);
		sendBufferSizeLabel = new Label(sendGroup, SWT.NONE);
		sendBufferSizeLabel.setText("Buffer Size (Bytes)");
		sendBufferSizeSpinner = new Spinner(sendGroup, SWT.BORDER);
		sendBufferSizeSpinner.setMaximum(10000);
		sendBufferSizeSpinner.setMinimum(0);
		sendBufferSizeSpinner.setSelection(1024);
		sendBufferSizeSpinner.setLayoutData(gridData5);
		sendNetworkInterfaceLabel = new Label(sendGroup, SWT.NONE);
		sendNetworkInterfaceLabel.setText("Network Interface");
		createSendNetworkInterfaceCombo();
		sendInterfaceRefreshButton = new Button(sendGroup, SWT.NONE);
		sendInterfaceRefreshButton.setToolTipText("Refresh Network Interface");
		sendInterfaceRefreshButton.setImage(Icon.iSync.getX16());
		sendPackTimerLabel = new Label(sendGroup, SWT.NONE);
		sendPackTimerLabel.setText("Time Between Pakets(ms)");
		sendPackTimerSpinner = new Spinner(sendGroup, SWT.BORDER);
		sendPackTimerSpinner.setMaximum(10000);
		sendPackTimerSpinner.setSelection(1000);
		sendPackTimerSpinner.setMinimum(1);
		sendPackTimerSpinner.setLayoutData(gridData31);
		sendInterfaceRefreshButton
				.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						Network.GetNetworkInterface(sendNetworkInterfaceCombo);
					}
				});
		sendProtoclTypeLabel = new Label(sendGroup, SWT.NONE);
		sendProtoclTypeLabel.setText("Protocol Type");
		createSendProtocolTypeCombo();
		Label filler2 = new Label(sendGroup, SWT.NONE);
		sendEstimateBPSLabel = new Label(sendGroup, SWT.NONE);
		sendEstimateBPSLabel.setText("Estimate traffic (kbps)");
		sendEstimateBPSValueLabel = new Label(sendGroup, SWT.NONE);
		sendEstimateBPSValueLabel.setText("1.0");
		sendEstimateBPSValueLabel.setLayoutData(gridData12);
		sendStartButton = new Button(sendGroup, SWT.NONE);
		sendStartButton.setText("Start Send");
		sendStartButton.setLayoutData(gridData41);
		sendTable = new Table(sendGroup, SWT.BORDER | SWT.FULL_SELECTION);
		sendTable.setHeaderVisible(true);
		sendTable.setLayoutData(gridData13);
		sendTable.setLinesVisible(true);
		TableColumn sendPIDColumn = new TableColumn(sendTable, SWT.NONE);
		sendPIDColumn.setWidth(30);
		sendPIDColumn.setText("PID");
		TableColumn tableColumn = new TableColumn(sendTable, SWT.NONE);
		tableColumn.setWidth(60);
		tableColumn.setText("Protocol");
		TableColumn sendIPPortColumn = new TableColumn(sendTable, SWT.NONE);
		sendIPPortColumn.setWidth(120);
		sendIPPortColumn.setText("IP:Port");
		TableColumn sendNICColumn = new TableColumn(sendTable, SWT.NONE);
		sendNICColumn.setWidth(120);
		sendNICColumn.setText("NIC:Port");
		TableColumn sendProgressColumn = new TableColumn(sendTable, SWT.NONE);
		sendProgressColumn.setWidth(80);
		sendProgressColumn.setText("Progress");
		sendStartButton
				.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						TableItem item;
						String ip = sendIPText.getText();
						int port = Integer.parseInt(sendPortText.getText());
						String nic = sendNetworkInterfaceCombo
								.getItem(sendNetworkInterfaceCombo
										.getSelectionIndex());
						int bufferSize = Integer.parseInt(sendBufferSizeSpinner
								.getText());
						int noPack = Integer.parseInt(sendPackNoSpinner
								.getText());
						int timer = Integer.parseInt(sendPackTimerSpinner
								.getText());
						String select = sendProtocolTypeCombo
								.getItem(sendProtocolTypeCombo
										.getSelectionIndex());
						MessageBox mess = new MessageBox(sShell, SWT.ICON_ERROR);
						mess.setText("Error");
						mess.setMessage("Port " + port
								+ " is binded for another process!!");
						switch (ProtocolType.valueOf(select)) {
						case UDP:
							try {
								ec = new EchoClient(ip, port, nic, port,
										bufferSize, noPack, timer);
								item = new TableItem(sendTable, SWT.NONE);
								item.setText(0, "" + ec.getId());
								item.setText(1, ProtocolType.UDP.toString());
								item.setText(2, ec.getAddress()
										.getHostAddress()
										+ ":" + ec.getPort());
								item.setText(3, ec.getLocalAddr()
										.getHostAddress()
										+ ":" + ec.getLocalPort());
								item.setText(4, ec.getSendNoPack() + "/"
										+ ec.getPackNo());
								ec.start();
								ecHT.put(ec.getId(), ec);
							} catch (SocketException e1) {
								mess.open();
								e1.printStackTrace();
							}
							break;
						case TCP:
							try {
								tcpc = new TCPClient(ip, port, nic, port,
										bufferSize, noPack, timer);
								item = new TableItem(sendTable, SWT.NONE);
								item.setText(0, "" + tcpc.getId());
								item.setText(1, ProtocolType.TCP.toString());
								item.setText(2, tcpc.getAddress()
										.getHostAddress()
										+ ":" + tcpc.getPort());
								item.setText(3, tcpc.getLocalAddr()
										.getHostAddress()
										+ ":" + tcpc.getLocalPort());
								item.setText(4, tcpc.getSendNoPack() + "/"
										+ tcpc.getPackNo());
								tcpc.start();
								tcpcHT.put(tcpc.getId(), tcpc);
							} catch (IOException e1) {
								mess.open();
								e1.printStackTrace();
							}

							break;
						case MULTICAST:

							try {
								bcs = new BroadcastServer(ip, port, nic, port,
										bufferSize, noPack, timer);
								item = new TableItem(sendTable, SWT.NONE);
								item.setText(0, "" + bcs.getId());
								item.setText(1, ProtocolType.MULTICAST
										.toString());
								item.setText(2, bcs.getAddress()
										.getHostAddress()
										+ ":" + bcs.getPort());
								item.setText(3, bcs.getLocalAddr()
										.getHostAddress()
										+ ":" + bcs.getLocalPort());
								item.setText(4, bcs.getSendNoPack() + "/"
										+ bcs.getPackNo());
								bcs.start();
								bcsHT.put(bcs.getId(), bcs);
							} catch (IOException e1) {
								mess.open();
								e1.printStackTrace();
							}

							break;
						}
					}
				});
		Menu sendPopUp = new Menu(sShell, SWT.POP_UP);
		MenuItem item = new MenuItem(sendPopUp, SWT.PUSH);
		item.setText("Delete");
		item.addSelectionListener(new SelectionListener() {
			

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				int index = sendTable.getSelectionIndex();
				if ( index != -1) {
					Long pid = Long.parseLong(sendTable.getItem(
							index).getText(0));
					String pt = sendTable
							.getItem(index).getText(1);
					sendTable.remove(index);
					switch (ProtocolType.valueOf(pt)) {
					case UDP:
						ecHT.get(pid).exit();
						ecHT.remove(pid);
						break;
					case TCP:
						tcpcHT.get(pid).exit();
						tcpcHT.remove(pid);
						break;
					case MULTICAST:
						bcsHT.get(pid).exit();
						bcsHT.remove(pid);
						break;
					}
				} else {
					MessageBox m = new MessageBox(sShell);
					m.setText("Send Process");
					m.setMessage("Please select Process");
					m.open();
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});
		sendTable.setMenu(sendPopUp);

		sendPackNoSpinner.setMaximum(10000);
		sendPackNoSpinner.setToolTipText("Zero == Infinite");
		sendPackNoSpinner.setLayoutData(gridData);
		sendPackNoSpinner.setSelection(100);
	}

}
