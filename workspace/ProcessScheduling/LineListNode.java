package zhang.cqjtu.os;

/**
 * 创建PCB的数据结构
 * @author Lewis
 */
public class LineListNode<T> {
    private LineListNode<T> node;
    private T element;

    /**
     * 创建空链表
     */
    public LineListNode() {
        this.node = null;
        this.element = null;
    }
    /**
     * 创建一个存储特定元素的线性表
     */
    public LineListNode(T element) {
        this.node = null;
        this.element = element;
    }
    /**
     * 返回当前结点点的下一个节点
     */
    public LineListNode<T> getNextNode() {
        return this.node;
    }
    /**
     * 设置当前结点的下一个结点
     */
    public void setNextNode(LineListNode<T> node) {
        this.node = node;
    }
    /**
     * 返回当前结点存储的数据元素
     */
    public T getElement() {
        return this.element;
    }
    /**
     * 设置当前结点存储的数据元素
     */
    public void setElement(T element) {
        this.element = element;
    }





}
