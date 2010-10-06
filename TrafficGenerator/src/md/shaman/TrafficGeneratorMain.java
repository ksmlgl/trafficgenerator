/*
 * TrafficGeneratorView.java
 */
package md.shaman;

import java.io.IOException;
import java.util.HashMap;
import org.jdesktop.application.Action;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import md.shaman.configs.Config;
import md.shaman.custom.CustomTreeCellRenderer;
import md.shaman.custom.wizard.Wizard;
import md.shaman.forms.wizard.*;
import md.shaman.icons.PNGPacket;
import md.shaman.protocols.ProtocolConfig;
import md.shaman.protocols.ProtocolThread;
import md.shaman.protocols.ProtocolThreadUtilities;
import md.shaman.utils.ThreadUtilities;

/**
 * The application's main frame.
 */
public class TrafficGeneratorMain extends FrameView {

    HashMap<Long, ProtocolThread> ptMap = new HashMap<Long, ProtocolThread>();

    public TrafficGeneratorMain(SingleFrameApplication app) {
        super(app);
        initComponents();
        getFrame().setIconImages(PNGPacket.Network.getImages());

        Thread t = new Thread(new Runnable() {
        public void run() {
            while (true) {
                    try {
                        Thread.sleep(Config.getGeneralRefrash());
                        DefaultTableModel dtm = (DefaultTableModel) processTable.getModel();
                        for(int i = 0; i<dtm.getRowCount(); i++){
                            ProtocolThread pt = ptMap.get(dtm.getValueAt(i, 0));
                            //Progress
                            dtm.setValueAt(pt.getPacketSendReceive(), i, 4);
                            //Status
                            dtm.setValueAt(pt.getState(), i, 5);
                        }
                    } catch (Exception e) {
                    }
                }
        }
        });
        t.start();
    }


    @Action
    public void StartAll(){
        for(ProtocolThread pt : ptMap.values())
        {
            if(!pt.isAlive())
                pt.start();
        }
    }
    @Action
    public void StopAll(){
        for(ProtocolThread pt : ptMap.values())
            pt.stop();
    }
    @Action
    public void Stop(){
        for(int rw : processTable.getSelectedRows())
            ptMap.get(processTable.getValueAt(rw, 0)).stop();
    }
    @Action
    public void Start(){
        for(int rw : processTable.getSelectedRows())
        {
            ProtocolThread pt = ptMap.get(processTable.getValueAt(rw, 0));
            if(!pt.isAlive())
                pt.start();
        }
    }
    @Action
    public void Remove()
    {
        for(int rw : processTable.getSelectedRows())
        {
            Long key = (Long) processTable.getValueAt(rw, 0);
            ProtocolThread pt = ptMap.get(key);
            pt.exit();
            ((DefaultTableModel)processTable.getModel()).removeRow(rw);
            ptMap.remove(key);
        }
    }

    @Action
    public void showProperties()
    {
    }
    @Action
    public void showWizard() {
        JFrame mainFrame = TrafficGeneratorApp.getApplication().getMainFrame();
        Wizard wizard = new Wizard(mainFrame);
        wizard.getDialog().setTitle("Traffic Generator Wizard");
        wizard.getDialog().setLocationRelativeTo(mainFrame);
        //Wizard Forms Register
        GeneralStartWizardDescriptor gswd = new GeneralStartWizardDescriptor();
        wizard.registerWizardPanel(GeneralStartWizardDescriptor.IDENTIFIER, gswd);
        GeneralSendReceiveWizardDescriptor gsrwd = new GeneralSendReceiveWizardDescriptor();
        wizard.registerWizardPanel(GeneralSendReceiveWizardDescriptor.IDENTIFIER, gsrwd);
        GeneralTrafficWizardDescriptor gtwd = new GeneralTrafficWizardDescriptor();
        wizard.registerWizardPanel(GeneralTrafficWizardDescriptor.IDENTIFIER, gtwd);
        GeneralFinishWizardDescriptor gfwd = new GeneralFinishWizardDescriptor();
        wizard.registerWizardPanel(GeneralFinishWizardDescriptor.IDENTIFIER, gfwd);

        //Wizard Config
        wizard.setCurrentPanel(GeneralStartWizardDescriptor.IDENTIFIER);
        if (Wizard.FINISH_RETURN_CODE == wizard.showModalDialog()) {
            try {
                ProtocolThread pt = (ProtocolThread) ProtocolConfig.execute();
                ptMap.put(pt.getId(), pt);
                if (ProtocolConfig.isStartNow()) {
                    pt.start();
                    System.out.println("Process is started");
                }
                Object[] rowData = {pt.getId(),
                pt.getType(),
                pt.getIpAddress().toString().substring(1) + ":" + pt.getIpPort(),
                pt.getNicAddress().toString().substring(1) + ":" + pt.getNicPort(),
                pt.getPacketSendReceive(),
                pt.getState(), ""};
                ((DefaultTableModel) processTable.getModel()).addRow(rowData);
            } catch (IOException ex) {
            }
        }
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = TrafficGeneratorApp.getApplication().getMainFrame();
            aboutBox = new TrafficGeneratorAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        TrafficGeneratorApp.getApplication().show(aboutBox);
    }

    @Action
    public void showSystemPreference() {
        JFrame mainFrame = TrafficGeneratorApp.getApplication().getMainFrame();
        preference = new TrafficGeneratorSystemPreference(mainFrame);
        preference.setLocationRelativeTo(mainFrame);
        TrafficGeneratorApp.getApplication().show(preference);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        systemPreferencesMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem1 = new javax.swing.JMenuItem();
        componentPanel = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jSplitPane2 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        processTable = new javax.swing.JTable();
        tabbedPane = new javax.swing.JTabbedPane();
        generalPanel = new javax.swing.JPanel();
        protocolTypeLabel = new javax.swing.JLabel();
        ipPortLabel = new javax.swing.JLabel();
        nicPortLabel = new javax.swing.JLabel();
        protocolTypeValue = new javax.swing.JLabel();
        ipPortValue = new javax.swing.JLabel();
        nicPortValue = new javax.swing.JLabel();
        graphPanel = new javax.swing.JPanel();
        logPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        filterTree = new javax.swing.JTree();
        statusPanel = new javax.swing.JPanel();
        toolBar = new javax.swing.JToolBar();
        addButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        playButton = new javax.swing.JButton();
        pauseButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        processPopupMenu = new javax.swing.JPopupMenu();
        startMenuItem = new javax.swing.JMenuItem();
        stopMenuItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        removeMenuItem = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        propertiesMenuItem = new javax.swing.JMenuItem();

        menuBar.setName("menuBar"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(md.shaman.TrafficGeneratorApp.class).getContext().getResourceMap(TrafficGeneratorMain.class);
        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(md.shaman.TrafficGeneratorApp.class).getContext().getActionMap(TrafficGeneratorMain.class, this);
        systemPreferencesMenuItem.setAction(actionMap.get("showSystemPreference")); // NOI18N
        systemPreferencesMenuItem.setIcon(resourceMap.getIcon("systemPreferencesMenuItem.icon")); // NOI18N
        systemPreferencesMenuItem.setText(resourceMap.getString("systemPreferencesMenuItem.text")); // NOI18N
        systemPreferencesMenuItem.setName("systemPreferencesMenuItem"); // NOI18N
        fileMenu.add(systemPreferencesMenuItem);

        jSeparator1.setName("jSeparator1"); // NOI18N
        fileMenu.add(jSeparator1);

        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setIcon(resourceMap.getIcon("exitMenuItem.icon")); // NOI18N
        exitMenuItem.setText(resourceMap.getString("exitMenuItem.text")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N

        aboutMenuItem1.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem1.setIcon(resourceMap.getIcon("aboutMenuItem1.icon")); // NOI18N
        aboutMenuItem1.setText(resourceMap.getString("aboutMenuItem1.text")); // NOI18N
        aboutMenuItem1.setName("aboutMenuItem1"); // NOI18N
        helpMenu.add(aboutMenuItem1);

        menuBar.add(helpMenu);

        componentPanel.setName("componentPanel"); // NOI18N
        componentPanel.setLayout(new java.awt.GridLayout(1, 0));

        jSplitPane1.setDividerLocation(50);
        jSplitPane1.setName("jSplitPane1"); // NOI18N

        jSplitPane2.setDividerLocation(200);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane2.setName("jSplitPane2"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        processTable.setAutoCreateRowSorter(true);
        processTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PID", "ProtocolType", "IP:Port", "NIC:Port", "Progress", "Status", "Label"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        processTable.setComponentPopupMenu(processPopupMenu);
        processTable.setName("processTable"); // NOI18N
        processTable.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        processTable.setShowHorizontalLines(false);
        processTable.setShowVerticalLines(false);
        processTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(processTable);
        processTable.getColumnModel().getColumn(0).setMinWidth(35);
        processTable.getColumnModel().getColumn(0).setPreferredWidth(35);
        processTable.getColumnModel().getColumn(0).setMaxWidth(50);
        processTable.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("processTable.columnModel.title0")); // NOI18N
        processTable.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("processTable.columnModel.title1")); // NOI18N
        processTable.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("processTable.columnModel.title2")); // NOI18N
        processTable.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("processTable.columnModel.title3")); // NOI18N
        processTable.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("processTable.columnModel.title4")); // NOI18N
        processTable.getColumnModel().getColumn(5).setHeaderValue(resourceMap.getString("processTable.columnModel.title5")); // NOI18N
        processTable.getColumnModel().getColumn(6).setHeaderValue(resourceMap.getString("processTable.columnModel.title6")); // NOI18N

        jSplitPane2.setTopComponent(jScrollPane2);

        tabbedPane.setName("tabbedPane"); // NOI18N

        generalPanel.setName("generalPanel"); // NOI18N

        protocolTypeLabel.setText(resourceMap.getString("protocolTypeLabel.text")); // NOI18N
        protocolTypeLabel.setName("protocolTypeLabel"); // NOI18N

        ipPortLabel.setText(resourceMap.getString("ipPortLabel.text")); // NOI18N
        ipPortLabel.setName("ipPortLabel"); // NOI18N

        nicPortLabel.setText(resourceMap.getString("nicPortLabel.text")); // NOI18N
        nicPortLabel.setName("nicPortLabel"); // NOI18N

        protocolTypeValue.setText(resourceMap.getString("protocolTypeValue.text")); // NOI18N
        protocolTypeValue.setName("protocolTypeValue"); // NOI18N

        ipPortValue.setText(resourceMap.getString("ipPortValue.text")); // NOI18N
        ipPortValue.setName("ipPortValue"); // NOI18N

        nicPortValue.setText(resourceMap.getString("nicPortValue.text")); // NOI18N
        nicPortValue.setName("nicPortValue"); // NOI18N

        javax.swing.GroupLayout generalPanelLayout = new javax.swing.GroupLayout(generalPanel);
        generalPanel.setLayout(generalPanelLayout);
        generalPanelLayout.setHorizontalGroup(
            generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(protocolTypeLabel)
                    .addComponent(ipPortLabel)
                    .addComponent(nicPortLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nicPortValue, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ipPortValue, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(protocolTypeValue, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(379, Short.MAX_VALUE))
        );
        generalPanelLayout.setVerticalGroup(
            generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(protocolTypeLabel)
                    .addComponent(protocolTypeValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ipPortLabel)
                    .addComponent(ipPortValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nicPortLabel)
                    .addComponent(nicPortValue))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        tabbedPane.addTab(resourceMap.getString("generalPanel.TabConstraints.tabTitle"), resourceMap.getIcon("generalPanel.TabConstraints.tabIcon"), generalPanel, resourceMap.getString("generalPanel.TabConstraints.tabToolTip")); // NOI18N

        graphPanel.setName("graphPanel"); // NOI18N

        javax.swing.GroupLayout graphPanelLayout = new javax.swing.GroupLayout(graphPanel);
        graphPanel.setLayout(graphPanelLayout);
        graphPanelLayout.setHorizontalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
        );
        graphPanelLayout.setVerticalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
        );

        tabbedPane.addTab(resourceMap.getString("graphPanel.TabConstraints.tabTitle"), resourceMap.getIcon("graphPanel.TabConstraints.tabIcon"), graphPanel, resourceMap.getString("graphPanel.TabConstraints.tabToolTip")); // NOI18N

        logPanel.setName("logPanel"); // NOI18N

        javax.swing.GroupLayout logPanelLayout = new javax.swing.GroupLayout(logPanel);
        logPanel.setLayout(logPanelLayout);
        logPanelLayout.setHorizontalGroup(
            logPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
        );
        logPanelLayout.setVerticalGroup(
            logPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
        );

        tabbedPane.addTab(resourceMap.getString("logPanel.TabConstraints.tabTitle"), resourceMap.getIcon("logPanel.TabConstraints.tabIcon"), logPanel, resourceMap.getString("logPanel.TabConstraints.tabToolTip")); // NOI18N

        jSplitPane2.setRightComponent(tabbedPane);

        jSplitPane1.setRightComponent(jSplitPane2);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setName("jScrollPane1"); // NOI18N

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("ALL");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("STATUS");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("NEW");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("RUNNABLE");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("BLOCKED");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("WAITING");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("TIMED_WAITING");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("TERMINATED");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("PROTOCOL");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("TCP");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("UDP");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("MULTICAST");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("LABEL");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("NO LABEL");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        filterTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        filterTree.setToolTipText(resourceMap.getString("filterTree.toolTipText")); // NOI18N
        filterTree.setCellRenderer(new CustomTreeCellRenderer());
        filterTree.setName("filterTree"); // NOI18N
        filterTree.setRootVisible(false);
        filterTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        filterTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                filterTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(filterTree);

        jSplitPane1.setLeftComponent(jScrollPane1);

        componentPanel.add(jSplitPane1);

        statusPanel.setName("statusPanel"); // NOI18N

        toolBar.setFloatable(false);
        toolBar.setRollover(true);
        toolBar.setName("toolBar"); // NOI18N

        addButton.setAction(actionMap.get("showWizard")); // NOI18N
        addButton.setIcon(resourceMap.getIcon("addButton.icon")); // NOI18N
        addButton.setToolTipText(resourceMap.getString("addButton.toolTipText")); // NOI18N
        addButton.setFocusable(false);
        addButton.setName("addButton"); // NOI18N
        toolBar.add(addButton);

        jSeparator2.setName("jSeparator2"); // NOI18N
        toolBar.add(jSeparator2);

        playButton.setAction(actionMap.get("StartAll")); // NOI18N
        playButton.setIcon(resourceMap.getIcon("playButton.icon")); // NOI18N
        playButton.setText(resourceMap.getString("playButton.text")); // NOI18N
        playButton.setToolTipText(resourceMap.getString("playButton.toolTipText")); // NOI18N
        playButton.setFocusable(false);
        playButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        playButton.setName("playButton"); // NOI18N
        playButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(playButton);

        pauseButton.setIcon(resourceMap.getIcon("pauseButton.icon")); // NOI18N
        pauseButton.setText(resourceMap.getString("pauseButton.text")); // NOI18N
        pauseButton.setToolTipText(resourceMap.getString("pauseButton.toolTipText")); // NOI18N
        pauseButton.setFocusable(false);
        pauseButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pauseButton.setName("pauseButton"); // NOI18N
        pauseButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(pauseButton);

        stopButton.setIcon(resourceMap.getIcon("stopButton.icon")); // NOI18N
        stopButton.setText(resourceMap.getString("stopButton.text")); // NOI18N
        stopButton.setFocusable(false);
        stopButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        stopButton.setName("stopButton"); // NOI18N
        stopButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(stopButton);

        processPopupMenu.setName("processPopupMenu"); // NOI18N

        startMenuItem.setAction(actionMap.get("Start")); // NOI18N
        startMenuItem.setText(resourceMap.getString("startMenuItem.text")); // NOI18N
        startMenuItem.setName("startMenuItem"); // NOI18N
        processPopupMenu.add(startMenuItem);

        stopMenuItem.setAction(actionMap.get("Stop")); // NOI18N
        stopMenuItem.setIcon(resourceMap.getIcon("stopMenuItem.icon")); // NOI18N
        stopMenuItem.setText(resourceMap.getString("stopMenuItem.text")); // NOI18N
        stopMenuItem.setEnabled(false);
        stopMenuItem.setName("stopMenuItem"); // NOI18N
        processPopupMenu.add(stopMenuItem);

        jSeparator3.setName("jSeparator3"); // NOI18N
        processPopupMenu.add(jSeparator3);

        removeMenuItem.setAction(actionMap.get("Remove")); // NOI18N
        removeMenuItem.setText(resourceMap.getString("removeMenuItem.text")); // NOI18N
        removeMenuItem.setName("removeMenuItem"); // NOI18N
        processPopupMenu.add(removeMenuItem);

        jSeparator4.setName("jSeparator4"); // NOI18N
        processPopupMenu.add(jSeparator4);

        propertiesMenuItem.setAction(actionMap.get("showProperties")); // NOI18N
        propertiesMenuItem.setText(resourceMap.getString("propertiesMenuItem.text")); // NOI18N
        propertiesMenuItem.setName("propertiesMenuItem"); // NOI18N
        processPopupMenu.add(propertiesMenuItem);

        setComponent(componentPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
        setToolBar(toolBar);
    }// </editor-fold>//GEN-END:initComponents

    private void filterTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_filterTreeValueChanged
        TreePath tp = filterTree.getSelectionPath();
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(processTable.getModel());
        RowFilter<TableModel, Object> rf = null;

        //If current expression doesn't parse, don't update.
        if (tp.getPathCount() == 2 && tp.getLastPathComponent().toString().equals("ALL")) {
            sorter.setRowFilter(rf);
            processTable.setRowSorter(sorter);
            return;
        } else if (tp.getPathCount() == 3) {
            if (tp.getPathComponent(1).toString().equals("STATUS")) {
                rf = RowFilter.regexFilter("^"+tp.getLastPathComponent().toString()+"$", 5);
            } else if (tp.getPathComponent(1).toString().equals("PROTOCOL")) {
                rf = RowFilter.regexFilter("^"+tp.getLastPathComponent().toString()+"$", 1);
            } else if (tp.getPathComponent(1).toString().equals("LABEL")) {
                String rs = "^$";
                if (!tp.getLastPathComponent().toString().equals("NO LABEL")) {
                    rs = tp.getLastPathComponent().toString();
                }
                rf = RowFilter.regexFilter(rs, 6);
            }
            sorter.setRowFilter(rf);
            processTable.setRowSorter(sorter);
        }

    }//GEN-LAST:event_filterTreeValueChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem1;
    private javax.swing.JButton addButton;
    private javax.swing.JPanel componentPanel;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JTree filterTree;
    private javax.swing.JPanel generalPanel;
    private javax.swing.JPanel graphPanel;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel ipPortLabel;
    private javax.swing.JLabel ipPortValue;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JPanel logPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JLabel nicPortLabel;
    private javax.swing.JLabel nicPortValue;
    private javax.swing.JButton pauseButton;
    private javax.swing.JButton playButton;
    private javax.swing.JPopupMenu processPopupMenu;
    private javax.swing.JTable processTable;
    private javax.swing.JMenuItem propertiesMenuItem;
    private javax.swing.JLabel protocolTypeLabel;
    private javax.swing.JLabel protocolTypeValue;
    private javax.swing.JMenuItem removeMenuItem;
    private javax.swing.JMenuItem startMenuItem;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JButton stopButton;
    private javax.swing.JMenuItem stopMenuItem;
    private javax.swing.JMenuItem systemPreferencesMenuItem;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
    private JDialog aboutBox;
    private JDialog preference;
}
