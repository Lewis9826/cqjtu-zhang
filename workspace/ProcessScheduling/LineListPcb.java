package zhang.cqjtu.os;

/**
 * 创建一个存储PCB用的线性链表，通过线性链表的相关操作来实现相应的功能
 * @author Lewis
 */
public class LineListPcb<T> {
    /**
     * 表示PCB线性表的长度
     */
    private int size;
    /**
     * 表示PCB线性表的头元素结点
     */
    private LineListNode<T> headPcb;
    /**
     * 表示PCB线性表尾元素结点
     */
    private LineListNode<T> lastPcb;
    /**
     * 创建一个空的PCB线性存储链表
     */
    public LineListPcb() {
        this.size = 0;
        this.headPcb = null;
        this.lastPcb = null;
    }

    /**
     * 创建一个具有特定元素的PCB线性存储链表
     */
    public LineListPcb(LineListPcb<T> llp) {
        this.size = llp.getSize();
        this.headPcb = llp.getHeadPcb();
        this.lastPcb = llp.getLastPcb();
    }

    /**
     * 从PCB线性表中的头部移除数据元素
     * @param element
     */
    public void removeElement() {
        if (0 == this.size) {
            return;
        }
        @SuppressWarnings("unused")
        LineListNode<T> tempNode = this.headPcb;
        this.headPcb = this.headPcb.getNextNode();
        this.size--;
        // 这一段主要是为了处理移除数据元素后只剩下一个数据元素的时候的线性链表处理
        if (this.size == 1) {
            this.headPcb.setNextNode(this.lastPcb);
            this.lastPcb = this.headPcb;
            this.lastPcb.setNextNode(null);
        }
    }

    /**
     * 向PCB线性表中的添加数据元素
     * @param element
     */
    public void addElement(T element) {
        LineListNode<T> newElement = new LineListNode<T>(element);
        if (this.headPcb == null) {
            // 头结点为空，表示链表中当前没有数据元素，说明头结点和尾结点指向同一内存空间
            this.headPcb = newElement;
            // 新添加一个数据元素则仍然指向同一内存空间
            this.lastPcb = this.headPcb;
        } else {
            // 链表不为空，在这里要保证最后一个结点与新加入的结点连接在一起
            this.lastPcb.setNextNode(newElement);
            this.lastPcb = newElement;
        }
        this.size++;
    }

    /**
     * 从PCB线性表中的头部移除数据元素，并将其添加到PCB线性表中的尾部
     */
    public void removeFromHeadAddToLast() {
        if (this.size <= 1) {
            return;
        }
        LineListNode<T> tempNode = this.headPcb;
        this.headPcb = tempNode.getNextNode();
        this.lastPcb.setNextNode(tempNode);
        this.lastPcb = tempNode;
    }

    /**
     * 从PCB线性表中中的尾部移除数据元素，并将其添加到PCB的线性表中的头部
     */
    public void removeFromLastAddToHead() {
        if (0 == this.size) {
            return;
        }
        LineListNode<T> tempNode = this.lastPcb;
        // 设置尾结点的以一个结点为空
        LineListNode<T> lastSecondNode = this.headPcb;
/*
         @i=1表示指向PCB线性表的元素为线性表的第一个元素
         @i=this.size-1表示指向线性表的元素为线性表的末尾第二个数据元素
*/
        for (int i = 1; i < this.size - 1; i++) {
            lastSecondNode = lastSecondNode.getNextNode();
        }
        lastSecondNode.setNextNode(null);
        // 设置PCB线性表尾结点的下一个结点为头结点的下一个结点，头结点为为尾结点
        tempNode.setNextNode(this.headPcb.getNextNode());
        this.headPcb = tempNode;
    }

    /**
     * 判断PCB线性表是否为空
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public LineListNode<T> getHeadPcb() {
        return this.headPcb;
    }

    public void setHeadPcb(LineListNode<T> headPcb) {
        this.headPcb = headPcb;
    }

    public LineListNode<T> getLastPcb() {
        return this.lastPcb;
    }

    /**
     * 获取Pcb
     * @return PCB
     */
    public T getPCB() {
        return this.headPcb.getElement();
    }


    public void setLastPcb(LineListNode<T> lastPcb) {
        this.lastPcb = lastPcb;
    }
}
