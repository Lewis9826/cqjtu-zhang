package zhang.cqjtu.os;

/**
 * 设计输入数据和输出格式；
 * 数据测试
 * @author Lewis
 */
public class PcbProcess {

    public static void main(String[] args) {

        Pcb[] p = {new Pcb(0, 9, 0, 3, 1), new Pcb(1, 38, 0, 2, 1),
                new Pcb(2, 30, 0, 6, 1), new Pcb(3, 29, 0, 3, 1),
                new Pcb(4, 0, 0, 4, 1)};
        LineListPcb<Pcb> llp = new LineListPcb<>();
        for (int i = 0; i < p.length; i++) {
            llp.addElement(p[i]);
        }

        while (true) {
            if (llp.getSize() == 0) {
                break;
            }
            LineListNode<Pcb> lln = llp.getHeadPcb();
            Pcb pcb = lln.getElement();
            pcb.modify();
            System.out.print("进程" + pcb.getId() + "正在占用时间片");
            pcb.showStatus();
            if (0 != pcb.getAllTime()) {
                System.out.println();
                llp.removeFromHeadAddToLast();
            } else {
                System.out.println();
                System.out.println("^**********************" + "进程"
                        + pcb.getId() + "获得执行，并且移除就绪队列"
                        + "^**********************");
                System.out.println();
                llp.removeElement();
            }
        }
    }

}
