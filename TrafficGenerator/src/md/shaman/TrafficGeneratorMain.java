/*
 * TrafficGeneratorView.java
 */
package md.shaman;

import org.jdesktop.application.Action;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import md.shaman.protocols.Protocol;
import md.shaman.resources.icons.PNGPacket;

/**
 * The application's main frame.
 */
public class TrafficGeneratorMain extends FrameView {

    public TrafficGeneratorMain(SingleFrameApplication app) {
        super(app);
        initComponents();
        getFrame().setIconImages(PNGPacket.Network.getImages());
        //filterList.setCellRenderer(new FilterCellRenderer());
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
        exitMenuItem.setText(resourceMap.getString("exitMenuItem.text")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

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
                {new Long(1), "TCP", "192.168.1.1", "192.168.1.2", "95 %", "NEW"},
                {new Long(2), "UDP", "192.168.1.1", "192.168.1.2", "4 %", "RUNNABLE"},
                {new Long(3), "MULTICAST", "192.168.1.1", "192.168.1.2", "1 %", "TERMINATED"}
            },
            new String [] {
                "PID", "ProtocolType", "IP:Port", "NIC:Port", "Progress", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        processTable.setName("processTable"); // NOI18N
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

        jSplitPane2.setTopComponent(jScrollPane2);

        tabbedPane.setName("tabbedPane"); // NOI18N

        generalPanel.setName("generalPanel"); // NOI18N
        tabbedPane.addTab(resourceMap.getString("generalPanel.TabConstraints.tabTitle"), resourceMap.getIcon("generalPanel.TabConstraints.tabIcon"), generalPanel, resourceMap.getString("generalPanel.TabConstraints.tabToolTip")); // NOI18N

        graphPanel.setName("graphPanel"); // NOI18N
        tabbedPane.addTab(resourceMap.getString("graphPanel.TabConstraints.tabTitle"), resourceMap.getIcon("graphPanel.TabConstraints.tabIcon"), graphPanel, resourceMap.getString("graphPanel.TabConstraints.tabToolTip")); // NOI18N

        logPanel.setName("logPanel"); // NOI18N
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
        treeNode1.add(treeNode2);
        filterTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
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

        addButton.setIcon(resourceMap.getIcon("addButton.icon")); // NOI18N
        addButton.setToolTipText(resourceMap.getString("addButton.toolTipText")); // NOI18N
        addButton.setFocusable(false);
        addButton.setLabel(resourceMap.getString("addButton.label")); // NOI18N
        addButton.setName("addButton"); // NOI18N
        toolBar.add(addButton);

        jSeparator2.setName("jSeparator2"); // NOI18N
        toolBar.add(jSeparator2);

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
        stopButton.setToolTipText(resourceMap.getString("stopButton.toolTipText")); // NOI18N
        stopButton.setFocusable(false);
        stopButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        stopButton.setName("stopButton"); // NOI18N
        stopButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(stopButton);

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
            //processTable.setRowSorter(null);
            //return;
        }else if(tp.getPathCount() == 3){
            if(tp.getPathComponent(1).toString().equals("STATUS"))
            {
                switch(Thread.State.valueOf(tp.getLastPathComponent().toString()))
                {
                    case NEW: rf = RowFilter.regexFilter(Thread.State.NEW.toString(), 5); break;
                    case RUNNABLE: rf = RowFilter.regexFilter(Thread.State.RUNNABLE.toString(), 5);break;
                    case BLOCKED: rf = RowFilter.regexFilter(Thread.State.BLOCKED.toString(), 5);break;
                    case WAITING: rf = RowFilter.regexFilter(Thread.State.WAITING.toString(), 5);break;
                    case TIMED_WAITING: rf = RowFilter.regexFilter(Thread.State.TIMED_WAITING.toString(), 5);break;
                    case TERMINATED: rf = RowFilter.regexFilter(Thread.State.TERMINATED.toString(), 5);break;
                }
            }else if (tp.getPathComponent(1).toString().equals("PROTOCOL"))
            {
                switch(Protocol.ProtocolType.valueOf(tp.getLastPathComponent().toString()))
                {
                    case UDP: rf = RowFilter.regexFilter(Protocol.ProtocolType.UDP.toString(), 1); break;
                    case TCP: rf = RowFilter.regexFilter(Protocol.ProtocolType.TCP.toString(), 1);break;
                    case MULTICAST: rf = RowFilter.regexFilter(Protocol.ProtocolType.MULTICAST.toString(), 1);break;
                }
            }

        }
        sorter.setRowFilter(rf);
        processTable.setRowSorter(sorter);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JPanel logPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton pauseButton;
    private javax.swing.JButton playButton;
    private javax.swing.JTable processTable;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JButton stopButton;
    private javax.swing.JMenuItem systemPreferencesMenuItem;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
    private JDialog aboutBox;
    private JDialog preference;
}
