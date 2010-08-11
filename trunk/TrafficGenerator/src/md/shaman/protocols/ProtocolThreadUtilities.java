package md.shaman.protocols;

public class ProtocolThreadUtilities {

    static ThreadGroup rootThreadGroup = null;

    public static ThreadGroup getRootThreadGroup() {
        if (null != rootThreadGroup) {
            return rootThreadGroup;
        }

        ThreadGroup tg = Thread.currentThread().getThreadGroup();
        while (null != tg.getParent()) {
            tg = tg.getParent();
        }
        rootThreadGroup = tg;
        return tg;
    }

    public static ProtocolThread getProtocolThread(long id) {
        return getProtocolThread(id, getRootThreadGroup());
    }

    public static ProtocolThread getProtocolThread(long id, ThreadGroup group) {
        int nt = group.activeCount();
        Thread[] threads = new Thread[nt*2 + 10]; //nt is not accurate
        nt = group.enumerate(threads, false);

        // List every thread in the group
        for (int i=0; i<nt; i++) {
            if (threads[i].getId() == id) {
                return (ProtocolThread) threads[i];
            }
        }

//        // Recursively list all subgroups
//        int ng = group.activeGroupCount();
//        ThreadGroup[] groups = new ThreadGroup[ng*2 + 10];
//        ng = group.enumerate(groups, false);
//
//        for (int i=0; i<ng; i++) {
//            ProtocolThread pt = getProtocolThread(id, groups[i]);
//                if (null != pt) {
//                    return pt;
//                }
//        }
        return null;
    }
}
